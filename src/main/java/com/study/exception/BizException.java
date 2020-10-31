package com.study.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tanpengwei
 */
@Getter
@Setter
public class BizException extends RuntimeException {
    private String code;

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }
}
