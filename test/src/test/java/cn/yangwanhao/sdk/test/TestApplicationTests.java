package cn.yangwanhao.sdk.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yangwanhao.sdk.common.component.impl.ValidateComponentImpl;
import cn.yangwanhao.sdk.test.common.dto.ValidateDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplicationTests {

    @Autowired
    private ValidateComponentImpl validateComponent;

    @Test
    public void validateTest() {
        ValidateDto validateDto = new ValidateDto();
        List<String> errorMessages = validateComponent.validateAll(validateDto);
        System.err.println(errorMessages);
    }

}
