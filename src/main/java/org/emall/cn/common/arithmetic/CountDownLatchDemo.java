package org.emall.cn.common.arithmetic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Description 一个同步的辅助类，在完成一组正在进行的操作之前，它允许一个或者多个线程进行等待
 * 在于我理解就是获得一个同步锁，等待锁释放后，再允许下一个线程获得同步锁
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class CountDownLatchDemo {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Worker worker1=new Worker("work1",1000,countDownLatch);
        Worker worker2=new Worker("work2",2000,countDownLatch);
        worker1.run();
        worker2.run();
        /**
         *  worker1.start();如果使用start的话,因为线程之间没有同步锁，所以会导致线程之间进行竞争
         *  worker2.start();
         */
        countDownLatch.await();//等待所有工人完成工作
        System.out.println("all work done at "+sdf.format(new Date()));
    }
    static  class Worker extends Thread{
        private String workName;
        private int workTime;
        CountDownLatch countDownLatch;
        public Worker(String workName,int workTime,CountDownLatch countDownLatch){
            this.countDownLatch=countDownLatch;
            this.workName=workName;
            this.workTime=workTime;
        }
        public void run(){
            System.out.println("Worker "+workName+" do work begin at "+sdf.format(new Date()));
            doWork();//工作了
            System.out.println("Worker "+workName+" do work complete at "+sdf.format(new Date()));
            countDownLatch.countDown();//工人完成工作，计数器减一
        }
        private void doWork(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
