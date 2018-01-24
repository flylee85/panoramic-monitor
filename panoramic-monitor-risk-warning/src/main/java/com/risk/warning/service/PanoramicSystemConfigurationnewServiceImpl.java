
/**
 * @author fgh
 *
 */
package com.risk.warning.service;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemConfigurationnewService;
import com.risk.warning.dto.PanoramicSystemSqlqueryDto;
import com.risk.warning.mapper.PanoramicSystemConfigurationnewMapper;
import com.risk.warning.mapper.PanoramicSystemSqlqueryMapper;
import com.risk.warning.model.PanoramicSystemConfigurationnew;
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

@Service("panoramicSystemConfigurationnewService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicSystemConfigurationnewServiceImpl extends AbstractService<PanoramicSystemConfigurationnew>  implements PanoramicSystemConfigurationnewService {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicSystemConfigurationnewServiceImpl.class);
    @Autowired
    @Qualifier("systemConfigurationnewMapper")
    private PanoramicSystemConfigurationnewMapper systemConfigurationnewMapper;
	
    @Autowired
    @Qualifier("systemSqlqueryMapper")
    private PanoramicSystemSqlqueryMapper systemSqlqueryMapper;
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createSqlService() {
    	 try {
    		 systemSqlqueryMapper.truncateTable();
    		//获取规则表离数据
            List<PanoramicSystemConfigurationnew> QueryList = systemConfigurationnewMapper.getStrToSql();
            
         	if (QueryList != null) {
         		for (PanoramicSystemConfigurationnew configuration : QueryList) {
         			String strSql = "Select ''%s'' as FactoryName , ''%s'' as SectionName, %s as DeviceName , ''%s'' as EventName,''%s'' as StrEvent, %s as EventValue,1 as Status,%s as createtime,%d as WarnConfigurationID,1 as Level,%s as SourceID from %s where (%s > %f OR %s < %f)   %s and %s>= ";
         	   
         			String strDeviceName = configuration.getDeviceName();
         			String strCondition = "";
         			switch(configuration.getLogicType()) {
         				case 1:
         					break;
         				case 2:
         					strDeviceName = "''" + strDeviceName +  "''";
         					break;
         				case 3:
         					strDeviceName = "''" + strDeviceName +  "''";
         					strCondition = " and %s = ''%s'' ";
         					strCondition = String.format(strCondition, configuration.getStrSubEvent(),configuration.getStrSubEventValue());
         					break;
         				default:
         		         	DB_LOGGER.warn("数据异常!");
         					break;
         			}
         			
         			strSql = String.format(strSql, configuration.getFactoryName(),configuration.getSectionName(),strDeviceName,configuration.getSubName(),configuration.getStrEvent(),configuration.getStrEvent(),configuration.getStrDateEvent(),configuration.getId(),"id",configuration.getDataBaseTable(),configuration.getStrEvent(),configuration.getMaxValue(),configuration.getStrEvent(),configuration.getMinValue(),strCondition,configuration.getStrDateEvent());

                 	DB_LOGGER.warn(strSql);
         			systemSqlqueryMapper.addStrSqlQuery(configuration.getId(), strSql, configuration.getIntervaltime());
                }
         	}
             
         } catch (Exception e) {
         	DB_LOGGER.warn("操作异常!");
         }
    }
}