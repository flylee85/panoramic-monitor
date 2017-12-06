package com.monitor.service.dailyinventorysummary;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.google.common.collect.Maps;
import com.monitor.api.dailyinventorysummary.PanoramicDailyInventorySummaryService;
import com.monitor.api.materialthresholdconfiguration.PanoramicMaterialThresholdConfigurationService;
import com.monitor.mapper.dailyinventorysummary.PanoramicDailyInventorySummaryMapper;
import com.monitor.model.dailyinventorysummary.PanoramicDailyInventorySummary;
import com.monitor.model.materialthresholdconfiguration.PanoramicMaterialThresholdConfiguration;
import com.monitor.support.ExceptionRecordStatusEnum;
import com.monitor.support.ThresholdConfigConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author summer 2017/11/21.
 */
@Service("dailyInventorySummaryService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicDailyInventorySummaryServiceImpl extends AbstractService<PanoramicDailyInventorySummary>
        implements PanoramicDailyInventorySummaryService {
    @Autowired
    @Qualifier("materialThresholdConfigurationService")
    private PanoramicMaterialThresholdConfigurationService materialThresholdConfigurationService;
    @Autowired
    @Qualifier("dailyInventorySummaryMapper")
    private PanoramicDailyInventorySummaryMapper dailyInventorySummaryMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public Integer countUsable(String code, String date) {
        Double avg = 0.0;
        boolean flag = false;
        List<PanoramicDailyInventorySummary> recordList = dailyInventorySummaryMapper.findNumberdayData(code, 7, date);
        if (null == recordList || recordList.size() == 0) {
            recordList = dailyInventorySummaryMapper.findNumberdayData(code, 30, date);
            if (null == recordList || recordList.size() == 0) {
                return 0;
            }
            flag = true;
        }
        final Double[] sum = {0.0};
        recordList.forEach(e -> {
            sum[0] += e.getValue();
        });
        avg = flag ? sum[0] / 30 : sum[0] / 7;

        PanoramicDailyInventorySummary summary = queryByDateAndCode(code, date);
        if (Optional.ofNullable(summary).isPresent()) {
            return Integer.parseInt(new java.text.DecimalFormat("0").format(summary.getValue() / avg));
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public PanoramicDailyInventorySummary queryByDateAndCode(String code, String date) {
        Condition condition = new Condition(PanoramicDailyInventorySummary.class, false);
        condition.createCriteria()
                .andCondition(" code ='" + code + "' and f_id=2 and delete_flag=1 and utime > '"
                        + DateUtil.parseTimestamp(date, "yyyy-MM-dd") + "' and  utime < '"
                        + DateUtil.parseTimestamp(DateUtil.getSpecifiedDayBefor(date, -1), "yyyy-MM-dd") + "'");
        condition.setOrderByClause(" utime desc ");
        List<PanoramicDailyInventorySummary> recordList = dailyInventorySummaryMapper.selectByCondition(condition);
        return (null == recordList || recordList.size() == 0) ? null : recordList.get(0);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicDailyInventorySummary> listByDateAndCode(String date) {
        Condition condition = new Condition(PanoramicDailyInventorySummary.class, false);
        condition.createCriteria()
                .andCondition(" f_id=2 and delete_flag=1 and utime > '" + DateUtil.parseTimestamp(date, "yyyy-MM-dd")
                        + "' and  utime < '"
                        + DateUtil.parseTimestamp(DateUtil.getSpecifiedDayBefor(date, -1), "yyyy-MM-dd") + "'");
        condition.setOrderByClause(" utime desc ");
        List<PanoramicDailyInventorySummary> recordList = dailyInventorySummaryMapper.selectByCondition(condition);
        return recordList;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public Map<String, String> check(List<String> codeList, String date) {
        Map<String, String> result = Maps.newHashMap();
        codeList.forEach((String e) -> {
            PanoramicDailyInventorySummary dailyInventorySummary = this.queryByDateAndCode(e,
                    date);
            PanoramicMaterialThresholdConfiguration configuration = materialThresholdConfigurationService
                    .findByCode(ThresholdConfigConstant.STOCK, e);
            result.put(e, ExceptionRecordStatusEnum.normal.getCode());
            if (!Optional.ofNullable(configuration).isPresent()) {
                // 3 库存配置异常
                result.put(e, ExceptionRecordStatusEnum.configuration.getCode());
            } else if ((!Optional.ofNullable(dailyInventorySummary).isPresent())
                    || dailyInventorySummary.getValue() < configuration.getLowerLimit()) {
                // 1：库存偏低
                result.put(e, ExceptionRecordStatusEnum.low.getCode());
            } else if (dailyInventorySummary.getValue() > configuration.getUpperLimit()) {
                result.put(e, ExceptionRecordStatusEnum.high.getCode());
            }
        });
        return result;
    }


}
