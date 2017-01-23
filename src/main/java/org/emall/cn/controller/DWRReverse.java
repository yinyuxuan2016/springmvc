package org.emall.cn.controller;

import org.directwebremoting.*;
import org.directwebremoting.proxy.dwr.Util;
import org.emall.cn.model.project.User;

import java.util.Collection;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/9/22
 */
public class DWRReverse {
    public static WebContext wctx = null;
    public static void sendMessage(User monitor) {
        if (wctx == null) {
            wctx = WebContextFactory.get();
        }
        ScriptBuffer script = new ScriptBuffer();
        //执行js 方法
        if (monitor != null) {
            StringBuffer sb = new StringBuffer();
            sb.append(monitor.getId()).append(",");
            sb.append(monitor.getUsername()).append(",");
            sb.append(monitor.getPassword()).append(",");
            sb.append(monitor.getAge()).append(",");
            sb.append(monitor.getTel());
            script.appendScript("receiveMessages('").appendData(sb.toString())
                    .appendScript("');");
        }
        ServerContext sctx = ServerContextFactory.get(wctx.getServletContext());
        Collection<ScriptSession> scriptSessions = sctx.getScriptSessionsByPage(wctx.getCurrentPage());
        Util util = new Util(scriptSessions);
        //可以设置样式等
        // util.setStyle("test", "display", "none");
        for (ScriptSession session : scriptSessions) {
            session.addScript(script);
        }
    }
}
