/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwayqueryresult;

import java.util.List;

public class PanoramicOnWayQueryResultDto{
	
	private String result;
	
	private Integer pageNo;
	
	private Integer totalCount;
	



    /**
     * 获取result
     *
     * @return result - result
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置result
     *
     * @param result result
     */
    public void setResult(String result) {
        this.result = result;
    }
    

    /**
     * 获取PageNo
     *
     * @return pageNo - PageNo
     */
    public Integer getPageNo() {
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
     * 获取totalCount
     *
     * @return totalCount - totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置totalCount
     *
     * @param totalCount totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}