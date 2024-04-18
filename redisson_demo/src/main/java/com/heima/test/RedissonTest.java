package com.heima.test;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RedissonTest
 * @Description
 * @Author LXY
 * @Date 2023/11/6 8:04
 **/
@Component
public class RedissonTest {
    @Resource
    private RedissonClient redissonClient;

    void testRedisson() throws InterruptedException {
        //获取锁(可重入)，指定锁的名称
        RLock lock = redissonClient.getLock("anyLock");
        //尝试获取锁，参数分别是：获取锁的最大等待时间(期间会重试)，锁自动释放时间，时间单位
//        boolean isLock = lock.tryLock(1,10, TimeUnit.SECONDS);
        boolean isLock = lock.tryLock();//默认获取锁失败时，不等待，直接返回，30秒自动释放锁
        //判断获取锁成功
        if(isLock){
            try{
                System.out.println("执行业务");
            }finally{
                //释放锁
                lock.unlock();
            }

        }
    }

}
