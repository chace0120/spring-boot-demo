package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Model类：GoCanvas服务接口返回的结果
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("CanvasResult")
public class CanvasResult {
    @XStreamAlias("TotalPages")
    private Integer totalPages;

    @XStreamAlias("CurrentPage")
    private Integer currentPage;

    @XStreamAlias("Submissions")
    private List<Submission> submissions;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    @Override
    public String toString() {
        return "CanvasResult{" +
                "totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", submissions=" + submissions +
                '}';
    }
}
