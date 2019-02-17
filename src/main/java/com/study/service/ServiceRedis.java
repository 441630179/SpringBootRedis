package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ServiceRedis {

    @Autowired
    protected StringRedisTemplate template;
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

    /**
     * Map中的所有值存入Hash 操作
     * @param hash
     * @param map
     */
    public void opsHashPutAll(String hash,Map map){
        template.opsForHash().putAll(hash,map);
    }

    /**
     * 在已有的Hash值中新增key-value
     * @param hash
     * @param key
     * @param value
     */
    public void opsHashPut(String hash,String key,String value){
        template.opsForHash().put(hash,key,value);
    }

    /**
     * Set 批量操作
     * @param key
     * @param value
     */
    public void opsForSetAll(String key,String... value){
        template.opsForSet().add(key, value);
    }



    /**
     * List 右边最佳批量操作
     * @param key
     * @param value
     */
    public void opsForListAll(String key,String... value){
        template.opsForList().rightPushAll(key, value);
    }

    /**
     * List 右边单个操作
     * @param key
     * @param value
     */
    public void opsForList(String key,String value){
        template.opsForList().rightPush(key, value);
    }
}
