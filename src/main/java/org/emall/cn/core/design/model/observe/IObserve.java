package org.emall.cn.core.design.model.observe;

/**
 * @Description 接受者接口（主要是接受执行者的对数据的变化）消息通知可以用到观察者模式
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public interface IObserve {
    public void update(String msg);
}
