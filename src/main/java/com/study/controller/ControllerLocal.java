package com.study.controller;

import com.study.common.Constans;
import com.study.service.ServiceLocal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api("ControllerLocal的api")
@Controller
public class ControllerLocal {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLocal.class);
    @Autowired
    private ServiceLocal serviceLocal;

    @ApiOperation(value = "省份列表查询", notes = "省份列表查询", httpMethod = "POST")
    @RequestMapping(value = "/local/provList")
    @ResponseBody
    public Map<String, Object> provList() {
        Map<String, Object> map = new HashMap<>();
        Map<Object, Object> provMap = serviceLocal.getProvList();
        map.put(Constans.RERUN_CODE, "000000");
        map.put("provMap", provMap);
        return map;
    }

    @ApiOperation(value = "城市列表查询", notes = "城市列表查询", httpMethod = "POST")
    @ApiImplicitParams(
        @ApiImplicitParam(name = "provId", value = "省份ID", required = true, defaultValue = "440000")
    )
    @RequestMapping(value = "/local/cityList")
    @ResponseBody
    public Map<String, Object> cityList(String provId) {
        Map<String, Object> map = new HashMap<>();
        Map<Object, Object> cityMap = serviceLocal.getCityList(provId);
        map.put(Constans.RERUN_CODE, "000000");
        map.put("cityMap", cityMap);
        return map;
    }

    @ApiOperation(value = "地区列表查询", notes = "地区列表查询", httpMethod = "POST")
    @ApiImplicitParams(
        @ApiImplicitParam(name = "cityId", value = "城市ID", required = true, defaultValue = "440100")
    )
    @RequestMapping(value = "/local/areaList")
    @ResponseBody
    public Map<String, Object> areaList(String cityId) {
        Map<String, Object> map = new HashMap<>();
        Map<Object, Object> areaMap = serviceLocal.getAreaList(cityId);
        map.put(Constans.RERUN_CODE, "000000");
        map.put("areaMap", areaMap);
        return map;
    }


}
