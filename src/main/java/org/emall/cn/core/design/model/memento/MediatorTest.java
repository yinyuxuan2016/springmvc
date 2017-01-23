package org.emall.cn.core.design.model.memento;

/**
 * @Description 备忘录模式Test
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/1
 */
public class MediatorTest {
    public static void main(String[] args) {
        Originor originor=new Originor("egg");
        Mediator mediator=originor.createMediator();
        System.out.println("未改变之前的原型名称："+originor.getName());
        originor.setName("apple");
        System.out.println("改变知乎的原型名称："+originor.getName());
        System.out.println("备忘录中的原型名称："+mediator.getValue());
        originor.releaseMediator(mediator);
        System.out.println("还原后的原型名称："+originor.getName());
    }
}
