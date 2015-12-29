package cn.chace.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * 应用启动类
 *
 * @author chenxin
 * @date 2015/12/17
 */
/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
@SpringBootApplication //一个相当于上面三个
@PropertySource("classpath:myconfig.properties")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
