package org.emall.cn.core.design.model.factory;

import org.emall.cn.core.design.model.factory.impl.MailSendImpl;
import org.emall.cn.core.design.model.factory.impl.MsgSendImpl;

/**
 * @Description 建立一个工厂类，实现统一接口的类进行统一创建
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SendFactory {
    public ISend publicSend(String key){
        ISend send=null;
        if("msg".equals(key)){
             send=new MsgSendImpl();
        }else if("mail".equals(key)){
            send=new MailSendImpl();
        }else{
            System.out.println("please input correct message");
        }
        return send;
    }

    public static void main(String[] args) {
        SendFactory sendFactory=new SendFactory();
        //ISend  send=sendFactory.publicSend("msg");
        ISend  send=sendFactory.publicSend("mail");
        send.send();
    }
}
