package org.emall.cn.core.design.model.observe;

/**
 * @Description 观察者的测试类
 * 适用场景：某个类的变化，通知到其他多个关联的对象
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class ObserveTest {
    public static void main(String[] args) {
        Subject subject=new MyObserve();
        subject.add(new Observe1());
        subject.add(new Observe2());
        subject.operation();
    }
}
