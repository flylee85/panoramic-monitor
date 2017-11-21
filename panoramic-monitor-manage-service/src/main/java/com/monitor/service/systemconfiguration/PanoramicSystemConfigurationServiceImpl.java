package com.monitor.service.systemconfiguration;

import com.cloud.core.AbstractService;
import com.monitor.api.systemconfiguration.PanoramicSystemConfigurationService;
import com.monitor.mapper.systemconfiguration.PanoramicSystemConfigurationMapper;
import com.monitor.model.systemconfiguration.PanoramicSystemConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * sunder
 * 2017/11/21.
 */
@Service("panoramicSystemConfigurationService")
@Transactional
public class PanoramicSystemConfigurationServiceImpl extends AbstractService<PanoramicSystemConfiguration> implements PanoramicSystemConfigurationService {
    @Autowired
    @Qualifier("panoramicSystemConfigurationMapper")
    private PanoramicSystemConfigurationMapper panoramicSystemConfigurationMapper;

}
