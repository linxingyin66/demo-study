package com.heima.redis.test;

import cn.hutool.json.JSONUtil;
import com.heima.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class RedisStringTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        // 写入一条String数据
        stringRedisTemplate.opsForValue().set("verify:phone:13600527634", "124143");
        // 获取string数据
        Object name = stringRedisTemplate.opsForValue().get("verify:phone:13600527634");
        System.out.println("verify:phone:13600527634 = " + name);
    }

    @Test
    void testSaveUser() {
        // 创建对象
        User user = new User("虎哥", 22);
        // 手动序列化
        String json = JSONUtil.toJsonStr(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user:201", json);
        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:201");
        // 手动反序列化
        User user1 = JSONUtil.toBean(jsonUser, User.class);
        System.out.println("user1 = " + user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:400", "name", "虎哥");
        stringRedisTemplate.opsForHash().put("user:400", "age", "21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entries = " + entries);
    }

    @Test
    void name() {
    }
}
