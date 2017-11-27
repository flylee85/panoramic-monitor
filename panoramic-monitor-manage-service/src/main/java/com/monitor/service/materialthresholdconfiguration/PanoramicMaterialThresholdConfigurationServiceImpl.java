package com.monitor.service.materialthresholdconfiguration;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.materialthresholdconfiguration.PanoramicMaterialThresholdConfigurationService;
import com.monitor.mapper.materialthresholdconfiguration.PanoramicMaterialThresholdConfigurationMapper;
import com.monitor.model.materialthresholdconfiguration.PanoramicMaterialThresholdConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author summer
 * 2017/11/27
 */
@Service("materialThresholdConfigurationService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicMaterialThresholdConfigurationServiceImpl extends AbstractService<PanoramicMaterialThresholdConfiguration> implements PanoramicMaterialThresholdConfigurationService {
    @Autowired
    @Qualifier("materialThresholdConfigurationMapper")
    private PanoramicMaterialThresholdConfigurationMapper materialThresholdConfigurationMapper;

}
