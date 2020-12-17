package cn.yangwanhao.sdk.common.utils;

import org.springframework.context.ApplicationContext;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * 手动加载spring容器的工具类
 *
 * @author 杨万浩
 * @date 2019/10/14 10:37
 * @version 1.0.0
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringContextUtils {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static Object getBean(Class<?> requiredType){
        return applicationContext.getBean(requiredType);
    }

}
