package com.risk.warning.dto;

import com.cloud.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author summer
 */
public class PanoramicWarningDataDto {
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
   private String event_name;
   /**
    * StrEvent
    */
   private String str_event;
   /**
    * EventValue
    */
   private String event_value;
   /**
    * Status
    */
   private Integer status;
   /**
    * Createtime
    */
   private String  createtime;
   /**
    * updatetime
    */
   private String  updatetime;
   /**
    * SourceID
    */
   private Integer source_id;
   /**
    * Level
    */
   private Integer level;
   /**
    * WarningName
    */
   private String warning_name;
   /**
    * FactoryName
    */
   private String factory_name;
   /**
    * SectionName
    */
   private String section_name;
   /**
    * DeviceName
    */
   private String device_name;
   /**
    * WarnConfigurationID
    */
   private Integer warn_configuration_id;
   /**
    * MaxValue
    */
   private Double max_value;
   /**
    * MinValue
    */
   private Double min_value;
   
   /**
    * LogicType
    */
   private Integer logic_type;
   /**
    * MaxLevel
    */
   private Integer max_level;
   /**
    * DayCount
    */
   private Integer day_count;
   
   /**
    * ResponsibleContent
    */
   private String responsible_content;
   
   /**
    * ResponsibleName
    */
   private String responsible_name;
   
   
   
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
    * @return event_name -EventName
    */
   public String getEventName() {
	   return event_name;
   }

   /**
    * 设置ID
    *
    * @param eventname EventName
    */
   public void setEventName(String eventname) {
	   this.event_name = eventname;
   }

   /**
    * 获取StrEvent
    * 
    * @return str_event -StrEvent
    */
   public String getStrEvent() {
	   return str_event;
   }
   
   /**
    * 设置StrEvent
    *
    * @param strevent StrEvent
    */
   public void setStrEvent(String strevent) {
	   this.str_event = strevent;
   }
   
   /**
    * 获取EventValue
    * 
    * @return event_value -EventValue
    */
   public String getEventValue() {
	   return event_value;
   }

   /**
    * 设置EventValue
    *
    * @param eventvalue EventValue
    */
   public void setEventValue(String eventvalue) {
	   this.event_value = eventvalue;
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
    * 获取createtime
    * 
    * @return createtime -createtime
    */
   public String getCreateTime() {
	   return createtime;
   }
   
   /**
    * 设置createtime
    *
    * @param createtime Ctime
    */
   public void setCreateTime(String createtime) {
	   this.createtime = createtime;
   }

   
   /**
    * 获取updatetime
    * 
    * @return updatetime -updatetime
    */
   public String getUpdateTime() {
	   return updatetime;
   }
   
   /**
    * 设置Utime
    *
    * @param utime Utime
    */
   public void setUpdateTime(String updatetime) {
	   this.updatetime = updatetime;
   }
   
   /**
    * 获取SourceId
    * 
    * @return source_id -SourceId
    */
   public Integer getSourceId() {
	   return source_id;
   }
   
   /**
    * 设置SourceId
    *
    * @param sourceid SourceId
    */
   public void setSourceId(Integer sourceid) {
	   this.source_id = sourceid;
   }
   

   /**
    * 获取WarnConfigurationID
    *
    * @return warn_configuration_id - WarnConfigurationID
    */
   public Integer getWarnConfigurationID() {
       return warn_configuration_id;
   }

   /**
    * 设置WarnConfigurationID
    *
    * @param warnconfigurationid WarnConfigurationID
    */
   public void setWarnConfigurationID(Integer warnconfigurationid) {
       this.warn_configuration_id = warnconfigurationid;
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
    * @return warning_name - Warningname
    */
   public String getWarningname() {
	   return warning_name;
   }

   /**
    * 设置Warningname
    *
    * @param warningname Warningname
    */
   public void setWarningname(String warningname) {
	   this.warning_name = warningname;
   }
   

   
   /**
    * 获取FactoryName
    *
    * @return factory_name - FactoryName
    */
   public String getFactoryName() {
   		return factory_name;    	
   }
   

   /**
    * 设置FactoryName
    *
    * @param warningname FactoryName
    */
   public void setFactoryName(String factoryname) {
       this.factory_name = factoryname;
   } 
   
   /**
    * 获取SectionName
    *
    * @return section_name - SectionName
    */
   public String getSectionName() {
   		return section_name;    	
   }
   

   /**
    * 设置SectionName
    *
    * @param sectionname SectionName
    */
   public void setSectionName(String sectionname) {
       this.section_name = sectionname;
   } 

   /**
    * 获取DeviceName
    *
    * @return device_name - DeviceName
    */
   public String getDeviceName() {
   		return device_name;    	
   }
   

   /**
    * 设置DeviceName
    *
    * @param devicename DeviceName
    */
   public void setDeviceName(String devicename) {
       this.device_name = devicename;
   } 
   

   /**
    * 获取MaxValue
    *
    * @return max_value - MaxValue
    */
   public Double getMaxValue() {
   		return max_value;    	
   }
   

   /**
    * 设置MaxValue
    *
    * @param maxvalue MaxValue
    */
   public void setMaxValue(Double maxvalue) {
       this.max_value = maxvalue;
   } 

   
   /**
    * 获取MinValue
    *
    * @return min_value - MinValue
    */
   public Double getMinValue() {
   		return min_value;    	
   }
   

   /**
    * 设置MinValue
    *
    * @param minvalue MinValue
    */
   public void setMinValue(Double minvalue) {
       this.min_value = minvalue;
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
   

   /**
    * 获取MaxLevel
    *
    * @return max_level - MaxLevel
    */
   public Integer getMaxLevel() {
   	return max_level;    	
   }
   


   /**
    * 设置MaxLevel
    *
    * @param maxlevel MaxLevel
    */
   public void setMaxLevel(Integer maxlevel) {
       this.max_level = maxlevel;
   } 
   

   /**
    * 获取DayCount
    *
    * @return day_count - DayCount
    */
   public Integer getDayCount() {
   	return day_count;    	
   }
   


   /**
    * 设置DayCount
    *
    * @param daycount DayCount
    */
   public void setDayCount(Integer daycount) {
       this.day_count = daycount;
   } 

   /**
    * 获取ResponsibleContent
    *
    * @return return_content - ResponsibleContent
    */
   public String getResponsibleContent() {
   		return responsible_content;    	
   }
   

   /**
    * 设置ResponsibleContent
    *
    * @param responsiblecontent ResponsibleContent
    */
   public void setResponsibleContent(String responsiblecontent) {
       this.responsible_content = responsiblecontent;
   } 

   /**
    * 获取ResponsibleName
    *
    * @return responsible_name - ResponsibleName
    */
   public String getResponsibleName() {
   		return responsible_name;    	
   }
   

   /**
    * 设置ResponsibleName
    *
    * @param responsiblename ResponsibleName
    */
   public void setResponsibleName(String responsiblename) {
       this.responsible_name = responsiblename;
   } 
   
}