package org.emall.cn.core.design.model.observe;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description 抽象接口实现部分通用的逻辑 （抽象方法可以部分的实现接口，未实现的可以让子类去实现）
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public abstract class AbstractSuject implements Subject{
    private Vector<IObserve> vector=new Vector<IObserve>();

    @Override
    public void add(IObserve observe) {
        vector.add(observe);
    }

    @Override
    public void remove(IObserve observe) {
        vector.remove(observe);
    }

    @Override
    public void notifyAllUser() {
        Enumeration<IObserve> enumeration=vector.elements();
        while(enumeration.hasMoreElements()){
            enumeration.nextElement().update("this is msg");
        }
    }

}
