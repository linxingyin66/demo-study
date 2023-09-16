package com.heima.verify.controller;

import com.heima.verify.common.Result;
import com.heima.verify.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginWithFilterTest
 * @Description
 * @Author LXY
 * @Date 2023/9/16 12:35
 **/
@RestController
@Slf4j
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

    @PostMapping("/login")
    public Result login(){
        log.info("登陆成功！");
        Map<String, Object> map = new HashMap<>();
        map.put("name","tom");
        String jwt = JwtUtils.generateJwt(map);
        return Result.success(jwt);
    }

    @PostMapping("/test")
    public Result loginTest(){
        return Result.success("执行了操作");
    }

}
