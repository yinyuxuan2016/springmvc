package org.emall.cn.dao.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.emall.cn.common.CurrentSession;
import org.emall.cn.core.exceptions.BusinessException;
import org.emall.cn.core.pager.Pager;
import org.emall.cn.dao.MyBatisBaseDAO;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @Description 此处将mybatis的基础实现类作为泛型，可以支持多种数据结构进行匹配
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/28
 */
public class MyBatisBaseDAOImpl<T, PK extends Serializable> implements MyBatisBaseDAO<T, PK>{
    private static Logger logger = Logger.getLogger(MyBatisBaseDAOImpl.class);
    public String INSERT = ".insert";
    public String INSERT_BATCH = ".insertBatch";
    public String UPDATE = ".update";
    public String DELETE = ".delete";
    public String GETBYID = ".getById";
    public String COUNT = ".findPage_count";
    public String PAGESELECT = ".findPage";

    public MyBatisBaseDAOImpl() {
    }

    public int save(T var1) {
        if (var1==null){
            throw new BusinessException("object can not be null");
        }/*else if(JtaContext.TRANSACTION_LOCAL.get() != null) {
            SqlSession session = this.getCurSqlSessionFactory().openSession(false);
            this.setAutoCommit(session.getConnection(), false);
            ((Vector)JtaContext.CONNECTION_HOLDER.get()).add(session);
            return session.insert(object.getClass().getName() + this.INSERT, object);
        }*/ else {
            return this.getCurSqlSessionTemplate().insert(var1.getClass().getName() + this.INSERT, var1);
        }
    }

    public List<T> findByCondition(T var1) {
        if(var1==null){
            throw new BusinessException("condition can not be null");
        }else{
            return this.getCurSqlSessionTemplate().selectList(var1.getClass().getName()+this.PAGESELECT,var1);
        }
    }

    public List<T> findByCondition(T var1, int var2, int var3) {
        if(var1==null){
            throw new BusinessException("condition can not be null");
        }
        RowBounds rowBounds=new RowBounds(var2,var3);
        return this.getCurSqlSessionTemplate().selectList(var1.getClass().getName()+this.PAGESELECT,var1,rowBounds);
    }

    public List<T> findByCondition(T obj, Pager pager) {
        if(obj == null) {
            throw new BusinessException(" condition can\'t null!");
        } else {
            return pager != null?this.findByCondition(obj, pager.getStartRow(), pager.getPageSize()):this.findByCondition(obj);
        }
    }

    public T findByPK(PK pk, Class<T> cls) {
        if(pk == null) {
            throw new BusinessException(" pk can\'t null!");
        } else {
            return this.getCurSqlSessionTemplate().selectOne(cls.getName() + this.GETBYID, pk);
        }
    }

    public void update(T object) {
        if(object == null) {
            throw new BusinessException(" object can\'t null!");
        } else {
            this.getCurSqlSessionTemplate().update(object.getClass().getName() + this.UPDATE, object);
        }
    }

    public int updateExp(T object) {
        if(object == null) {
            throw new BusinessException(" object can\'t null!");
        } else {
            return this.getCurSqlSessionTemplate().update(object.getClass().getName() + this.UPDATE, object);
        }
    }

    public void delete(PK pk, Class<T> cls) {
        if(pk == null) {
            throw new BusinessException(" pk can\'t null!");
        } else {
            this.getCurSqlSessionTemplate().delete(cls.getName() + this.DELETE, pk);
        }
    }

    public int deleteExp(PK pk, Class<T> cls) {
        if(pk == null) {
            throw new BusinessException(" pk can\'t null!");
        } else {
            return this.getCurSqlSessionTemplate().delete(cls.getName() + this.DELETE, pk);
        }
    }

    public Integer getTotalCount(T object) {
        if(object == null) {
            throw new BusinessException(" condition can\'t null!");
        } else {
            Object obj = this.getCurSqlSessionTemplate().selectOne(object.getClass().getName() + this.COUNT, object);
            return obj != null?Integer.valueOf(Integer.parseInt(obj.toString())):Integer.valueOf(0);
        }
    }

    /**
     * 此处需要说明的是：批量插入是分为两个参数和三个参数
     * 其中两个参数的批插入是将集合或者数组全部遍历，然后一次性提交，这种如果是数据量小，没有任何问题，
     * 如果数据量大则会产生高并发的操作，所以有了第三个参数就解决了此类问题
     * 第三个参数是限制commit的数量，这样就会按照限制的数量进行提交，提交多次，这样就避免了高并发的操作
     * @param cls
     * @param domainList
     * @param count
     */
    public void insertBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if(domainList == null) {
                return;
            }
            sqlSession = this.getCurSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int e = 0;
            Iterator i$ = domainList.iterator();

            while(i$.hasNext()) {
                Object t = i$.next();
                sqlSession.insert(cls.getName() + this.INSERT, t);
                ++e;
                if(count.intValue() == e) {
                    sqlSession.commit();
                    e = 0;
                }
            }
        } catch (Exception var11) {
                sqlSession.rollback(true);
            logger.error(var11.getMessage(), var11);
            throw new RuntimeException(var11.getMessage(), var11);
        } finally {
                sqlSession.close();
        }

    }
    /**
     * 此处需要说明的是：批量插入是分为两个参数和三个参数
     * 其中两个参数的批插入是将集合或者数组全部遍历，然后一次性提交，这种如果是数据量小，没有任何问题，
     * 如果数据量大则会产生高并发的操作，所以有了第三个参数就解决了此类问题
     * 第三个参数是限制commit的数量，这样就会按照限制的数量进行提交，提交多次，这样就避免了高并发的操作
     * @param cls
     * @param domainList
     * @param count
     */
    public int insertBatchExp(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;

        try {
            if(domainList == null) {
                byte var13 = 0;
                return var13;
            }
            sqlSession = this.getCurSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int e = 0;
            Iterator i$ = domainList.iterator();

            while(true) {
                Object t = i$.next();
                sqlSession.insert(cls.getName() + this.INSERT, t);
                ++e;
                if(count.intValue() == e) {
                    sqlSession.commit();
                    e = 0;
                }
            }
        } catch (Exception var11) {
                sqlSession.rollback(true);
            logger.error(var11.getMessage(), var11);
            throw new RuntimeException(var11.getMessage(), var11);
        } finally {
                sqlSession.close();
            return domainList.size();
        }
    }

    public void insertBatch(Class<T> cls, List<T> domainList) {
        this.getCurSqlSessionTemplate().insert(cls.getName() + this.INSERT_BATCH, domainList);
    }

    public int insertBatchExp(Class<T> cls, List<T> domainList) {
        return this.getCurSqlSessionTemplate().insert(cls.getName() + this.INSERT_BATCH, domainList);
    }
    /**
     * 此处需要说明的是：批量插入是分为两个参数和三个参数
     * 其中两个参数的批插入是将集合或者数组全部遍历，然后一次性提交，这种如果是数据量小，没有任何问题，
     * 如果数据量大则会产生高并发的操作，所以有了第三个参数就解决了此类问题
     * 第三个参数是限制commit的数量，这样就会按照限制的数量进行提交，提交多次，这样就避免了高并发的操作
     * @param cls
     * @param domainList
     * @param count
     */
    public void updateBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if(domainList == null) {
                return;
            }
            sqlSession = this.getCurSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int e = 0;
            Iterator i$ = domainList.iterator();

            while(i$.hasNext()) {
                Object t = i$.next();
                sqlSession.update(cls.getName() + this.UPDATE, t);
                ++e;
                if(count.intValue() == e) {
                    sqlSession.commit();
                    e = 0;
                }
            }
        } catch (Exception var11) {
                sqlSession.rollback(true);
            logger.error(var11.getMessage(), var11);
            throw new RuntimeException(var11.getMessage(), var11);
        } finally {
                sqlSession.close();
        }
    }

    public int updateBatchExp(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;

        try {
            if(domainList == null) {
                byte var13 = 0;
                return var13;
            }

            sqlSession = this.getCurSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int e = 0;
            Iterator i$ = domainList.iterator();

            while(true) {
                if(!i$.hasNext()) {
                    break;
                }

                Object t = i$.next();
                sqlSession.update(cls.getName() + this.UPDATE, t);
                ++e;
                if(count.intValue() == e) {
                    sqlSession.commit();
                    e = 0;
                }
            }
        } catch (Exception var11) {
                sqlSession.rollback(true);
            logger.error(var11.getMessage(), var11);
            throw new RuntimeException(var11.getMessage(), var11);
        } finally {
                sqlSession.close();
        }

        return domainList.size();
    }

    public void deleteBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if(domainList == null) {
                return;
            }
            sqlSession = this.getCurSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int e = 0;
            Iterator i$ = domainList.iterator();

            while(i$.hasNext()) {
                Object t = i$.next();
                sqlSession.delete(cls.getName() + this.DELETE, t);
                ++e;
                if(count.intValue() == e) {
                    sqlSession.commit();
                    e = 0;
                }
            }
        } catch (Exception var11) {
                sqlSession.rollback(true);
            logger.error(var11.getMessage(), var11);
            throw new RuntimeException(var11.getMessage(), var11);
        } finally {
                sqlSession.close();
        }

    }

    public int deleteBatchExp(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if(domainList == null) {
                byte var13 = 0;
                return var13;
            }

            sqlSession = this.getCurSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int e = 0;
            Iterator i$ = domainList.iterator();

            while(i$.hasNext()) {
                Object t = i$.next();
                sqlSession.delete(cls.getName() + this.DELETE, t);
                ++e;
                if(count.intValue() == e) {
                    sqlSession.commit();
                    e = 0;
                }
            }
        } catch (Exception var11) {
                sqlSession.rollback(true);
            logger.error(var11.getMessage(), var11);
            throw new RuntimeException(var11.getMessage(), var11);
        } finally {
                sqlSession.close();
                return domainList.size();
     }
    }

    public SqlSessionTemplate getCurSqlSessionTemplate() {
        CurrentSession currentSession=new CurrentSession(null);
        return currentSession.getSqlSessionTemplate();
    }

    public SqlSessionFactory getCurSqlSessionFactory() {
        CurrentSession currentSession=new CurrentSession(null);
        return currentSession.getSqlSessionFactory();
    }
    private void setAutoCommit(Connection con, boolean autoCommit) {
        try {
            if(con != null) {
                con.setAutoCommit(autoCommit);
            }
        } catch (Exception var4) {
            ;
        }

    }
}
