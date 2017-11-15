package com.invoke.web.controller.api;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.util.DateUtil;
import com.cloud.util.HttpResult;
import com.cloud.util.HttpUtils;
import com.cloud.util.JsonUtils;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.google.common.collect.Maps;
import com.invoke.api.api.ApiConfigure;
import com.invoke.util.SignUtil;
import com.invoke.web.util.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author summer api对外接口网关
 */
@Api
@RestController
@RequestMapping("/gateway")
public class GateWayController {
	protected static final transient TLogger dbLogger = LoggerUtils.getLogger(GateWayController.class);

	@ApiOperation(value = "GET 请求网关", notes = "GET 请求网关授权验证")
	@PostMapping
	public HttpResult getApiAuth(@RequestParam Map<String, String> params) {
		String sign = params.get("sign") + "";
		String mehtod = params.get("method") + "";
		// 移除sign再进行验签，原始数据验签
		params.remove("sign");
		String content = WebUtils.joinParams(params, true);
		Boolean checkRsaSign = SignUtil.checkRsaSign(content, sign, ApiConfigure.PUBLICKEY, ApiConfigure.CHARSET);
		if (!checkRsaSign) {
			dbLogger.error("验证签名失败:" + JsonUtils.writeMapToJson(params));
			return HttpResult.getFailure("签名验证失败", 401, JsonUtils.writeMapToJson(params));
		}
		String requestUrl = params.get("method") + "";
		String biz = params.get("biz_content");
		Map<String, String> bizMap2 = JsonUtils.readJsonToMap(biz);
		HttpResult biz_content = HttpUtils.getUrlAsString(requestUrl, bizMap2);
		return biz_content;
	}

	@ApiOperation(value = "GET 请求网关test", notes = "GET 请求网关授权验证test")
	@GetMapping("/test")
	public HttpResult testGetApiAuth() {
		Map<String, String> params = Maps.newHashMap();
		params.put("app_id", ApiConfigure.APPID);
		params.put("method", ApiConfigure.QUERYURL);
		params.put("charset", ApiConfigure.CHARSET);
		params.put("sign_type", "RSA");
		params.put("timestamp", DateUtil.format(DateUtil.getMillTimestamp(), "yyyy-MM-dd HH:mm:ss"));
		params.put("version", "1.0");
		Map<String, String> bizMap = Maps.newHashMap();
		bizMap.put("id", "1");
		params.put("biz_content", JsonUtils.writeMapToJson(bizMap));
		String sign = SignUtil.getSign(params, ApiConfigure.PRIVATEKEY);
		params.put("sign", sign);
		HttpResult httpResult = HttpUtils.postUrlAsString(ApiConfigure.GATEWAY, params);
		return httpResult;
	}
}
