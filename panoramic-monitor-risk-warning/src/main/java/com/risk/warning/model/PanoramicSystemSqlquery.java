package com.risk.warning.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "panoramic_system_sqlquery")
public class PanoramicSystemSqlquery {
    @Id
    @Column(name = "warn_configuration_id")
    private Integer warnConfigurationId;

    @Column(name = "query_sql")
    private String querySql;

    private Boolean available;

    @Column(name = "interval_time")
    private Integer intervalTime;

    @Column(name = "last_excute_time")
    private Date lastExcuteTime;

    /**
     * @return warn_configuration_id
     */
    public Integer getWarnConfigurationId() {
        return warnConfigurationId;
    }

    /**
     * @param warnConfigurationId
     */
    public void setWarnConfigurationId(Integer warnConfigurationId) {
        this.warnConfigurationId = warnConfigurationId;
    }

    /**
     * @return query_sql
     */
    public String getQuerySql() {
        return querySql;
    }

    /**
     * @param querySql
     */
    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    /**
     * @return available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * @return interval_time
     */
    public Integer getIntervalTime() {
        return intervalTime;
    }

    /**
     * @param intervalTime
     */
    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }

    /**
     * @return last_excute_time
     */
    public Date getLastExcuteTime() {
        return lastExcuteTime;
    }

    /**
     * @param lastExcuteTime
     */
    public void setLastExcuteTime(Date lastExcuteTime) {
        this.lastExcuteTime = lastExcuteTime;
    }
}