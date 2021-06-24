package cn.yangwanhao.sdk.test.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2021/6/23 11:38
 */
@Getter
@AllArgsConstructor
public enum EnumGender {

    /** 女 */
    MAN("1", "男"),
    /** 男 */
    WOMAN("0", "女")
    ;

    private String code;

    private String message;

}
