/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.model.onwaydeparture;

import java.io.Serializable;
import java.sql.Timestamp;

import com.cloud.model.BaseObject;

public class PanoramicOnWayDeparture extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Departure_Id
     */
	private String departure_id;
	/**
     * Start_Time
     */
	private Timestamp start_time;
	/**
     * Arrive_Time
     */
	private Timestamp arrive_time;
	/**
     * Postman
     */
	private String postman;
	/**
     * Postman_Phone
     */
	private String postman_phone;
	/**
     * Device_No
     */
	private String device_no;
	

    /**
     * 获取DepartureId
     *
     * @return departure_id - DepartureId
     */
    public String getDepartureId() {
        return departure_id;
    }

    /**
     * 设置DepartureId
     *
     * @param departureid DepartureId
     */
    public void setDepartureId(String departureid) {
        this.departure_id = departureid;
    }
	

    /**
     * 获取StartTime
     *
     * @return start_time - StartTime
     */
    public Timestamp getStartTime() {
        return start_time;
    }

    /**
     * 设置StartTime
     *
     * @param starttime StartTime
     */
    public void setStartTime(Timestamp starttime) {
        this.start_time = starttime;
    }


    /**
     * 获取ArriveTime
     *
     * @return arrive_time - ArriveTime
     */
    public Timestamp getArriveTime() {
        return arrive_time;
    }

    /**
     * 设置ArriveTime
     *
     * @param arrivetime ArriveTime
     */
    public void setArriveTime(Timestamp arrivetime) {
        this.arrive_time = arrivetime;
    }

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
     * 获取Postman
     *
     * @return postman - Postman
     */
    public String getPostman() {
        return postman;
    }

    /**
     * 设置Postman
     *
     * @param postman Postman
     */
    public void setPostman(String postman) {
        this.postman = postman;
    }
	

    /**
     * 获取PostmanPhone
     *
     * @return postman_phone - PostmanPhone
     */
    public String getPostmanPhone() {
        return postman_phone;
    }

    /**
     * 设置PostmanPhone
     *
     * @param postmanphone PostmanPhone
     */
    public void setPostmanPhone(String postmanphone) {
        this.postman_phone = postmanphone;
    }
	


    @Override
    public Serializable realId() {
        return null;
    }
	
}