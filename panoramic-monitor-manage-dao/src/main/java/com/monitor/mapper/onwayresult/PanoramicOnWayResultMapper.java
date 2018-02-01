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
	@Select("SELECT order_no AS orderNo,receive_address AS receiveAddress ,device_last_address AS address,IFNULL(device_start_time,ctime) AS startTime,TIMESTAMPDIFF(DAY,IFNULL(device_start_time,ctime),NOW()) AS useday FROM panoramic_on_way_order WHERE current_status =1 ORDER BY device_last_time DESC ")
	   List<PanoramicOnWayResultDto> getOnWayResult(); 
	
	
	@Select(" SELECT order_no AS orderNo,receive_address AS receiveAddress ,IFNULL(device_start_time,ctime) AS startTime,utime AS arriveTime,TIMESTAMPDIFF(DAY,IFNULL(device_start_time,ctime),utime) AS useday , TIMESTAMPDIFF(DAY,request_receive_time,NOW()) AS overday FROM panoramic_on_way_order WHERE current_status = 2  AND TIMESTAMPDIFF(MONTH,utime,NOW()) <3 ORDER BY device_last_time DESC ")
	   List<PanoramicOnWayResultDto> getOnWayFinishResult();
	

	
	 /**
     * 获取在途超时物资数
     */
	@Select("select count(0) from panoramic_on_way_order where  current_status =1  and now() > request_receive_time")
	Integer getOverDayCount();
	
}