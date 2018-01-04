/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.risk.warning.service.scheduletask;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cloud.util.DateUtil;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemSqlqueryService;

/**
 * 实时消耗数据汇总到汇总表
 *
 * @author summer 定时任务必须实现Job接口
 */
//@Component
public class panoramicSystemSqlqueryTask implements Job {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(panoramicSystemSqlqueryTask.class);
    @Autowired
    @Qualifier("panoramicSystemSqlqueryService")
    private PanoramicSystemSqlqueryService panoramicSystemSqlqueryService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
        	DB_LOGGER.warn("abc");
        } catch (Exception e) {
            DB_LOGGER.warn("");
        }
    }

}