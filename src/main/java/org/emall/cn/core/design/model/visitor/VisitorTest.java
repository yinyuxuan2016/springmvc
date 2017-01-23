package org.emall.cn.core.design.model.visitor;

/**
 * @Description 接收者接受来自访问者的访问请求，调用访问者进行处理请求
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class VisitorTest {
    public static void main(String[] args) {
        Visitor visitor=new MyVisitor();
        //visitor.visit(new MySubject());
        Subject subject=new MySubject();
        subject.accept(visitor);
    }
}
