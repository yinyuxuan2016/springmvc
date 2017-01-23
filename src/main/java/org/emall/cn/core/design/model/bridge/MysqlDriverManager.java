package org.emall.cn.core.design.model.bridge;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class MysqlDriverManager implements IDriverManager{
    @Override
    public void getConnection() {
        System.out.println("connect mysql finish");
    }
}
