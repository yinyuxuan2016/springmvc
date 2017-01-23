package org.emall.cn.core.design.model.factory.impl;

import org.emall.cn.core.design.model.factory.AbstractFactory;
import org.emall.cn.core.design.model.factory.ISend;

/**
 * @Description 发送短信的工厂类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class MsgFactory implements AbstractFactory{
    public ISend produce() {
        return new MsgSendImpl();
    }

    public static void main(String[] args) {
        AbstractFactory abstractFactory=new MsgFactory();
        ISend send=abstractFactory.produce();
        send.send();
    }
}
