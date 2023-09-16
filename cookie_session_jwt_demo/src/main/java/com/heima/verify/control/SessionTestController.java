package com.heima.verify.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName SessionController
 * @Description
 * @Author LXY
 * @Date 2023/9/16 10:47
 **/
@RestController
@Slf4j
public class SessionTestController {
    /**
     * @Author LXY
     * @Description 第一次请求时，服务器端设置session，session值保存在服务器端，session的id返回给客户端浏览器并保存
     * @Date 2023/9/16
     * @param session
     * @return String
     **/
    @GetMapping("/s1")
    public String session1(HttpSession session){

        session.setAttribute("name","tom");

        return "s1";
    }

    /**
     * @Author LXY
     * @Description 第二次请求时，会携带session的id，通过id可以获取上次请求中的数据
     * @Date 2023/9/16
     * @param request
     * @return String
     **/

    @GetMapping("/s2")
    public String cookie2(HttpServletRequest request){

        HttpSession session = request.getSession();

        Object name = session.getAttribute("name");

        System.out.println(name);

        return "s2";
    }




}
