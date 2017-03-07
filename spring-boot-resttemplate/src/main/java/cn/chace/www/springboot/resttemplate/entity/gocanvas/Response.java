package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Model类：表单项信息
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("Response")
public class Response {
    @XStreamAlias("Label")
    private String label;

    @XStreamAlias("Value")
    private String value;

    @XStreamAlias("Type")
    private String type;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Response{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
