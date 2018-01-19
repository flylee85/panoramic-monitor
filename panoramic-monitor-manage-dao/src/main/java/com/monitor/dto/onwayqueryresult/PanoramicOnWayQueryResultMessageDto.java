
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwayqueryresult;


public class PanoramicOnWayQueryResultMessageDto{


	private Integer code;
	
	private String message;
	
	private String data;
	

    /**
     * 获取Code
     *
     * @return code - Code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置Code
     *
     * @param code Code
     */
    public void setCode(Integer code) {
        this.code = code;
    }
	

    /**
     * 获取Message
     *
     * @return message - Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置Message
     *
     * @param message Message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    


    /**
     * 获取Data
     *
     * @return data - Data
     */
    public String getData() {
        return data;
    }

    /**
     * 设置Data
     *
     * @param data Data
     */
    public void setData(String data) {
        this.data = data;
    }
	
}