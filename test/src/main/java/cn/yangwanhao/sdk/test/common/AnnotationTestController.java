package cn.yangwanhao.sdk.test.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yangwanhao.sdk.common.annotation.LogExecutionTime;
import cn.yangwanhao.sdk.common.annotation.PrintLog;
import cn.yangwanhao.sdk.test.common.dto.PrintLogRequestDto;
import cn.yangwanhao.sdk.test.common.vo.PrintLogResponseVo;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2021/3/20 11:13
 */
@RestController
@RequestMapping("/annotation")
public class AnnotationTestController {

    @RequestMapping("/test/print-log/1")
    @PrintLog(description = "test1方法")
    @LogExecutionTime
    public PrintLogResponseVo test1(String param1, String param2, String param3) {
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PrintLogResponseVo(param1, param2, param3);
    }

    @RequestMapping("/test/print-log/2")
    @PrintLog(description = "test2方法")
    @LogExecutionTime(methodName = "test2方法")
    public PrintLogResponseVo test2(PrintLogRequestDto dto) {
        try {
            Thread.sleep(2532L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PrintLogResponseVo(dto.getRequestParam1(), dto.getRequestParam2(), dto.getRequestParam3());
    }

}
