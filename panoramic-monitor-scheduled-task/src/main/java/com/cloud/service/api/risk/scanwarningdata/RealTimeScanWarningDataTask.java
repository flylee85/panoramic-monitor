package com.cloud.service.api.risk.scanwarningdata;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author 
 */
public interface RealTimeScanWarningDataTask extends Job {
    /**
     * 执行定时任务
     *
     * @param 
     */
    @Override
    void execute(JobExecutionContext context);
}
