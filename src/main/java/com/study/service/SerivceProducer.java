package com.study.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者
 * @author pengwei.tan
 * 2019-03-23
 */
@Service
public class SerivceProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * @param destination
     * @param message
     */
    public void sendMessage(String destination ,final String message){
        jmsTemplate.convertAndSend(new ActiveMQQueue(destination),message);
    }
}
