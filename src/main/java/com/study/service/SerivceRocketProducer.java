package com.study.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者
 * @author pengwei.tan
 * 2019-03-23
 */
@Service
public class SerivceRocketProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * @param destination
     * @param message
     */
    public void sendMessage(String destination ,final Object message){
        SendResult sendResult = rocketMQTemplate.syncSend(destination,message);
    }

}
