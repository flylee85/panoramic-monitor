/**
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 */
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwayqueryresult;

import com.cloud.model.BaseObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author fgh
 * 	G7设备相关查询
 */
public class PanoramicOnWayQueryResultDeviceDto extends BaseObject {

    /**
     * Dtype
     */
    private Integer dtype;
    /**
     * DeviceNo
     */
    private String deviceno;
    /**
     * Bind
     */
    private Integer bind;
    /**
     * OnlineStatus
     */
    private Integer onlinestatus;
    /**
     * Battery
     */
    private String battery;
    /**
     * lng
     */
    private Double lng;
    /**
     * lat
     */
    private Double lat;
    /**
     * GpsTime
     */
    private Timestamp gpstime;
    /**
     * Address
     */
    private String address;
    /**
     * Orders
     */
    private List<String> orders;


    /**
     * 获取DType
     *
     * @return dtype - DType
     */
    public Integer getDType() {
        return dtype;
    }

    /**
     * 设置DType
     *
     * @param dtype DType
     */
    public void setDType(Integer dtype) {
        this.dtype = dtype;
    }


    /**
     * 获取DeviceNo
     *
     * @return deviceno - DeviceNo
     */
    public String getDeviceNo() {
        return deviceno;
    }

    /**
     * 设置DeviceNo
     *
     * @param deviceno DeviceNo
     */
    public void setDeviceNo(String deviceno) {
        this.deviceno = deviceno;
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
     * @return onlinestatus - OnlineStatus
     */
    public Integer getOnlineStatus() {
        return onlinestatus;
    }

    /**
     * 设置OnlineStatus
     *
     * @param onlinestatus OnlineStatus
     */
    public void setOnlineStatus(Integer onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    /**
     * 获取Battery
     *
     * @return battery - Battery
     */
    public String getBattery() {
        return battery;
    }

    /**
     * 设置Battery
     *
     * @param battery Battery
     */
    public void setBattery(String battery) {
        this.battery = battery;
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
     * 获取GpsTime
     *
     * @return gpstime - GpsTime
     */
    public Timestamp getGpsTime() {
        return gpstime;
    }

    /**
     * 设置GpsTime
     *
     * @param gpstime GpsTime
     */
    public void setGpsTime(Timestamp gpstime) {
        this.gpstime = gpstime;
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

    /**
     * 获取Orders
     *
     * @return orders - Orders
     */
    public List<String> getOrders() {
        return orders;
    }

    /**
     * 设置Orders
     *
     * @param orders Orders
     */
    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    @Override
    public Serializable realId() {
        return null;
    }
}