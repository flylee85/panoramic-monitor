package com.monitor.mapper.productionmonitoring;

import com.cloud.core.Mapper;
import com.monitor.dto.productionmonitoring.Productionmonitoringinfo;
import com.monitor.model.productionmonitoring.PanoramicProductionMonitoring;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author summer
 */
@Repository("productionMonitoringMapper")
public interface PanoramicProductionMonitoringMapper extends Mapper<PanoramicProductionMonitoring> {
	
    /**
     * @param category
     * @param date
     * @return
     */
    @Select("select calcium_phosphate_ore_consumption as cpoc,calcium_phosphate_acid_consumption as cpac,coal_calcium_phosphate as ccp,calcium_power_consumption as cpc from panoramic_production_monitoring where DATE_FORMAT(ctime,\"%Y-%m-%d\") = #{date}")
    Productionmonitoringinfo findByDate(@Param("date") String date);
}
