package com.risk.warning.dto;

import com.cloud.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 
 */
public class PanoramicSystemSqlqueryDto {
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
    private Timestamp last_excute_time;
    
    /**
     * LogicType
     */
    private Integer logic_type;

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
    public Timestamp getLastExecuteTime() {
    	return last_excute_time;
    }
    
    /**
     * 设置LastExecuteTime
     *
     * @param lastexecutetime LastExecuteTime
     */
    public void setLastExecuteTime(Timestamp lastexecutetime) {
    	this.last_excute_time = lastexecutetime;
    } 
    


    /**
     * 获取LogicType
     *
     * @return logic_type - LogicType
     */
    public Integer getLogicType() {
    	return logic_type;    	
    }
    


    /**
     * 设置LogicType
     *
     * @param logictype LogicType
     */
    public void setLogicType(Integer logictype) {
        this.logic_type = logictype;
    } 
    
}