package org.emall.cn.service.dwr;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import java.util.Collection;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/9/22
 */
public class TestPush {
    public void sendMessageAuto(String userid, String message){

        final String userId = userid;
        final String autoMessage = message;
        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            public boolean match(ScriptSession session){
                return true;
            }
        }, new Runnable(){

            private ScriptBuffer script = new ScriptBuffer();

            public void run(){

                script.appendCall("showMessage", autoMessage);

                Collection<ScriptSession> sessions = Browser

                        .getTargetSessions();

                for (ScriptSession scriptSession : sessions){
                    scriptSession.addScript(script);
                }
            }
        });
    }
}
