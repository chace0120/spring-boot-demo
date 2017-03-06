package cn.chace.www.spring.boot.redis.repository;

import cn.chace.www.spring.boot.redis.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Redis类：序列化Teacher类存储
 *
 * @author chenx
 * @date 2016/12/17
 */
@Repository
public class TeacherRedis {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    public void setTeacherInfo(Teacher teacherInfo) {
        valueOperations.set("test.teacher", teacherInfo);
    }

    public Teacher getTeacherInfo() {
        return (Teacher) valueOperations.get("test.teacher");
    }
}
