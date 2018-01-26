package com.monitor.service.dataverification;

import com.monitor.mapper.dataverification.PanoramicDataVerificationMapper;
import com.monitor.model.dataverification.PanoramicDataVerification;
import com.monitor.api.dataverification.PanoramicDataVerificationService;
import com.monitor.dto.dataverification.PanoramicDataVerificationDto;
import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
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
    
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicDataVerificationServiceImpl.class);
	
	@Autowired
    @Qualifier("dataVerificationMapper")
    private PanoramicDataVerificationMapper panoramicDataVerificationMapper;
	
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
			bios = new BigDecimal((valueAuto - valueManual) * 100/ valueAuto).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
		result.setValueAuto(new java.text.DecimalFormat("#0.00").format(valueAuto));
		result.setValueManual(new java.text.DecimalFormat("#0.00").format(valueManual));
		result.setBias(new java.text.DecimalFormat("#0.00").format(bios));
		
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
			bios = new BigDecimal((valueAuto - valueManual) * 100/ valueAuto).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
		result.setValueAuto(new java.text.DecimalFormat("#0.00").format(valueAuto));
		result.setValueManual(new java.text.DecimalFormat("#0.00").format(valueManual));
		result.setBias(new java.text.DecimalFormat("#0.00").format(bios));
		
		return result;
	}

	@Override
	public PanoramicDataVerificationDto findContentByDate(String code, String date) {
		
		PanoramicDataVerificationDto result = panoramicDataVerificationMapper.findContentByDate(date,code);
		
		if(result != null) {
			String bios = result.getBias();
			
			try {
				result.setBias(String.valueOf(new java.text.DecimalFormat("#0.00").format(new DecimalFormat().parse(bios).doubleValue() * 100)));
			} catch (ParseException e) {
				DB_LOGGER.warn("数据校验值有异常" + e);
			}
		}
		
		return result;
	}
}
