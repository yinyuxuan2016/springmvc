package org.emall.cn.netty.thread;

import org.emall.cn.netty.handle.ClientHandle;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.handler.timeout.ReadTimeoutHandler;
import org.jboss.netty.util.HashedWheelTimer;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import static org.jboss.netty.channel.Channels.pipeline;

/**
 * @Description 客户端线程，用于初始化链接
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class ClientThread implements Runnable{
    //静态化ChannelFuture,因为客户端只需要保持一个连接跟服务器
    public static ChannelFuture channelFuture;

    //客户端线程标识名
    private String name;
    public static boolean isShortTcp = false;

    public ClientThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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
        if(!isShortTcp){
            channelFuture=clientBootstrap.connect(remoteServerAddress);
            System.out.println("客户端："+name+"启动完毕，返回长连接："+channelFuture.hashCode());
        }
    }
    //创建client端线程池工厂
    private static final NioClientSocketChannelFactory factory=new NioClientSocketChannelFactory(
            Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
    //创建客户端的启动器
    public static final ClientBootstrap clientBootstrap=new ClientBootstrap(factory);
    //服务器地址
    public static final InetSocketAddress remoteServerAddress = new InetSocketAddress("127.0.0.1", 8080);
    public static final HashedWheelTimer timer=new HashedWheelTimer();
    private static ReadTimeoutHandler timeoutHandler = new ReadTimeoutHandler(timer,3);
    private static final ChannelPipelineFactory CHANNEL_PIPELINE_FACTORY=new ChannelPipelineFactory() {
        @Override
        public ChannelPipeline getPipeline() throws Exception {
            ChannelPipeline channelPipeline=pipeline();
            channelPipeline.addLast("encode", new StringEncoder());
            channelPipeline.addLast("decode", new StringDecoder());
            channelPipeline.addLast("timeout", timeoutHandler);// this is correct
//			pipleline.addLast("timeout", new ReadTimeoutHandler(new HashedWheelTimer(),3));//this is bug
            channelPipeline.addLast("handler", new ClientHandle());//客户端handler
            return channelPipeline;
        }
    };
    static {
        clientBootstrap.setPipelineFactory(CHANNEL_PIPELINE_FACTORY);
    }
}
