package org.emall.cn.core.design.model.template;

/**
 * @Description 模板模式的测试类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class TemplateTest {
    public static void main(String[] args) {
        Person person=new XiaoMing();
        person.eat();
        person.love();
        person.say();
        person=new XiaoQiang();
        person.eat();
        person.love();
        person.say();
    }

}
