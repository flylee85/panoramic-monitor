package com.monitor.service.realtimeconsumptiongather;

import com.cloud.core.AbstractService;
import com.monitor.api.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherService;
import com.monitor.mapper.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherMapper;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicRealTimeConsumptionGatherService")
@Transactional
public class PanoramicRealTimeConsumptionGatherServiceImpl extends AbstractService<PanoramicRealTimeConsumptionGather> implements PanoramicRealTimeConsumptionGatherService {
    @Autowired
    @Qualifier("panoramicRealTimeConsumptionGatherMapper")
    private PanoramicRealTimeConsumptionGatherMapper panoramicRealTimeConsumptionGatherMapper;

}
