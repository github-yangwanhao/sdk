package cn.yangwanhao.sdk.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cn.yangwanhao.sdk.common.component.ValidateComponent;
import cn.yangwanhao.sdk.test.common.dto.ValidateDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplicationTests {

    @Autowired
    private ValidateComponent validateComponent;

    @Test
    public void validateTest() {
        ValidateDto validateDto = new ValidateDto();
        List<String> errorMessages = validateComponent.validateAll(validateDto);
        System.err.println(errorMessages);
    }

}
