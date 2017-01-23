package org.emall.cn.controller;

import org.emall.cn.model.project.ProjectVO;
import org.emall.cn.service.ProjInterProjectService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/23
 */
@Controller
public class ProjInterProjectController {
    public final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
    @Autowired
    private ProjInterProjectService projInterProjectService;
    @RequestMapping(value="/list")
    public String list(Model model){
        logger.info("=======进入到列表页面======");
        String createUser="3";
        List<ProjectVO> list=projInterProjectService.findFeeRemindByParas(createUser);
        logger.info("list{}"+list);
        model.addAttribute("list",list);
        int count=projInterProjectService.queryCountUsers();
        logger.info("demo库的用户人数为："+count);
        model.addAttribute("count",count);
        //测试多数据源的切换
        return "project/list";
    }
    @RequestMapping(value="/test")
    public String test(){
        return "project/test";
    }
}
