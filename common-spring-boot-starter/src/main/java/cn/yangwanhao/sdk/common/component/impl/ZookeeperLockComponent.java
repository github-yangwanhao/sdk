package cn.yangwanhao.sdk.common.component.impl;

import org.springframework.stereotype.Component;

import cn.yangwanhao.base.common.support.ResponseMessage;
import cn.yangwanhao.sdk.common.component.ILockComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/31 20:49
 */
@Component
@Slf4j
public class ZookeeperLockComponent implements ILockComponent {
    @Override
    public ResponseMessage<Boolean> tryLock(String key, Long time) {
        log.info("zookeeper lock");
        return ResponseMessage.success();
    }

    @Override
    public ResponseMessage<Boolean> unlock(String key) {
        log.info("zookeeper unlock");
        return ResponseMessage.success();
    }
}
