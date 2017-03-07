package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Model类：GoCanvas APP信息
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("Form")
public class Form {
    @XStreamAlias("Name")
    private String name;

    @XStreamAlias("Status")
    private String status;

    @XStreamAlias("Version")
    private Integer version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Form{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", version=" + version +
                '}';
    }
}
