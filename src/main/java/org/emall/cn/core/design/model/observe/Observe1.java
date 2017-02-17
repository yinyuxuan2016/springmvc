package org.emall.cn.core.design.model.observe;

/**
 * @Description 观察者1的实现
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class Observe1 implements IObserve{
    @Override
    public void update(String msg) {
        System.out.println("Observe1 is received,and msg is:"+msg);
    }
}
