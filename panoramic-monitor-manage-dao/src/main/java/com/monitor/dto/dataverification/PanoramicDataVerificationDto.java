package com.monitor.dto.dataverification;

import java.io.Serializable;


/**
 * @author summer
 */
public class PanoramicDataVerificationDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 采集计量
	 */
	private double value_auto;
	
	/**
	 * 出入库计量
	 */
	private double value_manual;
	
	/**
	 * 偏差
	 */
	private double bias;
	
	public double getValue_auto() {
		return value_auto;
	}
	
	public void setValue_auto(double value_auto) {
		this.value_auto = value_auto;
	}
	
	public double getValue_manual() {
		return value_manual;
	}
	
	public void setValue_manual(double value_manual) {
		this.value_manual = value_manual;
	}
	
	public double getBias() {
		return bias;
	}
	
	public void setBias(double bias) {
		this.bias = bias;
	}
	
	
}
