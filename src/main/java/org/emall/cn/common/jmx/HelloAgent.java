package org.emall.cn.common.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/22
 */
public class HelloAgent {
    public static void main(String[] args) throws Exception{
        HelloInterface helloInterface=new HelloImpl();
        helloInterface.printHello();
       /* MBeanServer server= MBeanServerFactory.createMBeanServer();
        ObjectName objectName=new ObjectName("localhost:name=helloWorld");
        server.registerMBean(new HelloImpl(),objectName);
*/
        //ObjectName htmlName=new ObjectName("HelloAgent:name=htmladapter,port=8182");
        //server.registerMBean(new HtmlAda)
        System.out.println("start....");
    }
}
