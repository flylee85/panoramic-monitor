package com.cloud.service.feign.risk;

import com.cloud.configure.FeignConfiguration;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author summer
 */
@FeignClient(name = "monitor-zuul", configuration = FeignConfiguration.class, fallback = RiskFeignHystrixClient.HystrixClientFallback.class)
@Service
public interface RiskFeignHystrixClient {

    /**
     * 获取预警数据
     */
    @RequestLine("POST /risk-warning/scan/warning/data/task")
    void realTimeScanWarningDataTask();

    /**
     * 处理预警数据
     */
    @RequestLine("POST /risk-warning/deal/warning/data/task")
    void realTimedealWarningDataTask();

    /**
     * @author summer
     */
    @Component
    class HystrixClientFallback implements RiskFeignHystrixClient {

        private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(HystrixClientFallback.class);

        /**
         * hystrix fallback方法
         */
        @Override
        public void realTimeScanWarningDataTask() {
            DB_LOGGER.warn("扫描预警数据刷新-调度risk-warning服务发生异常，进入fallback方法{},扫描预警数据刷新失败");
            return;
        }
        @Override
        public void realTimedealWarningDataTask() {
            DB_LOGGER.warn("扫描预警数据刷新-调度risk-warning服务发生异常，进入fallback方法{},扫描预警数据刷新失败");
            return;
        }

    }
}
