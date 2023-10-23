package cn.itcast.mq.spring;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @ClassName SpringAmqpTest
 * @Description
 * @Author LXY
 * @Date 2023/10/22 7:36
 **/
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage2SimpleQueue() {
        String queueName = "simple666.queue";
        String message = "rabbitTemplate kkk";
        rabbitTemplate.convertAndSend(queueName,message);
    }

    @Test
    void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName = "simple666.queue";
        String message = "rabbitTemplate XXXXXXXX__";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName,message + i);
            Thread.sleep(20);
        }
    }

    @Test
    void testSendMessage2FanoutExchange() {
        String exchangeName = "testfanout.exchange";
        String message = "Hello fanoutExchange 666";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    @Test
    void testSendMessage2DirectExchange() {
        String exchangeName = "testdirect.exchange";
        String message = "Hello directExchange 123456";
        rabbitTemplate.convertAndSend(exchangeName,"yellow",message);
    }

    @Test
    void testSendMessage2TopicExchange() {
        String exchangeName = "testtopic.exchange";
        String message = "Hello topicExchange ggggg";
        rabbitTemplate.convertAndSend(exchangeName,"chain.weather",message);
    }

    @Test
    void testSendObjectQueue() {
        String queue = "testobject.queue";
        HashMap<String, Object> msg = new HashMap<>();
        msg.put("name","鲁班");
        msg.put("age",18);
        rabbitTemplate.convertAndSend(queue,msg);
    }
}
