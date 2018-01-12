/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.model.onwayqueryorder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.cloud.model.BaseObject;
import com.monitor.model.onwayquerydepartures.PanoramicOnWayQueryDepartures;

/**
 * @author fgh
 * 	G7订单相关查询
 */
public class PanoramicOnWayQueryOrder extends BaseObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * OrderNo
     */
	private String orderno;
    /**
     * SebindStatus
     */
	private String sebindstatus;
    /**
     * UserOrderNo
     */
	private String userorderno;
    /**
     * SCompany
     */
	private String scompany;
    /**
     * SProvince
     */
	private String sprovince;
    /**
     * SCity
     */
	private String scity;
    /**
     * SDistricts
     */
	private String sdistricts;
    /**
     * SLocation
     */
	private String slocation;
    /**
     * SName
     */
	private String sname;
    /**
     * SPhone
     */
	private String sphone;
    /**
     * RCompany
     */
	private String rcompany;
    /**
     * RProvince
     */
	private String rprovince;
    /**
     * RCity
     */
	private String rcity;
    /**
     * RDistricts
     */
	private String rdistricts;
    /**
     * RLocation
     */
	private String rlocation;
    /**
     * RName
     */
	private String rname;
    /**
     * RPhone
     */
	private String rphone;
    /**
     * RDateTime
     */
	private Timestamp rdatetime;
    /**
     * UpdateTime
     */
	private Timestamp updatetime;
    /**
     * CurrentStatus
     */
	private String currentstatus;
    /**
     * CurrentStatusType
     */
	private String currenttranstype;
    /**
     * OrgCode
     */
	private String orgcode;
    /**
     * Deleted
     */
	private String deleted;
    /**
     * FromOrgCode
     */
	private String fromorgcode;
    /**
     * FromTime
     */
	private Timestamp fromtime;

    /**
     * departures
     */
	private List<PanoramicOnWayQueryDepartures> departures;
	


    /**
     * 获取OrderNo
     *
     * @return orderno - OrderNo
     */
    public String getOrderNo() {
        return orderno;
    }

    /**
     * 设置OrderNo
     *
     * @param orderno ID
     */
    public void setOrderNo(String orderno) {
        this.orderno = orderno;
    }
    

    /**
     * 获取SebindStatus
     *
     * @return sebindstatus - SebindStatus
     */
    public String getSebindStatus() {
        return sebindstatus;
    }

    /**
     * 设置SebindStatus
     *
     * @param sebindstatus SebindStatus
     */
    public void setSebindStatus(String sebindstatus) {
        this.sebindstatus = sebindstatus;
    }

    /**
     * 获取UserOrderNo
     *
     * @return userorderno - UserOrderNo
     */
    public String getUserOrderNo() {
        return userorderno;
    }

    /**
     * 设置UserOrderNo
     *
     * @param userorderno UserOrderNo
     */
    public void setUserOrderNo(String userorderno) {
        this.userorderno = userorderno;
    }
    
    /**
     * 获取SCompany
     *
     * @return scompany - SCompany
     */
    public String getSCompany() {
        return scompany;
    }

    /**
     * 设置SCompany
     *
     * @param scompany SCompany
     */
    public void setSCompany(String scompany) {
        this.scompany = scompany;
    }
    
    /**
     * 获取SProvince
     *
     * @return sprovince - SProvince
     */
    public String getSProvince() {
        return sprovince;
    }

    /**
     * 设置SProvince
     *
     * @param sprovince SProvince
     */
    public void setSProvince(String sprovince) {
        this.sprovince = sprovince;
    }

    /**
     * 获取SCity
     *
     * @return scity - SCity
     */
    public String getSCity() {
        return scity;
    }

    /**
     * 设置SCity
     *
     * @param scity SCity
     */
    public void setSCity(String scity) {
        this.scity = scity;
    }

    /**
     * 获取SDistricts
     *
     * @return sdistricts - SDistricts
     */
    public String getSDistricts() {
        return sdistricts;
    }

    /**
     * 设置SDistricts
     *
     * @param sdistricts SDistricts
     */
    public void setSDistricts(String sdistricts) {
        this.sdistricts = sdistricts;
    }
    
    /**
     * 获取SLocation
     *
     * @return slocation - SLocation
     */
    public String getSLocation() {
        return slocation;
    }

    /**
     * 设置SLocation
     *
     * @param slocation SLocation
     */
    public void setSLocation(String sdistricts) {
        this.slocation = slocation;
    }

    /**
     * 获取SName
     *
     * @return sname - SName
     */
    public String getSName() {
        return sname;
    }

    /**
     * 设置SName
     *
     * @param sname SName
     */
    public void setSName(String sname) {
        this.sname = sname;
    }

    /**
     * 获取SPhone
     *
     * @return sphone - SPhone
     */
    public String getSPhone() {
        return sphone;
    }

    /**
     * 设置SPhone
     *
     * @param sphone SPhone
     */
    public void setSPhone(String sphone) {
        this.sphone = sphone;
    }
    
    /**
     * 获取RCompany
     *
     * @return rcompany - RCompany
     */
    public String getRCompany() {
        return rcompany;
    }

    /**
     * 设置RCompany
     *
     * @param rcompany RCompany
     */
    public void setRCompany(String rcompany) {
        this.rcompany = rcompany;
    }
    
    /**
     * 获取RProvince
     *
     * @return rprovince - RProvince
     */
    public String getRProvince() {
        return rprovince;
    }

    /**
     * 设置RProvince
     *
     * @param rprovince RProvince
     */
    public void setRProvince(String rprovince) {
        this.rprovince = rprovince;
    }
    
    /**
     * 获取RCity
     *
     * @return rcity - RCity
     */
    public String getRCity() {
        return rcity;
    }

    /**
     * 设置RCity
     *
     * @param rcity RCity
     */
    public void setRCity(String rcity) {
        this.rcity = rcity;
    }
    
    /**
     * 获取RDistricts
     *
     * @return rdistricts - RDistricts
     */
    public String getRDistricts() {
        return rdistricts;
    }

    /**
     * 设置RDistricts
     *
     * @param rdistricts RDistricts
     */
    public void setRDistricts(String rdistricts) {
        this.rdistricts = rdistricts;
    }
    
    /**
     * 获取RLocation
     *
     * @return rlocation - RLocation
     */
    public String getRLocation() {
        return rlocation;
    }

    /**
     * 设置RLocation
     *
     * @param rlocation RLocation
     */
    public void setRLocation(String rlocation) {
        this.rlocation = rlocation;
    }
    
    /**
     * 获取RName
     *
     * @return rname - RName
     */
    public String getRName() {
        return rname;
    }

    /**
     * 设置RName
     *
     * @param rname RName
     */
    public void setRName(String rname) {
        this.rname = rname;
    }
    
    /**
     * 获取RPhone
     *
     * @return rphone - RPhone
     */
    public String getRPhone() {
        return rphone;
    }

    /**
     * 设置RPhone
     *
     * @param rphone RPhone
     */
    public void setRPhone(String rphone) {
        this.rphone = rphone;
    }
    
    /**
     * 获取RDateTime
     *
     * @return rdatetime - RDateTime
     */
    public Timestamp getRDateTime() {
        return rdatetime;
    }

    /**
     * 设置RDateTime
     *
     * @param rdatetime RDateTime
     */
    public void setRDateTime(Timestamp rdatetime) {
        this.rdatetime = rdatetime;
    }
    
    /**
     * 获取UpdateTime
     *
     * @return updatetime - UpdateTime
     */
    public Timestamp getUpdateTime() {
        return updatetime;
    }

    /**
     * 设置UpdateTime
     *
     * @param updatetime UpdateTime
     */
    public void setUpdateTime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
    
    /**
     * 获取CurrentStatus
     *
     * @return currentstatus - CurrentStatus
     */
    public String getCurrentStatus() {
        return currentstatus;
    }

    /**
     * 设置CurrentStatus
     *
     * @param currentstatus CurrentStatus
     */
    public void setCurrentStatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }
    
    /**
     * 获取CurrentStatusType
     *
     * @return currenttranstype - CurrentStatusType
     */
    public String getCurrentStatusType() {
        return currenttranstype;
    }

    /**
     * 设置CurrentStatusType
     *
     * @param currenttranstype CurrentStatusType
     */
    public void setCurrentStatusType(String currenttranstype) {
        this.currenttranstype = currenttranstype;
    }
    
    /**
     * 获取OrgCode
     *
     * @return orgcode - OrgCode
     */
    public String getOrgCode() {
        return orgcode;
    }

    /**
     * 设置OrgCode
     *
     * @param orgcode OrgCode
     */
    public void setOrgCode(String orgcode) {
        this.orgcode = orgcode;
    }
    
    /**
     * 获取Deleted
     *
     * @return deleted - Deleted
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 设置Deleted
     *
     * @param deleted Deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
    
    /**
     * 获取FromOrgCode
     *
     * @return fromorgcode - FromOrgCode
     */
    public String getFromOrgCode() {
        return fromorgcode;
    }

    /**
     * 设置FromOrgCode
     *
     * @param fromorgcode FromOrgCode
     */
    public void setFromOrgCode(String fromorgcode) {
        this.fromorgcode = fromorgcode;
    }
    
    /**
     * 获取FromTime
     *
     * @return fromtime - FromTime
     */
    public Timestamp getFromTime() {
        return fromtime;
    }

    /**
     * 设置FromTime
     *
     * @param fromtime FromTime
     */
    public void setFromTime(Timestamp fromtime) {
        this.fromtime = fromtime;
    }
    
    /**
     * 获取Departures
     *
     * @return departures - Departures
     */
    public List<PanoramicOnWayQueryDepartures> getDepartures() {
        return departures;
    }

    /**
     * 设置Departures
     *
     * @param departures Departures
     */
    public void setDepartures(List<PanoramicOnWayQueryDepartures> departures) {
        this.departures = departures;
    }
    
    
    


    @Override
    public Serializable realId() {
        return null;
    }
	
}