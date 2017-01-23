package org.emall.cn.core.design.model.template;

/**
 * @Description 模板模式 这是抽象模板
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public abstract class Person {
    public void say(){
        System.out.println("i am a person");
    }
    public  void eat(){
        System.out.println("i am eatting happlier");
    }
    public  abstract void love();
}
