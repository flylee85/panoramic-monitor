/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.cloud.service.task.risk.scanwarningdata;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.service.api.risk.scanwarningdata.RealTimeScanWarningDataTask;
import com.cloud.service.feign.manage.ManageFeignHystrixClient;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;

@Component
public class RealTimeScanWarningDataTaskImpl implements RealTimeScanWarningDataTask {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(RealTimeScanWarningDataTaskImpl.class);
    
    @Autowired
    private ManageFeignHystrixClient manageFeignHystrixClient;

    @Override
    public void execute(JobExecutionContext context) {
        try {
            DB_LOGGER.warn("<--扫描预警数据定时任务  开始-->");
            manageFeignHystrixClient.realTimeScanWarningDataTask();
            DB_LOGGER.warn("<--扫描预警数据定时任务 结束-->");
        } catch (Exception e) {
            DB_LOGGER.error("扫描预警数据定时任务出现异常{}" + e);
        }
    }
}
