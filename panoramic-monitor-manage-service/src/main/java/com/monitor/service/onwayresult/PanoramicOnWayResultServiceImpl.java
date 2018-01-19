/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.service.onwayresult;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.onwayresult.PanoramicOnWayResultService;
import com.monitor.dto.onwayresult.PanoramicOnWayResultDto;
import com.monitor.mapper.onwayresult.PanoramicOnWayResultMapper;

@Service("onWayResultService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicOnWayResultServiceImpl extends AbstractService<PanoramicOnWayResultDto> implements PanoramicOnWayResultService {
    @Autowired
    @Qualifier("onWayResultMapper")
    private PanoramicOnWayResultMapper onWayResultMapper;
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicOnWayResultDto> getOnWayResult(Integer currentstatus){
    	String strdate = "";
    	 	List<PanoramicOnWayResultDto> recordList = null;
    	if(currentstatus == 2){
    		recordList = onWayResultMapper.getOnWayFinishResult();
    	}else {
    	    recordList = onWayResultMapper.getOnWayResult(currentstatus);
    	}
    	 return (null == recordList || recordList.size() == 0) ? null :recordList;
    }
    

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public Integer getOverDayCount(){
    	Integer OverDayCount  = onWayResultMapper.getOverDayCount();
    	return OverDayCount;
    }

}
