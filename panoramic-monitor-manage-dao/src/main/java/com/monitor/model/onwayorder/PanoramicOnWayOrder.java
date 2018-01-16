package com.monitor.model.onwayorder;

import java.util.Date;
import javax.persistence.*;

@Table(name = "panoramic_on_way_order")
public class PanoramicOnWayOrder {
    @Id
    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "user_order_no")
    private String userOrderNo;

    @Column(name = "send_address")
    private String sendAddress;

    @Column(name = "send_name")
    private String sendName;

    @Column(name = "send_mobile")
    private String sendMobile;

    @Column(name = "receive_address")
    private String receiveAddress;

    @Column(name = "receive_name")
    private String receiveName;

    @Column(name = "receive_mobile")
    private String receiveMobile;

    @Column(name = "request_receive_time")
    private Date requestReceiveTime;

    private Date ctime;

    private Date utime;

    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "current_trans_type")
    private String currentTransType;

    @Column(name = "org_code")
    private String orgCode;

    @Column(name = "from_org_code")
    private String fromOrgCode;

    @Column(name = "from_time")
    private Date fromTime;

    private String deleted;

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
     * @return user_order_no
     */
    public String getUserOrderNo() {
        return userOrderNo;
    }

    /**
     * @param userOrderNo
     */
    public void setUserOrderNo(String userOrderNo) {
        this.userOrderNo = userOrderNo;
    }

    /**
     * @return send_address
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * @param sendAddress
     */
    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    /**
     * @return send_name
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * @param sendName
     */
    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    /**
     * @return send_mobile
     */
    public String getSendMobile() {
        return sendMobile;
    }

    /**
     * @param sendMobile
     */
    public void setSendMobile(String sendMobile) {
        this.sendMobile = sendMobile;
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
     * @return receive_name
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * @param receiveName
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    /**
     * @return receive_mobile
     */
    public String getReceiveMobile() {
        return receiveMobile;
    }

    /**
     * @param receiveMobile
     */
    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    /**
     * @return request_receive_time
     */
    public Date getRequestReceiveTime() {
        return requestReceiveTime;
    }

    /**
     * @param requestReceiveTime
     */
    public void setRequestReceiveTime(Date requestReceiveTime) {
        this.requestReceiveTime = requestReceiveTime;
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

    /**
     * @return current_status
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    /**
     * @param currentStatus
     */
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     * @return current_trans_type
     */
    public String getCurrentTransType() {
        return currentTransType;
    }

    /**
     * @param currentTransType
     */
    public void setCurrentTransType(String currentTransType) {
        this.currentTransType = currentTransType;
    }

    /**
     * @return org_code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * @return from_org_code
     */
    public String getFromOrgCode() {
        return fromOrgCode;
    }

    /**
     * @param fromOrgCode
     */
    public void setFromOrgCode(String fromOrgCode) {
        this.fromOrgCode = fromOrgCode;
    }

    /**
     * @return from_time
     */
    public Date getFromTime() {
        return fromTime;
    }

    /**
     * @param fromTime
     */
    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * @return deleted
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}