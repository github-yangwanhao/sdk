package cn.yangwanhao.sdk.test.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yangwanhao.sdk.common.component.impl.ValidateComponentImpl;
import cn.yangwanhao.sdk.test.common.dto.ValidateDto;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2020/12/18 20:15
 */
@RestController
@RequestMapping("/validate")
public class ValidateTestController {

    @Autowired
    private ValidateComponentImpl validator;

    @PostMapping("/test")
    public String testValidate(ValidateDto dto) {
        List<String> errorMessages = validator.validateAll(dto);
        if (CollectionUtils.isEmpty(errorMessages)) {
            return "no error occurred";
        }
        return errorMessages.toString();
    }

}
