package com.invoke.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.cloud.util.HttpResult;
import com.cloud.util.JsonUtils;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.google.common.collect.Maps;
import com.invoke.api.api.ApiConfigure;
import com.invoke.util.SignUtil;
import com.invoke.web.controller.api.GateWayController;
import com.invoke.web.util.WebUtils;

/**
 * 
 * @author summer 签名验签过滤器
 *
 */
public class GateWayAuthenticationFilter extends GenericFilterBean {
	protected static final transient TLogger dbLogger = LoggerUtils.getLogger(GateWayController.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Map<String, String> params = Maps.newHashMap();
		params = (Map<String, String>) request.getAttribute("params");
		String sign = params.get("sign") + "";
		String mehtod = params.get("method") + "";
		// 移除sign再进行验签，原始数据验签
		params.remove("sign");
		String content = WebUtils.joinParams(params, true);
		Boolean checkRsaSign = SignUtil.checkRsaSign(content, sign, ApiConfigure.PUBLICKEY, ApiConfigure.CHARSET);
		if (!checkRsaSign) {
			dbLogger.error("验证签名失败:" + JsonUtils.writeMapToJson(params));
			return;
		}
		chain.doFilter(request, response);

	}

}
