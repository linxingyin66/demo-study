package com.heima.spring_load.config;

import com.heima.spring_load.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName SpringConfig
 * @Description
 * @Author LXY
 * @Date 2023/10/31 18:18
 **/
//配置类(起扫描作用)
@ComponentScan({"com.heima.spring_load.bean,com.heima.spring.config"})
public class SpringConfig {

    @Bean
    public DogFactoryBean dog(){
        return new DogFactoryBean();
    }

}
