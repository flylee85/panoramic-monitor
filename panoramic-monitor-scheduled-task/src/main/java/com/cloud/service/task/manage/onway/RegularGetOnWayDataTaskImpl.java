/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.cloud.service.task.manage.onway;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.service.api.manage.onway.RegularGetOnWayDataTask;
import com.cloud.service.feign.manage.ManageFeignHystrixClient;
import com.cloud.service.task.manage.exception.ManualEntryExceptionRecordTaskImpl;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;

@Component
public class RegularGetOnWayDataTaskImpl implements RegularGetOnWayDataTask {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(ManualEntryExceptionRecordTaskImpl.class);
    @Autowired
    private ManageFeignHystrixClient manageFeignHystrixClient;

    @Override
    public void execute(JobExecutionContext context) {
        try {
            DB_LOGGER.warn("<--对接G7天眼系统获取数据定时  开始-->");
            manageFeignHystrixClient.manualEntryExceptionRecordTask();
            DB_LOGGER.warn("<--对接G7天眼系统获取数据定时  结束-->");
        } catch (Exception e) {
            DB_LOGGER.error("对接G7天眼系统获取数据定时出现异常{}" + e);
        }
    }
}