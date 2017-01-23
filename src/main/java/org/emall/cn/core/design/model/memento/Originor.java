package org.emall.cn.core.design.model.memento;

/**
 * @Description 备忘录模式
 * 原有的对象，具有某些属性，可以进行改变
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/1
 */
public class Originor {
    private String name;

    public Originor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 持有备忘录的实例
     * @return
     */
    public Mediator createMediator(){
        return new Mediator(name);
    }

    /**
     * 将对象还原到备忘录的状态
     * @param mediator
     */
    public void releaseMediator(Mediator mediator){
        this.name=mediator.getValue();
    }
}
