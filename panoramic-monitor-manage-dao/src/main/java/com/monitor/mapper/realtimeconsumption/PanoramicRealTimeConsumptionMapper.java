package com.monitor.mapper.realtimeconsumption;

import com.cloud.core.Mapper;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author summer
 */
@Repository("realTimeConsumptionMapper")
public interface PanoramicRealTimeConsumptionMapper extends Mapper<PanoramicRealTimeConsumption> {

    @Select("select id,code,name  from panoramic_real_time_consumption as b group by code ")
    List<PanoramicRealTimeConsumption> listRealTimeConsumptionCategory();
}