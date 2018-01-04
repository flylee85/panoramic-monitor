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
    private String receivername;
    
    private String receiveremail;
    
    private Integer warningsourceid;
    
    private Integer sendstatus;
    
    
    private String reason;
    
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
    
    
    
    
    public String getReceiverName() {
    	return receivername;
    }
    
    public void setReceiverName(String receivername) {
    	this.receivername = receivername;
    }


    public String getReceiverEmail() {
    	return receiveremail;
    }
    
    public void setReceiverEmail(String receiveremail) {
    	this.receiveremail = receiveremail;
    }


    public Integer getWarningSourceID() {
    	return warningsourceid;
    }
    
    public void setWarningSourceID(Integer warningsourceid) {
    	this.warningsourceid = warningsourceid;
    }

    public Integer getSendStatus() {
    	return sendstatus;
    }
    
    public void setSendStatus(Integer sendstatus) {
    	this.sendstatus = sendstatus;
    }
    
    

    public String getReason() {
    	return reason;
    }
    
    public void setReason(String reason) {
    	this.reason = reason;
    }
    
    public Timestamp getSendTime() {
    	return sendtime;
    }
    
    public void setSendTime(Timestamp sendtime) {
    	this.sendtime = sendtime;
    }
    
    
    @Override
    public Serializable realId() {
        return null;
    }
}