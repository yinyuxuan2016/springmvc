package org.emall.cn.core.design.model.proxy;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SourceImpl implements ISource {
    @Override
    public void method() {
        System.out.println("this is source method!!!");
    }
}
