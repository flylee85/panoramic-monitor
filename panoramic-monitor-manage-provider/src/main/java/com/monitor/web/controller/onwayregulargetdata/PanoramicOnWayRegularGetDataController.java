/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.web.controller.onwayregulargetdata;



import com.cloud.api.vo.ResultCode;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.monitor.api.onwayregulargetdata.PanoramicOnWayRegularGetDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
*@author summer
* 2017/11/21.
*/
@Api
@RestController
@RequestMapping("/onway/regular/get/data")
public class PanoramicOnWayRegularGetDataController {

	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicOnWayRegularGetDataController.class);
    @Autowired
    @Qualifier("onWayRegularGetDataService")
    private PanoramicOnWayRegularGetDataService onWayRegularGetDataService;
	
    @ApiOperation(value = "对接G7天眼系统同步数据", notes = "对接G7天眼系统同步数据")
    @PostMapping("/task")
    public ResultCode<Void> task() {
    	DB_LOGGER.warn("<--对接G7天眼系统同步数据  开始-->");
    	DB_LOGGER.warn("<--获取新增订单  开始-->");
		onWayRegularGetDataService.getNewOrderData();
    	DB_LOGGER.warn("<--获取新增订单  结束-->");
    	DB_LOGGER.warn("<--更新现有订单  开始-->");
		onWayRegularGetDataService.updateOrderData();
    	DB_LOGGER.warn("<--更新现有订单  结束-->");
    	DB_LOGGER.warn("<--更新订单天眼节点  开始-->");
		onWayRegularGetDataService.getOrderNodes();
    	DB_LOGGER.warn("<--更新订单天眼节点  结束-->");
    	DB_LOGGER.warn("<--更新设备  开始-->");
		onWayRegularGetDataService.addDeviceData();
    	DB_LOGGER.warn("<--更新设备  结束-->");
        DB_LOGGER.warn("<--对接G7天眼系统同步数据  结束-->");
        return ResultCode.SUCCESS;
    }
}