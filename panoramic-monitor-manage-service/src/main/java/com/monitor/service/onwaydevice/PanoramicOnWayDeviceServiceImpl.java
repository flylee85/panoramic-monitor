/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.service.onwaydevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.onwaydevice.PanoramicOnWayDeviceService;
import com.monitor.mapper.onwaydevice.PanoramicOnWayDeviceMapper;
import com.monitor.model.onwaydevice.PanoramicOnWayDevice;

@Service("onWayDeviceService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicOnWayDeviceServiceImpl extends AbstractService<PanoramicOnWayDevice>
       implements PanoramicOnWayDeviceService {

	   @Autowired
	   @Qualifier("onWayDeviceMapper")
	   private PanoramicOnWayDeviceMapper onWayDeviceMapper;
	
	/**
	 * 获取全部设备
	 * @return
	 */
	@Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<PanoramicOnWayDevice> getDeviceList(){
		 List<PanoramicOnWayDevice> recordList = onWayDeviceMapper.getDeviceList();
		 return (null == recordList || recordList.size() == 0) ? null :recordList;
	}
	
	
	/**
	 * 获取绑定的数据量
	 * @return
	 */
	@Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer getBindCount() {
		Integer bindCount = onWayDeviceMapper.getBindCount();
		return bindCount;
	}
	
	
	/**
	 * 获取所有设备数量
	 * @return
	 */
	@Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer getDeviceCount() {
		Integer bindCount = onWayDeviceMapper.getDeviceCount();
		return bindCount;
	}
	
}