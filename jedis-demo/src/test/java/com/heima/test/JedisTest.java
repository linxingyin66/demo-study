package com.heima.test;

import com.heima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author lxy
 * @create 2024-01-25 12:04
 */
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 1.建立连接
//         jedis = new Jedis("192.168.11.100", 6379);
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
        jedis.auth("123456");
        // 3.选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        // 存入数据
        String result = jedis.set("user1", "鲁班");
        System.out.println("result = " + result);
        // 获取数据
        String user1 = jedis.get("user1");
        System.out.println("user1 = " + user1);
    }

    @Test
    void testHash() {
        // 插入hash数据
        jedis.hset("user:1", "name", "Jack");
        jedis.hset("user:1", "age", "21");

        // 获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
