package cn.chace.www.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例控制器类
 *
 * @author chenxin
 * @date 2015/12/17
 */
@RestController
public class DemoController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
}
