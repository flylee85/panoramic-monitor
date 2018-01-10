/**
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 */
/**
 * @author fgh
 *
 */
package com.cloud.service.task.risk.dealwarningdata;

import com.cloud.service.api.risk.dealwarningdata.RealTimeDealWarningDataTask;
import com.cloud.service.feign.risk.RiskFeignHystrixClient;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RealTimeDealWarningDataTaskImpl implements RealTimeDealWarningDataTask {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(RealTimeDealWarningDataTaskImpl.class);

    @Autowired
    private RiskFeignHystrixClient riskFeignHystrixClient;

    @Override
    public void execute(JobExecutionContext context) {
        try {
            DB_LOGGER.warn("<--处理预警数据定时任务  开始-->");
            riskFeignHystrixClient.realTimedealWarningDataTask();
            DB_LOGGER.warn("<--处理预警数据定时任务 结束-->");
        } catch (Exception e) {
            DB_LOGGER.error("处理预警数据定时任务出现异常{}" + e);
        }
    }
}