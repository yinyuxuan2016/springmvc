package org.emall.cn.netty.thread;

import org.emall.cn.netty.handle.ServerHandle;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import static org.jboss.netty.channel.Channels.pipeline;

/**
 * @Description 服务端的线程
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class ServerThread implements Runnable{
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
        bootstrap.bind(new InetSocketAddress(8080));
    }
    //服务器处理的工厂
    private static final NioServerSocketChannelFactory FACTORY=new NioServerSocketChannelFactory(
            Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
    //服务器启动
    private static final ServerBootstrap bootstrap=new ServerBootstrap(FACTORY);
    //处理客户端的管道信息
    private static final ChannelPipelineFactory PIPELINE_FACTORY=new ChannelPipelineFactory() {
        @Override
        public ChannelPipeline getPipeline() throws Exception {
            ChannelPipeline channelPipeline=pipeline();
            channelPipeline.addLast("encode",new StringEncoder());
            channelPipeline.addLast("decode",new StringDecoder());
            channelPipeline.addLast("handler",new ServerHandle());
            return channelPipeline;
        }
    };
    static {
        bootstrap.setPipelineFactory(PIPELINE_FACTORY);
    }

}
