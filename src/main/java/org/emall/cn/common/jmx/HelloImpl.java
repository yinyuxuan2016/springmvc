package org.emall.cn.common.jmx;

import javax.management.MXBean;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/22
 */
@MXBean(false)
public class HelloImpl implements HelloInterface{
    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void printHello() {
        System.out.println("hello world:"+name);
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("hello:"+whoName);
    }
}
