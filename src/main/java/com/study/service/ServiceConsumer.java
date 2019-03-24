package com.study.service;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消费者
 * @author pengwei.tan
 * 2019-03-23
 */
@Service
public class ServiceConsumer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public String recive(String destination){
        String messageStr = null;
        try {
            TextMessage message = (TextMessage)jmsMessagingTemplate.receive(destination);
            messageStr = message.getText();

        } catch (JMSException e) {
            e.printStackTrace();
        }
        return  messageStr;
    }
}
