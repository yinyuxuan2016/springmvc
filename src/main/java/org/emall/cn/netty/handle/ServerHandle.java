package org.emall.cn.netty.handle;

import org.emall.cn.netty.main.ServerMain;
import org.emall.cn.netty.thread.ServerThread;
import org.jboss.netty.channel.*;

import java.net.InetSocketAddress;

/**
 * @Description server处理程序handle
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class ServerHandle extends SimpleChannelUpstreamHandler{
    //server收到client的信息进行处理
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
       Channel channel=e.getChannel();
        if(channel!=null){
            String host=((InetSocketAddress)ctx.getChannel().getRemoteAddress()).getHostName();
            int port=((InetSocketAddress)ctx.getChannel().getRemoteAddress()).getPort();
            //将IP和端口组合起来放到map,方便管理多个client
            ServerMain.channelMap.put(host+":"+port,channel);
        }
        System.out.println("Server recive message:"+e.getMessage());
        System.out.println(ServerMain.channelMap);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.err.println(" Server has a error,Error cause:" + e.getCause());
        e.getChannel().close();
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        String host = ((InetSocketAddress) ctx.getChannel()
                .getRemoteAddress()).getAddress().getHostAddress();
        int port = ((InetSocketAddress) ctx.getChannel().getRemoteAddress())
                .getPort();
        System.out.println("server close channel: " + "[" + host + ":" + port + "]");
        ServerMain.channelMap.remove(host+":"+port);
    }
}
