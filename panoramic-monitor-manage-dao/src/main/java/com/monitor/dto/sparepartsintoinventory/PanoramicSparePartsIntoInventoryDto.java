package com.monitor.dto.sparepartsintoinventory;

import com.cloud.model.BaseObject;

import java.io.Serializable;

/**
 * 备件出入库表
 *
 * @author xuegang
 */
public class PanoramicSparePartsIntoInventoryDto extends BaseObject {

    private static final long serialVersionUID = 1L;

    /**
     * 入出库产品名称
     */
    private String name;

    /**
     * 入出库产品统计值
     */
    private double summary;
    
    /**
     * 单位
     */
    private String unit;

    @Override
    public Serializable realId() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
