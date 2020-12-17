package cn.yangwanhao.sdk.common.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * 参数验证组件类
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/9 17:59
 */
@Component
public class ValidateComponent {

    @Autowired
    private Validator validator;

    /**
     * 验证一个对象中所有字段,返回第一个错误信息
     * @param t 被验证的对象
     * @return 第一个错误信息
     */
    public <T> String validate(T t) {
        Set<ConstraintViolation<T>> errorMessage = validator.validate(t);
        if (errorMessage == null || CollectionUtils.isEmpty(errorMessage)) {
            return null;
        }
        return errorMessage.iterator().next().getMessage();
    }

    /**
     * 验证一个对象中所有字段,返回所有错误信息
     * @param t 被验证的对象
     * @return 所有的错误信息
     */
    public <T> List<String> validateAll(T t) {
        Set<ConstraintViolation<T>> errorMessage = validator.validate(t);
        if (errorMessage == null || CollectionUtils.isEmpty(errorMessage)) {
            return null;
        }
        List<String> errorList = new ArrayList<>();
        Iterator<ConstraintViolation<T>> iterator = errorMessage.iterator();
        while (iterator.hasNext()) {
            errorList.add(iterator.next().getMessage());
        }
        return errorList;
    }
}
