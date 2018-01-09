package com.cloud.service.task.manage.productoffline.summary;

import com.cloud.service.api.manage.productoffline.summary.ProductOfflineMeasurementSummaryTask;
import com.cloud.service.feign.manage.ManageFeignHystrixClient;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消耗数据定时任务汇总
 *
 * @author summer
 */
@Component
public class ProductOfflineMeasurementSummaryTaskImpl implements ProductOfflineMeasurementSummaryTask {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(ProductOfflineMeasurementSummaryTaskImpl.class);
    @Autowired
    private ManageFeignHystrixClient manageFeignHystrixClient;

    @Override
    public void execute(JobExecutionContext context) {

        try {
            DB_LOGGER.warn("<--产品下线数据汇总任务  开始-->");
            manageFeignHystrixClient.productOfflineMeausurementSummaryTask();
            DB_LOGGER.warn("<--产品下线数据汇总任务  结束-->");
        } catch (Exception e) {
            DB_LOGGER.error("产品下线数据汇总任务出现异常{}" + e);
        }
    }
}
