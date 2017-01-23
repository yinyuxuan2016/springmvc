package org.emall.cn.service.dwr;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.emall.cn.common.DwrScriptSessionManagerUtil;

import javax.servlet.ServletException;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/9/22
 */
public class MessagePush{
    public void onPageLoad(String userId) {
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute(userId, userId);
        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
        try {
            dwrScriptSessionManagerUtil.init();
            System.out.println("cacaca");
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
