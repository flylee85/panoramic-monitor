package com.monitor.model.onwaydevice;

import java.util.Date;
import javax.persistence.*;

@Table(name = "panoramic_on_way_device")
public class PanoramicOnWayDevice {
    @Id
    @Column(name = "device_no")
    private String deviceNo;

    @Column(name = "device_type")
    private Integer deviceType;

    private Boolean bind;

    @Column(name = "online_status")
    private Boolean onlineStatus;

    private Integer battery;

    private Double lng;

    private Double lat;

    @Column(name = "gps_time")
    private Date gpsTime;

    private String address;

    /**
     * @return device_no
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     * @param deviceNo
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * @return device_type
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * @param deviceType
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @return bind
     */
    public Boolean getBind() {
        return bind;
    }

    /**
     * @param bind
     */
    public void setBind(Boolean bind) {
        this.bind = bind;
    }

    /**
     * @return online_status
     */
    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * @param onlineStatus
     */
    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    /**
     * @return battery
     */
    public Integer getBattery() {
        return battery;
    }

    /**
     * @param battery
     */
    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    /**
     * @return lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * @return lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return gps_time
     */
    public Date getGpsTime() {
        return gpsTime;
    }

    /**
     * @param gpsTime
     */
    public void setGpsTime(Date gpsTime) {
        this.gpsTime = gpsTime;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}