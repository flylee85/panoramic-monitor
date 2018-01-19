package com.cloud.filter.pre;

import com.netflix.zuul.http.HttpServletRequestWrapper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author summer 流量转发
 */
class RewriteURIRequestWrapper extends HttpServletRequestWrapper {

    private String rewriteURI;

    public RewriteURIRequestWrapper(HttpServletRequest request, String rewriteURI) {
        super(request);
        this.rewriteURI = rewriteURI;
    }

    @Override
    public String getRequestURI() {
        return rewriteURI;
    }

}