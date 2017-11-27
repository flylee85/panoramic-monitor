package com.monitor.service.realtimeconsumption;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.monitor.api.realtimeconsumption.PanoramicRealTimeConsumptionService;
import com.monitor.mapper.realtimeconsumption.PanoramicRealTimeConsumptionMapper;
import com.monitor.mapper.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherMapper;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Optional;

/**
 * @author summer 2017/11/21.
 */
@Service("realTimeConsumptionService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicRealTimeConsumptionServiceImpl extends AbstractService<PanoramicRealTimeConsumption>
		implements PanoramicRealTimeConsumptionService {
	@Autowired
	@Qualifier("realTimeConsumptionMapper")
	private PanoramicRealTimeConsumptionMapper realTimeConsumptionMapper;
	@Autowired
	@Qualifier("realTimeConsumptionGatherMapper")
	private PanoramicRealTimeConsumptionGatherMapper realTimeConsumptionGatherMapper;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void realtimeConsumptionSummary(String name, String code, String date) {
		// 先查出来，再去更新
		Condition condition = new Condition(PanoramicRealTimeConsumption.class, false);
		condition.createCriteria().andCondition(" code ='" + code + "' AND f_id=2 AND delete_flag=1 "
				+ " AND date_format(utime,'%Y%m%d%H') = date_format('" + date + "','%Y%m%d%H')");
		List<PanoramicRealTimeConsumption> consumptionList = realTimeConsumptionMapper.selectByCondition(condition);
		PanoramicRealTimeConsumption record = new PanoramicRealTimeConsumption();
		record.setCode(code);
		record.setName(name);
		record.setValue(0.0);
		record.setCtime(DateUtil.getCurFullTimestamp());
		record.setId(null);
		record.setUnit("吨");
		record.setOperator("auto");
		record.setfId("2");
		record.setDeleteFlag(1);
		if (null != consumptionList && consumptionList.size() > 0) {
			consumptionList.forEach(e -> {
				record.setValue(record.getValue() + e.getValue());
				record.setUtime(e.getUtime());
				record.setDtime(null);
				record.setUnit(e.getUnit());
				record.setOperator(e.getOperator());
				record.setfId(e.getfId());
				record.setName(e.getName());
				record.setDeleteFlag(e.getDeleteFlag());
				record.setCtime(e.getCtime());
				record.setId(null);
			});
		}

		PanoramicRealTimeConsumptionGather gather = new PanoramicRealTimeConsumptionGather();
		gather.setCode(code);
		gather.setName(name);
		gather.setDeleteFlag(record.getDeleteFlag());
		gather.setfId(record.getfId());
		gather.setGatherTime(date);
		gather.setId(record.getId());
		gather.setCtime(DateUtil.getCurFullTimestamp());
		gather.setName(record.getName());
		gather.setOperator(record.getOperator());
		gather.setUnit(record.getUnit());
		gather.setDtime(record.getDtime());
		gather.setUtime(gather.getCtime());
		PanoramicRealTimeConsumptionGather selectOne = realTimeConsumptionGatherMapper.selectOne(gather);
		Optional<PanoramicRealTimeConsumptionGather> one = Optional.ofNullable(selectOne);
		if (one.isPresent()) {
			one.get().setValue(record.getValue());
			realTimeConsumptionGatherMapper.updateByPrimaryKeySelective(one.get());
		} else {
			realTimeConsumptionGatherMapper.insert(gather);
		}

	}

	@Override
	public List<PanoramicRealTimeConsumption> listRealTimeConsumptionCategory() {
		List<PanoramicRealTimeConsumption> recordList = realTimeConsumptionMapper.listRealTimeConsumptionCategory();
		return recordList;
	}
}
