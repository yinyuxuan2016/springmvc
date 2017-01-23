package org.emall.cn.core.design.model.build;

import org.emall.cn.core.design.model.factory.ISend;
import org.emall.cn.core.design.model.factory.impl.MailSendImpl;
import org.emall.cn.core.design.model.factory.impl.MsgSendImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 建造者模式 和工厂模式的区别就是工厂模式是创建单个对象，而
 * 建造者模式是创建一类的对象
 * 应用场景：创建一类相同属性的对象，考虑用建造者模式
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class BuildFactory {
    private static  List<ISend> list=new ArrayList<ISend>();
    public void getMsgProduce(int count){
        for (int i = 0; i <count ; i++) {
            list.add(new MsgSendImpl());
        }
    }
    public void getMailProduce(int count){
        for (int i = 0; i <count ; i++) {
            list.add(new MailSendImpl());
        }
    }

    public static void main(String[] args) {
        BuildFactory buildFactory=new BuildFactory();
        buildFactory.getMailProduce(10);
        for (ISend s:list
             ) {
            s.send();
        }
    }
}
