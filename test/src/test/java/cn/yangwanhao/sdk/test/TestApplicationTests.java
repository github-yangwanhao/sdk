package cn.yangwanhao.sdk.test;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import cn.yangwanhao.sdk.common.component.IValidateComponent;
import cn.yangwanhao.sdk.test.common.dto.ValidateDto;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestApplicationTests {

    @Autowired
    private IValidateComponent validateComponent;

    @Test
    public void validateTest() {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setCcc("aaa");
        String errorMessages = validateComponent.validateAll(validateDto);
        if (StringUtils.isBlank(errorMessages)) {
            log.info("no error occurs");
        } else {
            log.error(errorMessages.toString());
        }
    }

}
