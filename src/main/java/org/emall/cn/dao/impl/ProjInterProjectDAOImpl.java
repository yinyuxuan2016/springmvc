package org.emall.cn.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.emall.cn.core.interfaces.BiDSChoicer;
import org.emall.cn.dao.ProjInterProjectDAO;
import org.emall.cn.dao.dataSource.MultipleDataSource;
import org.emall.cn.model.project.ProjectVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/21
 */
@Component
public class ProjInterProjectDAOImpl implements ProjInterProjectDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<ProjectVO> findFeeRemindByParas(String createUserId) {
        return sqlSessionTemplate.selectList(ProjectVO.class.getCanonicalName()+".findFeeRemindByParas",createUserId);
    }

    public Long queryFeeRemindPage_count(@Param("createUserId") String createUserId) {
        return sqlSessionTemplate.selectOne(ProjectVO.class.getName()+".queryFeeRemindPage_count",createUserId);
    }
    @BiDSChoicer(dsName="key2")
    public int queryCountUsers() {
        //MultipleDataSource.setDataSourceKey("key2");
        return sqlSessionTemplate.selectOne(ProjectVO.class.getName()+".queryCountUsers");
    }
}
