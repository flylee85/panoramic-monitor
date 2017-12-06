package com.monitor.api.rawmaterials;

import com.cloud.core.Service;
import com.monitor.model.rawmaterials.PanoramicRawMaterials;


/**
 * @author summer
 * 2017/11/21.
 */
public interface PanoramicRawMaterialsService extends Service<PanoramicRawMaterials> {

    /**
     * 库存预计可使用天数
     *
     * @param code
     * @param date
     * @return
     */
    Integer countUsable(String code, String date);
}
