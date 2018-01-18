package com.monitor.dto.exceptionrecord;

import java.io.Serializable;
import java.util.Date;

/**
 * @author summer
 */
public class PanoramicExceptionRecordDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 报警项
     */
    private String alarmItem;

    /**
     * 报警状态（1：正常；0：报警）
     */
    private Integer status;

    /**
     * 删除标记（1：未删除；0：删除）
     */
    private Integer deleteFlag;

    /**
     * 报警内容
     */
    private String alarmContent;

    /**
     * 报警时间
     */
    private Date alarmTime;

    /**
     * 责任人
     */
    private String associatedPerson;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 更新时间
     */
    private Date utime;

    /**
     * 删除时间
     */
    private Date dtime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 责任人日志
     */
    private String relatedPersonLog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlarmItem() {
        return alarmItem;
    }

    public void setAlarmItem(String alarmItem) {
        this.alarmItem = alarmItem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAssociatedPerson() {
        return associatedPerson;
    }

    public void setAssociatedPerson(String associatedPerson) {
        this.associatedPerson = associatedPerson;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRelatedPersonLog() {
        return relatedPersonLog;
    }

    public void setRelatedPersonLog(String relatedPersonLog) {
        this.relatedPersonLog = relatedPersonLog;
    }
}