package org.emall.cn.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description 测试多线程中的信号量 控制多线程的并发数
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/8
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    //创建一个30个线程并发的线程池
    private static ExecutorService threadPool= Executors.newScheduledThreadPool(THREAD_COUNT);
    private static Semaphore semaphore=new Semaphore(10);
    private static int num=0;
    public static void main(String[] args) {
        for (int i = 0; i <THREAD_COUNT ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                        try {
                            num++;
                            semaphore.acquire();
                            System.out.println("save data."+num);
                            semaphore.release();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            });
        }
        threadPool.shutdown();
    }
}
