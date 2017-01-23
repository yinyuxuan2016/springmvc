package org.emall.cn.service.impl;

import org.emall.cn.model.project.ProjectVO;
import org.emall.cn.service.ProjInterProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ProjInterProjectServiceImplTest {
    @Autowired
    private ProjInterProjectService projInterProjectService;
    @Test
    public void testFindFeeRemindByParas() throws Exception {
        List<ProjectVO> list=projInterProjectService.findFeeRemindByParas("3");
        for (ProjectVO vo:list
             ) {
            System.out.println(vo.getId()+"_"+vo.getSupplierId());
        }
    }

    @Test
    public void testQueryFeeRemindPage_count() throws Exception {
        Long count=projInterProjectService.queryFeeRemindPage_count("3");
        System.out.println(count);
    }
    @Test
    public void testQueryUsersount() throws Exception {
        int count=projInterProjectService.queryCountUsers();
        System.out.println("用户数量为："+count);
    }
}