package com.heima.spring_load.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName DogFactoryBean
 * @Description
 * @Author LXY
 * @Date 2023/10/31 18:31
 **/

public class DogFactoryBean implements FactoryBean<Dog> { //FactoryBean 工厂bean  用于造对象
    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
