package org.emall.cn.common.thread;

/**
 * @Description Runnable是Thread的接口类，多线程开发的时候，一般使用runnable,原因有两个
 * 1：继承只能单继承，但是接口的实现可以是多实现
 * 2：多个线程实现了一个接口，这样会使得各个线程之间可见
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/23
 */
public class RunnelableTest implements Runnable {
    //这个地方使用volatile，就可以保持线程之间的可见性，就不会出现多线程问题
    private volatile int ticket=10;
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            if(this.ticket>0){
                System.out.println("当前线程："+Thread.currentThread().getName()+"卖出："+this.ticket--);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("开始卖票.......");
        Runnable r1=new RunnelableTest();
        new Thread(r1,"Thread 1").start();
        new Thread(r1,"Thread 2").start();
        new Thread(r1,"Thread 3").start();
        System.out.println("卖票完成.......");
    }
}
