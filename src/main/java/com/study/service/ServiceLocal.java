package com.study.service;

import com.study.mapper.impl.UserMapperImpl;
import com.study.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ServiceLocal {
    @Autowired
    private ServiceRedis serviceRedis;

    public Map<Object,Object> getProvList(){
       return serviceRedis.getHashValue("prov");
    }

    public Map<Object,Object> getCityList(String prov){

        return serviceRedis.getHashValue(prov.substring(0,2)+"_city");
    }

    public Map<Object,Object> getAreaList(String city){
        return serviceRedis.getHashValue(city.substring(0,4)+"_area");
    }


}
