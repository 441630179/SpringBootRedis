package com.study.service;

import com.study.mapper.impl.LocalMapperImpl;
import com.study.po.Local;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 测试ApplicationRunner 启动加载参数
 */
@Service
public class StaticInitService implements ApplicationRunner {
    @Autowired
    private ServiceRedis serviceRedis;

    @Autowired
    private LocalMapperImpl localMapperImpl;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Map<String,String> provMap = new HashMap<>();
//
//        Map<String,String> cityMap = new HashMap<>();
//
//        Map<String,String> areaMap = new HashMap<>();
//
//        Set<String> setProv = new HashSet();
//
//        Set<String> setCity = new HashSet();
//        //缓存所有省
//        List<Local> listProv = localMapperImpl.queryProv();
//        for (Local local : listProv) {
//            provMap.put(local.getLocalId(),local.getProvName());
//            setProv.add(local.getLocalId().substring(0,2));
//
//        }
//        serviceRedis.opsHashPutAll("prov",provMap);
//
//        for (String provId : setProv) {
//            List<Local> listCity = localMapperImpl.queryCity(provId);
//            for (Local localCity : listCity) {
//                if(StringUtils.equalsAny(provId,"11","12","31","50")){
//                    setCity.add(localCity.getLocalId().substring(0,2));
//                }else{
//                    setCity.add(localCity.getLocalId().substring(0,4));
//                }
//
//
//                cityMap.put(localCity.getLocalId(),localCity.getCityName());
//            }
//            serviceRedis.opsHashPutAll(provId+"_city",cityMap);
//            cityMap.clear();
//
//        }
//
//        for (String cityId : setCity) {
//            List<Local> listArea = localMapperImpl.queryArea(cityId);
//
//            for (Local localArea : listArea) {
//                areaMap.put(localArea.getLocalId(),localArea.getAreaName());
//            }
//            serviceRedis.opsHashPutAll(StringUtils.rightPad(cityId,4,"0")+"_area",areaMap);
//            areaMap.clear();
//        }
//
    }
}
