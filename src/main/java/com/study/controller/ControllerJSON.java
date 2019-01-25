package com.study.controller;

import com.study.po.BankVo;
import com.study.service.ServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerJSON {
    @Autowired
    private ServiceRedis serviceRedis;

    @RequestMapping("/bankJSONArray")
    @ResponseBody
    public Map<String,Object> bankJSONArray(){
        List<BankVo> list1 = new ArrayList<>();
        List<BankVo> list2 = new ArrayList<>();
        List<BankVo> list3 = new ArrayList<>();

        BankVo bankVo1 = new BankVo();
        BankVo bankVo11 = new BankVo();

        BankVo bankVo2 = new BankVo();
        BankVo bankVo22 = new BankVo();

        BankVo bankVo3 = new BankVo();
        BankVo bankVo33 = new BankVo();

        bankVo1.setBankId("1234");
        bankVo1.setBankName("中国工商银行");
        bankVo11.setBankId("2345");
        bankVo11.setBankName("中国银行");

        bankVo2.setBankId("3456");
        bankVo2.setBankName("交通银行");

        bankVo22.setBankId("4567");
        bankVo22.setBankName("平安银行");


        bankVo3.setBankId("5678");
        bankVo3.setBankName("招商银行");
        bankVo33.setBankId("6789");
        bankVo33.setBankName("花旗银行");

        list1.add(bankVo1);
        list1.add(bankVo11);

        list2.add(bankVo2);
        list2.add(bankVo22);

        list3.add(bankVo3);
        list3.add(bankVo33);

        Map<String,Object> map = new HashMap<>();
        map.put("debit",list1);
        map.put("credit",list2);
        map.put("pub",list3);

        return  map;
    }

    @RequestMapping("/bankJSON")
    @ResponseBody
    public List<BankVo> bankJSON(){
        List<BankVo> list = new ArrayList<>();

        BankVo bankVo1 = new BankVo();
        bankVo1.setBankId("1234");
        bankVo1.setBankName("中国工商银行");

        list.add(bankVo1);
        return list;

    }

    @RequestMapping("/bankVo")
    @ResponseBody
    public BankVo bankVo(){

        BankVo bankVo1 = new BankVo();
        bankVo1.setBankId("1234");
        bankVo1.setBankName("中国工商银行");

        return bankVo1;

    }
}
