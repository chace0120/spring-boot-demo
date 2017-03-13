package cn.chace.www.springboot.resttemplate.entity.gocanvas.referencedata;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Model类：Reference Data Row
 *
 * @author chenx
 * @date 2017/3/9
 */
@XStreamAlias("r")
public class Row {
    @XStreamImplicit(itemFieldName = "v")
    private List<String> values;

    public Row() {
    }

    public Row(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
