package com.monitor.service.productionefficiency;

import com.cloud.core.AbstractService;
import com.monitor.api.productionefficiency.PanoramicProductionEfficiencyService;
import com.monitor.mapper.productionefficiency.PanoramicProductionEfficiencyMapper;
import com.monitor.model.productionefficiency.PanoramicProductionEfficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author  summer
 * 2017/11/21
 */
@Service("panoramicProductionEfficiencyService")
@Transactional
public class PanoramicProductionEfficiencyServiceImpl extends AbstractService<PanoramicProductionEfficiency> implements PanoramicProductionEfficiencyService {
    @Autowired
    @Qualifier("panoramicProductionEfficiencyMapper")
    private PanoramicProductionEfficiencyMapper panoramicProductionEfficiencyMapper;

}