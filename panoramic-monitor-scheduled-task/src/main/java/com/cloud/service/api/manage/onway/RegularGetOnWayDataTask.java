/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.cloud.service.api.manage.onway;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public interface RegularGetOnWayDataTask extends Job {
    /**
     * 执行定时任务
     *
     * @param context
     */
    @Override
    void execute(JobExecutionContext context);
}