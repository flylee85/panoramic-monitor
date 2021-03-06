package com.monitor.model.onwaydeparture;

import java.util.Date;
import javax.persistence.*;

@Table(name = "panoramic_on_way_departure")
public class PanoramicOnWayDeparture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure_id")
    private String departureId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "arrive_time")
    private Date arriveTime;

    private String postman;

    @Column(name = "postman_phone")
    private String postmanPhone;

    @Column(name = "device_no")
    private String deviceNo;

    private Date ctime;

    private Date utime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return postman
     */
    public String getPostman() {
        return postman;
    }

    /**
     * @param postman
     */
    public void setPostman(String postman) {
        this.postman = postman;
    }

    /**
     * @return postman_phone
     */
    public String getPostmanPhone() {
        return postmanPhone;
    }

    /**
     * @param postmanPhone
     */
    public void setPostmanPhone(String postmanPhone) {
        this.postmanPhone = postmanPhone;
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

    /**
     * @return ctime
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * @return utime
     */
    public Date getUtime() {
        return utime;
    }

    /**
     * @param utime
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }
}