package org.emall.cn.core.design.model.factory;

import org.emall.cn.core.design.model.factory.impl.MailSendImpl;
import org.emall.cn.core.design.model.factory.impl.MsgSendImpl;

/**
 * @Description 不同的实现对应工厂中不同的方法
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SendFactory2 {
    public ISend publishMsg(){
        return new MsgSendImpl();
    }
    public  ISend publishMail(){
        return new MailSendImpl();
    }

    public static void main(String[] args) {
        SendFactory2 sendFactory2=new SendFactory2();
        //ISend send=sendFactory2.publishMail();
        ISend send=sendFactory2.publishMsg();
        send.send();
    }
}
