package com.dylan.maven.server.redis.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */
@Component
public class RedisSupport {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public static final long DEAULT_EXPIRE = 60 * 60 * 24;

    public static final long NOT_EXPIRE = -1;

    public boolean existsKey(String key){
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void renameKey(String oldKey, String newKey){
        redisTemplate.rename(oldKey, newKey);
    }

    public boolean renameKeyNotExist(String oldKey, String newKey){
        return Boolean.TRUE.equals(redisTemplate.renameIfAbsent(oldKey, newKey));
    }

    public void deleteKey(String key){
        redisTemplate.delete(key);
    }

    public void deleteKey(String... keys){
        Set<String> KSet = Stream.of(keys).collect(Collectors.toSet());
        deleteKey(KSet);
    }

    public void deleteKey(Collection<String> keys){
        redisTemplate.delete(keys);
    }

    public void expireKey(String key, long time, TimeUnit timeUnit){
        redisTemplate.expire(key, time, timeUnit);
    }

    public void expireKeyAt(String key, Date date){
        redisTemplate.expireAt(key, date);
    }

    public long getKeyExpire(String key, TimeUnit timeUnit){
        return redisTemplate.getExpire(key, timeUnit);
    }

    public void persistKey(String key){
        redisTemplate.persist(key);
    }


}
