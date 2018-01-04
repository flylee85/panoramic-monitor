package com.risk.warning.model;

import com.cloud.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "PanoramicSystemSqlquery")
public class PanoramicSystemSqlquery extends BaseObject {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    /**
     * WarnConfigurationID
     */
    private Integer warnconfigurationid;
    
    private String querysql;

    private Integer available;
    
    private Integer intervaltime;
    
    private Date lastexecutetime;

    /**
     * 获取WarnConfigurationID
     *
     * @return WarnConfigurationID - ID
     */
    public Integer getWarnConfigurationID() {
        return warnconfigurationid;
    }

    /**
     * 设置WarnConfigurationID
     *
     * @param WarnConfigurationID ID
     */
    public void setWarnConfigurationID(Integer warnconfigurationid) {
        this.warnconfigurationid = warnconfigurationid;
    } 
    
    public String getQuerySql() {
    	return querysql;
    	
    }
    
    public void setQuerySql(String querysql) {
    	this.querysql = querysql;
    }

    public Integer getAvailable() {
    	return available;
    }
    
    public void setAvailable(Integer available) {
    	this.available = available;
    }
    
  
    public Integer getIntervalTime() {
    	return intervaltime;
    }
    
    public void setIntervalTime(Integer intervaltime) {
    	this.intervaltime = intervaltime;
    }
    
    public Date getLastExecuteTime() {
    	return lastexecutetime;
    }
    
    public void setLastExecuteTime(Date lastexecutetime) {
    	this.lastexecutetime = lastexecutetime;
    } 
    
    @Override
    public Serializable realId() {
        return null;
    }
}