package org.emall.cn.core.design.model.observe;

/**
 * @Description 具体的实现类 复写抽象类的方法
 *  通知所有观察者
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class MyObserve extends AbstractSuject{
    @Override
    public void operation() {
        System.out.println("update myself");
        this.notifyAllUser();
    }
}
