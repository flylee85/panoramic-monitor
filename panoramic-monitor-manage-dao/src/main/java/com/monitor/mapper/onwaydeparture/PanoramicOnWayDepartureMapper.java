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

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.monitor.model.onwaydeparture.PanoramicOnWayDeparture;

@Repository("onWayDepartureMapper")
public interface PanoramicOnWayDepartureMapper extends Mapper<PanoramicOnWayDeparture> {
	
	@Insert("insert into panoramic.panoramic_on_way_departure " + 
			"	(departure_id, start_time, arrive_time, postman, postman_phone)" + 
			"	values " + 
			"	(\'${departureid}\', \'${starttime}\', \'${arrivetime}\', \'${postman}\', \'${postmanphone}\')")
	
    Boolean addDepartureData(@Param("departureid") String departureid
    		,@Param("starttime") Timestamp starttime
    		,@Param("arrivetime") Timestamp arrivetime
    		,@Param("postman") String postman
    		,@Param("postmanphone") String postmanphone);
	
	@Update("update panoramic.panoramic_on_way_departure " + 
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
}