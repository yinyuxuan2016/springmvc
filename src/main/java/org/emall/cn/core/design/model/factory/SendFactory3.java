package org.emall.cn.core.design.model.factory;

import org.emall.cn.core.design.model.factory.impl.MailSendImpl;
import org.emall.cn.core.design.model.factory.impl.MsgSendImpl;

/**
 * @Description  使用静态的方法就不需要实例化
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SendFactory3 {
    public static ISend publishMsg(){
        return new MsgSendImpl();
    }
    public  static  ISend publishMail(){
        return new MailSendImpl();
    }

    public static void main(String[] args) {
        ISend send=SendFactory3.publishMail();
        send.send();
    }
}
