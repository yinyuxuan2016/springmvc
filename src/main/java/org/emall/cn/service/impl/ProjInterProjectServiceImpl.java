package org.emall.cn.service.impl;

import org.aspectj.lang.annotation.Around;
import org.emall.cn.dao.ProjInterProjectDAO;
import org.emall.cn.model.project.ProjectVO;
import org.emall.cn.service.ProjInterProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/23
 */
@Transactional
@Service
public class ProjInterProjectServiceImpl implements ProjInterProjectService{
    @Autowired
    private ProjInterProjectDAO projInterProjectDAO;
    @Override
    public List<ProjectVO> findFeeRemindByParas(String createUserId) {
        return projInterProjectDAO.findFeeRemindByParas(createUserId);
    }
    @Override
    public Long queryFeeRemindPage_count(String createUserId) {
        return projInterProjectDAO.queryFeeRemindPage_count(createUserId);
    }
    @Override
    public int queryCountUsers() {
        return projInterProjectDAO.queryCountUsers();
    }
}
