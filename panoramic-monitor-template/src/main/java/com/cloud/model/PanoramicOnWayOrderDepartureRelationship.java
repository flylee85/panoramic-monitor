package com.cloud.model;

import javax.persistence.*;

@Table(name = "panoramic_on_way_order_departure_relationship")
public class PanoramicOnWayOrderDepartureRelationship {
    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "departure_id")
    private String departureId;

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
     * @return departure_id
     */
    public String getDepartureId() {
        return departureId;
    }

    /**
     * @param departureId
     */
    public void setDepartureId(String departureId) {
        this.departureId = departureId;
    }
}