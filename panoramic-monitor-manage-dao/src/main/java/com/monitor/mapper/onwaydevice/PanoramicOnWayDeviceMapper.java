/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.mapper.onwaydevice;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.monitor.model.onwaydevice.PanoramicOnWayDevice;

@Repository("onWayDeviceMapper")
public interface PanoramicOnWayDeviceMapper extends Mapper<PanoramicOnWayDevice> {
	
	@Insert("insert into panoramic_on_way_device " + 
			"	(device_no, device_type, bind, online_status, battery, lng, lat, gps_time, address )" + 
			"	values" + 
			"	(\'${deviceno}\', ${devicetype}, ${bind}, ${onlinestatus}, ${battery}, ${lng}, ${lat}, \'${gpstime}\', \'${address}\') ")
	
    Boolean addDeviceData(@Param("deviceno") String ordero
    		,@Param("devicetype") Integer devicetype
    		,@Param("bind") Integer bind
    		,@Param("onlinestatus") Integer onlinestatus
    		,@Param("battery") Integer battery
    		,@Param("lng") Double lng
    		,@Param("lat") Double lat
    		,@Param("gpstime") Timestamp gpstime
    		,@Param("address") String address);
	
	@Update("update panoramic_on_way_device" + 
			"	set" + 
			"	device_type = ${device_type} ," + 
			"	bind = ${bind}," + 
			"	online_status = ${online_status} ," + 
			"	battery = ${battery} ," + 
			"	lng = ${lng} ," + 
			"	lat = ${lat} ," + 
			"	gps_time = \'${gps_time}\'," + 
			"	address = \'${address}\'" + 
			"	where" + 
			"	device_no = \'${device_no}\' ")    
	Boolean updateDeviceData(@Param("devicetype") Integer devicetype
		    		,@Param("bind") Integer bind
		    		,@Param("onlinestatus") Integer onlinestatus
		    		,@Param("battery") Integer battery
		    		,@Param("lng") Double lng
		    		,@Param("lat") Double lat
		    		,@Param("gpstime") Timestamp gpstime
		    		,@Param("address") String address
		    		,@Param("deviceno") String ordero);
	
	 /**
     * 获取所有设备
     */
	@Select("select * from panoramic_on_way_device")
	List<PanoramicOnWayDevice> getDeviceList();
	 /**
     * 获取设备绑定数
     */
	@Select("select Count(0) from panoramic_on_way_device where bind = 1")
	Integer getBindCount();
	

	 /**
    * 验证是否存在
    */
	@Select(" select count(0)  from panoramic_on_way_device where device_no = \'${deviceno}\'")
	Integer isExistDevice(@Param("deviceno") String deviceno);
	

	@Insert(" insert into panoramic_on_way_order_device_relationship " + 
			"	(order_no, device_no, ctime ) " + 
			"	values (\'${orderno}\',\'${deviceno}\', now() )" )
	
	void addOrderDeviceLate(@Param("orderno") String orderno,@Param("deviceno") String deviceno);
	

	@Delete("delete panoramic_on_way_order_device_relationship where order = \'${orderno}\' ")
	void deleteOrderDevicelate(@Param("orderno") String orderno);
	

	 /**
    * 获取所有设备数量
    */
	@Select("select Count(*) from panoramic_on_way_device")
	Integer getDeviceCount();
	
}