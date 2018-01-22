package com.risk.warning.mapper;

import com.cloud.core.Mapper;
import com.risk.warning.model.PanoramicEmailSendInfo;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 
 */
@Repository("emailSendInfoMapper")
public interface PanoramicEmailSendInfoMapper extends Mapper<PanoramicEmailSendInfo> {
	
	   @Insert("Insert into panoramic_email_send_info (receiver_name, receiver_email, warning_source_id, send_status, reason, send_time) values(\'${ReceiverName}\',\'${ReceiverEmail}\',${WarningSourceID},${SendStatus},\'${Reason}\',now()) ")
	    void addSendInfo(@Param("ReceiverName") String receivername,@Param("ReceiverEmail") String receiveremail,@Param("WarningSourceID") Integer warningsourceid,@Param("SendStatus") Integer sendstatus,@Param("Reason") String reason);	 
}