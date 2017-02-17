package org.emall.cn.core.design.model.observe.test;

import org.emall.cn.core.design.model.observe.IObserve;

/**
 * @Description 被观察者的几个接口
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/15
 */
public interface ISubject {
    //添加观察者
    void addObserve(IObserve observe);
    //移除观察者
    void removeObserve(IObserve observe);
    //唤醒所有的观察者
    void notifyAllObserve(String msg);
    //被观察者操作
    void operation();
}
