package com.heima.spring_load.config;

import com.heima.spring_load.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description
 * @Author LXY
 * @Date 2023/10/31 18:18
 **/

@Configuration
public class SpringConfig3 {

    @Bean
    public Dog dog(){
        return new Dog();
    }

}
