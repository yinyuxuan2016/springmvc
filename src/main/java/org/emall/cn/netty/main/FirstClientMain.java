package org.emall.cn.netty.main;

import org.emall.cn.netty.thread.ClientThread;
import org.emall.cn.netty.util.ClientHeartbeatUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 第一个客户端
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class FirstClientMain {
    private static final int SEND_MILLISECOND = 3000;
    //单线程池,只与一个Server连接,减少开销
    private static final ExecutorService service = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        ClientThread clientThread=new ClientThread("client1");
        clientThread.isShortTcp=true;
        service.submit(clientThread);
        ClientHeartbeatUtil util=new ClientHeartbeatUtil(SEND_MILLISECOND);
        util.start(clientThread.getName());
    }
}
