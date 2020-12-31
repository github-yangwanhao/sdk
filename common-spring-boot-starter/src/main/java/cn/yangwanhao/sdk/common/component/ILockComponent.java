package cn.yangwanhao.sdk.common.component;

import cn.yangwanhao.base.common.support.ResponseMessage;

/**
 * 业务锁
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/30 10:59
 */
public interface ILockComponent {

    /**
     * 业务加锁
     * @param key 加锁的key
     * @param time 加锁的时间
     * @return 加锁是否成功
     */
    ResponseMessage<Boolean> tryLock(String key, Long time);

    /**
     * 业务解锁
     * @param key 解锁的key
     * @return 解锁是否成功
     */
    ResponseMessage<Boolean> unlock(String key);

}
