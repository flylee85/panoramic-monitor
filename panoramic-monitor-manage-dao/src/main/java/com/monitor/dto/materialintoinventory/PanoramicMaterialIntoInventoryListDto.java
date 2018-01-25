package com.monitor.dto.materialintoinventory;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xuegang
 */
public class PanoramicMaterialIntoInventoryListDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * 出入库时间
     */
    private Date inOutTime;
    
    /**
     * 净重
     */
    private String value;
    
    /**
     * 责任人
     */
    private String personLiable;
    
    
    /**
     * 责任人单位
     */
    private String inOutCompany;


	public Date getInOutTime() {
		return inOutTime;
	}


	public void setInOutTime(Date inOutTime) {
		this.inOutTime = inOutTime;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getPersonLiable() {
		return personLiable;
	}


	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}


	public String getInOutCompany() {
		return inOutCompany;
	}


	public void setInOutCompany(String inOutCompany) {
		this.inOutCompany = inOutCompany;
	}
}