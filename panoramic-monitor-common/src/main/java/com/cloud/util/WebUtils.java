package com.cloud.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

public abstract class WebUtils extends BaseWebUtils {

    public static void setInviteFromCookie(HttpServletResponse res, String basePath, Long from, String string) {
        // TODO 待定

    }

    public static String getAndSetDefault(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie("citycode", null);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);// 24 hour
        response.addCookie(cookie);
        return null;
    }


    public static String urlDecoder(String str) {
        return urlDecoder(str, "utf-8");
    }

    public static String urlDecoder(String str, String encode) {
        String tmp = "";
        try {
            tmp = URLDecoder.decode(str, encode);
        } catch (Exception e) {
        }
        return tmp;
    }

    public static String getIpAndPort(String ip, HttpServletRequest request) {
        if (StringUtils.isBlank(ip))
            return null;
        String port = request.getHeader("x-client-port");
        if (StringUtils.isBlank(port))
            return ip;
        String result = ip + ":" + port;
        return result;
    }
}
