package org.emall.cn.core.design.model.observe.test;

import org.emall.cn.core.design.model.observe.Observe1;
import org.emall.cn.core.design.model.observe.Observe2;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/15
 */
public class ObserveSubjectTest {
    public static void main(String[] args) {
        ISubject iSubject=new MySubject();
        iSubject.addObserve(new Observe1());
        iSubject.addObserve(new Observe2());
        iSubject.operation();
    }
}
