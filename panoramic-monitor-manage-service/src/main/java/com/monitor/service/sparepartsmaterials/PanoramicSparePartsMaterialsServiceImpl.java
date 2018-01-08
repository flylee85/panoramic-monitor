package com.monitor.service.sparepartsmaterials;

import com.monitor.api.sparepartsmaterials.PanoramicSparePartsMaterialsService;
import com.monitor.mapper.sparepartsmaterials.PanoramicSparePartsMaterialsMapper;
import com.monitor.model.sparepartsmaterials.PanoramicSparePartsMaterials;
import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author xuegang
 * 2018/01/08.
 */
@Service("sparePartsMaterialsService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicSparePartsMaterialsServiceImpl extends AbstractService<PanoramicSparePartsMaterials> implements PanoramicSparePartsMaterialsService {
	@Autowired
    @Qualifier("sparePartsMaterialsMapper")
    private PanoramicSparePartsMaterialsMapper panoramicSparePartsMaterialsMapper;

	@Override
	public PanoramicSparePartsMaterials getSummaryByDate(String date) {
		PanoramicSparePartsMaterials result = panoramicSparePartsMaterialsMapper.getSummaryByDate(date);
		return result;
	}

	@Override
	public List<PanoramicSparePartsMaterials> listSummaryByDate(String date) {
		List<PanoramicSparePartsMaterials> lstResult = panoramicSparePartsMaterialsMapper.listSummaryByDate(date);
		return lstResult;
	}

}
