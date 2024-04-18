package com.heima;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName RedissonApplication
 * @Description
 * @Author LXY
 * @Date 2023/11/6 7:46
 **/
@SpringBootApplication
@Slf4j
public class RedissonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedissonApplication.class,args);
        log.info("启动成功");
    }
}
