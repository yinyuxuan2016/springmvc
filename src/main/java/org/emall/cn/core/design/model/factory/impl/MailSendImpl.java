package org.emall.cn.core.design.model.factory.impl;

import org.emall.cn.core.design.model.factory.ISend;

/**
 * @Description 发送邮件的实现类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class MailSendImpl implements ISend {
    public void send() {
        System.out.println("send email success!!!!");
    }
}
