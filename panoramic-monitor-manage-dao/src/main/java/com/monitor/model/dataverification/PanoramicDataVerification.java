package com.monitor.model.dataverification;

import java.util.Date;
import javax.persistence.*;

/**
 * @author summer
 */
@Table(name = "panoramic_data_verification")
public class PanoramicDataVerification {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 物料编码
     */
    private String code;

    /**
     * 时间
     */
    private Date date;

    /**
     * 物料名
     */
    private String name;

    /**
     * 采集计量
     */
    @Column(name = "value_auto")
    private Double valueAuto;

    /**
     * 出入库记录量
     */
    @Column(name = "value_manual")
    private Double valueManual;

    /**
     * 偏差
     */
    private String bias;

    /**
     * ETL查询标识
     */
    private String logo;

    /**
     * 创建时间
     */
    private Date ctime;

    private Date utime;

    private Date dtime;

    /**
     * 1(可用) 0（删除）
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取物料编码
     *
     * @return code - 物料编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置物料编码
     *
     * @param code 物料编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取时间
     *
     * @return date - 时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置时间
     *
     * @param date 时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取物料名
     *
     * @return name - 物料名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置物料名
     *
     * @param name 物料名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取采集计量
     *
     * @return value_auto - 采集计量
     */
    public Double getValueAuto() {
        return valueAuto;
    }

    /**
     * 设置采集计量
     *
     * @param valueAuto 采集计量
     */
    public void setValueAuto(Double valueAuto) {
        this.valueAuto = valueAuto;
    }

    /**
     * 获取出入库记录量
     *
     * @return value_manual - 出入库记录量
     */
    public Double getValueManual() {
        return valueManual;
    }

    /**
     * 设置出入库记录量
     *
     * @param valueManual 出入库记录量
     */
    public void setValueManual(Double valueManual) {
        this.valueManual = valueManual;
    }

    /**
     * 获取偏差
     *
     * @return bias - 偏差
     */
    public String getBias() {
        return bias;
    }

    /**
     * 设置偏差
     *
     * @param bias 偏差
     */
    public void setBias(String bias) {
        this.bias = bias;
    }

    /**
     * 获取ETL查询标识
     *
     * @return logo - ETL查询标识
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置ETL查询标识
     *
     * @param logo ETL查询标识
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取创建时间
     *
     * @return ctime - 创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime 创建时间
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
     * @return dtime
     */
    public Date getDtime() {
        return dtime;
    }

    /**
     * @param dtime
     */
    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    /**
     * 获取1(可用) 0（删除）
     *
     * @return delete_flag - 1(可用) 0（删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置1(可用) 0（删除）
     *
     * @param deleteFlag 1(可用) 0（删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取操作人
     *
     * @return operator - 操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作人
     *
     * @param operator 操作人
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }
}