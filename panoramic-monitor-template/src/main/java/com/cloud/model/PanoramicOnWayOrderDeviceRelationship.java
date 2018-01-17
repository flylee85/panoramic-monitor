package com.cloud.model;

import javax.persistence.*;

@Table(name = "panoramic_on_way_order_device_relationship")
public class PanoramicOnWayOrderDeviceRelationship {
    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "device_no")
    private String deviceNo;

    /**
     * @return order_no
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

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
}