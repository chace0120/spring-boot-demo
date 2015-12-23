package cn.chace.www.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外部属性示例
 *
 * @author chenxin
 * @date 2015/12/21
 */
@RestController
//@Profile("dev")
@RequestMapping("property")
public class PropertyController {
    @Value("${customerName}")
    private String customerName;
    @Value("${random.int}")
    private String randomNum;
    @Value("${app.full.name}")
    private String appFullName;
    @Value("${environments.dev.url}")
    private String url;

    /**
     * 显示自定义属性文件中的属性
     */
    @RequestMapping("value")
    public String showCustomerName() {
        return customerName;
    }

    /**
     * 显示RandomValuePropertySource注入的随机值
     */
    @RequestMapping("randomValue")
    public String showRandomNum() {
        return randomNum;
    }

    /**
     * 显示属性占位符配置的属性值
     */
    @RequestMapping("placeholder")
    public String showAppFullName() {
        return appFullName;
    }

    /**
     * 显示Yaml方式配置的属性值
     */
    @RequestMapping("yaml")
    public String showYamlValue() {
        return url;
    }
}
