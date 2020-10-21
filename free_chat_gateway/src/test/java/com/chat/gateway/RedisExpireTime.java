package com.chat.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: Parent
 * @Package: com.chat.gateway
 * @ClassName: RedisExpireTime
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/7/17 22:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/17 22:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisExpireTime {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void getTime(){
        String key = "user_token:1a197f73-1f2a-469b-8efd-9c72080f94bb";
        String token =  stringRedisTemplate.opsForValue().get(key);
//        boolean b =  redisTemplate.hasKey(key);
////        redisTemplate.opsForValue().set("12345",12355);
//        Integer c = (Integer)redisTemplate.opsForValue().get("12345");
//        String d = (String)redisTemplate.opsForValue().get(key);
        System.out.println(token);
    }
}
