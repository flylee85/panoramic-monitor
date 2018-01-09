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
    private Integer warn_configuration_id;

    /**
     * QuerySql
     */
    private String query_sql;

    /**
     * Available
     */
    private Integer available;

    /**
     * IntervalTime
     */
    private Integer interval_time;

    /**
     * LastExecuteTime
     */
    private Date last_excute_time;

    /**
     * 获取WarnConfigurationID
     *
     * @return warn_configuration_id - warnconfigurationid
     */
    public Integer getWarnConfigurationID() {
        return warn_configuration_id;
    }

    /**
     * 设置WarnConfigurationID
     *
     * @param WarnConfigurationID WarnConfigurationID
     */
    public void setWarnConfigurationID(Integer warnconfigurationid) {
        this.warn_configuration_id = warnconfigurationid;
    } 

    /**
     * 获取QuerySql
     *
     * @return query_sql - querysql
     */
    public String getQuerySql() {
    	return query_sql;
    }

    /**
     * 设置QuerySql
     *
     * @param querysql QuerySql
     */
    public void setQuerySql(String querysql) {
    	this.query_sql = querysql;
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
     * @return interval_time - intervaltime
     */
    public Integer getIntervalTime() {
    	return interval_time;
    }
    
    /**
     * 设置IntervalTime
     *
     * @param intervaltime IntervalTime
     */
    public void setIntervalTime(Integer intervaltime) {
    	this.interval_time = intervaltime;
    }
    
    /**
     * 获取LastExecuteTime
     *
     * @return last_excute_time - lastexecutetime
     */
    public Date getLastExecuteTime() {
    	return last_excute_time;
    }
    
    /**
     * 设置LastExecuteTime
     *
     * @param lastexecutetime LastExecuteTime
     */
    public void setLastExecuteTime(Date lastexecutetime) {
    	this.last_excute_time = lastexecutetime;
    } 
    
    @Override
    public Serializable realId() {
        return null;
    }
}