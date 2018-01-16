
/**
 * @author fgh
 *
 */
package com.risk.warning.service;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemWebService;
import com.risk.warning.mapper.PanoramicWarningReceiverMapper;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import com.risk.warning.model.PanoramicRiskForWebInfo;
import com.risk.warning.model.PanoramicSystemSqlquery;
import com.risk.warning.model.PanoramicWarningReceiver;
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

@Service("panoramicSystemWebService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicSystemWebServiceImpl extends AbstractService<PanoramicWarningData>  implements PanoramicSystemWebService {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicSystemSqlqueryServiceImpl.class);

    
    @Autowired
    @Qualifier("warningDataMapper")
    private PanoramicWarningDataMapper warningDataMapper;
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicRiskForWebInfo> getRiskListByDate(String startDate, String endDate,Integer status,String name) {
    	String strWhere = "";
    	if(status == 0) {
    		//未解除预警
    		strWhere += " and T1.status = 1" ;
    	}else if(status == 1) {
    		//已解除预警
    		strWhere += " and T1.status = 2" ;
    	}
    	
    	if (name != null && !name.equals("")) {
    		strWhere += " and T1.responsible_name = '" + name + "' ";
    	}
    	
    	DB_LOGGER.warn(strWhere);
        List<PanoramicRiskForWebInfo> recordList = warningDataMapper.getRiskListByDate(startDate, endDate,strWhere);
        return (null == recordList || recordList.size() == 0) ? null :recordList;
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public Boolean finishDataByManual(String responsiblecontent,String responsiblename,Integer id){
    	Boolean result = warningDataMapper.finishDataByManual(responsiblecontent,responsiblename,id);
        return result;
    }
    

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<String> getResponsibleNameList(){
    	List<String> recordList = warningDataMapper.getResponsibleNameList();
    	   return (null == recordList || recordList.size() == 0) ? null :recordList;
    }
    
}