/**
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 */
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwaytitleresult;/**
 *
 */

import com.cloud.model.BaseObject;

import java.io.Serializable;

/**
 * @author fgh
 *
 */

public class PanoramicOnWayTitleResultDto extends BaseObject{

    private Integer allcount;

    private Integer bindcount;

    private Integer overdaycount;


    /**
     * @return allcount
     */
    public Integer getAllCount() {
        return allcount;
    }

    /**
     * @param allcount
     */
    public void setAllCount(Integer allcount) {
        this.allcount = allcount;
    }


    /**
     * @return bindcount
     */
    public Integer getBindCount() {
        return bindcount;
    }

    /**
     * @param bindcount
     */
    public void setBindCount(Integer bindcount) {
        this.bindcount = bindcount;
    }


    /**
     * @return overdaycount
     */
    public Integer getOverDayCount() {
        return overdaycount;
    }

    /**
     * @param
     */
    public void setOverDayCount(Integer overdaycount) {
        this.overdaycount = overdaycount;
    }

    @Override
    public Serializable realId() {
        return null;
    }
}