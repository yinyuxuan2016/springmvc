package org.emall.cn.dao.adivce;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.emall.cn.core.interfaces.JTATransaction;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/5
 */
@Aspect
@Component
@Order(0)
public class JTAInterceptor {
    private static final Logger logger = Logger.getLogger(JTAInterceptor.class);
    public JTAInterceptor() {
    }
/*
    @Around(
            value = "execution(* *org.emall.cn.service.impl.*ServiceImpl.* (..))",
            argNames = "pjp"
    )
    public Object doException(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        Method method = null;
        JtaModel model = null;
        JTATransaction jtaTran = null;
        try {
            Signature e = pjp.getSignature();
            if(e instanceof MethodSignature) {
                MethodSignature methodSign = (MethodSignature)e;
                method = methodSign.getMethod();
                jtaTran = (JTATransaction)method.getAnnotation(JTATransaction.class);
                if(jtaTran != null && JtaContext.TRANSACTION_LOCAL.get() == null) {
                    JtaContext.TRANSACTION_LOCAL.set(new JtaModel(System.currentTimeMillis(), method));
                    JtaContext.CONNECTION_HOLDER.set(new Vector());
                }
            }

            obj = pjp.proceed();
            model = (JtaModel)JtaContext.TRANSACTION_LOCAL.get();
            if(jtaTran != null && method != null && model != null && method.hashCode() == model.getMethod().hashCode()) {
                this.commitAllTransaction();
            }
        } catch (Throwable var11) {
            if(jtaTran != null) {
                this.rollbackAll();
            }

            throw var11;
        } finally {
            model = (JtaModel)JtaContext.TRANSACTION_LOCAL.get();
            if(jtaTran != null && method != null && model != null && method.hashCode() == model.getMethod().hashCode()) {
                this.removeCurThreadLocal(model);
            }

        }

        return obj;
    }

    private void removeCurThreadLocal(JtaModel model) {
        try {
            JtaContext.TRANSACTION_LOCAL.remove();
            JtaContext.CONNECTION_HOLDER.remove();
            JtaContext.JMS_SESSION_LOCAL.remove();
            JtaContext.JMS_CONNECTION_LOCAL.remove();
            logger.debug("grobal trancation cost time :" + (System.currentTimeMillis() - model.getStartTime()) + "ms");
        } catch (Exception var3) {
            logger.error(var3.getMessage(), var3);
        }

    }

    private void commitAllTransaction() {
        Vector vectorList = (Vector)JtaContext.CONNECTION_HOLDER.get();
        if(vectorList != null && vectorList.size() > 0) {
            Iterator session;
            SqlSession jmsCon;
            if(this.executeTest(vectorList)) {
                session = vectorList.iterator();

                while(session.hasNext()) {
                    jmsCon = (SqlSession)session.next();
                    this.setAutoCommit(jmsCon.getConnection(), true);
                    this.commit(jmsCon);
                }
            } else {
                session = vectorList.iterator();

                while(session.hasNext()) {
                    jmsCon = (SqlSession)session.next();
                    this.rollback(jmsCon);
                }
            }
        }

        Session session1 = (Session)JtaContext.JMS_SESSION_LOCAL.get();
        Connection jmsCon1 = (Connection)JtaContext.JMS_CONNECTION_LOCAL.get();
        if(session1 != null) {
            this.commitIfNecessary(session1);
        }

        if(jmsCon1 != null) {
            this.closeJmsConnection(jmsCon1);
        }

    }

    private void commitIfNecessary(Session session) {
        Assert.notNull(session, "Session must not be null");

        try {
            session.commit();
        } catch (Exception var10) {
            throw new BidJmsException(var10);
        } finally {
            try {
                session.close();
            } catch (JMSException var9) {
                throw new BidJmsException(var9);
            }
        }

    }

    private void rollbackIfNecessary(Session session) {
        Assert.notNull(session, "Session must not be null");

        try {
            session.rollback();
        } catch (Exception var10) {
            throw new BidJmsException(var10);
        } finally {
            try {
                session.close();
            } catch (JMSException var9) {
                throw new BidJmsException(var9);
            }
        }

    }

    private void closeJmsConnection(Connection connection) {
        Assert.notNull(connection, "jms connection must not be null");

        try {
            connection.close();
        } catch (JMSException var3) {
            throw new BidJmsException(var3);
        }
    }

    private void rollbackAll() {
        Vector vectorList = (Vector)JtaContext.CONNECTION_HOLDER.get();
        if(vectorList != null && vectorList.size() > 0) {
            Iterator session = vectorList.iterator();

            while(session.hasNext()) {
                SqlSession jmsCon = (SqlSession)session.next();
                this.rollback(jmsCon);
            }
        }

        Session session1 = (Session)JtaContext.JMS_SESSION_LOCAL.get();
        Connection jmsCon1 = (Connection)JtaContext.JMS_CONNECTION_LOCAL.get();
        if(session1 != null) {
            this.rollbackIfNecessary(session1);
        }

        if(jmsCon1 != null) {
            this.closeJmsConnection(jmsCon1);
        }

    }

    private void commit(SqlSession sqlSession) {
        try {
            sqlSession.commit(true);
        } catch (Exception var6) {
            logger.error(var6.getMessage(), var6);
        } finally {
            sqlSession.close();
        }

    }

    private void rollback(SqlSession sqlSession) {
        try {
            sqlSession.rollback(true);
        } catch (Exception var6) {
            logger.error(var6.getMessage(), var6);
        } finally {
            sqlSession.close();
        }

    }

    private boolean executeTest(Vector<SqlSession> vectorList) {
        if(vectorList == null) {
            return false;
        } else {
            Iterator i$ = vectorList.iterator();

            SqlSession session;
            do {
                if(!i$.hasNext()) {
                    return true;
                }

                session = (SqlSession)i$.next();
            } while(this.checkConnection(session));

            return false;
        }
    }

    private boolean checkConnection(SqlSession session) {
        try {
            java.sql.Connection e = session.getConnection();
            Statement stmt = e.createStatement();
            stmt.executeQuery("select \'x\' ");
            stmt.close();
            return true;
        } catch (Exception var4) {
            logger.error(var4.getMessage(), var4);
            return false;
        }
    }

    private void setAutoCommit(java.sql.Connection con, boolean autoCommit) {
        try {
            if(con != null) {
                con.setAutoCommit(autoCommit);
            }
        } catch (Exception var4) {

        }

    }*/
}
