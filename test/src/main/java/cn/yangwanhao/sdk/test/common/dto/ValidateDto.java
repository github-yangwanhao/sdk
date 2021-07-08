package cn.yangwanhao.sdk.test.common.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import cn.yangwanhao.sdk.common.annotation.In;
import cn.yangwanhao.sdk.common.annotation.InEnum;
import cn.yangwanhao.sdk.test.common.enums.EnumGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/18 20:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateDto extends ValidateParentDto {

    @NotBlank(message = "字符串bbb不能为空")
    private String bbb;

    @NotEmpty(message = "字符串ccc不能为空")
    @In(template = "c|cc|ccc", message = "参数不在'c|cc|ccc'的范围内")
    private String ccc;

    @NotNull(message = "属性ValidateChildDto不能为空")
    @Valid
    private ValidateChildDto childDto;

    @NotNull(message = "属性childDtoList不能为空")
    @Valid
    private List<ValidateChildDto> childDtoList;

    @InEnum(template = EnumGender.class, message = "性别字段不在接口提供的码值范围内")
    private String gender;

    @Email
    private String email;

}
