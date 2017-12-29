package com.monitor.service.dataverification;

import com.cloud.core.ServiceException;
import com.monitor.mapper.dataverification.PanoramicDataVerificationMapper;
import com.monitor.model.dataverification.PanoramicDataVerification;
import com.monitor.api.dataverification.PanoramicDataVerificationService;
import com.monitor.dto.dataverification.PanoramicDataVerificationDto;
import com.cloud.core.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 *@author xuegang
 * 2017/12/27.
 */
@Service("panoramicDataVerificationService")
@Transactional(readOnly = true,rollbackFor = ServiceException.class)
public class PanoramicDataVerificationServiceImpl extends AbstractService<PanoramicDataVerification> implements PanoramicDataVerificationService {
    @Autowired
    @Qualifier("dataVerificationMapper")
    private PanoramicDataVerificationMapper panoramicDataVerificationMapper;

    /**
     * 指定时间查询月度偏差值
     */
	@Override
	public PanoramicDataVerificationDto findThisMonthBiosByDate(String date) {
		
		//指定时间获取本月度的采集计量值和出入库计量值
		double value_auto = panoramicDataVerificationMapper.findThisMonthAutoSummary(date) == null ? 0:
					panoramicDataVerificationMapper.findThisMonthAutoSummary(date).doubleValue();
		
		double value_manual =  panoramicDataVerificationMapper.findThisMonthManualSummary(date) == null ? 0:
					panoramicDataVerificationMapper.findThisMonthManualSummary(date).doubleValue();
		double bios;
		PanoramicDataVerificationDto result = new PanoramicDataVerificationDto();
		
		if(value_auto == 0) {
			bios = 0;
		} else {
			bios = Math.round((value_auto - value_manual)/ value_auto * 100)/100 ;
		}
		
		result.setValue_auto(value_auto);
		result.setValue_manual(value_manual);
		result.setBias(bios);
		
		return result;
	}

	/**
	 * 指定时间查询上月度偏差值
	 */
	@Override
	public PanoramicDataVerificationDto findLastMonthBiosByDate(String date) {
		
		//指定时间获取本月度的采集计量值和出入库计量值
		double value_auto = panoramicDataVerificationMapper.findLastMonthAutoSummary(date) == null? 0:
			panoramicDataVerificationMapper.findLastMonthAutoSummary(date).doubleValue();
		
		double value_manual =  panoramicDataVerificationMapper.findLastMonthAutoSummary(date) == null? 0:
			panoramicDataVerificationMapper.findLastMonthAutoSummary(date).doubleValue();
		
		double bios;
		PanoramicDataVerificationDto result = new PanoramicDataVerificationDto();
		
		if(value_auto == 0) {
			bios = 0;
		} else {
			bios = Math.round((value_auto - value_manual)/ value_auto * 100)/100 ;
		}
		
		result.setValue_auto(value_auto);
		result.setValue_manual(value_manual);
		result.setBias(bios);
		
		return result;
	}
}
