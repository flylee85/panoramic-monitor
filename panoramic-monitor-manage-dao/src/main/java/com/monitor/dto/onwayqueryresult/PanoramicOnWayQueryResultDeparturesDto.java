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

public class PanoramicOnWayQueryResultDeparturesDto extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * DepartureId
     */
    private String departureid;
    /**
     * GStartTime
     */
    private Timestamp gstarttime;
    /**
     * GArriveTime
     */
    private Timestamp garrivetime;
    /**
     * Postman
     */
    private String postman;
    /**
     * PostmanPhone
     */
    private String postmanphone;
    /**
     * gpsno
     */
    private String gpsno;


    /**
     * 获取DepartureId
     *
     * @return departureid - DepartureId
     */
    public String getDepartureId() {
        return departureid;
    }

    /**
     * 设置DepartureId
     *
     * @param departureid DepartureId
     */
    public void setDepartureId(String departureid) {
        this.departureid = departureid;
    }


    /**
     * 获取GStartTime
     *
     * @return gstarttime - GStartTime
     */
    public Timestamp getGStartTime() {
        return gstarttime;
    }

    /**
     * 设置GStartTime
     *
     * @param departureid GStartTime
     */
    public void setGStartTime(Timestamp gstarttime) {
        this.gstarttime = gstarttime;
    }


    /**
     * 获取GArriveTime
     *
     * @return garrivetime - GArriveTime
     */
    public Timestamp getGArriveTime() {
        return garrivetime;
    }

    /**
     * 设置GArriveTime
     *
     * @param departureid GArriveTime
     */
    public void setGArriveTime(Timestamp garrivetime) {
        this.garrivetime = garrivetime;
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
     * @return postmanphone - PostmanPhone
     */
    public String getPostmanPhone() {
        return postmanphone;
    }

    /**
     * 设置PostmanPhone
     *
     * @param postmanphone PostmanPhone
     */
    public void setPostmanPhone(String postmanphone) {
        this.postmanphone = postmanphone;
    }


    /**
     * 获取GpsNo
     *
     * @return gpsno - GpsNo
     */
    public String getGpsNo() {
        return gpsno;
    }

    /**
     * 设置GpsNo
     *
     * @param gpsno GpsNo
     */
    public void setGpsNo(String gpsno) {
        this.gpsno = gpsno;
    }

    @Override
    public Serializable realId() {
        return null;
    }
}