package cn.chace.www.spring.boot.redis.service;

import cn.chace.www.spring.boot.redis.model.Teacher;
import cn.chace.www.spring.boot.redis.repository.TeacherRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务类
 *
 * @author chenx
 * @date 2016/12/18
 */
@Service
public class TeacherService {
    @Cacheable(value = "testRedisCache", key = "'teacherInfo'")
    public Teacher getDetail() {
        List<Integer> classIds = new ArrayList<>();
        classIds.add(2);
        classIds.add(3);

        return new Teacher(1, "Miss Wang", classIds);
    }
}
