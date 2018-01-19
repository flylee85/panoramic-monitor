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
	

	public String getOrdernoIn() {
		return ordernoIn;
	}

	public void setOrdernoIn(String ordernoIn) {
		this.ordernoIn = ordernoIn;
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
	 * ordernoIn
	 */
	private String ordernoIn;
	/**
	 * orgcode
	 */
	private String orgcode;

	/**
	 * pageNo
	 */
	private Integer pageNo;
	/**
	 * pageSize
	 */
	private Integer pageSize;

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
    


    /**
     * 获取pageNo
     *
     * @return pageNo - pageNo
     */
    public  Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置PageNo
     *
     * @param pageNo PageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    

    /**
     * 获取PageSize
     *
     * @return pageSize - PageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置PageSize
     *
     * @param pageSize PageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}