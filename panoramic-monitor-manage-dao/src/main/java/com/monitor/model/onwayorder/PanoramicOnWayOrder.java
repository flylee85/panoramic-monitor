/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.model.onwayorder;

import java.io.Serializable;
import java.sql.Timestamp;

import com.cloud.model.BaseObject;

public class PanoramicOnWayOrder extends BaseObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Order_No
     */
	private String order_no;
    /**
     * User_Order_No
     */
	private String user_order_no;
    /**
     * Sender_Address
     */
	private String send_address;
    /**
     * Sender_Name
     */
	private String send_name;
    /**
     * Sender_Mobile
     */
	private String send_mobile;
    /**
     * Receive_Address
     */
	private String receive_address;
    /**
     * Receive_Name
     */
	private String receive_name;
    /**
     * Receive_Mobile
     */
	private String receive_mobile;
    /**
     * Request_Receive_Time
     */
	private Timestamp request_receive_time;
    /**
     * Ctime
     */
	private Timestamp ctime;
    /**
     * Utime
     */
	private Timestamp utime;
    /**
     * Current_Status
     */
	private String current_status;
    /**
     * Current_Trans_Type
     */
	private String current_trans_type;
    /**
     * Org_Code
     */
	private String org_code;
    /**
     * From_Org_Code
     */
	private String from_org_code;
    /**
     * From_Time
     */
	private String from_time;
    /**
     * Deleted
     */
	private String deleted;
	

    /**
     * 获取OrderNo
     *
     * @return order_no - OrderNo
     */
    public String getOrderNo() {
        return order_no;
    }

    /**
     * 设置OrderNo
     *
     * @param orderno OrderNo
     */
    public void setOrderNo(String orderno) {
        this.order_no = orderno;
    }
    

    /**
     * 获取UserOrderNo
     *
     * @return user_order_no - UserOrderNo
     */
    public String getUserOrderNo() {
        return user_order_no;
    }

    /**
     * 设置UserOrderNo
     *
     * @param userorderno UserOrderNo
     */
    public void setUserOrderNo(String userorderno) {
        this.user_order_no = userorderno;
    }
    

    /**
     * 获取SendAddress
     *
     * @return send_address - SendAddress
     */
    public String getSendAddress() {
        return send_address;
    }

    /**
     * 设置SendAddress
     *
     * @param sendaddress SendAddress
     */
    public void setSendAddress(String sendaddress) {
        this.send_address = sendaddress;
    }
    

    /**
     * 获取SendName
     *
     * @return send_name - SendName
     */
    public String getSendName() {
        return send_name;
    }

    /**
     * 设置SendName
     *
     * @param sendname SendName
     */
    public void setSendName(String sendname) {
        this.send_name = sendname;
    }
    

    /**
     * 获取SendMobile
     *
     * @return send_mobile - SendMobile
     */
    public String getSendMobile() {
        return send_mobile;
    }

    /**
     * 设置SendMobile
     *
     * @param sendmobile SendMobile
     */
    public void setSendMobile(String sendmobile) {
        this.send_mobile = sendmobile;
    }

    

    /**
     * 获取ReceiveAddress
     *
     * @return receive_address - ReceiveAddress
     */
    public String getReceiveAddress() {
        return receive_address;
    }

    /**
     * 设置ReceiveAddress
     *
     * @param receiveaddress ReceiveAddress
     */
    public void setReceiveAddress(String receiveaddress) {
        this.receive_address = receiveaddress;
    }
    

    /**
     * 获取ReceiveName
     *
     * @return receive_name - ReceiveName
     */
    public String getReceiveName() {
        return receive_name;
    }

    /**
     * 设置ReceiveName
     *
     * @param receivename ReceiveName
     */
    public void setReceiveName(String receivename) {
        this.receive_name = receivename;
    }


    /**
     * 获取ReceiveMobile
     *
     * @return receive_mobile - ReceiveMobile
     */
    public String getReceiveMobile() {
        return receive_mobile;
    }

    /**
     * 设置ReceiveMobile
     *
     * @param receivemobile ReceiveMobile
     */
    public void setReceiveMobile(String receivemobile) {
        this.receive_mobile = receivemobile;
    }
	

    /**
     * 获取RequestReceiveTime
     *
     * @return request_receive_time - RequestReceiveTime
     */
    public Timestamp getRequestReceiveTime() {
        return request_receive_time;
    }

    /**
     * 设置RequestReceiveTime
     *
     * @param requestreceivetime RequestReceiveTime
     */
    public void setRequestReceiveTime(Timestamp requestreceivetime) {
        this.request_receive_time = requestreceivetime;
    }
	

    /**
     * 获取Ctime
     *
     * @return ctime - Ctime
     */
    public Timestamp getCtime() {
        return ctime;
    }

    /**
     * 设置Ctime
     *
     * @param ctime Ctime
     */
    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }
	

    /**
     * 获取Utime
     *
     * @return utime - Utime
     */
    public Timestamp getUtime() {
        return utime;
    }

    /**
     * 设置Utime
     *
     * @param utime Utime
     */
    public void setUtime(Timestamp utime) {
        this.utime = utime;
    }
	

    /**
     * 获取CurrentStatus
     *
     * @return current_status - CurrentStatus
     */
    public String getCurrentStatus() {
        return current_status;
    }

    /**
     * 设置CurrentStatus
     *
     * @param currentstatus CurrentStatus
     */
    public void setCurrentStatus(String currentstatus) {
        this.current_status = currentstatus;
    }

    /**
     * 获取CurrentTransType
     *
     * @return current_trans_type - CurrentTransType
     */
    public String getCurrentTransType() {
        return current_trans_type;
    }

    /**
     * 设置CurrentTransType
     *
     * @param currenttranstype CurrentTransType
     */
    public void setCurrentTransType(String currenttranstype) {
        this.current_trans_type = currenttranstype;
    }

    /**
     * 获取OrgCode
     *
     * @return org_code - OrgCode
     */
    public String getOrgCode() {
        return org_code;
    }

    /**
     * 设置OrgCode
     *
     * @param orgcode OrgCode
     */
    public void setOrgCode(String orgcode) {
        this.org_code = orgcode;
    }

    /**
     * 获取FromOrgCode
     *
     * @return from_org_code - FromOrgCode
     */
    public String getFromOrgCode() {
        return from_org_code;
    }

    /**
     * 设置FromOrgCode
     *
     * @param fromorgcode FromOrgCode
     */
    public void setFromOrgCode(String fromorgcode) {
        this.from_org_code = fromorgcode;
    }

    /**
     * 获取FromTime
     *
     * @return from_time - FromTime
     */
    public String getFromTime() {
        return from_time;
    }

    /**
     * 设置FromTime
     *
     * @param fromtime FromTime
     */
    public void setFromTime(String fromtime) {
        this.from_time = fromtime;
    }

    /**
     * 获取Deleted
     *
     * @return deleted - Deleted
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 设置Deleted
     *
     * @param deleted Deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public Serializable realId() {
        return null;
    }
	
}