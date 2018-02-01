/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.mapper.onwayorder;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.monitor.model.onwayorder.PanoramicOnWayOrder;
@Repository("onWayOrderMapper")
public interface PanoramicOnWayOrderMapper extends Mapper<PanoramicOnWayOrder> {
	
	/**
	 * 插入订单数据
	 * @param date
	 * @return
	 */
	@Insert("insert into panoramic_on_way_order" + 
			"	(order_no, user_order_no, send_address, send_name, send_mobile, receive_address, receive_name, receive_mobile, request_receive_time, ctime, utime, current_status, current_trans_type, org_code, from_org_code, from_time, deleted)" + 
			"	values" + 
			"	(\'${ordero}\', CASE \'${userorderno}\' WHEN '' THEN NULL ELSE \'${userorderno}\' END, CASE \'${sendaddress}\' WHEN '' THEN NULL ELSE \'${sendaddress}\' END, CASE \'${sendname}\' WHEN '' THEN NULL ELSE \'${sendname}\' END,   CASE \'${sendmobile}\' WHEN '' THEN NULL ELSE \'${sendmobile}\' END,   CASE \'${receiveaddress}\' WHEN '' THEN NULL ELSE \'${receiveaddress}\' END,   CASE \'${receivename}\' WHEN '' THEN NULL ELSE \'${receivename}\' END,  CASE \'${receivemobile}\' WHEN '' THEN NULL ELSE \'${receivemobile}\' END,   CASE \'${requestreceivetime}\' WHEN '' THEN NULL ELSE \'${requestreceivetime}\' END,   CASE \'${ctime}\' WHEN '' THEN NULL ELSE \'${ctime}\' END,   CASE \'${utime}\' WHEN '' THEN NULL ELSE \'${utime}\' END,  \'${currentstatus}\', CASE \'${currenttranstype}\' WHEN '' THEN NULL ELSE \'${currenttranstype}\' END,   CASE \'${orgcode}\' WHEN '' THEN NULL ELSE \'${orgcode}\' END,   CASE \'${fromorgcode}\' WHEN '' THEN NULL ELSE \'${fromorgcode}\' END,  CASE \'${fromtime}\' WHEN '' THEN NULL ELSE \'${fromtime}\' END,  CASE \'${deleted}\' WHEN '' THEN NULL ELSE \'${deleted}\' END)") 
    Boolean addOrderData(@Param("ordero") String ordero
    		,@Param("userorderno") String userorderno
    		,@Param("sendaddress") String sendaddress
    		,@Param("sendname") String sendname
    		,@Param("sendmobile") String sendmobile
    		,@Param("receiveaddress") String receiveaddress
    		,@Param("receivename") String receivename
    		,@Param("receivemobile") String receivemobile
    		,@Param("requestreceivetime") String requestreceivetime
    		,@Param("ctime") String ctime
    		,@Param("utime") String utime
    		,@Param("currentstatus") String currentstatus
    		,@Param("currenttranstype") String currenttranstype
    		,@Param("orgcode") String orgcode
    		,@Param("fromorgcode") String fromorgcode
    		,@Param("fromtime") String fromtime
    		,@Param("deleted") String deleted);
	
	@Update("update panoramic_on_way_order" + 
			"	set " + 
			"	user_order_no = CASE \'${userorderno}\' WHEN '' THEN NULL ELSE \'${userorderno}\' END," + 
			"	send_address = CASE \'${sendaddress}\' WHEN '' THEN NULL ELSE \'${sendaddress}\' END," + 
			"	send_name = CASE \'${sendname}\' WHEN '' THEN NULL ELSE \'${sendname}\' END," + 
			"	send_mobile = CASE \'${sendmobile}\' WHEN '' THEN NULL ELSE \'${sendmobile}\' END," + 
			"	receive_address = CASE \'${receiveaddress}\' WHEN '' THEN NULL ELSE \'${receiveaddress}\' END," + 
			"	receive_name = CASE \'${receivename}\' WHEN '' THEN NULL ELSE \'${receivename}\' END," + 
			"	receive_mobile = CASE \'${receivemobile}\' WHEN '' THEN NULL ELSE \'${receivemobile}\' END," + 
			"	request_receive_time = CASE \'${requestreceivetime}\' WHEN '' THEN NULL ELSE \'${requestreceivetime}\' END," + 
			"	ctime = CASE \'${ctime}\' WHEN '' THEN NULL ELSE \'${ctime}\' END," + 
			"	utime = CASE \'${utime}\' WHEN '' THEN NULL ELSE \'${utime}\' END," + 
			"	current_status = \'${currentstatus}\' ," + 
			"	current_trans_type = CASE \'${currenttranstype}\' WHEN '' THEN NULL ELSE \'${currenttranstype}\' END," + 
			"	org_code = CASE \'${orgcode}\' WHEN '' THEN NULL ELSE \'${orgcode}\' END," + 
			"	from_org_code = CASE \'${fromorgcode}\' WHEN '' THEN NULL ELSE \'${fromorgcode}\' END," + 
			"	from_time = CASE \'${fromtime}\' WHEN '' THEN NULL ELSE \'${fromtime}\' END," + 
			"	deleted = CASE \'${deleted}\' WHEN '' THEN NULL ELSE \'${deleted}\' END " + 
			"	where" + 
			"	order_no = \'${orderno}\' ")
	
    Boolean updateOrderData(@Param("userorderno") String userorderno
    		,@Param("sendaddress") String sendaddress
    		,@Param("sendname") String sendname
    		,@Param("sendmobile") String sendmobile
    		,@Param("receiveaddress") String receiveaddress
    		,@Param("receivename") String receivename
    		,@Param("receivemobile") String receivemobile
    		,@Param("requestreceivetime") String requestreceivetime
    		,@Param("ctime") String ctime
    		,@Param("utime") String utime
    		,@Param("currentstatus") String currentstatus
    		,@Param("currenttranstype") String currenttranstype
    		,@Param("orgcode") String orgcode
    		,@Param("fromorgcode") String fromorgcode
    		,@Param("fromtime") String fromtime
    		,@Param("deleted") String deleted
    		,@Param("orderno") String orderno);
	
	@Select(" Select date_format(max(ctime) ,'%Y-%m-%d %T')  from panoramic_on_way_order  ")
	String getStartTime();
	

	 /**
   * 验证是否存在
   */
	@Select(" select count(0)  from panoramic_on_way_order where order_no = \'${order_no}\'")
	Integer isExistOrder(@Param("order_no") String order_no);
	

	 /**
	   * 获取状态是未完成的订单号用来获取订单最新的状态
	 */
	@Select("select order_no from panoramic_on_way_order where current_status <> 2 order by ctime ")
	List<String> getUnfinishOrderNo();
	
	 /**
	   * 获取最近一个月已经完成的或者未完成的订单号用来获取天眼最新的节点信息
	 */
	@Select("SELECT order_no FROM panoramic_on_way_order WHERE deleted = 'false' AND ((current_status = 2 AND TIMESTAMPDIFF(DAY,utime,NOW()) < 3) OR current_status = 1) ")
	List<String> getNeedUpdateDeviceOrderNo();
	
	@Update("update panoramic_on_way_order " + 
			"set device_no = CASE \'${deviceno}\' WHEN '' THEN NULL ELSE \'${deviceno}\' END, " + 
			"device_start_time = CASE \'${devicestarttime}\' WHEN '' THEN ctime ELSE \'${devicestarttime}\' END, "+ 
			"device_last_time = CASE \'${devicelasttime}\' WHEN '' THEN NULL ELSE \'${devicelasttime}\' END, " + 
			"device_last_address =  CASE \'${devicelastaddress}\' WHEN '' THEN NULL ELSE \'${devicelastaddress}\' END  " + 
			"where order_no = \'${orderno}\' ")
	void updateOrderNodes(@Param("deviceno") String deviceno,@Param("devicestarttime") String devicestarttime,@Param("devicelasttime") String devicelasttime,@Param("devicelastaddress") String devicelastaddress,@Param("orderno") String orderno);
	
}