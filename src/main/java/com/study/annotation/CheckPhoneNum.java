package com.study.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPhoneNumValidate.class)
public @interface CheckPhoneNum {

    String message() default "{org.hibernate.validator.constraints.Length.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };

}
