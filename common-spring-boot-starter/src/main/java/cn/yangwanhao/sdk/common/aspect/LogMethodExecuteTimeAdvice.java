package cn.yangwanhao.sdk.common.aspect;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import cn.yangwanhao.sdk.common.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2021/3/17 19:38
 */
@Slf4j
@Aspect
@Component
public class LogMethodExecuteTimeAdvice {

    @Around("@annotation(logExecutionTime)")
    public Object printMethodExecuteTimes(ProceedingJoinPoint proceedingJoinPoint, LogExecutionTime logExecutionTime) {
        Object object = null;
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            object = proceedingJoinPoint.proceed();
            stopWatch.stop();
            String methodName = StringUtils.isBlank(logExecutionTime.methodName()) ? proceedingJoinPoint.getSignature().toShortString() : logExecutionTime.methodName();
            log.info("接口方法[{}]一共执行了[{}]秒时间。", methodName, stopWatch.getTotalTimeSeconds());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

}
