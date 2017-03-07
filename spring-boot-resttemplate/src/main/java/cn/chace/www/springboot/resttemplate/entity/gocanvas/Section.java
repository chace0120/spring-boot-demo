package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Model类：区域信息
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("Section")
public class Section {
    @XStreamAlias("Name")
    private String name;

    @XStreamAlias("Screens")
    private List<Screen> screens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", screens=" + screens +
                '}';
    }
}
