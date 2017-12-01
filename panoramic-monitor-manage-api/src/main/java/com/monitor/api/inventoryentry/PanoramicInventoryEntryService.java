package com.monitor.api.inventoryentry;

import java.util.List;

import com.cloud.core.Service;
import com.monitor.model.inventoryentry.PanoramicInventoryEntry;


/**
 * @author summer
 * 2017/11/30
 */
public interface PanoramicInventoryEntryService extends Service<PanoramicInventoryEntry> {

	/** 上传数据
	 * @param panoramicInventoryEntryList
	 * @return
	 */
	void saveOrUpdate(List<PanoramicInventoryEntry> panoramicInventoryEntryList);
}
