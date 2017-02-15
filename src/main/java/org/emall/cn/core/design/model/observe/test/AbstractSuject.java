package org.emall.cn.core.design.model.observe.test;

import org.emall.cn.core.design.model.observe.IObserve;

import java.util.Enumeration;
import java.util.Vector;

/**
 * The type Abstract suject.
 *
 * @author :<a href="mailto:zhengdb@ebnew.com">zhengdb</a>
 * @date :2017-02-15 13:40:51
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017 /2/15
 */
public abstract class AbstractSuject implements ISubject{
    /**
     * The Vector.
     *
     * @author :<a href="mailto:zhengdb@ebnew.com">zhengdb</a>
     * @date :2017-02-15 13:40:51
     */
    private Vector<IObserve> vector=new Vector<IObserve>();

    /**
     * 添加观察者
     * @param observe
     */
    @Override
    public void addObserve(IObserve observe) {
        vector.add(observe);
    }

    /**
     * 移除观察者
     * @param observe
     */
    @Override
    public void removeObserve(IObserve observe) {
        vector.remove(observe);
    }

    /**
     * 通知所有的观察者
     */
    @Override
    public void notifyAllObserve(String msg) {
        Enumeration<IObserve> elements=vector.elements();
        while(elements.hasMoreElements()){
            elements.nextElement().update(msg);
        }
    }
}
