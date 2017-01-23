package org.emall.cn.core.design.model.visitor;

/**
 * @Description 访问者的实现类 访问方法
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class MyVisitor implements Visitor{
    @Override
    public void visit(Subject subject) {
        System.out.println("the subject is :"+subject.getSubject());
    }
}
