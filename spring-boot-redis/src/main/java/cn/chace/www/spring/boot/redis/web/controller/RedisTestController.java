package cn.chace.www.spring.boot.redis.web.controller;

import cn.chace.www.spring.boot.redis.model.Teacher;
import cn.chace.www.spring.boot.redis.repository.TeacherRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器类：Redis序列号测试
 * @author chenx
 * @date 2016/12/17
 */
@RestController
public class RedisTestController {
    @Autowired
    private TeacherRedis teacherRedis;

    @RequestMapping(value = "redis", method = RequestMethod.GET)
    public Teacher doRedisSerialize() {
        List<Integer> classIds = new ArrayList<>();
        classIds.add(2);
        classIds.add(3);

        Teacher teacher = new Teacher(1, "Miss Wang", classIds);
        teacherRedis.setTeacherInfo(teacher);

        teacher = teacherRedis.getTeacherInfo();

        return teacher;
    }
}
