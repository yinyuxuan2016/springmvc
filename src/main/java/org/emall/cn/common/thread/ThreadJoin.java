package org.emall.cn.common.thread;

/**
 * @Description join方法 就是子线程会阻塞主线程的执行，直到子线程执行完后主线程才能执行
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/20
 */
public class ThreadJoin {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        //子线程
        AThread at = new AThread();
        //主线程
        BThread bt = new BThread(at);
        try {
            bt.start();
            Thread.sleep(2000);
            bt.join();
            at.start();
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }

}
