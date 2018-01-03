package com.monitor.service.dataverification;

import com.monitor.mapper.dataverification.PanoramicDataVerificationMapper;
import com.monitor.model.dataverification.PanoramicDataVerification;
import com.monitor.api.dataverification.PanoramicDataVerificationService;
import com.monitor.dto.dataverification.PanoramicDataVerificationDto;
import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 
 * @author gang
 *
 */
@Service("dataVerificationService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicDataVerificationServiceImpl extends AbstractService<PanoramicDataVerification> implements PanoramicDataVerificationService {
    @Autowired
    @Qualifier("dataVerificationMapper")
    private PanoramicDataVerificationMapper panoramicDataVerificationMapper;

	/**
	 * 磷钙
	 */
	public static final String HG_01_XY_7505 = "HG01XY7505";
	public static final String NAME_01_XY_7505 = "磷钙";
	
	/**
	 * 普钙
	 */
	public static final String HG_01_XY_7504 = "HG01XY7504";
	public static final String NAME_01_XY_7504 = "普钙";
	
	/**
	 * 磷矿粉
	 */
	public static final String HG_01_XY_7500 = "HG01XY7500";
	public static final String NAME_01_XY_7500 = "磷矿粉";
	
    /**
     * 指定时间查询月度偏差值
     */
	@Override
	public PanoramicDataVerificationDto findThisMonthBiosByDate(String code,String date) {
		
		//指定时间获取本月度的采集计量值和出入库计量值
		double valueAuto = panoramicDataVerificationMapper.findThisMonthAutoSummary(code,date) == null ? 0:
					panoramicDataVerificationMapper.findThisMonthAutoSummary(code,date).doubleValue();
		
		double valueManual =  panoramicDataVerificationMapper.findThisMonthManualSummary(code,date) == null ? 0:
					panoramicDataVerificationMapper.findThisMonthManualSummary(code,date).doubleValue();
		double bios;
		PanoramicDataVerificationDto result = new PanoramicDataVerificationDto();
		
		if(valueAuto == 0) {
			bios = 0;
		} else {
			bios = Math.round((valueAuto - valueManual)/ valueAuto * 1000000)/10000 ;
		}
		
		result.setValueAuto(valueAuto);
		result.setValueManual(valueManual);
		result.setBias(bios);
		
		return result;
	}

	/**
	 * 指定时间查询上月度偏差值
	 */
	@Override
	public PanoramicDataVerificationDto findLastMonthBiosByDate(String code,String date) {
		
		//指定时间获取本月度的采集计量值和出入库计量值
		double valueAuto = panoramicDataVerificationMapper.findLastMonthAutoSummary(code,date) == null? 0:
			panoramicDataVerificationMapper.findLastMonthAutoSummary(code,date).doubleValue();
		
		double valueManual =  panoramicDataVerificationMapper.findLastMonthAutoSummary(code,date) == null? 0:
			panoramicDataVerificationMapper.findLastMonthManualSummary(code,date).doubleValue();
		
		double bios;
		PanoramicDataVerificationDto result = new PanoramicDataVerificationDto();
		
		if(valueAuto == 0) {
			bios = 0;
		} else {
			bios = Math.round((valueAuto - valueManual)/ valueAuto * 1000000)/10000 ;
		}
		
		result.setValueAuto(valueAuto);
		result.setValueManual(valueManual);
		result.setBias(bios);
		
		return result;
	}

	@Override
	public PanoramicDataVerificationDto findContentByDate(String code, String date) {
		
		PanoramicDataVerificationDto result = new PanoramicDataVerificationDto();
		
		result = panoramicDataVerificationMapper.findContentByDate(date,code);
		
		return result;
	}
}
