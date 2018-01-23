package com.risk.warning.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "panoramic_warning_data")
public class PanoramicWarningData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "factory_name")
    private String factoryName;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "str_event")
    private String strEvent;

    @Column(name = "event_value")
    private Double eventValue;

    private Integer status;

    private Date ctime;

    private Date utime;

    @Column(name = "source_id")
    private Integer sourceId;

    @Column(name = "warn_configuration_id")
    private Integer warnConfigurationId;

    private Integer level;

    @Column(name = "is_send_email")
    private Boolean isSendEmail;

    @Column(name = "responsible_content")
    private String responsibleContent;

    @Column(name = "responsible_name")
    private String responsibleName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return factory_name
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * @param factoryName
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    /**
     * @return section_name
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * @return device_name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @return event_name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return str_event
     */
    public String getStrEvent() {
        return strEvent;
    }

    /**
     * @param strEvent
     */
    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    /**
     * @return event_value
     */
    public Double getEventValue() {
        return eventValue;
    }

    /**
     * @param eventValue
     */
    public void setEventValue(Double eventValue) {
        this.eventValue = eventValue;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return ctime
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * @return utime
     */
    public Date getUtime() {
        return utime;
    }

    /**
     * @param utime
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    /**
     * @return source_id
     */
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     * @param sourceId
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

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
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return is_send_email
     */
    public Boolean getIsSendEmail() {
        return isSendEmail;
    }

    /**
     * @param isSendEmail
     */
    public void setIsSendEmail(Boolean isSendEmail) {
        this.isSendEmail = isSendEmail;
    }

    /**
     * @return responsible_content
     */
    public String getResponsibleContent() {
        return responsibleContent;
    }

    /**
     * @param responsibleContent
     */
    public void setResponsibleContent(String responsibleContent) {
        this.responsibleContent = responsibleContent;
    }

    /**
     * @return responsible_name
     */
    public String getResponsibleName() {
        return responsibleName;
    }

    /**
     * @param responsibleName
     */
    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }
}