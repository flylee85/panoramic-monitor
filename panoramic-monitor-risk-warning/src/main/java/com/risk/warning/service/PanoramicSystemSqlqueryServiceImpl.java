
/**
 * @author fgh
 *
 */
package com.risk.warning.service;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemSqlqueryService;
import com.risk.warning.dto.PanoramicSystemSqlqueryDto;
import com.risk.warning.dto.PanoramicWarningDataDto;
import com.risk.warning.mapper.PanoramicSystemSqlqueryMapper;
import com.risk.warning.mapper.PanoramicWarningReceiverMapper;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import com.risk.warning.model.PanoramicWarningReceiver;
import com.risk.warning.web.controller.PanoramicRealTimeScanWarningDataController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("panoramicSystemSqlqueryService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicSystemSqlqueryServiceImpl extends AbstractService<PanoramicSystemSqlqueryDto>  implements PanoramicSystemSqlqueryService {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicSystemSqlqueryServiceImpl.class);
    @Autowired
    @Qualifier("systemSqlqueryMapper")
    private PanoramicSystemSqlqueryMapper systemSqlqueryMapper;
    
    @Autowired
    @Qualifier("warningDataMapper")
    private PanoramicWarningDataMapper warningDataMapper;
    

    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void realTimeScanWarningDataTask() {
    	 try {
             //查询出数据库中需要执行的SQL语句
             List<PanoramicSystemSqlqueryDto> QueryList = systemSqlqueryMapper.getStrSqlQuery();
	 		   	if (QueryList != null) {
 	   			for (PanoramicSystemSqlqueryDto warningquery : QueryList) {
 	   				//更新最后扫描数据的时间
 	   				
 	   				List<PanoramicWarningDataDto> WarningSourceList = warningDataMapper.GetSourceData(warningquery.getQuerySql(),warningquery.getLastExecuteTime());
 	   				
 	   				//更新SQL语句执行时间
 	   				if(WarningSourceList != null && WarningSourceList.size() > 0 ) {
 	   					for (PanoramicWarningDataDto  SourceData : WarningSourceList) {
 	   						Boolean issendemail = false;
 	   						if(warningquery.getLogicType() == 2 ||  warningquery.getLogicType() == 3) {
 	   							//查询报警数据库离是否存在昨天的报警数据
 	   							List<PanoramicWarningDataDto> ListData = warningDataMapper.getLastWarningDataByConfigurationID(5,warningquery.getWarnConfigurationID(),SourceData.getCreateTime());
 	   							if(ListData != null && ListData.size() > 0) {
 	   								PanoramicWarningDataDto lastData = ListData.get(0);
 	   								//判断需要不需要提升报警等级
 	   								if(ListData.size() == 1 && lastData.getDayCount() == 1 && lastData.getMaxLevel() > lastData.getLevel()) {
 	   									//插入报警等级提升之后的数据
 	   									warningDataMapper.addWarningSource(lastData.getFactoryName(),lastData.getSectionName(),lastData.getDeviceName(),  lastData.getEventName(),lastData.getStrEvent(), lastData.getEventValue(), lastData.getStatus(),lastData.getCreateTime(),lastData.getSourceId(),lastData.getWarnConfigurationID(),lastData.getLevel() + 1,issendemail);	
 	   								}
 	   								if(ListData.size() <= 5) {
 	   									issendemail = true;
 	   								}
 	   							}
 	   						}
 	   						//扫描出的预警数据插入预警数据库
 	   						warningDataMapper.addWarningSource(SourceData.getFactoryName(),SourceData.getSectionName(),SourceData.getDeviceName(),  SourceData.getEventName(),SourceData.getStrEvent(), SourceData.getEventValue(), SourceData.getStatus(),SourceData.getCreateTime(),SourceData.getSourceId(),warningquery.getWarnConfigurationID(),1,issendemail);
 	   						
 	   					}
 	   					if(warningquery.getLogicType() == 1) {
 	   						//不需要发送邮件的自动解除预警
							warningDataMapper.finishDataForNoSendEmail(warningquery.getWarnConfigurationID());
						}
 	   				}else {
 	   					if(warningquery.getLogicType() == 2 ||  warningquery.getLogicType() == 3 )
 	   					{
 	   						//自动解除之前没有解除的预警数据
 	   						warningDataMapper.finishDataForSendEmail(warningquery.getWarnConfigurationID());
 	   					}
 	   				}
 	   				//更新最后执行时间
 	   				systemSqlqueryMapper.updateLastexcuteTime(warningquery.getWarnConfigurationID());
                }
             }
         } catch (Exception e) {
         	DB_LOGGER.warn("操作异常!");
         }
    }
}