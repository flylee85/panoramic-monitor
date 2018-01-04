package com.risk.warning.model;

import com.cloud.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "panoramic_system_configurationNew")
public class PanoramicSystemConfigurationnew extends BaseObject {
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
     * SubID
     */
    private Integer subid;
    /**
     * WarnType
     */
    private Integer warntype;
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
     * SourceName
     */
    private String subname;
    /**
     * MaxValue
     */
    private Double maxvalue;
    /**
     * MinValue
     */
    private Double minvalue;
    
    private String databaseaddress;
    private String databasename;
    private String databasetable;
    private String databasetype;
    private String strevent;
    
    private String checkfield;
    /**
     * CheckCondition
     */
    private String checkcondition;
    /**
     * CheckValue
     */
    private Integer checkvalue;
    /**
     * Available
     */
    private Boolean available;
    /**
     * intervaltime
     */
    private Integer intervaltime;

    private String strsubevent;
    private String strsubeventname;
    private String strsubeventvalue;
    
    

    /**
     * 获取ID
     *
     * @return id - ID
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
     * 获取SubID
     *
     * @return subid - SubID
     */
    public Integer getSubId() {
        return subid;
    }



    /**
     * 设置SubID
     *
     * @param subid SubID
     */
    public void setSubId(Integer subid) {
        this.subid = subid;
    } 
    
    /**
     * 获取WarnType
     *
     * @return warntype - WarnType
     */
    public Integer getWarnType() {
    	return warntype;    	
    }
    

    /**
     * 设置WarnType
     *
     * @param warntype WarnType
     */
    public void setWarnType(Integer warntype) {
        this.warntype = warntype;
    } 
    
    /**
     * 获取SubName
     *
     * @return subname - SubName
     */
    public String getSubName() {
    	return subname;    	
    }
    

    /**
     * 设置SubName
     *
     * @param subname SubName
     */
    public void setSourceName(String subname) {
        this.subname = subname;
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
    

    /**
     * 获取DataBaseAddress
     *
     * @return databaseaddress - DataBaseAddress
     */
    public String getDataBaseAddress() {
    	return databaseaddress;    	
    }
    

    /**
     * 设置DataBaseAddress
     *
     * @param databaseaddress DataBaseAddress
     */
    public void setDataBaseAddress(String databaseaddress) {
        this.databaseaddress = databaseaddress;
    } 
    

    /**
     * 获取DataBaseName
     *
     * @return databasename - DataBaseName
     */
    public String getDataBaseName() {
    	return databasename;    	
    }
    

    /**
     * 设置DataBaseName
     *
     * @param databasename DataBaseName
     */
    public void setDataBaseName(String databasename) {
        this.databasename = databasename;
    } 
    

    /**
     * 获取DataBaseTable
     *
     * @return databasetable - DataBaseTable
     */
    public String getDataBaseTable() {
    	return databasetable;    	
    }
    

    /**
     * 设置DataBaseTable
     *
     * @param databasetable DataBaseTable
     */
    public void setDataBaseTable(String databasetable) {
        this.databasetable = databasetable;
    } 
    

    /**
     * 获取DataBaseType
     *
     * @return databasetype - DataBaseType
     */
    public String getDataBaseType() {
    	return databasetype;    	
    }
    

    /**
     * 设置DataBaseType
     *
     * @param databasetype DataBaseType
     */
    public void setDataBaseType(String databasetype) {
        this.databasetype = databasetype;
    } 
    

    /**
     * 获取StrEvent
     *
     * @return strevent - StrEvent
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
     * 获取CheckField
     *
     * @return checkfield - CheckField
     */
    public String getCheckField() {
    	return checkfield;    	
    }
    

    /**
     * 设置CheckField
     *
     * @param checkfield CheckField
     */
    public void setCheckField(String checkfield) {
        this.checkfield = checkfield;
    } 
    

    /**
     * 获取CheckCondition
     *
     * @return checkcondition - CheckCondition
     */
    public String setCheckCondition() {
    	return checkcondition;    	
    }
    

    /**
     * 设置CheckCondition
     *
     * @param checkcondition CheckCondition
     */
    public void setCheckCondition(String checkcondition) {
        this.checkcondition = checkcondition;
    } 
    
    
    /**
     * 获取CheckValue
     *
     * @return checkvalue - CheckValue
     */
    public Integer setCheckValue() {
    	return checkvalue;    	
    }
    

    /**
     * 设置CheckValue
     *
     * @param checkvalue CheckValue
     */
    public void setCheckValue(Integer checkvalue) {
        this.checkvalue = checkvalue;
    }
    

    /**
     * 获取Available
     *
     * @return available - Available
     */
    public Boolean setAvailable() {
    	return available;    	
    }
    

    /**
     * 设置Available
     *
     * @param available Available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    } 


    /**
     * 获取Intervaltime
     *
     * @return intervaltime - Intervaltime
     */
    public Integer setntervaltime() {
    	return intervaltime;    	
    }
    

    /**
     * 设置Intervaltime
     *
     * @param intervaltime Intervaltime
     */
    public void setIntervaltime(Integer intervaltime) {
        this.intervaltime = intervaltime;
    } 
    
    
    /**
     * 获取StrSubEvent
     *
     * @return strsubevent - StrSubEvent
     */
    public String getStrSubEvent() {
    	return strsubevent;    	
    }
    

    /**
     * 设置StrSubEvent
     *
     * @param strsubevent StrSubEvent
     */
    public void setStrSubEvent(String strsubevent) {
        this.strsubevent = strsubevent;
    } 
    
    
    /**
     * 获取StrSubEventName
     *
     * @return strsubeventname - StrSubEventName
     */
    public String getStrSubEventName() {
    	return strsubeventname;    	
    }
    

    /**
     * 设置StrSubEventName
     *
     * @param strsubeventname StrSubEventName
     */
    public void setStrSubEventName(String strsubeventname) {
        this.strsubeventname = strsubeventname;
    } 
    
    
    /**
     * 获取StrSubEventValue
     *
     * @return strsubeventvalue - StrSubEventValue
     */
    public String getStrSubEventValue() {
    	return strsubeventvalue;    	
    }
    

    /**
     * 设置StrSubEventValue
     *
     * @param strsubeventvalue StrSubEventValue
     */
    public void setStrSubEventValue(String strsubeventvalue) {
        this.strsubeventvalue = strsubeventvalue;
    } 
    

    
    
    /**
     * 获取WarningName
     *
     * @return warningname - WarningName
     */
    public String getWarningName() {
    	return warningname;    	
    }
    

    /**
     * 设置WarningName
     *
     * @param warningname WarningName
     */
    public void setWarningName(String warningname) {
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
    
    @Override
    public Serializable realId() {
        return null;
    }
}