package org.emall.cn.core.design.model.visitor;

/**
 * @Description 访问者模式 访问者的接口类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public interface Visitor {
    public void visit(Subject subject);
}
