package com.itmuch.cloud.microserviceprovideruser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisConfigService {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     *
     * redisTemplate.opsForValue();　　//操作字符串
     * redisTemplate.opsForHash();　　 //操作hash
     * redisTemplate.opsForList();　　 //操作list
     * redisTemplate.opsForSet();　　  //操作set
     * redisTemplate.opsForZSet();　 　//操作有序set
     *
     stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间

     stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作

     stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val

     stringRedisTemplate.boundValueOps("test").increment(1);//val +1

     stringRedisTemplate.getExpire("test")//根据key获取过期时间

     stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位

     stringRedisTemplate.delete("test");//根据key删除缓存

     stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值

     stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合

     stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间

     stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据

     stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合
     * */

    /**
     * 设置key-value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }


    public void set(String key, String value, long timeOut) {
        redisTemplate.opsForValue().set(key, value, timeOut * 1000L, TimeUnit.MILLISECONDS);
    }


    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setTimeOut(String key, long timeOut) {
        redisTemplate.expire(key, timeOut * 1000L, TimeUnit.MILLISECONDS);
    }

    public boolean hashKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public Long getKeyTimeOut(String key){
        return redisTemplate.getExpire(key);
    }

}
