package org.emall.cn.core.design.model.memento;

/**
 * @Description 存储备忘录
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/1
 */
public class Strorage {
    private Mediator mediator;

    public Strorage(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
