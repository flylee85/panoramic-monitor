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
   

   /**
    * ID
    */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   /**
    * EventName
    */
   private String eventname;
   /**
    * StrEvent
    */
   private String strevent;
   /**
    * EventValue
    */
   private Double eventvalue;
   /**
    * Status
    */
   private Integer status;
   /**
    * Ctime
    */
   private Timestamp  ctime;
   /**
    * Utime
    */
   private Timestamp  utime;
   /**
    * SourceID
    */
   private Integer sourceid;
   /**
    * Level
    */
   private Integer level;
   /**
    * WarningName
    */
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

   /**
    * 设置ID
    *
    * @param id ID
    */
   public void setId(Integer id) {
	   this.id = id;
   }

   /**
    * 获取EventName
    * 
    * @return eventname -EventName
    */
   public String getEventName() {
	   return eventname;
   }

   /**
    * 设置ID
    *
    * @param eventname EventName
    */
   public void setEventName(String eventname) {
	   this.eventname = eventname;
   }

   /**
    * 获取StrEvent
    * 
    * @return strevent -StrEvent
    */
   public String getStrEvent() {
	   return strevent;
   }
   
   /**
    * 设置StrEvent
    *
    * @param strevent StrEvent
    */
   public void setStrEvent(String strevent) {
	   this.strevent = strevent;
   }
   
   /**
    * 获取EventValue
    * 
    * @return eventvalue -EventValue
    */
   public Double getEventValue() {
	   return eventvalue;
   }

   /**
    * 设置EventValue
    *
    * @param eventvalue EventValue
    */
   public void strEventValue(Double eventvalue) {
	   this.eventvalue = eventvalue;
   }

   /**
    * 获取Status
    * 
    * @return status -Status
    */
   public Integer getStatus() {
	   return status;
   }

   /**
    * 设置Status
    *
    * @param status Status
    */
   public void SetStatus(Integer status) {
	   this.status = status;
   }
   
   /**
    * 获取Ctime
    * 
    * @return ctime -Ctime
    */
   public Timestamp getCtime() {
	   return ctime;
   }
   
   /**
    * 设置Ctime
    *
    * @param ctime Ctime
    */
   public void setCtime(Timestamp ctime) {
	   this.ctime = ctime;
   }

   
   /**
    * 获取Utime
    * 
    * @return utime -Utime
    */
   public Timestamp getUtime() {
	   return utime;
   }
   
   /**
    * 设置Utime
    *
    * @param utime Utime
    */
   public void setUtime(Timestamp utime) {
	   this.utime = utime;
   }
   
   /**
    * 获取SourceId
    * 
    * @return sourceid -SourceId
    */
   public Integer getSourceId() {
	   return sourceid;
   }
   
   /**
    * 设置SourceId
    *
    * @param sourceid SourceId
    */
   public void setSourceId(Integer sourceid) {
	   this.sourceid = sourceid;
   }
   

   /**
    * 获取WarnConfigurationID
    *
    * @return warnconfigurationid - WarnConfigurationID
    */
   public Integer getWarnConfigurationID() {
       return warnconfigurationid;
   }

   /**
    * 设置WarnConfigurationID
    *
    * @param warnconfigurationid WarnConfigurationID
    */
   public void setWarnConfigurationID(Integer warnconfigurationid) {
       this.warnconfigurationid = warnconfigurationid;
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
   public void SetLevel(Integer level) {
	   this.level = level;
   }

   /**
    * 获取Warningname
    *
    * @return warningname - Warningname
    */
   public String getWarningname() {
	   return warningname;
   }

   /**
    * 设置Warningname
    *
    * @param warningname Warningname
    */
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