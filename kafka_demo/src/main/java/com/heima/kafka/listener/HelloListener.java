package com.heima.kafka.listener;

import cn.hutool.core.util.StrUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class HelloListener {

    @KafkaListener(topics = "itcast-topic")
    public void onMessage(String message){
        if(!StrUtil.isEmpty(message)){
//            User user = JSON.parseObject(message, User.class);
//            System.out.println(user);
            System.out.println(message);
        }

    }
}
