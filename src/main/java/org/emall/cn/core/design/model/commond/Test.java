package org.emall.cn.core.design.model.commond;

/**
 * @Description 命令模式的测试类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class Test {
    public static void main(String[] args) {
        Commond commond=new MyCommond(new Receiver());
        Invoke invoke=new Invoke(commond);
        invoke.action();
    }
}
