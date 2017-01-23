package org.emall.cn.dao.impl;

import junit.framework.JUnit4TestAdapter;
import org.aspectj.lang.annotation.Around;
import org.emall.cn.dao.ProjInterProjectDAO;
import org.emall.cn.model.project.ProjInterProject;
import org.emall.cn.model.project.ProjectVO;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ProjInterProjectDAOImplTest {
    @Autowired
    private ProjInterProjectDAO projInterProjectDAO;
    @Test
    public void testFindFeeRemindByParas() throws Exception {
        String createUserId="3";
        List<ProjectVO> list=projInterProjectDAO.findFeeRemindByParas(createUserId);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getSupplierName());
        }
    }

    @Test
    public void testQueryFeeRemindPage_count() throws Exception {
        String createUserId="3";
        Long count=projInterProjectDAO.queryFeeRemindPage_count(createUserId);
        System.out.println(count);
    }
    @Test
    public void testQueryCountUsers() throws Exception {
        int count=projInterProjectDAO.queryCountUsers();
        System.out.println(count);
    }
}