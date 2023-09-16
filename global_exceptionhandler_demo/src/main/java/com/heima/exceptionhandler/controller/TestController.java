package com.heima.exceptionhandler.controller;

import com.heima.exceptionhandler.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author LXY
 * @Date 2023/9/16 15:39
 **/
@RestController
public class TestController {

    @PostMapping("/ex")
    public Result login(){
        int i = 1/0;
        return Result.success("登陆成功");
    }
}
