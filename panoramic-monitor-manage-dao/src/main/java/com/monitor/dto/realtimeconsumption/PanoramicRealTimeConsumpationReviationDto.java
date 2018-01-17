package com.monitor.dto.realtimeconsumption;

import com.cloud.model.BaseObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 实时消耗偏差
 * @author gang
 *
 */
public class PanoramicRealTimeConsumpationReviationDto extends BaseObject {

	/**
	 * 消耗计量
	 */
	private double realtimeConsumption;
	
	/**
	 * 出入库数量
	 */
	private double productmaterialStock;

	public double getRealtimeConsumption() {
		return realtimeConsumption;
	}

	public void setRealtimeConsumption(double realtimeConsumption) {
		this.realtimeConsumption = realtimeConsumption;
	}

	public double getProductmaterialStock() {
		return productmaterialStock;
	}

	public void setProductmaterialStock(double productmaterialStock) {
		this.productmaterialStock = productmaterialStock;
	}

	public double getConsumptionReviation() {
		return consumptionReviation;
	}

	public void setConsumptionReviation(double consumptionReviation) {
		this.consumptionReviation = consumptionReviation;
	}

	/**
	 * 偏差对比
	 */
	private double consumptionReviation;

	@Override
	public Serializable realId() {
		return null;
	}
}
