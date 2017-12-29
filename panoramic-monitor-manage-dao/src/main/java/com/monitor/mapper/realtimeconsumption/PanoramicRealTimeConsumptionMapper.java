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
    @Select("SELECT SUBSTRING(CODE, 1, 12) CODE ,NAME FROM PANORAMIC_REAL_TIME_CONSUMPTION AS B GROUP BY SUBSTRING(CODE, 1, 12)")
    List<PanoramicRealTimeConsumption> listRealTimeConsumptionCategory();
    
    /**
     * 查询当天早中晚班中的分时数据
     * 
     */
    @Select("select DATE_FORMAT(ctime,\"%H\") as hour,sum(value) as value from panoramic_real_time_consumption where name like \"%磷矿粉%\" and DATE_FORMAT(ctime,\"%Y%m%d\") = #{date} and DATE_FORMAT(ctime,\"%H\")  BETWEEN 00 and 24 group by DATE_FORMAT(ctime,\"%H\")")
    List<PanoramicRealTimeConsumptionDto> listRealTimeConsumption(@Param("date") String date);
    
    /**
     * 查询当天早中晚班各自合计数据
     * 
     */
    @Select("select sum(value) as value from panoramic_real_time_consumption where name like \"%磷矿粉%\" and DATE_FORMAT(ctime,\"%Y%m%d\") = #{date} and DATE_FORMAT(ctime,\"%H\") BETWEEN #{startHour} and #{endHour}")
    PanoramicRealTimeConsumptionDto listRealTimeConsumptionAmount(@Param("date") String date,@Param("startHour") String startHour,@Param("endHour") String endHour);    
    
}
