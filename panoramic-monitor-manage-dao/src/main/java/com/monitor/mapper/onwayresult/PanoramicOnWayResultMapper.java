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
	@Select(" select t1.order_no as orderNo,t1.receive_address as receiveAddress ,t3.address,t5.start_time as startTime,timestampdiff(day,t1.request_receive_time,now()) as overday,t5.arrive_time as arriveTime,timestampdiff(day,t5.start_time,t5.arrive_time) as useday from panoramic_on_way_order t1" + 
			" left join panoramic_on_way_order_device_relationship t2 " + 
			" on t1.order_no = t2.order_no " + 
			" left join panoramic_on_way_device t3 " + 
			" on t2.device_no = t3.device_no " + 
			" left join panoramic_on_way_order_departure_relationship t4 " + 
			" on t1.order_no = t4.order_no " + 
			" left join panoramic_on_way_departure t5 " + 
			" on t4.departure_id = t5.departure_id " + 
			" where T1.current_status =${currentstatus} and t5.start_time >= \'${startdate}\' and t5.start_time <= \'${enddate}\' order by t5.start_time desc ")
	   List<PanoramicOnWayResultDto> getOnWayResult(@Param("currentstatus") Integer currentstatus,@Param("startdate") String startdate,@Param("enddate") String enddate);
	

	
	 /**
     * 获取在途超时物资数
     */
	@Select("select count(0) from panoramic_on_way_order where  current_status =1  and now() > request_receive_time")
	Integer getOverDayCount();
	
}