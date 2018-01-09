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
    private String receivername;

    /**
     * ReceiverEmail
     */
    private String receiveremail;

    /**
     * WarningSourceID
     */
    private Integer warningsourceid;

    /**
     * SendStatus
     */
    private Integer sendstatus;
    
    /**
     * Reason
     */
    private String reason;

    /**
     * SendTime
     */
    private Timestamp sendtime;
    
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
     * @return receivername - ReceiverName
     */
    public String getReceiverName() {
    	return receivername;
    }

    /**
     * 设置ReceiverName
     *
     * @param receivername ReceiverName
     */
    public void setReceiverName(String receivername) {
    	this.receivername = receivername;
    }
    
    /**
     * 获取ReceiverEmail
     *
     * @return receiveremail - ReceiverEmail
     */
    public String getReceiverEmail() {
    	return receiveremail;
    }

    /**
     * 设置ReceiverEmail
     *
     * @param receiveremail ReceiverEmail
     */
    public void setReceiverEmail(String receiveremail) {
    	this.receiveremail = receiveremail;
    }

    
    /**
     * 获取WarningSourceID
     *
     * @return warningsourceid - WarningSourceID
     */
    public Integer getWarningSourceID() {
    	return warningsourceid;
    }


    /**
     * 设置WarningSourceID
     *
     * @param warningsourceid WarningSourceID
     */
    public void setWarningSourceID(Integer warningsourceid) {
    	this.warningsourceid = warningsourceid;
    }

    /**
     * 获取SendStatus
     *
     * @return sendstatus - SendStatus
     */
    public Integer getSendStatus() {
    	return sendstatus;
    }

    /**
     * 设置SendStatus
     *
     * @param sendstatus SendStatus
     */
    public void setSendStatus(Integer sendstatus) {
    	this.sendstatus = sendstatus;
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
    	return sendtime;
    }


    /**
     * 设置SendTime
     *
     * @param sendtime SendTime
     */
    public void setSendTime(Timestamp sendtime) {
    	this.sendtime = sendtime;
    }
    
    
    @Override
    public Serializable realId() {
        return null;
    }
}