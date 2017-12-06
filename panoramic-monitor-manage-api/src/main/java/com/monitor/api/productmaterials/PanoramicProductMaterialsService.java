package com.monitor.api.productmaterials;

import com.cloud.core.Service;
import com.monitor.model.productmaterials.PanoramicProductMaterials;

import java.util.List;


/**
 * @author summer
 * 2017/11/21.
 */
public interface PanoramicProductMaterialsService extends Service<PanoramicProductMaterials> {

    /**
     * 查询产品分类-定时任务
     *
     * @return
     */
    List<PanoramicProductMaterials> listRealTimeProductSummaryCategoryTask();

    /**
     * 产品实时数据汇总-定时任务
     *
     * @param name
     * @param code
     * @param date
     */
    void productSummaryTask(String name, String code, String date);
}
