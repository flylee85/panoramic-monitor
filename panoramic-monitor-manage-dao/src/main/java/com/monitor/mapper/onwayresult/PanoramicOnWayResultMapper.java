/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.mapper.onwayresult;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.monitor.dto.onwayresult.PanoramicOnWayResultDto;
@Repository("onWayResultMapper")
public interface PanoramicOnWayResultMapper extends Mapper<PanoramicOnWayResultDto> {
	
	 /**
     * 获取在途物资一览
     */
	@Select("select order_no as orderNo,receive_address as receiveAddress ,device_last_address as address,device_start_time as startTime,timestampdiff(day,device_start_time,now()) as useday from panoramic_on_way_order where current_status =1 order by device_last_time desc ")
	   List<PanoramicOnWayResultDto> getOnWayResult(); 
	
	
	@Select(" select order_no as orderNo,receive_address as receiveAddress ,device_start_time as startTime,device_last_time as arriveTime,timestampdiff(day,device_start_time,device_last_time) as useday , timestampdiff(day,request_receive_time,now()) as overday from panoramic_on_way_order where current_status = 2  and timestampdiff(month,utime,now()) < 1 order by device_last_time desc ")
	   List<PanoramicOnWayResultDto> getOnWayFinishResult();
	

	
	 /**
     * 获取在途超时物资数
     */
	@Select("select count(0) from panoramic_on_way_order where  current_status =1  and now() > request_receive_time")
	Integer getOverDayCount();
	
}