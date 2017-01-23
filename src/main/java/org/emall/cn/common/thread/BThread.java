package org.emall.cn.common.thread;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/20
 */
public class BThread extends Thread{
     AThread aThread;
    public BThread(AThread aThread){
        super("[BThread] BThread");
        this.aThread=aThread;
    }
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            aThread.join();
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
