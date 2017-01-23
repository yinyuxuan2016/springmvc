package org.emall.cn.common.thread;

/**
 * @Description 该方法使用volatile使得线程的执行顺序保证，但是由于是没有锁机制的，会出现多线程问题
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/23
 */
public class ThreadTest extends Thread{
    public ThreadTest(String name){
        super(name);
    }
    private volatile int ticket=10;
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            synchronized (this){
            if(this.ticket>0){
                    System.out.println("当前线程："+Thread.currentThread().getName()+"卖票："+this.ticket--);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始卖票.......");
        Thread.currentThread().sleep(1000);
        System.out.println("正在卖票.......");
        Thread t1=new ThreadTest("Thread 1");
        Thread t2=new ThreadTest("Thread 2");
        Thread t3=new ThreadTest("Thread 3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();//join的用法
        t3.start();
        t3.join();
        System.out.println("卖票完成.......");
    }
}
