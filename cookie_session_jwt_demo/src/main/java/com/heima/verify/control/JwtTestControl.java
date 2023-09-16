package com.heima.verify.control;

import com.heima.verify.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTestControl
 * @Description
 * @Author LXY
 * @Date 2023/9/16 11:51
 **/
@RestController
@Slf4j
public class JwtTestControl {

    @GetMapping("/login")
    public String login(String username,String password){

        if("tom".equals(username) && "123".equals(password)){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username","tom");
            claims.put("password","123");

            String jwt = JwtUtils.generateJwt(claims);
            return "jwt令牌:"+jwt;
        }

        return "无jwt令牌";
    }

}
