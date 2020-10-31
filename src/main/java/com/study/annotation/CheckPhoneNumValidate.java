package com.study.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CheckPhoneNumValidate implements ConstraintValidator<CheckPhoneNum,String> {
    public static final String REGX ="^1[0-9]{10}$";
    @Override
    public boolean isValid(String phoneNum, ConstraintValidatorContext constraintValidatorContext) {

        return  Pattern.matches(REGX,phoneNum);
    }
}
