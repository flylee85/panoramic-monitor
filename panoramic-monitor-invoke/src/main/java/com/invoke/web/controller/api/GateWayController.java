package com.invoke.web.controller.api;

import com.cloud.util.*;
import com.google.common.collect.Maps;
import com.invoke.api.api.ApiConfigure;
import com.invoke.util.SignUtil;
import com.invoke.web.util.BaseWebUtils;
import com.invoke.web.util.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author summer api对外接口网关
 */
@Api
@RestController
@RequestMapping("/gateway")
public class GateWayController {
	protected static final transient TLogger dbLogger = LoggerUtils.getLogger(GateWayController.class);

	@ApiOperation(value = "接口 请求网关（只能POST）", notes = "请求网关授权验证，POST方式请求，统一的请求网关")
	@PostMapping
	public HttpResult getApiAuth(@RequestParam Map<String, String> params, HttpServletRequest req) {
		String sign = params.get("sign") + "";
		String[] methods = null;
		if (null == params.get("method")||params.get("method").split(" ").length<=1) {
			return HttpResult.getFailure("请求参数异常", 400);
		}
		methods = params.get("method").split(" ");
		String biz = params.get("biz_content");
		Map<String, String> bizMap2 = JsonUtils.readJsonToMap(biz);
		bizMap2.put(WebUtils.HTTP_REQUEST_TOKEN, (String)WebUtils.getSession(req).getAttribute(WebUtils.HTTP_REQUEST_TOKEN));
		HttpResult biz_content = null;
		// method 包含的方法必须是小写
		if (methods[0].equalsIgnoreCase(WebUtils.HTTP_REQUEST_METHOD)) {
			biz_content = HttpUtils.getUrlAsString(methods[1], bizMap2);
		} else {
			biz_content = HttpUtils.postUrlAsString(methods[1], bizMap2);
		}
		return biz_content;
	}

	@ApiOperation(value = "GET 请求网关失败回调", notes = "GET 请求网关授权验证失败回调")
	@RequestMapping("/apiAuthFailure")
	public HttpResult getApiAuthFailure(@RequestParam Map<String, String> params) {
		return HttpResult.getFailure("签名验证失败", 401, JsonUtils.writeMapToJson(params));
	}

	@ApiOperation(value = "GET 请求网关test", notes = "GET 请求网关授权验证test")
	@GetMapping("/gateway/test")
	public HttpResult testGetApiAuth(HttpServletRequest req) {
		Map<String, String> params = Maps.newHashMap();
		params.put("app_id", ApiConfigure.APPID);
		params.put("method","GET "+ BaseWebUtils.getRequestNamePortPath(req) + ApiConfigure.QUERYURL);
		params.put("charset", ApiConfigure.CHARSET);
		params.put("sign_type", "RSA");
		params.put("timestamp", DateUtil.getCurFullTimestampStr());
		params.put("version", "1.0");
		Map<String, String> bizMap = Maps.newHashMap();
		bizMap.put("id", "1");
		params.put("biz_content", JsonUtils.writeMapToJson(bizMap));
		String sign = SignUtil.getSign(params, ApiConfigure.PRIVATEKEY);
		params.put("sign", sign);
		// 发post请求
		HttpResult postHttpResult = HttpUtils
				.postUrlAsString(BaseWebUtils.getRequestNamePortPath(req) + ApiConfigure.QUERYURL, params);
		HttpResult getHttpResult = HttpUtils.getUrlAsString(BaseWebUtils.getRequestNamePortPath(req)
				+ ApiConfigure.QUERYURL + "?token=" + JsonUtils.writeMapToJson(params));
		return null;
	}
}
