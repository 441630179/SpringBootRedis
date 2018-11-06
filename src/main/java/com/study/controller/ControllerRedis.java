package com.study.controller;

import com.study.service.ServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRedis {
    @Autowired
    private ServiceRedis serviceRedis;

    @RequestMapping("/setValue")
    public String SetValue(String key,String value){
        System.out.println("key="+key+"value="+value);
        serviceRedis.opsValue(key,value);
        return "set success";
    }

    @RequestMapping("/delete")
    public String Delete(String key){
        serviceRedis.opsDel(key);
        return "Delete Success";
    }

    @RequestMapping("get")
    public String getKey(String key){
        System.out.printf("value="+serviceRedis.getKey(key));
        return serviceRedis.getKey(key);
    }
}
