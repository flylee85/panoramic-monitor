package com.monitor.model.sparepartsmaterials;

import java.util.Date;
import javax.persistence.*;

/**
 * @author xuegang
 */
@Table(name = "panoramic_spare_parts_materials")
public class PanoramicSparePartsMaterials {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编码
     */
    private String code;

    /**
     * 参考单价
     */
    @Column(name = "reference_price")
    private Integer referencePrice;

    /**
     * 库存量
     */
    private Double inventory;

    /**
     * 单位
     */
    private String unit;

    /**
     * 库存货值
     */
    @Column(name = "inventory_value")
    private Long inventoryValue;

    /**
     * 删除标记（1：未删除；0：删除）
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 更新时间
     */
    private Date utime;

    /**
     * 删除时间
     */
    private Date dtime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 工厂id
     */
    @Column(name = "f_id")
    private String fId;

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
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取产品编码
     *
     * @return code - 产品编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置产品编码
     *
     * @param code 产品编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取参考单价
     *
     * @return reference_price - 参考单价
     */
    public Integer getReferencePrice() {
        return referencePrice;
    }

    /**
     * 设置参考单价
     *
     * @param referencePrice 参考单价
     */
    public void setReferencePrice(Integer referencePrice) {
        this.referencePrice = referencePrice;
    }

    /**
     * 获取库存量
     *
     * @return inventory - 库存量
     */
    public Double getInventory() {
        return inventory;
    }

    /**
     * 设置库存量
     *
     * @param inventory 库存量
     */
    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取库存货值
     *
     * @return inventory_value - 库存货值
     */
    public Long getInventoryValue() {
        return inventoryValue;
    }

    /**
     * 设置库存货值
     *
     * @param inventoryValue 库存货值
     */
    public void setInventoryValue(Long inventoryValue) {
        this.inventoryValue = inventoryValue;
    }

    /**
     * 获取删除标记（1：未删除；0：删除）
     *
     * @return delete_flag - 删除标记（1：未删除；0：删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记（1：未删除；0：删除）
     *
     * @param deleteFlag 删除标记（1：未删除；0：删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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
     * 获取更新时间
     *
     * @return utime - 更新时间
     */
    public Date getUtime() {
        return utime;
    }

    /**
     * 设置更新时间
     *
     * @param utime 更新时间
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    /**
     * 获取删除时间
     *
     * @return dtime - 删除时间
     */
    public Date getDtime() {
        return dtime;
    }

    /**
     * 设置删除时间
     *
     * @param dtime 删除时间
     */
    public void setDtime(Date dtime) {
        this.dtime = dtime;
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

    /**
     * 获取工厂id
     *
     * @return f_id - 工厂id
     */
    public String getfId() {
        return fId;
    }

    /**
     * 设置工厂id
     *
     * @param fId 工厂id
     */
    public void setfId(String fId) {
        this.fId = fId;
    }
}