package cn.chace.www.spring.boot.redis.model;

import java.io.Serializable;
import java.util.List;

/**
 * Model类
 *
 * @author chenx
 * @date 2016/12/17
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = -4848665612204601333L;

    private Integer id;
    private String name;
    private List<Integer> classIds;

    public Teacher() {
    }

    public Teacher(Integer id, String name, List<Integer> classIds) {
        this.id = id;
        this.name = name;
        this.classIds = classIds;
    }
}
