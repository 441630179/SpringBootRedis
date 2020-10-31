package com.study.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @author tanpengwei
 * 学习在配置文件中获取参数
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String id;
    private String name;
    private String age;

}
