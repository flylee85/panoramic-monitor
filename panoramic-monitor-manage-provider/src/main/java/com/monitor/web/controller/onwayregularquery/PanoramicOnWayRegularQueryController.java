/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.web.controller.onwayregularquery;



import com.monitor.api.realtimeconsumption.PanoramicRealTimeConsumptionService;
import com.monitor.dto.realtimeconsumption.PanoramicRealTimeConsumptionDto;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import com.monitor.web.controller.base.AbstractAnnotationController;

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
@RequestMapping("/onway/regular/query")
public class PanoramicOnWayRegularQueryController extends AbstractAnnotationController {
	
}