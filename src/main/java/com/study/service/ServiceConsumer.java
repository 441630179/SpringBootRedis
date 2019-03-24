package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * 消费者
 * @author pengwei.tan
 * 2019-03-23
 */
@Service
public class ServiceConsumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public String recive(String destination){
        String messageStr = null;
        try {
            TextMessage message   =  (TextMessage) jmsTemplate.receive(destination);
            messageStr = message.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  messageStr;
    }
}
