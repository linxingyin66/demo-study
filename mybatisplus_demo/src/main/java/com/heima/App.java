package com.heima;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName App
 * @Description
 * @Author LXY
 * @Date 2023/11/2 21:27
 **/
@SpringBootApplication
@Slf4j
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        log.info("启动成功!");
    }
}
