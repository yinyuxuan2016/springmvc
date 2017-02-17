package org.emall.cn.netty.util;

import org.emall.cn.netty.main.ServerMain;
import org.jboss.netty.channel.Channel;

/**
 * @Description 服务器推送消息工具类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/17
 */
public class ServerPullUitl {
    public static void pullMsg(){
        //这里为了方便测试，使用心跳推送
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //遍历所有维持链接的client，发送消息，忽略掉宕机
            for(String key: ServerMain.channelMap.keySet()){
                Channel channel=ServerMain.channelMap.get(key);
                serverSendMsg(channel,key);
            }
        }
    }
    public static void  serverSendMsg(Channel channel,String clientName){
        String msg="server say hello !"+clientName;
        if(channel!=null && channel.isOpen() && channel.isConnected() && channel.isWritable()){
            channel.write(msg);
        }
    }
}
