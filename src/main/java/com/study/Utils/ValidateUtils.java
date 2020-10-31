package com.study.Utils;

import com.study.exception.BizException;
import org.apache.commons.collections.CollectionUtils;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

public class ValidateUtils {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static<T> void validateEntity(T t){
        Set<ConstraintViolation<T>> set=  validator.validate(t, Default.class);
        if(CollectionUtils.isNotEmpty(set)){
            for (ConstraintViolation<T> cv : set) {
                throw new BizException("000093",cv.getMessage());
            }

        }

    }
}
