package org.emall.cn.netty.main;

import org.emall.cn.netty.thread.ServerThread;
import org.emall.cn.netty.util.ServerPullUitl;
import org.jboss.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 服务器启动函数
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class ServerMain {
    public static ConcurrentHashMap<String,Channel> channelMap=new ConcurrentHashMap();
    public static void main(String[] args) {
        try{
            ServerThread serverThread=new ServerThread();
            Thread t=new Thread(serverThread);
            t.setName("server Thread");
            t.start();
            System.out.println("server start at localhost:8080");
            //推送消息
            ServerPullUitl.pullMsg();//这里是个while ture,模拟server不停给client反馈
        }catch(Exception e){
            System.out.println("know exception on server: " + e.getMessage());
        }
    }
}
