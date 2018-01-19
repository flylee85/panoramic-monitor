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

public class PanoramicOnWayQueryDeviceDto {
    /**
     * addr
     */
    private Boolean addr;
    /**
     * location
     */
    private Boolean location;
    /**
     * pageNo
     */
    private Integer pageNo;
    /**
     * pageSize
     */
    private Integer pageSize;


    /**
     * 获取Addr
     *
     * @return addr - Addr
     */
    public Boolean getAddr() {
        return addr;
    }

    /**
     * 设置Addr
     *
     * @param addr Addr
     */
    public void setAddr(Boolean addr) {
        this.addr = addr;
    }

    /**
     * 获取Location
     *
     * @return location - Location
     */
    public Boolean getLocation() {
        return location;
    }

    /**
     * 设置Location
     *
     * @param location Location
     */
    public void setLocation(Boolean location) {
        this.location = location;
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