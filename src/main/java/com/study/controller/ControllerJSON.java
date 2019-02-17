package com.study.controller;

import com.study.po.Bank;
import com.study.service.ServiceJSON;
import com.study.service.ServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("json")
public class ControllerJSON {
    @Autowired
    private ServiceJSON serviceJSON;

    @RequestMapping("/jsonIndex")
    public String jsonIndex(){

        return "json/jsonIndex";
    }

    @RequestMapping("/jsonMapString")
    public String bankJSONArray(Model model){

        Map<String,Object> map = new HashMap<>();

        List<Bank> list1 =  serviceJSON.selectByName("中国银行");

        List<Bank> list2 =  serviceJSON.selectByName("中国工商");

        List<Bank> list3 =  serviceJSON.selectByName("交通银行");

        map.put("list1",list1);
        map.put("list2",list2);
        map.put("list3",list3);

        model.addAttribute("bankMap",map);
        return  "json/showMap";
    }
    @RequestMapping("/jsonMap")
    @ResponseBody
    public Map<String,Object> bankJSONArray(){

        Map<String,Object> map = new HashMap<>();

        List<Bank> list1 =  serviceJSON.selectByName("中国银行");

        List<Bank> list2 =  serviceJSON.selectByName("中国工商");

        List<Bank> list3 =  serviceJSON.selectByName("交通银行");

        map.put("list1",list1);
        map.put("list2",list2);
        map.put("list3",list3);
        return  map;
    }

    @RequestMapping("/jsonListString")
    public String bankListJSON(Model model){
        List<Bank> list =serviceJSON.selectBankAll();
        model.addAttribute("bankList",list);
        return "json/showList";

    }

    @RequestMapping("/jsonList")
    @ResponseBody
    public List<Bank> bankJSON(Model model){

        List<Bank> list =serviceJSON.selectBankAll();

        return list;

    }

    @RequestMapping("/jsonObjectString")
    public String jsonObjectString(Model model){

        Bank bank = serviceJSON.selectBankById(1L);
        model.addAttribute("bank",bank);
        return "json/showObject";

    }

    @RequestMapping("/jsonObject")
    @ResponseBody
    public Bank jsonObject(){

        Bank bank = serviceJSON.selectBankById(1L);

        return bank;

    }
}
