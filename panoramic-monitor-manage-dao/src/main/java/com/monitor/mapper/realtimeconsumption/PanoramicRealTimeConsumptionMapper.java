package com.monitor.mapper.realtimeconsumption;

import com.cloud.core.Mapper;
import com.monitor.dto.realtimeconsumption.PanoramicRealTimeConsumptionDto;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author summer
 */
@Repository("realTimeConsumptionMapper")
public interface PanoramicRealTimeConsumptionMapper extends Mapper<PanoramicRealTimeConsumption> {

    /**
     * 查询所有物料code和名称
     *
     * @return
     */
    @Select("SELECT SUBSTRING(CODE,1,12) AS CODE,NAME FROM PANORAMIC_REAL_TIME_CONSUMPTION  GROUP BY CODE,NAME")
    List<PanoramicRealTimeConsumption> listRealTimeConsumptionCategory();
    
    /**
     * 时间段内数据统计
     * @param code
     * @param dateBefore
     * @param dateEnd
     * @return
     */
    PanoramicRealTimeConsumption selectSummaryConsumptionByCondition(
    		@Param("code") String code,
    		@Param("dateBefore") String dateBefore,
    		@Param("dateEnd") String dateEnd);
}
