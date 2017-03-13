package cn.chace.www.springboot.resttemplate.entity.gocanvas.referencedata;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.List;

/**
 * Model类：Reference Data
 *
 * @author chenx
 * @date 2017/3/9
 */
@XStreamAlias("List")
public class RefData {
    @XStreamAlias("Name")
    @XStreamAsAttribute
    private String name;

    @XStreamAlias("Columns")
    private Columns columns;

    @XStreamAlias("Rows")
    private List<Row> rows;

    public RefData() {
    }

    public RefData(String name, Columns columns, List<Row> rows) {
        this.name = name;
        this.columns = columns;
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Columns getColumns() {
        return columns;
    }

    public void setColumns(Columns columns) {
        this.columns = columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
