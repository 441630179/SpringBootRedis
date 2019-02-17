package com.study.controller;

import com.study.service.ServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengwei.tan
 * @date 2019-01-27
 */
@Controller
@RequestMapping("/redis")
public class ControllerRedis {
    @Autowired
    private ServiceRedis serviceRedis;

    @RequestMapping("/redisIndex")
    public String redisIndex(){
        
        return "redis/redisIndex";
    }

    @RequestMapping("/redisString")
    public String redisString(){

        return "redis/redisString";
    }

    @RequestMapping("/redisStringAdd")
    public String redisStringAdd(Model model,HttpServletRequest request){
        String key =request.getParameter("key");
        String value =request.getParameter("value");
        serviceRedis.opsValue(key,value);
        return "redis/redisSuccess";
    }

    @RequestMapping("/redisHash")
    public String redisHash(){

        return "redis/redisHash";
    }

    @RequestMapping("/redisHashAdd")
    public String redisHashAdd(Model model,HttpServletRequest request){
        String hash =request.getParameter("hash");
        String key1 =request.getParameter("key1");
        String value1 =request.getParameter("value1");
        String key2 =request.getParameter("key2");
        String value2 =request.getParameter("value2");
        String key3 =request.getParameter("key1");
        String value3 =request.getParameter("value3");
        Map<String,String> map = new HashMap<>();
        map.put(key1,value1);
        map.put(key2,value2);
        map.put(key3,value3);
        serviceRedis.opsHashPutAll(hash,map);

        model.addAttribute("key",hash);
        return "redis/redisSuccess";
    }


    @RequestMapping("/redisList")
    public String redisList(){

        return "redis/redisList";
    }

    @RequestMapping("/redisListAdd")
    public String redisListAdd(Model model,HttpServletRequest request){
        String key =request.getParameter("key");

        String value1 =request.getParameter("value1");
        String value2 =request.getParameter("value2");
        String value3 =request.getParameter("value3");
        serviceRedis.opsForListAll(key,value1,value2,value3);
        model.addAttribute("key",key);
        return "redis/redisSuccess";
    }

    @RequestMapping("/redisSet")
    public String redisSet(){

        return "redis/redisSet";
    }

    @RequestMapping("/redisSetAdd")
    public String redisSettAdd(Model model,HttpServletRequest request){
        String key =request.getParameter("key");

        String value1 =request.getParameter("value1");
        String value2 =request.getParameter("value2");
        String value3 =request.getParameter("value3");
        String value4 =request.getParameter("value4");
        serviceRedis.opsForSetAll(key,value1,value2,value3,value4);

        model.addAttribute("key",key);
        return "redis/redisSuccess";
    }

}
