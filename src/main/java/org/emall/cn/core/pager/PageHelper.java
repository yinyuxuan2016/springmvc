package org.emall.cn.core.pager;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/28
 */
public class PageHelper {
    private static int DEFAULT_PAGESIZE = 10;
    public static String FIRST_METHOD = "first";
    public static String PREVIOUS_METHOD = "previous";
    public static String NEXT_METHOD = "next";
    public static String LAST_METHOD = "last";
    public static String GO_METHOD = "go";

    public PageHelper() {
    }

    public static Pager getPager(PagerParam param, int totalRows, int onePageSize) {
        Pager pager = new Pager(totalRows, onePageSize);
        String currentPage = param.getCurrentPage();
        if(currentPage != null && !currentPage.equals("")) {
            pager.refresh(Integer.parseInt(currentPage));
        }

        String pagerMethod = param.getPagerMethod();
        if(pagerMethod != null && !"".equals(currentPage)) {
            if(pagerMethod.equals(FIRST_METHOD)) {
                pager.first();
            } else if(pagerMethod.equals(PREVIOUS_METHOD)) {
                pager.previous();
            } else if(pagerMethod.equals(NEXT_METHOD)) {
                pager.next();
            } else if(pagerMethod.equals(LAST_METHOD)) {
                pager.last();
            } else if(pagerMethod.equals(GO_METHOD)) {
                pager.go(Integer.parseInt(currentPage));
            }
        }

        return pager;
    }

    public static Pager getPager(PagerParam param, int totalRows) {
        return getPager(param, totalRows, DEFAULT_PAGESIZE);
    }
}
