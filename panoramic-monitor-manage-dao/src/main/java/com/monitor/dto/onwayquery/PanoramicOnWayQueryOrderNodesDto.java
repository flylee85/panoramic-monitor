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

public class PanoramicOnWayQueryOrderNodesDto  {

	/**
	 * pageNo
	 */
	private List<String> orderno;
	/**
	 * pageNo
	 */
	private Integer pageNo;
	/**
	 * pageSize
	 */
	private Integer pageSize;

    /**
     * 获取Orderno
     *
     * @return orderno - Orderno
     */
    public  List<String> getOrderno() {
        return orderno;
    }

    /**
     * 设置Orderno
     *
     * @param orderno Orderno
     */
    public void setOrderno( List<String> orderno) {
        this.orderno = orderno;
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