/**
 * @author fgh
 */
package com.risk.warning.service;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemWebService;
import com.risk.warning.dto.PanoramicEmailSendInfoDto;
import com.risk.warning.dto.PanoramicRiskForWebInfoDto;
import com.risk.warning.dto.PanoramicWarningDataDto;
import com.risk.warning.mapper.PanoramicWarningDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("panoramicSystemWebService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicSystemWebServiceImpl extends AbstractService<PanoramicWarningDataDto> implements PanoramicSystemWebService {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicSystemSqlqueryServiceImpl.class);


    @Autowired
    @Qualifier("warningDataMapper")
    private PanoramicWarningDataMapper warningDataMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicRiskForWebInfoDto> getRiskListByDate(String startDate, String endDate, Integer status, String name) {
        String strWhere = "";
        if (status == 0) {
            //未解除预警
            strWhere += " and T1.status = 1";
        } else if (status == 1) {
            //已解除预警
            strWhere += " and T1.status = 2";
        }

        if (name != null && !"".equals(name)) {
            strWhere += " and T1.responsible_name = '" + name + "' ";
        }

        DB_LOGGER.warn(strWhere);
        List<PanoramicRiskForWebInfoDto> recordList = warningDataMapper.getRiskListByDate(startDate, endDate, strWhere);
        return (null == recordList || recordList.size() == 0) ? null : recordList;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public Boolean finishDataByManual(String responsiblecontent, String responsiblename, Integer id) {
        Boolean result = warningDataMapper.finishDataByManual(responsiblecontent, responsiblename, id);
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<String> getResponsibleNameList() {
        List<String> recordList = warningDataMapper.getResponsibleNameList();
        return (null == recordList || recordList.size() == 0) ? null : recordList;
    }

}