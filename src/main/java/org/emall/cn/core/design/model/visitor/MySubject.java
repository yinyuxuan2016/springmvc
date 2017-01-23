package org.emall.cn.core.design.model.visitor;

/**
 * @Description 接收者的实现类 接受的方法
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class MySubject implements Subject{

    @Override
    public String getSubject() {
        return "love";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
