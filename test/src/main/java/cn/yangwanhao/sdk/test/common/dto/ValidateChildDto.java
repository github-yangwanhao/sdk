package cn.yangwanhao.sdk.test.common.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/18 20:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateChildDto implements Serializable {

    @NotNull(message = "长整型属性ddd不能为空")
    @Min(value = 1000, message = "长整型属性ddd不能小于1000")
    @Max(value = 10000, message = "长整型属性ddd不能大于10000")
    private Long ddd;

}
