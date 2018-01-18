/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwayresult;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class PanoramicOnWayResultDto  {
	@Id
    @Column(name = "order_no")
    private String orderNo;
    

    @Column(name = "receive_address")
    private String receiveAddress;
    
    private String address;
    


    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "arrive_time")
    private Date arriveTime;
    
    private Integer overday;
    
    private Integer useday;

    

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
     * @return receive_address
     */
    public String getReceiveAddress() {
        return receiveAddress;
    }

    /**
     * @param receiveAddress
     */
    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
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
    

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return arrive_time
     */
    public Date getArriveTime() {
        return arriveTime;
    }

    /**
     * @param arriveTime
     */
    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }
    

    /**
     * @return overday
     */
    public Integer getOverDay() {
        return overday;
    }

    /**
     * @param overday
     */
    public void setOverDay(Integer overday) {
        this.overday = overday;
    }

    

    /**
     * @return useday
     */
    public Integer getUseDay() {
        return useday;
    }

    /**
     * @param overday
     */
    public void setUseDay(Integer useday) {
        this.useday = useday;
    }
}