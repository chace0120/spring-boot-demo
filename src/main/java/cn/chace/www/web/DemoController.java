package cn.chace.www.web;

import cn.chace.www.domain.User;
import cn.chace.www.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 示例控制器类
 *
 * @author chenxin
 * @date 2015/12/17
 */
@RestController
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/users")
    List<User> getUsers() throws InterruptedException {
        return userRepository.getAll();
    }
}
