package org.emall.cn.core.design.model.mediator;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator=new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
