package com.heima.verify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginWithFilterTest
 * @Description
 * @Author LXY
 * @Date 2023/9/16 12:35
 **/
@RestController
public class LoginTest {

    @GetMapping("/login1")
    public String login1(){
        System.out.println("当前请求被接收1...");
        return "OK";
    }

    @GetMapping("/login2")
    public String login2(){
        System.out.println("当前请求被接收2...");
        return "OK";
    }

}
