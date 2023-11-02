package com.heima.verify.filter;

import com.alibaba.fastjson.JSONObject;
import com.heima.verify.common.Result;
import com.heima.verify.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginCheckFilter
 * @Description
 * @Author LXY
 * @Date 2023/9/16 13:24
 **/
@WebFilter(urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.获取url，登陆请求则放行，否则拦截进行校验
        String url = request.getRequestURL().toString();
        log.info("当前请求路径:{}",url);
        if(url.contains("/login")){
            log.info("当前请求为登陆，放行");
            filterChain.doFilter(request,response);
            return;
        }
        //2.获取token，没有token则报异常，否则进行token解析并校验
        String token = request.getHeader("token");
        log.info("token:{}",token);
        if(!StringUtils.hasLength(token)){
            log.info("当前token为空");
            Result error = Result.error("not login");
            String err = JSONObject.toJSONString(error);
            response.getWriter().write(err);
            return;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("解析异常");
            Result error = Result.error("not login");
            String err = JSONObject.toJSONString(error);
            response.getWriter().write(err);
            return;
        }

        filterChain.doFilter(request,response);

    }

}
