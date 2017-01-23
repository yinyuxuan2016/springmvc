package org.emall.cn.common.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description 安全的终止线程
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/22
 */
public class InterruptThread {
    public static void main(String[] args) throws Exception{
        //第一种方式就是使用中断的方式，
        Runner one=new Runner();
        Thread countThread=new Thread(one,"CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        //第二种方式是使用线程cancel()方法
        Runner two=new Runner();
        countThread=new Thread(two,"Counthread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }
    private static class Runner implements Runnable{
       private long i;
        private volatile boolean on=true;
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
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i="+i);
        }
        public void cancel(){
            on=false;
        }
    }
}
