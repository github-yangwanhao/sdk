package cn.yangwanhao.sdk.common.component.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import cn.yangwanhao.base.common.support.ResponseMessage;
import cn.yangwanhao.sdk.common.component.ILockComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * 锁 组件类
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/16 11:47
 */
@Component
@Slf4j
@Primary
public class RedisLockComponentImpl implements ILockComponent {

    private static final String VALUE = "lock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseMessage<Boolean> tryLock(String key, Long time) {
        log.info("redis加锁:{}", key);
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(key, VALUE, time, TimeUnit.SECONDS);
        if (result != null && result) {
            log.info("redis加锁成功,key{},超时时间{}秒", key, time);
        } else {
            log.error("redis加锁失败,key{}", key);
        }
        return ResponseMessage.handleResult(result);
    }

    @Override
    public ResponseMessage<Boolean> unlock(String key) {
        log.info("redis释放锁:{}", key);
        Boolean result = stringRedisTemplate.delete(key);
        if (result != null && result) {
            log.info("redis释放锁成功,key{}", key);
        } else {
            log.error("redis释放锁失败,key{}", key);
        }
        return ResponseMessage.handleResult(result);
    }
}
