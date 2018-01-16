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
	@Insert("insert into panoramic.panoramic_on_way_order" + 
			"	(order_no, user_order_no, send_address, send_name, send_mobile, receive_address, receive_name, receive_mobile, request_receive_time, ctime, utime, current_status, current_trans_type, org_code, from_org_code, from_time, deleted)" + 
			"	values" + 
			"	(\'${ordero}\', \'${userorderno}\', \'${sendaddress}\', \'${sendname}\', \'${sendmobile}\', \'${receiveaddress}\', \'${receivename}\', \'${receivemobile}\', \'${requestreceivetime}\', \'${ctime}\', \'${utime}\', \'${currentstatus}\', \'${currenttranstype}\', \'${orgcode}\', \'${fromorgcode}\', \'${fromtime}\', \'${deleted}\')")
    Boolean addOrderData(@Param("ordero") String ordero
    		,@Param("userorderno") String userorderno
    		,@Param("sendaddress") String sendaddress
    		,@Param("sendname") String sendname
    		,@Param("sendmobile") String sendmobile
    		,@Param("receiveaddress") String receiveaddress
    		,@Param("receivename") String receivename
    		,@Param("receivemobile") String receivemobile
    		,@Param("requestreceivetime") Date requestreceivetime
    		,@Param("ctime") Timestamp ctime
    		,@Param("utime") Timestamp utime
    		,@Param("currentstatus") String currentstatus
    		,@Param("currenttranstype") String currenttranstype
    		,@Param("orgcode") String orgcode
    		,@Param("fromorgcode") String fromorgcode
    		,@Param("fromtime") String fromtime
    		,@Param("deleted") String deleted);
	
	@Update("update panoramic.panoramic_on_way_order" + 
			"	set " + 
			"	user_order_no = \'${userorderno}\' ," + 
			"	send_address = \'${sendaddress}\' ," + 
			"	send_name = \'${sendname}\' ," + 
			"	send_mobile = \'${sendmobile}\' ," + 
			"	receive_address = \'${receiveaddress}\' ," + 
			"	receive_name = \'${receivename}\' ," + 
			"	receive_mobile = \'${receivemobile}\' ," + 
			"	request_receive_time = \'${requestreceivetime}\' ," + 
			"	ctime = \'${ctime}\' ," + 
			"	utime = \'${utime}\' ," + 
			"	current_status = \'${currentstatus}\' ," + 
			"	current_trans_type = \'${currenttranstype}\' ," + 
			"	org_code = \'${orgcode}\' ," + 
			"	from_org_code = \'${fromorgcode}\' ," + 
			"	from_time = \'${fromtime}\' ," + 
			"	deleted = \'${deleted}\'" + 
			"	where" + 
			"	order_no = \'${orderno}\' ")
    Boolean updateOrderData(@Param("userorderno") String userorderno
    		,@Param("sendaddress") String sendaddress
    		,@Param("sendname") String sendname
    		,@Param("sendmobile") String sendmobile
    		,@Param("receiveaddress") String receiveaddress
    		,@Param("receivename") String receivename
    		,@Param("receivemobile") String receivemobile
    		,@Param("requestreceivetime") Date requestreceivetime
    		,@Param("ctime") Timestamp ctime
    		,@Param("utime") Timestamp utime
    		,@Param("currentstatus") String currentstatus
    		,@Param("currenttranstype") String currenttranstype
    		,@Param("orgcode") String orgcode
    		,@Param("fromorgcode") String fromorgcode
    		,@Param("fromtime") String fromtime
    		,@Param("deleted") String deleted
    		,@Param("ordero") String ordero);
	
	@Select(" Select date_format(max(ctime) ,'%Y-%m-%d %T')  from panoramic_on_way_order  ")
	String getStartTime();
	
	
}