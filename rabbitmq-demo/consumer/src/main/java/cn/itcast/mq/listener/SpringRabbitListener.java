package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

/**
 * @ClassName SpringRabbitListener
 * @Description
 * @Author LXY
 * @Date 2023/10/22 7:52
 **/
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple666.queue")
    public void listenSimpleQueue(String msg){
        System.out.println("接收到消息:" + msg);
    }

    @RabbitListener(queues = "simple666.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1接收到消息:" + msg + "___" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple666.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2接收到消息:" + msg + "___" + LocalTime.now());
        Thread.sleep(200);
    }

    @RabbitListener(queues = "testfanout.queue1")
    public void listenFanoutQueue1(String msg){
        System.out.println("消费者1接收到消息:" + msg);
    }

    @RabbitListener(queues = "testfanout.queue2")
    public void listenFanoutQueue2(String msg){
        System.out.println("消费者2接收到消息:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "testdirect.queue1"),
            exchange = @Exchange(name = "testdirect.exchange",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("消费者1接收到消息:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "testdirect.queue2"),
            exchange = @Exchange(name = "testdirect.exchange",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("消费者2接收到消息:" + msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "testtopic.queue1"),
            exchange = @Exchange(name = "testtopic.exchange",type = ExchangeTypes.TOPIC),
            key = {"chain.#"}
    ))
    public void listenTopicQueue1(String msg){
        System.out.println("消费者1接收到消息:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "testtopic.queue2"),
            exchange = @Exchange(name = "testtopic.exchange",type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void listenTopicQueue2(String msg){
        System.out.println("消费者2接收到消息:" + msg);
    }

    @RabbitListener(queues = "testobject.queue")
    public void listenObjectQueue1(Map<String,Object> msg){
        System.out.println("接收到消息:" + msg);
    }


}
