package org.emall.cn.core.design.model.mediator;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class User1 extends User{
    public User1(Mediator mediator) {
        super(mediator);
    }
    @Override
    public void work() {
        System.out.println("user1 is working");
    }
}
