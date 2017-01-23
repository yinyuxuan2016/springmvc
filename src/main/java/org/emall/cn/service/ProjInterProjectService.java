package org.emall.cn.service;

import org.apache.ibatis.annotations.Param;
import org.emall.cn.model.project.ProjectVO;

import java.util.List;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/23
 */
public interface ProjInterProjectService {
    List<ProjectVO> findFeeRemindByParas(String createUserId);
    Long queryFeeRemindPage_count(String createUserId);
    int queryCountUsers();
}
