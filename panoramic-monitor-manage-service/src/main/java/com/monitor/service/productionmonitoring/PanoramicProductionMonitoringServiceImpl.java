package com.monitor.service.productionmonitoring;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.productionmonitoring.PanoramicProductionMonitoringService;
import com.monitor.mapper.productionmonitoring.PanoramicProductionMonitoringMapper;
import com.monitor.model.productionmonitoring.PanoramicProductionMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicProductionMonitoringService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicProductionMonitoringServiceImpl extends AbstractService<PanoramicProductionMonitoring> implements PanoramicProductionMonitoringService {
    @Autowired
    @Qualifier("panoramicProductionMonitoringMapper")
    private PanoramicProductionMonitoringMapper panoramicProductionMonitoringMapper;

}
