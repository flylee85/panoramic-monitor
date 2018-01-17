package com.cloud.service.acl;

import com.cloud.mapper.ScheduleTriggerMapper;
import com.cloud.model.ScheduleTrigger;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author summer
 */
@Service
public class ScheduleTriggerService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTriggerService.class);
    /**
     * 状态 0 无效 1有效
     */
    private static final String STATUS = "0";
    /**
     * 获取锁的最大延迟时间（s）
     */
    private static final int DELAY = 10;
    private static final ReentrantLock LOCK = new ReentrantLock();
    ;
    @Autowired
    private Scheduler scheduler;

    @Autowired
    @Qualifier("scheduleTriggerMapper")
    private ScheduleTriggerMapper scheduleTriggerMapper;

    private ThreadPoolExecutor executor;

    @PostConstruct
    public void init() {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
        executor = new ThreadPoolExecutor(1, 10, 300, TimeUnit.SECONDS, taskQueue);
        executor.allowCoreThreadTimeOut(false);
    }

    /**
     * 定时刷新扫描配置表
     */
    @Scheduled(fixedRate = 1000 * 30)
    public void refreshTrigger() {
        try {

            List<ScheduleTrigger> jobList = scheduleTriggerMapper.selectAll();
            if (null != jobList && jobList.size() > 0) {
                for (ScheduleTrigger scheduleJob : jobList) {
                    pushScheduledTask(scheduleJob);
                }
            }
        } catch (Exception e) {
            logger.error("定时任务每日刷新触发器任务异常，在ScheduleTriggerService的方法refreshTrigger中，异常信息：", e);
        }
    }

    private void pushScheduledTask(Object obj) {
        executor.execute(new UpdateTask(obj));
    }

    private void updateScheduledTask(Object obj) {
        if (!(obj instanceof ScheduleTrigger)) {
            return;
        }
        try {
            if (LOCK.tryLock(DELAY, TimeUnit.SECONDS)) {
                ScheduleTrigger scheduleJob = (ScheduleTrigger) obj;
                String status = scheduleJob.getStatus();
                TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                // 说明本条任务还没有添加到quartz中
                if (null == trigger) {
                    if (STATUS.equals(status)) {
                        return;
                    }
                    try {
                        // 创建JobDetail（数据库中job_name存的任务全路径，这里就可以动态的把任务注入到JobDetail中）
                        JobDetail jobDetail = JobBuilder
                                .newJob((Class<? extends Job>) Class.forName(scheduleJob.getJobName()))
                                .withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).build();
                        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                                .cronSchedule(scheduleJob.getCron());
                        trigger = TriggerBuilder.newTrigger()
                                .withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup())
                                .withSchedule(scheduleBuilder).build();
                        scheduler.scheduleJob(jobDetail, trigger);
                    } catch (Exception e) {
                        logger.error("执行任务调度出现异常ClassNotFoundException {}", e);
                    } finally {
                        LOCK.unlock();
                    }
                } else {
                    // 如果是禁用，从quartz中删除这条任务
                    try {
                        if (STATUS.equals(status)) {
                            JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                            scheduler.deleteJob(jobKey);
                            return;
                        }
                        String searchCron = scheduleJob.getCron();
                        String currentCron = trigger.getCronExpression();
                        if (!searchCron.equals(currentCron)) {
                            // 表达式调度构建器
                            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
                            // 按新的cronExpression表达式重新构建trigger
                            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder)
                                    .build();
                            // 按新的trigger重新设置job执行
                            scheduler.rescheduleJob(triggerKey, trigger);
                        }
                    } catch (Exception e) {
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("定时任务每日刷新触发器任务异常，在ScheduleTriggerService的方法refreshTrigger中，异常信息：", e);
        }
    }

    private class UpdateTask implements Runnable {
        private Object obj;

        public UpdateTask(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            updateScheduledTask(obj);
        }
    }
}