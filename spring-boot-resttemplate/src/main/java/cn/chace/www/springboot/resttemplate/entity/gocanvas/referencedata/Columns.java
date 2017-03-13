package cn.chace.www.springboot.resttemplate.entity.gocanvas.referencedata;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Model类：Reference Data Columns
 *
 * @author chenx
 * @date 2017/3/9
 */
@XStreamAlias("Columns")
public class Columns {
    @XStreamImplicit(itemFieldName = "c")
    private List<String> columns;

    public Columns() {
    }

    public Columns(List<String> columns) {
        this.columns = columns;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
