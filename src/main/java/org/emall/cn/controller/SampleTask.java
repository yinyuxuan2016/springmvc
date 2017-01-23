package org.emall.cn.controller;

import org.emall.cn.model.project.User;

import javax.servlet.ServletContext;
import java.util.TimerTask;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/9/22
 */
public  class SampleTask extends TimerTask {
    private ServletContext context;
    private static boolean isRunning = false;
    public SampleTask(ServletContext context) {
        this.context = context;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (!isRunning) {
            isRunning = true;
            System.out.println("开始执行指定任务");
            if (DWRReverse.wctx != null) {
                User user = new User(1, "tom", "123456", "10", "13909876543", "");
                DWRReverse.sendMessage(user);
            }
            isRunning = false;
            // context.log("指定任务执行结束");
        } else {
            // context.log("上一次任务执行还未结束");
        }
    }
}
