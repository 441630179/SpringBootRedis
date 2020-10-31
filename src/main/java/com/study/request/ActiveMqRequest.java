package com.study.request;

import lombok.Data;

@Data
public class ActiveMqRequest {
    private String destination;
    private String message;


}
