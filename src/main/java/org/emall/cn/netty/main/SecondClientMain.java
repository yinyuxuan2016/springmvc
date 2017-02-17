package org.emall.cn.netty.main;

import org.emall.cn.netty.thread.ClientThread;
import org.emall.cn.netty.util.ClientHeartbeatUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class SecondClientMain {
    private static final int SEND_MILLISECOND = 3000;
    //单线程池,只与一个Server连接,减少开销
    private static final ExecutorService service = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        ClientThread clientThread=new ClientThread("client2");
        service.submit(clientThread);
        ClientHeartbeatUtil clientHeartbeatUtil=new ClientHeartbeatUtil(SEND_MILLISECOND);
        clientHeartbeatUtil.start(clientThread.getName());
    }
}
