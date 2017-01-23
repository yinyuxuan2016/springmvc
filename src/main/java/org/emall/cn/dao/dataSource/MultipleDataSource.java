package org.emall.cn.dao.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/5
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    public static final InheritableThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();
    //private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
    public static void toDefault(){
        dataSourceKey.remove();
    }
}
