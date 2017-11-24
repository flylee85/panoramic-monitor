package com.monitor.service.realtimeconsumption;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.realtimeconsumption.PanoramicRealTimeConsumptionService;
import com.monitor.mapper.realtimeconsumption.PanoramicRealTimeConsumptionMapper;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicRealTimeConsumptionService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicRealTimeConsumptionServiceImpl extends AbstractService<PanoramicRealTimeConsumption> implements PanoramicRealTimeConsumptionService {
    @Autowired
    @Qualifier("panoramicRealTimeConsumptionMapper")
    private PanoramicRealTimeConsumptionMapper panoramicRealTimeConsumptionMapper;

}
