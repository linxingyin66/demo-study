package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FanoutConfig
 * @Description
 * @Author LXY
 * @Date 2023/10/22 8:41
 **/
@Configuration
public class FanoutConfig {
    //交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("testfanout.exchange");
    }
    //队列
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("testfanout.queue1");
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("testfanout.queue2");
    }
    //将队列绑定到交换机
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("testobject.queue");
    }
}
