package org.emall.cn.core.design.model.visitor;

/**
 * @Description 接收者的接口类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public interface Subject {
    public String getSubject();
    public void accept(Visitor visitor);
}
