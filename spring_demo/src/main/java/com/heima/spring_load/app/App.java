package com.heima.spring_load.app;

import com.heima.spring_load.config.SpringConfig3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName App
 * @Description
 * @Author LXY
 * @Date 2023/10/31 18:25
 **/
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig3.class);
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(ioc.getBean("dog"));
        System.out.println("=======================");
        SpringConfig3 springConfig3 = ioc.getBean("springConfig3", SpringConfig3.class);
        System.out.println(springConfig3.dog());
        System.out.println(springConfig3.dog());
        System.out.println(springConfig3.dog());
    }
}
