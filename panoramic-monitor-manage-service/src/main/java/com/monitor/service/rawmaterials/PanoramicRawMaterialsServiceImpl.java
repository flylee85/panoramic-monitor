package com.monitor.service.rawmaterials;

import com.cloud.core.AbstractService;
import com.monitor.api.rawmaterials.PanoramicRawMaterialsService;
import com.monitor.mapper.rawmaterials.PanoramicRawMaterialsMapper;
import com.monitor.model.rawmaterials.PanoramicRawMaterials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicRawMaterialsService")
@Transactional
public class PanoramicRawMaterialsServiceImpl extends AbstractService<PanoramicRawMaterials> implements PanoramicRawMaterialsService {
    @Autowired
    @Qualifier("panoramicRawMaterialsMapper")
    private PanoramicRawMaterialsMapper panoramicRawMaterialsMapper;

}
