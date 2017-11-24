package com.monitor.service.scheduletask;

import com.cloud.core.AbstractService;
import com.monitor.api.scheduletask.ScheduleTriggerService;
import com.monitor.mapper.scheduletask.ScheduleTriggerMapper;
import com.monitor.model.task.ScheduleTrigger;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author summer
 */
@Service
public class ScheduleTriggerServiceImpl extends AbstractService<ScheduleTrigger> implements ScheduleTriggerService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTriggerServiceImpl.class);
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleTriggerMapper scheduleTriggerMapper;

    @Scheduled(fixedRate = 5000)
    @Override
    public void refreshTrigger() {
        try {
            List<ScheduleTrigger> jobList = scheduleTriggerMapper.selectAll();
            if (null != jobList && jobList.size() > 0) {
                for (ScheduleTrigger scheduleJob : jobList) {
                    String status = scheduleJob.getStatus();
                    TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                    CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                    //说明本条任务还没有添加到quartz中
                    if (null == trigger) {
                        if ("0".equals(status)) {
                            continue;
                        }
                        JobDetail jobDetail = null;
                        try {
                            //创建JobDetail（数据库中job_name存的任务全路径，这里就可以动态的把任务注入到JobDetail中）
                            jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(scheduleJob.getJobName()))
                                    .withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).build();
                            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob
                                    .getCron());
                            trigger = TriggerBuilder.newTrigger().withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).withSchedule(scheduleBuilder).build();
                            scheduler.scheduleJob(jobDetail, trigger);
                        } catch (ClassNotFoundException e) {
                        }
                    } else {
                        //如果是禁用，从quartz中删除这条任务
                        if ("0".equals(status)) {
                            JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                            scheduler.deleteJob(jobKey);
                            continue;
                        }
                        String searchCron = scheduleJob.getCron();
                        String currentCron = trigger.getCronExpression();
                        if (!searchCron.equals(currentCron)) {
                            //表达式调度构建器
                            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
                            //按新的cronExpression表达式重新构建trigger
                            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                                    .withSchedule(scheduleBuilder).build();
                            //按新的trigger重新设置job执行
                            scheduler.rescheduleJob(triggerKey, trigger);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("定时任务每日刷新触发器任务异常，在ScheduleTriggerService的方法refreshTrigger中，异常信息：", e);
        }
    }
}
