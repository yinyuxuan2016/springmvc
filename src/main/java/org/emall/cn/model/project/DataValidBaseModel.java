/*
 * Copyright (c) 2001-2015 Bidlink(Beijing) E-Biz Tech Co.,Ltd.
 * All rights reserved.
 * 必联（北京）电子商务科技有限公司 版权所有
 */

package org.emall.cn.model.project;

/**
 * @description:	 工作流子流程审批触发的数据有效性BaseModel对象
 * @version  Ver 1.0
 * @author   <a href="mailto:huyu@ebnew.com">huyu</a>
 * @Date	 2012-11-20 下午4:41:57
 */
public class DataValidBaseModel extends BaseModel {

	/**
	 * @description serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	/**
    * 描述:数据有效性     
    * 字段: DATA_VALID  TINYINT(4)   0-无效    1-有效
    */
	private Integer dataValid;

	public Integer getDataValid() {
		return dataValid;
	}

	public void setDataValid(Integer dataValid) {
		this.dataValid = dataValid;
	}

}
