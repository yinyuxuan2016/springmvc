package org.emall.cn.dao;

import org.apache.ibatis.annotations.Param;
import org.emall.cn.model.project.ProjectVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/21
 */
public interface ProjInterProjectDAO {
    List<ProjectVO> findFeeRemindByParas(String createUserId);
    Long queryFeeRemindPage_count(@Param("createUserId") String createUserId);
    int queryCountUsers();
}
