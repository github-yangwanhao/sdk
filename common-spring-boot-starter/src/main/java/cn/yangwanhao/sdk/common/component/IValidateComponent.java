package cn.yangwanhao.sdk.common.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.util.CollectionUtils;

/**
 * 验证类组件
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/30 11:30
 */
public interface IValidateComponent {

    /**
     * 验证一个对象中所有字段,返回第一个错误信息
     * @param t 被验证的对象
     * @return 第一个错误信息
     */
    public <T> String validate(T t);

    /**
     * 验证一个对象中所有字段,返回第一个错误信息
     * @param t 被验证的对象
     * @param groups 分组对象
     * @return 第一个错误信息
     */
    public <T> String validate(T t, Class<?> groups);

    /**
     * 验证一个对象中所有字段,返回所有错误信息
     * @param t 被验证的对象
     * @return 所有的错误信息
     */
    public <T> List<String> validateAll(T t);

    /**
     * 验证一个对象中所有字段,返回所有错误信息
     * @param t 被验证的对象
     * @param groups 分组对象
     * @return 所有的错误信息
     */
    public <T> List<String> validateAll(T t, Class<?> groups);

}
