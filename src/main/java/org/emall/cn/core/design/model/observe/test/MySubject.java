package org.emall.cn.core.design.model.observe.test;

/**
 * @Description 被观察者具体的实现
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/15
 */
public class MySubject extends AbstractSuject{
    @Override
    public void operation() {
        String msg="消息已经接受到！";
        System.out.println("我已经开始操作。。。。。。。。");
        this.notifyAllObserve(msg);
    }
}
