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
 * 扫描预警数据
 *
 * @author  定时任务必须实现Job接口
 */
//@Component
public class RealTimeScanWarningDataTask implements Job {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(RealTimeScanWarningDataTask.class);
    @Autowired
    @Qualifier("panoramicSystemSqlqueryService")
    private PanoramicSystemSqlqueryService panoramicSystemSqlqueryService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            DB_LOGGER.warn("<----------扫描预警数据定时刷新开始---------->");
        	panoramicSystemSqlqueryService.realTimeScanWarningDataTask();
            DB_LOGGER.warn("<----------扫描预警数据定时刷新刷新结束---------->");
        } catch (Exception e) {
        	DB_LOGGER.warn("扫描预警数据定时刷新定时刷新出错{}" + e);
        }
    }

}