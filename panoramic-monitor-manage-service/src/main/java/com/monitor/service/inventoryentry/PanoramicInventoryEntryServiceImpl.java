package com.monitor.service.inventoryentry;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.monitor.api.inventoryentry.PanoramicInventoryEntryService;
import com.monitor.mapper.inventoryentry.PanoramicInventoryEntryMapper;
import com.monitor.model.inventoryentry.PanoramicInventoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author summer
 * 2017/11/30
 */
@Service("inventoryEntryService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicInventoryEntryServiceImpl extends AbstractService<PanoramicInventoryEntry> implements PanoramicInventoryEntryService {
    @Autowired
    @Qualifier("inventoryEntryMapper")
    private PanoramicInventoryEntryMapper inventoryEntryMapper;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveOrUpdate(List<PanoramicInventoryEntry> panoramicInventoryEntryList) {
        panoramicInventoryEntryList.forEach(e -> {
        	e.setOperator("人工录入");
            PanoramicInventoryEntry record = inventoryEntryMapper.selectByCodeAndTime(e.getCode(), e.getCtime(), e.getSchedule());
            if (Optional.ofNullable(record).isPresent()) {
                record.setUtime(DateUtil.getCurFullTimestamp());
                record.setValue(e.getValue());
                record.setOperator(e.getOperator());
                inventoryEntryMapper.updateByPrimaryKeySelective(record);
            } else {
                inventoryEntryMapper.insertSelective(e);
            }
        });
    }

}
