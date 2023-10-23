package com.heima.restful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName RestApplication
 * @Description
 * @Author LXY
 * @Date 2023/10/22 13:59
 **/
@Slf4j
@SpringBootApplication
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class,args);
        log.info("启动成功！");
    }
}
