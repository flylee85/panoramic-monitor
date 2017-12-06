package com.monitor.service.productmaterials;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.monitor.api.productmaterials.PanoramicProductMaterialsService;
import com.monitor.mapper.productmaterials.PanoramicProductMaterialsMapper;
import com.monitor.mapper.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherMapper;
import com.monitor.model.productmaterials.PanoramicProductMaterials;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Optional;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("productMaterialsService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicProductMaterialsServiceImpl extends AbstractService<PanoramicProductMaterials> implements PanoramicProductMaterialsService {
    @Autowired
    @Qualifier("productMaterialsMapper")
    private PanoramicProductMaterialsMapper productMaterialsMapper;
    @Autowired
    @Qualifier("realTimeConsumptionGatherMapper")
    private PanoramicRealTimeConsumptionGatherMapper realTimeConsumptionGatherMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicProductMaterials> listRealTimeProductSummaryCategoryTask() {
        List<PanoramicProductMaterials> productMaterials = productMaterialsMapper.listRealTimeProductSummaryCategoryTask();
        return productMaterials;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void productSummaryTask(String name, String code, String date) {
        // 先查出来，再去更新
        Condition condition = new Condition(PanoramicProductMaterials.class, false);
        condition.createCriteria().andCondition(
                "  substring(code, 1, 12) = substring('" + code + "', 1, 12) AND f_id=2 AND delete_flag=1 "
                        + " AND date_format(utime,'%Y%m%d%H') = date_format('" + date + "','%Y%m%d%H')");
        List<PanoramicProductMaterials> consumptionList = productMaterialsMapper.selectByCondition(condition);
        PanoramicProductMaterials record = new PanoramicProductMaterials();
        record.setCode(code);
        record.setName(name);
        record.setValue("0");
        record.setCtime(DateUtil.getCurFullTimestamp());
        record.setId(null);
        record.setOperator("auto_task");
        record.setfId("2");
        record.setUnit("吨");
        record.setDeleteFlag(1);
        if (null != consumptionList && consumptionList.size() > 0) {
            consumptionList.forEach(e -> {
                record.setValue(Double.parseDouble(record.getValue()) + Double.parseDouble(e.getValue()) + "");
                record.setUtime(e.getUtime());
                record.setDtime(null);
                record.setUnit(e.getUnit());
                record.setOperator(e.getOperator());
                record.setfId(e.getfId());
                record.setName(e.getName());
                record.setDeleteFlag(e.getDeleteFlag());
                record.setCtime(e.getCtime());
                record.setId(null);
            });
        }
        PanoramicRealTimeConsumptionGather selectOne = realTimeConsumptionGatherMapper.selectByGatherTime(code, date);
        Optional<PanoramicRealTimeConsumptionGather> one = Optional.ofNullable(selectOne);
        if (one.isPresent()) {
            PanoramicRealTimeConsumptionGather realTimeConsumptionGather = one.get();
            realTimeConsumptionGather.setValue(Double.parseDouble(record.getValue()));
            realTimeConsumptionGather.setUtime(DateUtil.getCurFullTimestamp());
            realTimeConsumptionGather.setOperator("auto_task_update");
            realTimeConsumptionGather.setGatherTime(date);
            realTimeConsumptionGatherMapper.updateByPrimaryKeySelective(realTimeConsumptionGather);
        } else {
            PanoramicRealTimeConsumptionGather gather = new PanoramicRealTimeConsumptionGather();
            gather.setCode(code);
            gather.setName(name);
            gather.setDeleteFlag(record.getDeleteFlag());
            gather.setfId(record.getfId());
            gather.setGatherTime(date);
            gather.setId(null);
            gather.setCtime(DateUtil.getCurFullTimestamp());
            gather.setName(record.getName());
            gather.setOperator(record.getOperator());
            gather.setUnit(record.getUnit());
            gather.setDtime(record.getDtime());
            gather.setUtime(gather.getCtime());
            gather.setValue(Double.parseDouble(record.getValue()));
            realTimeConsumptionGatherMapper.insert(gather);
        }
    }
}
