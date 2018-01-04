package com.risk.warning.model;

import com.cloud.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author summer
 */
@Table(name = "PanoramicSystemWarningSourceData")
public class PanoramicWarningData extends BaseObject {
	/**
    *
    */
   private static final long serialVersionUID = 1L;
   

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String eventname;
   private String strevent;
   private Double eventvalue;
   private Integer status;
   private Timestamp  ctime;
   private Timestamp  utime;
   private Integer sourceid;
   private Integer level;
   private String warningname;
   /**
    * FactoryName
    */
   private String factoryname;
   /**
    * SectionName
    */
   private String sectionname;
   /**
    * DeviceName
    */
   private String devicename;
   /**
    * WarnConfigurationID
    */
   private Integer warnconfigurationid;
   /**
    * MaxValue
    */
   private Double maxvalue;
   /**
    * MinValue
    */
   private Double minvalue;
   
   
   /**
    * 获取ID
    * 
    * @return id -ID
    */
   public Integer getId() {
	   return id;
   }
   
   
   public void setId(Integer id) {
	   this.id = id;
   }
   
   public String getEventName() {
	   return eventname;
   }
   
   public void setEventName(String eventname) {
	   this.eventname = eventname;
   }
   
   public String getStrEvent() {
	   return strevent;
   }

   public void setStrEvent(String strevent) {
	   this.strevent = strevent;
   }
   
   public Double getEventValue() {
	   return eventvalue;
   }
   
   public void strEventValue(Double eventvalue) {
	   this.eventvalue = eventvalue;
   }
   
   public Integer getStatus() {
	   return status;
   }
   
   public void SetStatus(Integer status) {
	   this.status = status;
   }
   
   public Timestamp getCtime() {
	   return ctime;
   }
   
   public void setCtime(Timestamp ctime) {
	   this.ctime = ctime;
   }
   
   public Timestamp getUtime() {
	   return utime;
   }
   
   public void setUtime(Timestamp utime) {
	   this.utime = utime;
   }
   
   public Integer getSourceId() {
	   return sourceid;
   }
   
   
   public void setSourceId(Integer sourceid) {
	   this.sourceid = sourceid;
   }
   

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
   

   public Integer getLevel() {
	   return level;
   }
   
   public void SetLevel(Integer level) {
	   this.level = level;
   }
   
   public String getWarningname() {
	   return warningname;
   }
   
   public void setWarningname(String warningname) {
	   this.warningname = warningname;
   }
   

   
   /**
    * 获取FactoryName
    *
    * @return factoryname - FactoryName
    */
   public String getFactoryName() {
   	return factoryname;    	
   }
   

   /**
    * 设置FactoryName
    *
    * @param warningname FactoryName
    */
   public void setFactoryName(String factoryname) {
       this.factoryname = factoryname;
   } 
   
   /**
    * 获取SectionName
    *
    * @return sectionname - SectionName
    */
   public String getSectionName() {
   		return sectionname;    	
   }
   

   /**
    * 设置SectionName
    *
    * @param sectionname SectionName
    */
   public void setSectionName(String sectionname) {
       this.sectionname = sectionname;
   } 

   /**
    * 获取DeviceName
    *
    * @return devicename - DeviceName
    */
   public String getDeviceName() {
   	return devicename;    	
   }
   

   /**
    * 设置DeviceName
    *
    * @param devicename DeviceName
    */
   public void setDeviceName(String devicename) {
       this.devicename = devicename;
   } 
   

   /**
    * 获取MaxValue
    *
    * @return maxvalue - MaxValue
    */
   public Double getMaxValue() {
   	return maxvalue;    	
   }
   

   /**
    * 设置MaxValue
    *
    * @param maxvalue MaxValue
    */
   public void setMaxValue(Double maxvalue) {
       this.maxvalue = maxvalue;
   } 

   
   /**
    * 获取MinValue
    *
    * @return minvalue - MinValue
    */
   public Double getMinValue() {
   	return minvalue;    	
   }
   

   /**
    * 设置MinValue
    *
    * @param minvalue MinValue
    */
   public void setMinValue(Double minvalue) {
       this.minvalue = minvalue;
   } 
   
   
    @Override
    public Serializable realId() {
        return null;
    }
}