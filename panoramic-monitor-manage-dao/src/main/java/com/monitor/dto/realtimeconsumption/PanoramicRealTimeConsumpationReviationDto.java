package com.monitor.dto.realtimeconsumption;

import com.cloud.model.BaseObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 实时消耗偏差
 * @author gang
 *
 */
@Data
public class PanoramicRealTimeConsumpationReviationDto extends BaseObject {

	/**
	 * 消耗计量
	 */
	private double realtimeConsumption;
	
	/**
	 * 出入库数量
	 */
	private double productmaterialStock;
	
	/**
	 * 偏差对比
	 */
	private double consumptionReviation;

	@Override
	public Serializable realId() {
		return null;
	}
}
