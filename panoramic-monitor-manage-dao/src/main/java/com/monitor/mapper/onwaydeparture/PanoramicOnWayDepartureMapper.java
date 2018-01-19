/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.mapper.onwaydeparture;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.monitor.model.onwaydeparture.PanoramicOnWayDeparture;

@Repository("onWayDepartureMapper")
public interface PanoramicOnWayDepartureMapper extends Mapper<PanoramicOnWayDeparture> {
	
	@Insert("insert into panoramic_on_way_departure " + 
			"	(departure_id, start_time, arrive_time, postman, postman_phone)" + 
			"	values " + 
			"	(\'${departureid}\', CASE \'${starttime}\' WHEN '' THEN NULL ELSE \'${starttime}\' END, CASE \'${arrivetime}\' WHEN '' THEN NULL ELSE \'${arrivetime}\' END, CASE \'${postman}\' WHEN '' THEN NULL ELSE \'${postman}\' END, CASE \'${postmanphone}\' WHEN '' THEN NULL ELSE \'${postmanphone}\' END)")
	
    Boolean addDepartureData(@Param("departureid") String departureid
    		,@Param("starttime") Timestamp starttime
    		,@Param("arrivetime") Timestamp arrivetime
    		,@Param("postman") String postman
    		,@Param("postmanphone") String postmanphone);
	
	@Update("update panoramic_on_way_departure " + 
			"	set" + 
			"	start_time = \'${starttime}\' , " + 
			"	arrive_time = \'${arrivetime}\' , " + 
			"	postman = \'${postman}\' , " + 
			"	postman_phone = \'${postmanphone}\' " + 
			"	where" + 
			"	departure_id = \'${departureid}\' ")
	
    Boolean updateDepartureData(@Param("starttime") Timestamp starttime
    		,@Param("arrivetime") Timestamp arrivetime
    		,@Param("postman") String postman
    		,@Param("postmanphone") String postmanphone
    		,@Param("departureid") String departureid);
	
	
	@Insert(" insert into panoramic_on_way_order_departure_relationship " + 
			"	(order_no, departure_id, ctime ) " + 
			"	values (\'${orderno}\',\'${departureid}\', now() )" )
	
	void addOrderDepartureLate(@Param("orderno") String orderno,@Param("departureid") String departureid);
	
	@Delete("delete panoramic_on_way_order_departure_relationship where order = \'${orderno}\' ")
	void deleteOrderDeparturelate(@Param("orderno") String orderno);
	
	
	
	
}