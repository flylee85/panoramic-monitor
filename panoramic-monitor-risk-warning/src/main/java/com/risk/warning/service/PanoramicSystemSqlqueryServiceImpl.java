
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
import com.risk.warning.mapper.PanoramicSystemSqlqueryMapper;
import com.risk.warning.mapper.PanoramicWarningReceiverMapper;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import com.risk.warning.model.PanoramicSystemSqlquery;
import com.risk.warning.model.PanoramicWarningReceiver;
import com.risk.warning.web.controller.PanoramicRealTimeScanWarningDataController;
import com.risk.warning.model.PanoramicWarningData;

import java.sql.Timestamp;
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
public class PanoramicSystemSqlqueryServiceImpl extends AbstractService<PanoramicSystemSqlquery>  implements PanoramicSystemSqlqueryService {
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
             List<PanoramicSystemSqlquery> QueryList = systemSqlqueryMapper.getStrSqlQuery();
	 		   	if (QueryList != null) {
 	   			for (PanoramicSystemSqlquery warningquery : QueryList) {
 	   				List<PanoramicWarningData> WarningSourceList = warningDataMapper.GetSourceData(warningquery.getQuerySql());
 	   				
 	   				//更新SQL语句执行时间
 	   				systemSqlqueryMapper.updateLastexcuteTime(warningquery.getWarnConfigurationID());
 	   				if(WarningSourceList != null) {
 	   					for (PanoramicWarningData  SourceData : WarningSourceList) {
 	   						//扫描出的预警数据插入预警数据库
 	   						warningDataMapper.addWarningSource(SourceData.getFactoryName(),SourceData.getSectionName(),SourceData.getDeviceName(),  SourceData.getEventName(),SourceData.getStrEvent(), SourceData.getEventValue(), SourceData.getStatus(),SourceData.getCtime(),SourceData.getSourceId(),warningquery.getWarnConfigurationID(),1);
 	   						if(warningquery.getLogicType() == 1) {
 	   							warningDataMapper.finishDataForNoSendEmail(warningquery.getWarnConfigurationID());
 	   						}
 	   					}
 	   				}else {
 	   					if(warningquery.getLogicType() == 2 ||  warningquery.getLogicType() == 3 )
 	   					warningDataMapper.finishDataForSendEmail(warningquery.getWarnConfigurationID());
 	   				}
                }
             }
         } catch (Exception e) {
         	DB_LOGGER.warn("操作异常!");
         }
    }
}