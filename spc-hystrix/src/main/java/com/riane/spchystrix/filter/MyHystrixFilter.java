package com.riane.spchystrix.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 要使用注解式的Hystrix缓存和合并请求的注解，必须首先初始化HystrixRequestContext，
 * 即首先初始化请求的上下文，用于创建和销毁Hystrix请求上下文。
 */
@WebFilter(urlPatterns = "/*", filterName = "hystrixFilter")
public class MyHystrixFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HystrixRequestContext requestContext = HystrixRequestContext.initializeContext();
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            requestContext.shutdown();
        }
    }

    @Override
    public void destroy() {

    }
}
