package cn.chace.www.springboot.webmvc.web;

import cn.chace.www.springboot.webmvc.entity.User;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用于spring-boot-resttemplate模块测试
 *
 * @author chenx
 * @date 2016/3/25
 */
@RestController
@RequestMapping("users")
public class UserController {
    /**
     * 获取单个用户
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable int userId) throws InterruptedException {
        Thread.sleep(3000); //模拟网络延时
        return new User(userId, "A", 8);
    }

    /**
     * 获取多个用户
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = Lists.newArrayList(
              new User(1, "A", 18),
              new User(2, "B", 20),
              new User(3, "C", 18)
        );

        return users;
    }
}
