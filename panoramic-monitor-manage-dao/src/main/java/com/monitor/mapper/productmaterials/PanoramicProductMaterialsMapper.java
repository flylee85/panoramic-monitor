package com.monitor.mapper.productmaterials;

import com.cloud.core.Mapper;
import com.monitor.model.productmaterials.PanoramicProductMaterials;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author summer
 */
@Repository("productMaterialsMapper")
public interface PanoramicProductMaterialsMapper extends Mapper<PanoramicProductMaterials> {
    /**
     *查询产品分类
     */
    @Select("SELECT SUBSTRING(CODE, 1, 12) CODE ,NAME FROM PANORAMIC_PRODUCT_MATERIALS AS B GROUP BY SUBSTRING(CODE, 1, 12)")
    List<PanoramicProductMaterials> listRealTimeProductSummaryCategoryTask();
}