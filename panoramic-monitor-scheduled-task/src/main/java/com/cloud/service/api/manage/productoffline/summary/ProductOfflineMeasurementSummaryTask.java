package com.cloud.service.api.manage.productoffline.summary;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author summer
 */
public interface ProductOfflineMeasurementSummaryTask extends Job {
    /**
     * 执行定时任务
     *
     * @param context
     */
    @Override
    void execute(JobExecutionContext context);
}
