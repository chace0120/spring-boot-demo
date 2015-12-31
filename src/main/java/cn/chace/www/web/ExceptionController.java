package cn.chace.www.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常示例
 *
 * @author chenxin
 * @date 2015/12/30
 */
@RestController
public class ExceptionController {
    @RequestMapping("/exception")
    public void catchException() {
        throw new RuntimeException("error occur");
    }

    @RequestMapping("/500")
    public String showServerError() {
        return "server error";
    }
}
