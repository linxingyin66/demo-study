package com.heima.verify.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SessionController
 * @Description
 * @Author LXY
 * @Date 2023/9/16 10:47
 **/
@RestController
@Slf4j
public class CookieTestController {
    /**
     * @Author LXY
     * @Description 第一次请求时，服务器端设置cookie并返回给客户端浏览器，保存在浏览器
     * @Date 2023/9/16
     * @param response
     * @return String
     **/
    @GetMapping("/c1")
    public String cookie1(HttpServletResponse response){

        response.addCookie(new Cookie("name","tom"));

        return "c1";
    }

    /**
     * @Author LXY
     * @Description 第二次请求时，会携带cookie，服务端就可以获取上次请求中的数据
     * @Date 2023/9/16
     * @param request
     * @return String
     **/

    @GetMapping("/c2")
    public String cookie2(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if("name".equals(cookie.getName())){
                String value = cookie.getValue();
                System.out.println(value);
            }
        }

        return "c2";
    }




}
