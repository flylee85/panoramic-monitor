package com.monitor.service.productmaterials;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.productmaterials.PanoramicProductMaterialsService;
import com.monitor.mapper.productmaterials.PanoramicProductMaterialsMapper;
import com.monitor.model.productmaterials.PanoramicProductMaterials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

}
