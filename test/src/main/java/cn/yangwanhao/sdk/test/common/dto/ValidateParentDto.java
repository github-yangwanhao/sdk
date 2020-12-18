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
 * @since 2020/12/18 20:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateParentDto implements Serializable {

    @NotNull(message = "整数aaa不能为空")
    @Max(value = 10, message = "整数aaa不能大于10")
    @Min(value = 1, message = "整数aaa不能小于1")
    private Integer aaa;

}
