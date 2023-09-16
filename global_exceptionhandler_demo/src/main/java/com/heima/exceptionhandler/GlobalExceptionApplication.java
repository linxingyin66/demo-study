package com.heima.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@Slf4j
public class GlobalExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalExceptionApplication.class, args);
		log.info("启动成功！");
	}

}
