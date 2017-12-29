package com.monitor.service.sparepartsintoinventory;

import com.monitor.api.sparepartsintoinventory.PanoramicSparePartsIntoInventoryService;
import com.monitor.dto.sparepartsintoinventory.PanoramicSparePartsIntoInventoryDto;
import com.monitor.mapper.sparepartsintoinventory.PanoramicSparePartsIntoInventoryMapper;
import com.monitor.model.sparepartsintoinventory.PanoramicSparePartsIntoInventory;
import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;



/**
 *@author xuegang
 * 2017/12/26.
 */
@Service("sparePartsIntoInventoryService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicSparePartsIntoInventoryServiceImpl extends AbstractService<PanoramicSparePartsIntoInventory> implements PanoramicSparePartsIntoInventoryService {
    @Autowired
    @Qualifier("sparePartsIntoInventoryMapper")
    private PanoramicSparePartsIntoInventoryMapper panoramicSparePartsIntoInventoryMapper;

    private List<PanoramicSparePartsIntoInventoryDto> findWeeklySummary(String date,String in_out_type) {
    	//入库记录数据库查询
    			List<PanoramicSparePartsIntoInventoryDto> dbResult = panoramicSparePartsIntoInventoryMapper.findWeeklySummary(date, in_out_type);
    			List<PanoramicSparePartsIntoInventoryDto> result = new ArrayList<PanoramicSparePartsIntoInventoryDto>();
    			PanoramicSparePartsIntoInventoryDto temp = new PanoramicSparePartsIntoInventoryDto();
    			double summary = 0.0;
    			double count_summary = 0.0;
    			
    			//内容设置
    			if(dbResult != null) {
    				for(int i = 0;i < dbResult.size();i++) {
    					//最大统计值的前5设定
    					if( dbResult.get(i) != null && i < 5) {
    						temp = new PanoramicSparePartsIntoInventoryDto();
    						temp.setName(dbResult.get(i).getName());
    						temp.setSummary(dbResult.get(i).getSummary());
    						result.add(temp);
    					} else {
    						summary += dbResult.get(i).getSummary();
    					}
    					count_summary += dbResult.get(i).getSummary();
    				}
    				
    				if (dbResult.size() > 5) {
    					temp = new PanoramicSparePartsIntoInventoryDto();
    					temp.setName("其他");
    					temp.setSummary(summary);
    					result.add(temp);
    				}
    			}
    			
    			//余下内容设置
    			if (result.size() <= 5) {
    				for(int i = result.size() - 1; i < 6; i++) {
    					temp = new PanoramicSparePartsIntoInventoryDto();
    					temp.setName("");
    					temp.setSummary(0.0);
    					result.add(temp);
    				}
    			}
    			
    			//合计值设定
    			temp = new PanoramicSparePartsIntoInventoryDto();
    			temp.setName("合计值");
    			temp.setSummary(count_summary);
			result.add(temp);
			
    			return result;
    }
    
	@Override
	public List<PanoramicSparePartsIntoInventoryDto> findWeeklyInSummary(String date) {
		
		//入库内容查询
		List<PanoramicSparePartsIntoInventoryDto> inResult = findWeeklySummary(date,"1");
		return inResult;
	}

	@Override
	public List<PanoramicSparePartsIntoInventoryDto> findWeeklyOutSummary(String date) {
		//出库内容查询
		List<PanoramicSparePartsIntoInventoryDto> inResult = findWeeklySummary(date,"0");
		return inResult;
	}

	@Override
	public List<PanoramicSparePartsIntoInventoryDto> findMonthlyMaxPrice(String date) {
		//月度货值结果查询
		List<PanoramicSparePartsIntoInventoryDto> priceResult = panoramicSparePartsIntoInventoryMapper.findMonthlyMaxPrice(date);
		return priceResult;
	}

	@Override
	public List<PanoramicSparePartsIntoInventoryDto> findMonthlyMaxValue(String date) {
		//月度货值结果查询
		List<PanoramicSparePartsIntoInventoryDto> valueResult = panoramicSparePartsIntoInventoryMapper.findMonthlyMaxValue(date);
		return valueResult;
	}
}
