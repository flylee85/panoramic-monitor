package com.cloud.service.task.test;

import com.cloud.service.api.test.TestService;
import com.cloud.util.DateUtil;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

/**
 * @author summer
 */
@Service
public class TestServiceImpl implements TestService {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(TestServiceImpl.class);

    @Override
    public void test() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        DB_LOGGER.warn(DateUtil.currentTimeStr());
        DB_LOGGER.warn("哈哈，执行了定时任务");

    }
}
