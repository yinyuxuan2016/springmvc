package org.emall.cn.core.design.model.interpreter;

/**
 * @Description 解释器模式的测试类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class InterpreterTest {
    public static void main(String[] args) {
        //Exception exception=new Plus();
        Exception exception=new Minus();
        Context c=new Context(20,10);
        int result=exception.interpreter(c);
        System.out.println(result);
    }
}
