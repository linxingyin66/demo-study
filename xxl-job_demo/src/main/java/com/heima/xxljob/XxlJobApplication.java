package com.heima.xxljob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName XxlJobApplication
 * @Description
 * @Author LXY
 * @Date 2023/10/24 14:24
 **/

@SpringBootApplication
@Slf4j
public class XxlJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxlJobApplication.class,args);
        log.info("启动成功");
    }

}
