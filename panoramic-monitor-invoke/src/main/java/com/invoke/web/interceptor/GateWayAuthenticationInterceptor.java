package com.invoke.web.interceptor;

import com.cloud.util.JsonUtils;
import com.cloud.util.LoggerUtils;
import com.cloud.util.StringUtil;
import com.cloud.util.TLogger;
import com.google.common.collect.Maps;
import com.invoke.api.api.ApiConfigure;
import com.invoke.util.SignUtil;
import com.invoke.web.util.BaseWebUtils;
import com.invoke.web.util.WebUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

/**
 * @author summer 签名验签拦截器
 */
public class GateWayAuthenticationInterceptor implements HandlerInterceptor {
	protected static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(GateWayAuthenticationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		Map<String, String> params = null;
		if (ApiConfigure.GATEWAY_CALL_BACK.equals(req.getServletPath())) {
			return true;
		}
		if (WebUtils.HTTP_REQUEST_METHOD.equalsIgnoreCase(req.getMethod())) {
			DB_LOGGER.error("验证签名失败:" + JsonUtils.writeMapToJson(params));
			res.sendRedirect(BaseWebUtils.getRequestNamePortPath(req) + ApiConfigure.GATEWAY_CALL_BACK);
			return false;
		} else {
			// post封装请求你参数
			params = WebUtils.getRequestMap(req);
		}
		if (null == params) {
			params = Maps.newHashMap();
		}
		//验签通过生成token，用于内部请求转发使用，一次失效
		if (StringUtils.isNotBlank(params.get(WebUtils.HTTP_REQUEST_TOKEN))) {
			String token = params.get(WebUtils.HTTP_REQUEST_TOKEN);
			String sessionToken = (String) req.getSession().getAttribute(WebUtils.HTTP_REQUEST_TOKEN);
			if (StringUtils.equalsIgnoreCase(token, sessionToken)) {
				req.getSession().invalidate();
				return true;
			}
		}

		String sign = params.get("sign") + "";
		String mehtod = params.get("method") + "";
		// 移除sign再进行验签，原始数据验签
		params.remove("sign");
		String content = WebUtils.joinParams(params, true);
		Boolean checkRsaSign = SignUtil.checkRsaSign(content, sign, ApiConfigure.PUBLICKEY, ApiConfigure.CHARSET);
		if (!checkRsaSign) {
			DB_LOGGER.error("验证签名失败:" + JsonUtils.writeMapToJson(params));
			res.sendRedirect(BaseWebUtils.getRequestNamePortPath(req) + ApiConfigure.GATEWAY_CALL_BACK);
			return false;
		}
		String token = UUID.randomUUID().toString();
		req.setAttribute(WebUtils.HTTP_REQUEST_TOKEN, token);
		//后期采用redis优化
		req.getSession().setAttribute(WebUtils.HTTP_REQUEST_TOKEN, token);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
