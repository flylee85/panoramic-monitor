package com.monitor.dto.materialintoinventory;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author summer
 */
@Data
public class PanoramicMaterialIntoInventoryDto implements Serializable {
    
    private static final long serialVersionUID = 1L;



	/**
     * 50KG装包量
     */
    private Double summary50kg;

    /**
     * 吨装包量
     */
    private Double summary1000kg;

    /**
     * 总计
     */
    private Double summary;

    /**
     * 更新时间
     */
    private Date utime;
    
    public Double getSummary50kg() {
		return summary50kg;
	}

	public void setSummary50kg(Double summary50kg) {
		this.summary50kg = summary50kg;
	}

	public Double getSummary1000kg() {
		return summary1000kg;
	}

	public void setSummary1000kg(Double summary1000kg) {
		this.summary1000kg = summary1000kg;
	}

	public Double getSummary() {
		return summary;
	}

	public void setSummary(Double summary) {
		this.summary = summary;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}
}