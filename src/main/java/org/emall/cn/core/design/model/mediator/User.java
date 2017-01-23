package org.emall.cn.core.design.model.mediator;

/**
 * @Description 中介者模式 依赖类的抽象方法 持有一个中介者的实例，
 * 有一个抽象的方法需要子类去具体的实现
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
    public abstract void work();
}
