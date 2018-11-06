package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceRedis {

    @Autowired
    protected RedisTemplate<String, Object> template;
    /**
     * redis中保存key-value
     * @param key
     * @param value
     */
    public void opsValue(String key,String value){
        template.opsForValue().set(key,value);
    }

    /**
     * redis删除key
     * @param key
     */
    public void opsDel(String key){
        template.delete(key);
    }

    public String getKey(String key){
        return (String) template.opsForValue().get(key);
    }
}
