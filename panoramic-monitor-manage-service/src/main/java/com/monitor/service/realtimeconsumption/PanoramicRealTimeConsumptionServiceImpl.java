package com.monitor.service.realtimeconsumption;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.monitor.api.realtimeconsumption.PanoramicRealTimeConsumptionService;
import com.monitor.mapper.realtimeconsumption.PanoramicRealTimeConsumptionMapper;
import com.monitor.mapper.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherMapper;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author summer 2017/11/21.
 */
@Service("realTimeConsumptionService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicRealTimeConsumptionServiceImpl extends AbstractService<PanoramicRealTimeConsumption>
        implements PanoramicRealTimeConsumptionService {

    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeConsumptionServiceImpl.class);
    @Autowired
    @Qualifier("realTimeConsumptionMapper")
    private PanoramicRealTimeConsumptionMapper realTimeConsumptionMapper;
    @Autowired
    @Qualifier("realTimeConsumptionGatherMapper")
    private PanoramicRealTimeConsumptionGatherMapper realTimeConsumptionGatherMapper;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void realtimeConsumptionSummaryTask(String name, String code, String dateBefore, String dateEnd) {
        // 先查出来，再去更新
    		PanoramicRealTimeConsumption result = realTimeConsumptionMapper.selectSummaryConsumptionByCondition(code, dateBefore, dateEnd);
    		
        PanoramicRealTimeConsumption record = new PanoramicRealTimeConsumption();
        record.setCode(code);
        record.setName(name);
        record.setValue(0.0);
        record.setCtime(DateUtil.getCurFullTimestamp());
        record.setId(null);
        record.setOperator("auto_task");
        record.setfId("2");
        record.setUnit(StringUtils.containsIgnoreCase(code, "0004A4000009") ? "度" : "吨");
        record.setDeleteFlag(1);
        if(null != result) {
  	      record.setUtime(result.getUtime());
  	      record.setDtime(null);
  	      record.setOperator("auto_task");
  	      record.setfId(result.getfId());
  	      record.setName(result.getName());
  	      record.setDeleteFlag(result.getDeleteFlag());
  	      record.setCtime(result.getCtime());
  	      record.setId(null);       	
        }
	      
        PanoramicRealTimeConsumptionGather selectOne = realTimeConsumptionGatherMapper.selectByGatherTime(code, dateEnd);
        Optional<PanoramicRealTimeConsumptionGather> one = Optional.ofNullable(selectOne);
        if (one.isPresent()) {
        	selectOne.setValue(result != null? result.getValue():0.0);
        	selectOne.setUtime(DateUtil.getCurFullTimestamp());
        	selectOne.setCtime(selectOne.getUtime());
        	selectOne.setOperator("auto_task_update");
        	selectOne.setGatherTime(dateEnd);
            realTimeConsumptionGatherMapper.updateByPrimaryKeySelective(selectOne);
        } else {
            PanoramicRealTimeConsumptionGather gather = new PanoramicRealTimeConsumptionGather();
            gather.setCode(code);
            gather.setName(name);
            gather.setDeleteFlag(record.getDeleteFlag());
            gather.setfId(record.getfId());
            gather.setGatherTime(dateEnd);
            gather.setId(null);
            gather.setCtime(DateUtil.getCurFullTimestamp());
            gather.setName(record.getName());
            gather.setOperator(record.getOperator());
            gather.setUnit(record.getUnit());
            gather.setDtime(record.getDtime());
            gather.setUtime(gather.getCtime());
            gather.setValue(result != null? result.getValue():0.0);
            realTimeConsumptionGatherMapper.insert(gather);
        }

    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicRealTimeConsumption> listRealTimeConsumptionCategoryTask() {
    		List<PanoramicRealTimeConsumption> recordList = realTimeConsumptionMapper.listRealTimeConsumptionCategory();
 
    		if(recordList != null && recordList.size() != 0 ) {
    	   		Map<String, PanoramicRealTimeConsumption> map = new HashMap<String,PanoramicRealTimeConsumption>(recordList.size());
    	   		List<PanoramicRealTimeConsumption> nodupList = new ArrayList<PanoramicRealTimeConsumption>();
        		for(PanoramicRealTimeConsumption temp:recordList) {
        			if(map.get(temp.getCode()) == null) {
        				map.put(temp.getCode(), temp);
        				nodupList.add(temp);
        			} 
        		}
        		return nodupList;    			
    		} else {
    			return null;
    		}

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void realTimeConsumptionSummaryTask() {
        try {
            String dateBefore = DateUtil.currentTimeHourStr();
            String dateEnd = DateUtil.dateBeforeOrAfterHoursStr(DateUtil.currentTime(),1);
            
            List<PanoramicRealTimeConsumption> consumptionCategoryList = this.listRealTimeConsumptionCategoryTask();
            if (null == consumptionCategoryList || consumptionCategoryList.size() == 0) {
                DB_LOGGER.warn("实时消耗表数据为空{}");
                return;
            }
            consumptionCategoryList.forEach((PanoramicRealTimeConsumption e) -> {
                this.realtimeConsumptionSummaryTask(e.getName(), e.getCode(), dateBefore, dateEnd);
            });
        } catch (Exception e) {
            DB_LOGGER.warn("实时消耗数据汇总到汇总表{},出现异常" + e);
        }
    }

	@Override
	public void historyConsumptionSummaryTask(String dateFrom, String dateTo) {
		
		Date dateStart = DateUtil.getFormatDate(dateFrom);
		Date dateEnd = DateUtil.getFormatDate(dateTo);
		
		//指定时间间隔
		int daysBetween = DateUtil.getDaysBetweenDates(dateStart,dateEnd);
		
	    List<PanoramicRealTimeConsumption> consumptionCategoryList = this.listRealTimeConsumptionCategoryTask();
	    if (null == consumptionCategoryList || consumptionCategoryList.size() == 0) {
	        DB_LOGGER.warn("实时消耗表数据为空{}");
	        return;
	    }
    
		for (int i = 0; i <= daysBetween; i++) {
			Date dateTemp = DateUtil.getDateBeforeOrAfter(dateStart,i);
			
			for(int j = 0; j< 24;j++) {
				String date1 =  DateUtil.dateBeforeOrAfterHoursStr(dateTemp,j);
				String date2 =  DateUtil.dateBeforeOrAfterHoursStr(dateTemp,j + 1);
				
			    consumptionCategoryList.forEach((PanoramicRealTimeConsumption e) -> {
			    		DB_LOGGER.warn("code:" + e.getCode() + "StartTime:" + date1 + "EndTime:" + date2);
			        this.realtimeConsumptionSummaryTask(e.getName(), e.getCode(), date1, date2);
			    });
			}
		}
	}
}
