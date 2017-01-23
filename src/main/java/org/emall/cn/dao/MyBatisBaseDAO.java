package org.emall.cn.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.emall.cn.core.pager.Pager;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 封装 DAO，将一些简单的增删改查进行统一处理
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/28
 */
public interface MyBatisBaseDAO<T, PK extends Serializable> {
    int save(T var1);

    List<T> findByCondition(T var1);

    List<T> findByCondition(T var1, int var2, int var3);

    List<T> findByCondition(T var1, Pager var2);

    T findByPK(PK var1, Class<T> var2);

    /**
     * @deprecated
     */
    @Deprecated
    void update(T var1);

    int updateExp(T var1);

    /**
     * @deprecated
     */
    @Deprecated
    void delete(PK var1, Class<T> var2);

    int deleteExp(PK var1, Class<T> var2);

    Integer getTotalCount(T var1);

    /**
     * @deprecated
     */
    @Deprecated
    void insertBatch(Class<T> var1, List<T> var2, Integer var3);

    int insertBatchExp(Class<T> var1, List<T> var2, Integer var3);

    /**
     * @deprecated
     */
    @Deprecated
    void insertBatch(Class<T> var1, List<T> var2);

    int insertBatchExp(Class<T> var1, List<T> var2);

    /**
     * @deprecated
     */
    @Deprecated
    void updateBatch(Class<T> var1, List<T> var2, Integer var3);

    int updateBatchExp(Class<T> var1, List<T> var2, Integer var3);

    /**
     * @deprecated
     */
    @Deprecated
    void deleteBatch(Class<T> var1, List<T> var2, Integer var3);

    int deleteBatchExp(Class<T> var1, List<T> var2, Integer var3);

    SqlSessionTemplate getCurSqlSessionTemplate();

    SqlSessionFactory getCurSqlSessionFactory();
}
