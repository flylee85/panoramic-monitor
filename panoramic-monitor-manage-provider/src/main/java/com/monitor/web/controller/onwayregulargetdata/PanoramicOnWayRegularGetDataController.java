/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.web.controller.onwayregulargetdata;



import com.cloud.api.vo.ResultCode;
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
    @Autowired
    @Qualifier("onWayRegularGetDataService")
    private PanoramicOnWayRegularGetDataService onWayRegularGetDataService;
	@GetMapping("/getNewOrderData")
    public ResultCode<Void> getNewOrderData() {
		onWayRegularGetDataService.getNewOrderData();
		onWayRegularGetDataService.updateOrderData();
		onWayRegularGetDataService.getOrderNodes();
        return ResultCode.SUCCESS;
    }
	
	

	@GetMapping("/addDeviceData")
    public ResultCode<Void> getDeviceData() {
		onWayRegularGetDataService.addDeviceData();
        return ResultCode.SUCCESS;
    }
}