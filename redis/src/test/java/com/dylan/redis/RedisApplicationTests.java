package com.dylan.redis;

import com.dylan.redis.entity.UserVO;
import com.dylan.redis.support.RedisSupport;
import com.dylan.redis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisSupport redisSupport;
    @Autowired
    ValueOperations<String, Object> valueOperations;
    @Autowired
    HashOperations<String, String, Object> hashOperations;
    @Autowired
    ListOperations<String, Object> listOperations;
    @Autowired
    SetOperations<String, Object> setOperations;
    @Autowired
    ZSetOperations<String, Object> zSetOperations;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedisTemplate(){
        ValueOperations<String, Object> s = redisTemplate.opsForValue();
        String key = RedisUtil.getKeyNameWithColumn("t_user", "kid", "10", "rank");
        s.set(key, 10);
        System.out.println(s.get(key));
    }

    @Test
    void testRedisSupport(){
        redisSupport.deleteKey(RedisUtil.getKeyNameWithColumn("t_user", "kid", "10", "rank"));
    }

    @Test
    void testValueOperations(){
        valueOperations.set("user:id:1", new UserVO("1", "dylan", 18));
        System.out.println(valueOperations.get("user:id:1"));

        valueOperations.set("user:id:1", new UserVO("1", "dylan", 18),
                40, TimeUnit.SECONDS);
    }

    @Test
    void testHashOperations(){
        UserVO dylan = new UserVO("1", "dylan", 18);
        hashOperations.put("friend", "friend:id:1", dylan);
        System.out.println(hashOperations.get("friend", "friend:id:1"));
    }

    @Test
    void testListOperations(){
        UserVO dylan = new UserVO("1", "dylan", 18);
        listOperations.leftPush("list_test", dylan);
        System.out.println(listOperations.rightPop("list_test"));
    }

    @Test
    void testSetOperations(){

        UserVO dylan = UserVO.builder()
                .id("1")
                .name("dylan")
                .age(18)
                .build();

        setOperations.add("set_test", dylan);
        System.out.println(setOperations.isMember("set_test", dylan));
    }

    @Test
    void testZSetOperations(){
        zSetOperations.add("zset_test", "dylan", 99);
        zSetOperations.add("zset_test", "lilu", 60);
        zSetOperations.add("zset_test", "tom", 49);
        System.out.println(zSetOperations.range("zset_test", 0, -1));
    }


}
