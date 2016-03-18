package com.provence.common.web.context;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * Created by chengpanwang on 7/17/15.
 */
public class RequestContextFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestContextFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("request context filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long start = System.currentTimeMillis();
        RequestContext.init((HttpServletRequest) request, (HttpServletResponse) response, null);

        logger.info("request start| seq:{}, uri:{}, query string:{}, cookie:{} ",
                    RequestContext.getSeq(), ((HttpServletRequest) request).getRequestURI(),
                                       ((HttpServletRequest) request).getQueryString(),
                                       JSON.toJSONString(((HttpServletRequest) request).getCookies()));
        chain.doFilter(request, response);

        logger.info("request end| seq:{}, response:{}, spend time:{}",
                    RequestContext.getSeq(), response.getContentType(), (System.currentTimeMillis() - start));

        RequestContext.clear();

    }

    @Override
    public void destroy() {
        logger.info("request context filter destroy");
    }
}
