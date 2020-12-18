package cn.yangwanhao.sdk.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cn.yangwanhao.sdk.test.common.dto.ValidateDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void validateTest() {
        ValidateDto validateDto = new ValidateDto();
        ResponseEntity<String> res = restTemplate.postForEntity("http://localhost:8080/validate/test",
           validateDto, String.class);
        System.err.println(res.getBody());
    }

}
