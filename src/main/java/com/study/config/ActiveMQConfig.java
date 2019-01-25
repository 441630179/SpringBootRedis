package com.study.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;
import javax.jms.Topic;

@Configurable
public class ActiveMQConfig {

    private String queneName;

    private String topicName;

    private String userName;

    private String passWord;

    private String brokeUrl;


    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queneName);
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }



}
