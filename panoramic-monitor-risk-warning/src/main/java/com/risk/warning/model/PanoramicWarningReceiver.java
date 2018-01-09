package com.risk.warning.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cloud.model.BaseObject;
/**
 * @author 
 */
@Table(name = "panoramic_system_WarningReceiver")
public class PanoramicWarningReceiver extends BaseObject {

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
     * WarningConfigurationID
     */
    private Integer warningconfigurationid;
    
    /**
     * UserID
     */
    private Integer userid;
    
    /**
     * UserName
     */
    private String username;
    
    /**
     * Email
     */
    private String email;
    
    /**
     * Level
     */
    private Integer level;
    
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
     * 获取getWarningConfigurationID
     *
     * @return warningconfigurationid - getWarningConfigurationID
     */
    public Integer getWarningConfigurationID() {
    	return warningconfigurationid;
    }
    
    /**
     * 设置getWarningConfigurationID
     *
     * @param warningconfigurationid getWarningConfigurationID
     */
    public void setWarningConfigurationID(Integer warningconfigurationid) {
    	this.warningconfigurationid = warningconfigurationid;
    }
    
    /**
     * 获取UserID
     *
     * @return userid - UserID
     */
    public Integer getUserID() {
    	return userid;
    }
    
    /**
     * 设置UserID
     *
     * @param userid UserID
     */ 
    public void setUserID(Integer userid) {
    	this.userid = userid;
    }
    
    /**
     * 获取UserName
     *
     * @return username - UserName
     */
    public String getUserName() {
    	return username;
    }
    
    /**
     * 设置UserName
     *
     * @param username UserName
     */ 
    public void setUserName(String username) {
    	this.username = username;
    }
    
    /**
     * 获取Email
     *
     * @return email - Email
     */
    public String getEmail() {
    	return email;
    }
    
    /**
     * 设置Email
     *
     * @param email Email
     */ 
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * 获取Level
     *
     * @return level - Level
     */
    public Integer getLevel() {
    	return level;
    }

    /**
     * 设置Level
     *
     * @param level Level
     */ 
    public void setLevel(Integer level) {
    	this.level = level;
    }
    
    @Override
    public Serializable realId() {
        return null;
    }
}