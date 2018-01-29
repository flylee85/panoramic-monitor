package com.monitor.dto.intothefactoryrecords;

import java.util.Date;

/**
 * @author gang
 */
public class PanoramicIntoTheFactoryDto {
	
    /**
     * 物料名称
     */
    private String name;

    /**
     * 车牌
     */
    private String numberPlate;
    
    /**
     * 净重
     */
    private String netWeight;
    
    /**
     * 扣重
     */
    private String tare;

    /**
     * 进厂时间
     */
    private Date inTime;
    
    /**
     * 出厂时间
     */
    private Date outTime;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}
	public String getTare() {
		return tare;
	}
	public void setTare(String tare) {
		this.tare = tare;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
 
}