package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.request.ActiveMqRequest;
import com.study.service.SerivceProducer;
import com.study.service.ServiceConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengwei.tan
 * @date 2019-01-27
 */
@Controller
public class ControllerActiveMQ {
    private static final Logger logger = LoggerFactory.getLogger(ControllerActiveMQ.class);
    @Autowired
    private SerivceProducer serivceProducer;

    @Autowired
    private ServiceConsumer serviceConsumer;

    @RequestMapping("/activeMQ/send")
    public String activeMQSend(Model model, ActiveMqRequest request) {
        logger.info("请求参数：{}", JSONObject.toJSONString(request));
        serivceProducer.sendMessage(request.getDestination(),request.getMessage());
        return "success";
    }

    @RequestMapping("/activeMQ/recive")
    public String activeMQRecive(Model model, ActiveMqRequest request) {
        logger.info("请求参数：{}", JSONObject.toJSONString(request));
        String message = serviceConsumer.recive(request.getDestination());
        model.addAttribute("message",message);
        return "activeMq/activeMqShow";
    }

    @RequestMapping("/activeMQ/sendHtml")
    public String sendHtml(Model model) {

        return "activeMq/activeMqSend";
    }

    @RequestMapping("/activeMQ/reciveHtml")
    public String reciveHtml(Model model) {

        return "activeMq/activeMqRecive";
    }

    @RequestMapping("/activeMQ/activeMqIndex")
    public String activeMqIndex(Model model) {

        return "activeMq/activeMqIndex";
    }

}
