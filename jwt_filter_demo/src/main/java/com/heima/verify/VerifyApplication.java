package com.heima.verify;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@Slf4j
public class VerifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerifyApplication.class, args);
		log.info("启动成功！");
	}

}
