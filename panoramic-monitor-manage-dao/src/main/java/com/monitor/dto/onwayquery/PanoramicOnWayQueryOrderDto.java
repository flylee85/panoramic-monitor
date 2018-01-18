/**
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 */
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwayquery;

import com.cloud.model.BaseObject;

import java.io.Serializable;
import java.util.List;

public class PanoramicOnWayQueryOrderDto  {
    /**
     * createtimeGe
     */
    private String createtimeGe;
    public String getCreatetimeGe() {
		return createtimeGe;
	}

	public void setCreatetimeGe(String createtimeGe) {
		this.createtimeGe = createtimeGe;
	}

	public String getCreatetimeLt() {
		return createtimeLt;
	}

	public void setCreatetimeLt(String createtimeLt) {
		this.createtimeLt = createtimeLt;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	/**
     * createtimeLt
     */
    private String createtimeLt;
    /**
     * fields
     */
    private List<String> fields;
    /**
     * orgcode
     */
    private String orgcode;


    /**
     * 获取Fields
     *
     * @return fields - Fields
     */
    public  List<String> getFields() {
        return fields;
    }

    /**
     * 设置Fields
     *
     * @param fields Fields
     */
    public void setFields( List<String> fields) {
        this.fields = fields;
    }


}