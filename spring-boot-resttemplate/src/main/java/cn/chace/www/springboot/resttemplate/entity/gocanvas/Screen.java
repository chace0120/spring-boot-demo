package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Model类：屏幕信息
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("Screen")
public class Screen {
    @XStreamAlias("Name")
    private String name;

    @XStreamAlias("Responses")
    private List<Response> responses;

    @XStreamAlias("ResponseGroups")
    private List<ResponseGroup> responseGroups;

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResponseGroup> getResponseGroups() {
        return responseGroups;
    }

    public void setResponseGroups(List<ResponseGroup> responseGroups) {
        this.responseGroups = responseGroups;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "name='" + name + '\'' +
                ", responses=" + responses +
                ", responseGroups=" + responseGroups +
                '}';
    }
}
