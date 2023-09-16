package com.heima.verify.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTest
 * @Description
 * @Author LXY
 * @Date 2023/9/16 11:31
 **/
public class JwtTest {

    @Test
    public void jwtGenTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","tom");
        String jet = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "heima")
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jet);
    }

    @Test
    public void jwtParseTest(){
        Claims claims = Jwts.parser()
                .setSigningKey("heima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5NDgzOTI5M30.f2C-QgD3VNhpFyznXClirvmMtgK7ScdyMMRNv8fEGxg")
                .getBody();

        System.out.println(claims);

    }
}
