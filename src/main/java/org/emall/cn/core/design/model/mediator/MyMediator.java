package org.emall.cn.core.design.model.mediator;

/**
 * @Description 中介者模式 持有两个依赖类的实例
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class MyMediator implements Mediator{
    private  User1 user1;
    private User2 user2;

    public User1 getUser1() {
        return user1;
    }

    public User2 getUser2() {
        return user2;
    }

    /**
     * 创建依赖对象
     */
    @Override
    public void createMediator() {
        user1=new User1(this);
        user2=new User2(this);
    }

    /**
     * 使用中介者调用依赖对象的方法
     */
    @Override
    public void workAll() {
        user1.work();
        user2.work();
    }
}
