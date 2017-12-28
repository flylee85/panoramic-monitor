package com.monitor.dto.productmaterials;

import java.io.Serializable;

/**
 * 
 * @author gang
 *
 */
public class PanoramicProductMaterialsDto implements Serializable{

	 private static final long serialVersionUID = 1L;

	    /**
	     * 时间段
	     */
	    private int hour;

		/**
	     * 汇总值
	     */
	    private Double value;

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}
	    
}
