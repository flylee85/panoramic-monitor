package com.monitor.service.productofflinemeasurement;

import com.monitor.mapper.productofflinemeasurement.PanoramicProductOfflineMeasurementMapper;
import com.monitor.mapper.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherMapper;
import com.monitor.model.productofflinemeasurement.PanoramicProductOfflineMeasurement;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import com.monitor.service.realtimeconsumption.PanoramicRealTimeConsumptionServiceImpl;
import tk.mybatis.mapper.entity.Condition;
import com.monitor.api.productofflinemeasurement.PanoramicProductOfflineMeasurementService;
import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
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
 * 
 * @author gang
 *
 */
@Service("productOfflineMeasurementService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicProductOfflineMeasurementServiceImpl extends AbstractService<PanoramicProductOfflineMeasurement> implements PanoramicProductOfflineMeasurementService {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeConsumptionServiceImpl.class);
    
	@Autowired
    @Qualifier("productOfflineMeasurementMapper")
    private PanoramicProductOfflineMeasurementMapper panoramicProductOfflineMeasurementMapper;
	
	@Autowired
    @Qualifier("realTimeConsumptionGatherMapper")
    private PanoramicRealTimeConsumptionGatherMapper realTimeConsumptionGatherMapper;

	/**
	 * 产品下线定时任务
	 */
	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void productOfflineMeasurementSummaryTask() {
		try {
            String dateStart = DateUtil.currentTimeHourStr();
            String dateEnd = DateUtil.dateBeforeOrAfterHoursStr(DateUtil.currentTime(),1);
            
            List<PanoramicProductOfflineMeasurement> productOfflineCategoryList = this.getListProductOfflineCategory();
            
            if (null == productOfflineCategoryList || productOfflineCategoryList.size() == 0) {
                DB_LOGGER.warn("产品下线表数据为空{}");
                return;
            }
            
            productOfflineCategoryList.forEach((PanoramicProductOfflineMeasurement e) -> {
                this.productOfflineSummaryTask(e.getName(), e.getCode(), dateStart, dateEnd);
            });
        } catch (Exception e) {
            DB_LOGGER.warn("产品下线表数据汇总到汇总表{},出现异常" + e);
        }
	}

	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void historyConsumptionSummaryTask(String dateFrom,String dateTo) {
            
		Date dateStart = DateUtil.getFormatDate(dateFrom);
		Date dateEnd = DateUtil.getFormatDate(dateTo);
		
		//指定时间间隔
		int daysBetween = DateUtil.getDaysBetweenDates(dateStart,dateEnd);
		
		List<PanoramicProductOfflineMeasurement> productOfflineCategoryList = this.getListProductOfflineCategory();
	    if (null == productOfflineCategoryList || productOfflineCategoryList.size() == 0) {
	        DB_LOGGER.warn("产品下线表数据为空{}");
	        return;
	    }
    
		for (int i = 0; i <= daysBetween; i++) {
			Date dateTemp = DateUtil.getDateBeforeOrAfter(dateStart,i);
			
			for(int j = 0; j< 24;j++) {
				String date1 =  DateUtil.dateBeforeOrAfterHoursStr(dateTemp,j);
				String date2 =  DateUtil.dateBeforeOrAfterHoursStr(dateTemp,j + 1);
				productOfflineCategoryList.forEach((PanoramicProductOfflineMeasurement e) -> {
			    		DB_LOGGER.warn("code:" + e.getCode() + "StartTime:" + date1 + "EndTime:" + date2);
			        this.productOfflineSummaryTask(e.getName(), e.getCode(), date1, date2);
			    });
			}
		}
	}
	
	/**
	 * 产品消耗数据实时汇总
	 * @param name
	 * @param code
	 * @param date
	 */
	private void productOfflineSummaryTask(String name, String code, String dateStart, String dateEnd ) {

        PanoramicProductOfflineMeasurement result = 
        		panoramicProductOfflineMeasurementMapper.selectSummaryConsumptionByCondition(code, dateStart, dateEnd);
        
        PanoramicProductOfflineMeasurement record = new PanoramicProductOfflineMeasurement();
        record.setCode(code);
        record.setName(name);
        record.setValue(0.0);
        record.setCtime(DateUtil.getCurFullTimestamp());
        record.setId(null);
        record.setOperator("auto_task");
        record.setfId("2");
        record.setUnit("吨");
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
//        	selectOne.setValue(sumValue[0] );
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
	
	/**
	 * 获取下线数据条目
	 * @return
	 */
    private List<PanoramicProductOfflineMeasurement> getListProductOfflineCategory() {
    		List<PanoramicProductOfflineMeasurement> productOfflineCategoryList = 
        		panoramicProductOfflineMeasurementMapper.listProductOfflineCategory();

    		if(productOfflineCategoryList != null && productOfflineCategoryList.size() != 0) {
        		List<PanoramicProductOfflineMeasurement> nodupCastegoryList = 
        				new ArrayList<PanoramicProductOfflineMeasurement>();
        		
    			Map<String, PanoramicProductOfflineMeasurement> map = 
    					new HashMap<String,PanoramicProductOfflineMeasurement>(productOfflineCategoryList.size());
        		
        		for(PanoramicProductOfflineMeasurement temp:productOfflineCategoryList) {
        			if(map.get(temp.getCode()) == null) {
        				map.put(temp.getCode(), temp);
        				nodupCastegoryList.add(temp);
        			} 
        		}
        		
        		return nodupCastegoryList;
        		
    		} else {
    			return null;
		}
    }
}
