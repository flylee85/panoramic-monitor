package com.risk.warning.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "panoramic_email_send_info")
public class PanoramicEmailSendInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_email")
    private String receiverEmail;

    /**
     * 规则表主键ID
     */
    @Column(name = "warning_source_id")
    private Integer warningSourceId;

    /**
     * 发送情况 1：成功 2:失败
     */
    @Column(name = "send_status")
    private Integer sendStatus;

    /**
     * 发送失败理由
     */
    private String reason;

    /**
     * 发送时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    @Column(name = "return_content")
    private String returnContent;

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
     * @return receiver_name
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * @return receiver_email
     */
    public String getReceiverEmail() {
        return receiverEmail;
    }

    /**
     * @param receiverEmail
     */
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    /**
     * 获取规则表主键ID
     *
     * @return warning_source_id - 规则表主键ID
     */
    public Integer getWarningSourceId() {
        return warningSourceId;
    }

    /**
     * 设置规则表主键ID
     *
     * @param warningSourceId 规则表主键ID
     */
    public void setWarningSourceId(Integer warningSourceId) {
        this.warningSourceId = warningSourceId;
    }

    /**
     * 获取发送情况 1：成功 2:失败
     *
     * @return send_status - 发送情况 1：成功 2:失败
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置发送情况 1：成功 2:失败
     *
     * @param sendStatus 发送情况 1：成功 2:失败
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取发送失败理由
     *
     * @return reason - 发送失败理由
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置发送失败理由
     *
     * @param reason 发送失败理由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取发送时间
     *
     * @return send_time - 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return return_content
     */
    public String getReturnContent() {
        return returnContent;
    }

    /**
     * @param returnContent
     */
    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent;
    }
}