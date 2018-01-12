/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.model.onwaydevice;

import java.io.Serializable;
import java.sql.Timestamp;

import com.cloud.model.BaseObject;

public class PanoramicOnWayDevice extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Device_No
     */
	private String device_no;
	/**
     * Device_Type
     */
	private Integer device_type;
	/**
     * Bind
     */
	private Integer bind;
	/**
     * Online_Status
     */
	private Integer online_status;
	/**
     * Battery
     */
	private Integer battery;
	/**
     * Lng
     */
	private Double lng;
	/**
     * lat
     */
	private Double lat;
	/**
     * Gps_Time
     */
	private Timestamp gps_time;
	/**
     * Address
     */
	private String address;
	


    /**
     * 获取DeviceNo
     *
     * @return device_no - DeviceNo
     */
    public String getDeviceNo() {
        return device_no;
    }

    /**
     * 设置DeviceNo
     *
     * @param deviceno DeviceNo
     */
    public void setDeviceNo(String deviceno) {
        this.device_no = deviceno;
    }
    

    /**
     * 获取DeviceType
     *
     * @return device_type - DeviceType
     */
    public Integer getDeviceType() {
        return device_type;
    }

    /**
     * 设置DeviceType
     *
     * @param devicetype DeviceType
     */
    public void setDeviceType(Integer devicetype) {
        this.device_type = devicetype;
    }
    

    /**
     * 获取Bind
     *
     * @return bind - Bind
     */
    public Integer getBind() {
        return bind;
    }

    /**
     * 设置Bind
     *
     * @param bind Bind
     */
    public void setBind(Integer bind) {
        this.bind = bind;
    }
    

    /**
     * 获取OnlineStatus
     *
     * @return online_status - OnlineStatus
     */
    public Integer getOnlineStatus() {
        return online_status;
    }

    /**
     * 设置OnlineStatus
     *
     * @param onlinestatus OnlineStatus
     */
    public void setOnlineStatus(Integer onlinestatus) {
        this.online_status = onlinestatus;
    }
    

    /**
     * 获取Battery
     *
     * @return battery - Battery
     */
    public Integer getBattery() {
        return battery;
    }

    /**
     * 设置Battery
     *
     * @param battery Battery
     */
    public void setBattery(Integer battery) {
        this.battery = battery;
    }


    /**
     * 获取Lng
     *
     * @return lng - Lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * 设置Lng
     *
     * @param lng Lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }
	
    

    /**
     * 获取Lat
     *
     * @return lat - Lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 设置Lat
     *
     * @param lat Lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }
	


    /**
     * 获取GpsTime
     *
     * @return gps_time - GpsTime
     */
    public Timestamp getGpsTime() {
        return gps_time;
    }

    /**
     * 设置GpsTime
     *
     * @param gpstime GpsTime
     */
    public void setGpsTime(Timestamp gpstime) {
        this.gps_time = gpstime;
    }
    

    /**
     * 获取Address
     *
     * @return address - Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置Address
     *
     * @param address Address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    

    @Override
    public Serializable realId() {
        return null;
    }
	
}