package org.emall.cn.dao.adivce;

import org.apache.ibatis.session.SqlSession;

import java.util.Vector;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/5
 */
public class JtaContext {
    public static final InheritableThreadLocal<JtaModel> TRANSACTION_LOCAL = new InheritableThreadLocal();
    public static final InheritableThreadLocal<Vector<SqlSession>> CONNECTION_HOLDER = new InheritableThreadLocal();
    /*public static final InheritableThreadLocal<Session> JMS_SESSION_LOCAL = new InheritableThreadLocal();
    public static final InheritableThreadLocal<Connection> JMS_CONNECTION_LOCAL = new InheritableThreadLocal();*/

    public JtaContext() {
    }
}
