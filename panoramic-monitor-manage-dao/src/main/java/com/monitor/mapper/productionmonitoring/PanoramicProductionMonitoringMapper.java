package com.monitor.mapper.productionmonitoring;

import com.cloud.core.Mapper;
import com.monitor.model.productionmonitoring.PanoramicProductionMonitoring;
import org.springframework.stereotype.Repository;

/**
 * @author summer
 */
@Repository("productionMonitoringMapper")
public interface PanoramicProductionMonitoringMapper extends Mapper<PanoramicProductionMonitoring> {
}