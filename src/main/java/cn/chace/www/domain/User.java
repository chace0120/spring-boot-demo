package cn.chace.www.domain;

/**
 * 用户实体类
 *
 * @author chenxin
 * @date 2015/12/28
 */
public class User {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
