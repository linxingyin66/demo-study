package com.heima.verify.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName DemoFilter
 * @Description
 * @Author LXY
 * @Date 2023/9/16 12:38
 **/
//@WebFilter(urlPatterns = "/login1")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()方法执行了...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到请求");
        System.out.println("放行前的操作");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后的操作");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()方法执行了...");
    }
}
