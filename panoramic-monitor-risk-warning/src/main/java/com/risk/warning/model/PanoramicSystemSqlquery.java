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

    /**
     * QuerySql
     */
    private String querysql;

    /**
     * Available
     */
    private Integer available;

    /**
     * IntervalTime
     */
    private Integer intervaltime;

    /**
     * LastExecuteTime
     */
    private Date lastexecutetime;

    /**
     * 获取WarnConfigurationID
     *
     * @return WarnConfigurationID - warnconfigurationid
     */
    public Integer getWarnConfigurationID() {
        return warnconfigurationid;
    }

    /**
     * 设置WarnConfigurationID
     *
     * @param WarnConfigurationID WarnConfigurationID
     */
    public void setWarnConfigurationID(Integer warnconfigurationid) {
        this.warnconfigurationid = warnconfigurationid;
    } 

    /**
     * 获取QuerySql
     *
     * @return QuerySql - querysql
     */
    public String getQuerySql() {
    	return querysql;
    }

    /**
     * 设置QuerySql
     *
     * @param querysql QuerySql
     */
    public void setQuerySql(String querysql) {
    	this.querysql = querysql;
    }

    /**
     * 获取Available
     *
     * @return Available - available
     */
    public Integer getAvailable() {
    	return available;
    }

    /**
     * 设置Available
     *
     * @param available Available
     */
    public void setAvailable(Integer available) {
    	this.available = available;
    }

    /**
     * 获取IntervalTime
     *
     * @return Available - intervaltime
     */
    public Integer getIntervalTime() {
    	return intervaltime;
    }
    
    /**
     * 设置IntervalTime
     *
     * @param intervaltime IntervalTime
     */
    public void setIntervalTime(Integer intervaltime) {
    	this.intervaltime = intervaltime;
    }
    
    /**
     * 获取LastExecuteTime
     *
     * @return LastExecuteTime - lastexecutetime
     */
    public Date getLastExecuteTime() {
    	return lastexecutetime;
    }
    
    /**
     * 设置LastExecuteTime
     *
     * @param lastexecutetime LastExecuteTime
     */
    public void setLastExecuteTime(Date lastexecutetime) {
    	this.lastexecutetime = lastexecutetime;
    } 
    
    @Override
    public Serializable realId() {
        return null;
    }
}