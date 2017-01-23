package org.emall.cn.common.jmx;

/**
 * @Description hello的接口
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/22
 */
public interface HelloInterface {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}
