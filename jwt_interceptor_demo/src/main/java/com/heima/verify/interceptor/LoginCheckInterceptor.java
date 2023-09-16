package com.heima.verify.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.heima.verify.common.Result;
import com.heima.verify.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginCheckInterceptor
 * @Description
 * @Author LXY
 * @Date 2023/9/16 14:44
 **/
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取url，登陆请求则放行，否则拦截进行校验
        String url = request.getRequestURL().toString();
        log.info("当前请求路径:{}",url);
        if(url.contains("/login")){
            log.info("当前请求为登陆，放行");
            return true;
        }
        //2.获取token，没有token则报异常，否则进行token解析并校验
        String token = request.getHeader("token");
        log.info("token:{}",token);
        if(!StringUtils.hasLength(token)){
            log.info("当前token为空");
            Result error = Result.error("not login");
            String err = JSONObject.toJSONString(error);
            response.getWriter().write(err);
            return false;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("解析异常");
            Result error = Result.error("not login");
            String err = JSONObject.toJSONString(error);
            response.getWriter().write(err);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
