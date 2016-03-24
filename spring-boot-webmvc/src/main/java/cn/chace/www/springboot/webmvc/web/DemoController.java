package cn.chace.www.springboot.webmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chace on 2016/3/22.
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    @RequestMapping("msg")
    public String showMsg() {
        return "Hello World!";
    }
}
