package org.emall.cn.common.thread;

/**
 * @Description 守护线程，当前线程为守护线程时，由于没有非守护线程的存在，虚拟机将退出，finally的代码就不会被执行到。
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/22
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread thread=new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * The type Daemon runner.
     *
     * @author :<a href="mailto:zhengdb@ebnew.com">zhengdb</a>
     * @date :2017-01-22 11:55:17
     */
    static class DaemonRunner implements Runnable{
        @Override
        public void run(){
            try {
                System.out.println("Demond run..........");
            }finally{
                System.out.println("DemondThread finally run。");
            }
        }
    }
}
