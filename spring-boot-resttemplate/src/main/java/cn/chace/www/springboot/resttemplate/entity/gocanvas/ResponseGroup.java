package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Model类：屏幕列表中的提交信息
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("ResponseGroup")
public class ResponseGroup {
    @XStreamAlias("Response")
    private Response response;

    @XStreamAlias("Section")
    private Section section;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "ResponseGroup{" +
                "response=" + response +
                ", section=" + section +
                '}';
    }
}
