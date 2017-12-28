package com.monitor.api.productionmonitoring;

import com.cloud.core.Service;
import com.monitor.dto.productionmonitoring.Productionmonitoringinfo;
import com.monitor.model.productionmonitoring.PanoramicProductionMonitoring;


/**
* @author xuegang
* 2017/12/20.
*/
public interface PanoramicProductionMonitoringService extends Service<PanoramicProductionMonitoring> {
	
    /**
     * @param code
     * @param category
     * @return
     */
	Productionmonitoringinfo findByDate(String date);
    
}
