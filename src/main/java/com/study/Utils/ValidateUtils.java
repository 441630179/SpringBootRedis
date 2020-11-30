package com.study.Utils;

import com.alibaba.excel.annotation.ExcelProperty;
import com.study.exception.BizException;
import org.apache.commons.collections.CollectionUtils;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.lang.reflect.Field;
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

    public static<T> String  validateExcelValue(T t) throws NoSuchFieldException{
        StringBuilder result = new StringBuilder();
        Set<ConstraintViolation<T>> set=  validator.validate(t, Default.class);
        if(CollectionUtils.isNotEmpty(set)){
            for (ConstraintViolation<T> cv : set) {
               Field field = t.getClass().getDeclaredField(cv.getPropertyPath().toString());
                ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
                result.append(annotation.value()[0]+cv.getMessage()).append(";");
            }

        }
        return result.toString();
    }

    public static<T> void validateProperties(T t,String properties){
        Set<ConstraintViolation<T>> set=  validator.validateProperty(t,properties,Default.class);
        if(CollectionUtils.isNotEmpty(set)){
            for (ConstraintViolation<T> cv : set) {
                throw new BizException("000093",cv.getMessage());
            }

        }

    }
}
