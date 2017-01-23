package org.emall.cn.core.design.model.commond;

/**
 * @Description 命令的实现类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class MyCommond implements Commond {
    private Receiver receiver;

    public MyCommond(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
