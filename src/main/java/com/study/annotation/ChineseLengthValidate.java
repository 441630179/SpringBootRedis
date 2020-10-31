package com.study.annotation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;

public class ChineseLengthValidate implements ConstraintValidator<ChineseLength, String> {
    private int min = 0;
    private int max = 0;
    private String charset = "GBK";

    @Override
    public void initialize(ChineseLength constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        try {
            int length = value.getBytes(charset).length;
            if (min > length || max < length) {
                return false;
            }
        } catch (UnsupportedEncodingException e) {
           return true;
        }
        return true;
    }
}
