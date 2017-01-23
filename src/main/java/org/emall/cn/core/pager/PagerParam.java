package org.emall.cn.core.pager;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/28
 */
public class PagerParam implements Serializable{
    private static final long serialVersionUID = -3244699759102854782L;
    private String currentPage;
    private String pagerMethod;
    private Integer start;
    private Integer limit;

    public PagerParam(HttpServletRequest request) {
        this.pagerMethod = request.getParameter("pagerMethod");
        this.currentPage = request.getParameter("currentPage");
        this.start = Integer.valueOf(request.getParameter("start") == null?"0":request.getParameter("start"));
        this.limit = Integer.valueOf(request.getParameter("limit") == null?String.valueOf(2147483647):request.getParameter("limit"));
    }

    public String getCurrentPage() {
        return this.currentPage;
    }

    public String getPagerMethod() {
        return this.pagerMethod;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getStart() {
        return this.start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
