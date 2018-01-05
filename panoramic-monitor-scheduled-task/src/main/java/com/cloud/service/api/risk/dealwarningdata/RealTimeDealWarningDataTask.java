/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.cloud.service.api.risk.dealwarningdata;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public interface RealTimeDealWarningDataTask extends Job {
    /**
     * 执行定时任务
     *
     * @param 
     */
    @Override
    void execute(JobExecutionContext context);
}
