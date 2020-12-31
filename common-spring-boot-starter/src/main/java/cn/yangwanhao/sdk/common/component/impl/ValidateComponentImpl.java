package cn.yangwanhao.sdk.common.component.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import cn.yangwanhao.sdk.common.component.IValidateComponent;

/**
 * 参数验证组件类
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/9 17:59
 */
@Component
public class ValidateComponentImpl implements IValidateComponent {

    @Autowired
    private Validator validator;

    @Override
    public <T> String validate(T t) {
        Set<ConstraintViolation<T>> errorMessage = validator.validate(t);
        if (errorMessage == null || CollectionUtils.isEmpty(errorMessage)) {
            return null;
        }
        return errorMessage.iterator().next().getMessage();
    }

    @Override
    public <T> String validate(T t, Class<?> groups) {
        Set<ConstraintViolation<T>> errorMessage = validator.validate(t, groups);
        if (errorMessage == null || CollectionUtils.isEmpty(errorMessage)) {
            return null;
        }
        return errorMessage.iterator().next().getMessage();
    }

    @Override
    public <T> List<String> validateAll(T t) {
        Set<ConstraintViolation<T>> errorMessage = validator.validate(t);
        if (errorMessage == null || CollectionUtils.isEmpty(errorMessage)) {
            return null;
        }
        List<String> errorList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : errorMessage) {
            errorList.add(constraintViolation.getMessage());
        }
        return errorList;
    }

    @Override
    public <T> List<String> validateAll(T t, Class<?> groups) {
        Set<ConstraintViolation<T>> errorMessage = validator.validate(t, groups);
        if (errorMessage == null || CollectionUtils.isEmpty(errorMessage)) {
            return null;
        }
        List<String> errorList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : errorMessage) {
            errorList.add(constraintViolation.getMessage());
        }
        return errorList;
    }
}
