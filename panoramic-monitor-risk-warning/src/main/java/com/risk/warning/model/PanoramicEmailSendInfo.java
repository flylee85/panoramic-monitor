package com.risk.warning.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cloud.model.BaseObject;
/**
 * @author 
 */
@Table(name = "panoramic_system_EmailSendInfo")
public class PanoramicEmailSendInfo extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * ReceiveNname
     */
    private String receiver_name;

    /**
     * ReceiverEmail
     */
    private String receiver_email;

    /**
     * WarningSourceID
     */
    private Integer warning_source_id;

    /**
     * SendStatus 
     * 1：成功 2:失败
     */
    private Integer send_status;
    
    /**
     * Reason
     */
    private String reason;

    /**
     * SendTime
     */
    private Timestamp send_time;
    
    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    } 
    
    /**
     * 获取ReceiverName
     *
     * @return receiver_name - ReceiverName
     */
    public String getReceiverName() {
    	return receiver_name;
    }

    /**
     * 设置ReceiverName
     *
     * @param receivername ReceiverName
     */
    public void setReceiverName(String receivername) {
    	this.receiver_name = receivername;
    }
    
    /**
     * 获取ReceiverEmail
     *
     * @return receiver_email - ReceiverEmail
     */
    public String getReceiverEmail() {
    	return receiver_email;
    }

    /**
     * 设置ReceiverEmail
     *
     * @param receiveremail ReceiverEmail
     */
    public void setReceiverEmail(String receiveremail) {
    	this.receiver_email = receiveremail;
    }

    
    /**
     * 获取WarningSourceID
     *
     * @return warning_source_id - WarningSourceID
     */
    public Integer getWarningSourceID() {
    	return warning_source_id;
    }


    /**
     * 设置WarningSourceID
     *
     * @param warningsourceid WarningSourceID
     */
    public void setWarningSourceID(Integer warningsourceid) {
    	this.warning_source_id = warningsourceid;
    }

    /**
     * 获取SendStatus
     *
     * @return send_status - SendStatus
     */
    public Integer getSendStatus() {
    	return send_status;
    }

    /**
     * 设置SendStatus
     *
     * @param sendstatus SendStatus
     */
    public void setSendStatus(Integer sendstatus) {
    	this.send_status = sendstatus;
    }

    /**
     * 获取Reason
     *
     * @return reason - Reason
     */
    public String getReason() {
    	return reason;
    }

    /**
     * 设置Reason
     *
     * @param reason Reason
     */
    public void setReason(String reason) {
    	this.reason = reason;
    }


    /**
     * 获取SendTime
     *
     * @return sendtime - SendTime
     */
    public Timestamp getSendTime() {
    	return send_time;
    }


    /**
     * 设置SendTime
     *
     * @param sendtime SendTime
     */
    public void setSendTime(Timestamp sendtime) {
    	this.send_time = sendtime;
    }
    
    
    @Override
    public Serializable realId() {
        return null;
    }
}