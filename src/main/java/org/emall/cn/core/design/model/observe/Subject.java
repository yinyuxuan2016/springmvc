package org.emall.cn.core.design.model.observe;

/**
 * @Description 目标接口
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public interface Subject {
    /**增加观察者*/
    public void add(IObserve observe);
    /**删除观察者*/
    public void remove(IObserve observe);
    /**通知所有观察者*/
    public void notifyAllUser();
    /**自身的操作*/
    public void operation();
}
