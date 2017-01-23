/*
 * Copyright (c) 2001-2015 Bidlink(Beijing) E-Biz Tech Co.,Ltd.
 * All rights reserved.
 * 必联（北京）电子商务科技有限公司 版权所有
 */
package org.emall.cn.model.project;

import org.emall.cn.common.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author <a href="mailto:zuiwoxing@gmail.com">SYSTEM</a>
 * @version Ver 1.0
 * @description: 项目表
 * @table PROJ_INTER_PROJECT
 * @Date 2012 2012-9-5 上午9:37:37
 */
public class ProjInterProject extends DataValidBaseModel {

    /**
     * @description serialVersionUID:（用一句话描述这个变量表示什么）
     */

    private static final long serialVersionUID = 1L;

    /**
     * 描述:ID生成策略： 自增长 字段: ID BIGINT(19)
     */
    private Long id;

    /**
     * 描述:编号生成规则：公司内不能重复,如果是重新招标时不能修改.如果是分级拆分项目，同一级编号连续，不同级编号添加下一级的两位序号。 字段:
     * PROJECT_NUMBER VARCHAR(500)
     */
    private String projectNumber;

    /**
     * 描述:项目名称 字段: PROJECT_NAME VARCHAR(256)
     */
    private String projectName;

    /**
     * 描述:项目英文名称 字段: ENGLISH_NAME VARCHAR(256)
     */
    private String englishName;

    /**
     * 描述:项目建设地区.默认状态选择提取建项人的所属地区 字段: REGION_CODE VARCHAR(50)
     */
    private String regionCode;

    /**
     * 描述:项目建设地区.默认状态选择提取建项人的所属地区 字段: REGION VARCHAR(50)
     */
    private String region;
    /**
     * 描述:招标人id号.委托机构建项时才有这一项.可以选择多个,多个招标人时以逗号隔开 字段: TENDERINGS VARCHAR(1000)
     */
    private String tenderings;

    /**
     * 描述:招标人名称，多个招标人时用逗号分隔 字段: TENDER_NAMES VARCHAR(550)
     */
    private String tenderNames;

    /**
     * 描述:1依法必招; 2非依法必招 字段: IS_ACCORDING_TO_THE_LAW TINYINT(3)
     */
    private Integer isAccordingToTheLaw;

    /**
     * 描述:1代表公开招标,2代表邀请招标 当选择公开招标时,是否资格预审才会显示 字段: TENDER_MODE TINYINT(3)
     */
    private Integer tenderMode;

    /**
     * 描述:1代表需要资格预审，2代表不需要资格预审. 选择不需要资格预审时,是否二阶段招标才会显示 字段: IS_PREQUALIFY
     * TINYINT(3)
     */
    private Integer isPrequalify;

    /**
     * 描述:1代表是两阶段招标， 2代表不两阶段招标 字段: IS_TWO_STAGE TINYINT(3)
     */
    private Integer isTwoStage;

    /**
     * 描述:1代表在线投标,2代表线下投标 字段: IS_ONLINE_BIDDING TINYINT(3)
     */
    private Integer isOnlineBidding;

    /**
     * 描述:监管部门id 字段: MANAGE_DEPARTMENT_ID VARCHAR(100)
     */
    private String manageDepartmentId;

    /**
     * 描述:其他监管部门ids, 可以多选, 字符串以逗号隔开 字段: OTHER_MANAGE_DEPARTMENT_IDS VARCHAR(500)
     */
    private String otherManageDepartmentIds;

    /**
     * 描述:1代表机电产品 2代表重大设备 字段: KIND TINYINT(3)
     */
    private Integer kind;

    /**
     * 描述:1代表现汇项目,2代表世行,3代表亚行,4代表日贷,5代表外国政府贷款 字段: FUNDS_SOURCE TINYINT(3)
     */
    private Integer fundsSource;

    /**
     * 描述:根据项目性质的相关选择进行显示和隐藏: 选择的是 现汇项目,则没有填写贷款编号和贷款国家的行; 选择的是世行、亚行、日贷,则有填写编号的行;
     * 选择的是外国政府贷款,则有编号和国家选择的行,编号还是一个文本框,国家能选择多个 字段: LOAN_NUMBER VARCHAR(200)
     */
    private String loanNumber;

    /**
     * 描述:贷款国家字段填充用','分割的贷款国家名称 字段: LOAN_COUNTRY VARCHAR(1000)
     */
    private String loanCountry;

    /**
     * 描述:1代表支持联合体投标 2代表不支持联合体投标 字段: IS_SUPPORT_UNION TINYINT(3)
     */
    private Integer isSupportUnion;

    /**
     * 描述:项目主管单位名称 字段: MANAGE_MONAD VARCHAR(100)
     */
    private String manageMonad;

    /**
     * 描述:项目备案文号 字段: RECORD_SYMBOL VARCHAR(256)
     */
    private String recordSymbol;

    /**
     * 描述:委托机构建项目时填写的委托文档的id 字段: ENTRUST_DOC_ID  VARCHAR(255)
     */
    private String entrustDocId;

    /**
     * 描述:委托日期 字段: ENTRUST_DATE DATETIME(19)
     */
    @DateTimeFormat(pattern = DateUtils.DATE)
    private Date entrustDate;
    // 【非数据库字段，查询时使用】
    @DateTimeFormat(pattern = DateUtils.DATE)
    private Date entrustDateBegin;
    // 【非数据库字段，查询时使用】
    @DateTimeFormat(pattern = DateUtils.DATE)
    private Date entrustDateEnd;


    /**
     * 描述:项目内容 字段: CONTENTS TEXT(65535)
     */
    private String contents;

    /**
     * 描述:建项人的ID 字段: CREATER_ID BIGINT(19)
     */
    private Long createrId;

    /**
     * 描述:项目启动后关联的流程实例ID 字段: PROCESS_INSTANCE_ID VARCHAR(64)
     */
    private String processInstanceId;

    /**
     * 描述:流程流转到某一节点的任务id 字段: TASK_ID VARCHAR(64)
     */
    private String taskId;

    /**
     * 描述:后序结点通过此字段判断是否有联合体参与投标 字段: IS_CHOOSED_UNION TINYINT(3)
     */
    private Integer isChoosedUnion;

    /**
     * 描述:1代表不是项目拆分目录 2代表是项目拆分目录 字段: IS_PROJECT_DIRECTORY TINYINT(3)
     */
    private Integer isProjectDirectory;

    /**
     * 描述:直接父目录的项目id 字段: PARENT_ID BIGINT(19)
     */
    private Long parentId;

    /**
     * 描述:根目录的项目ID 字段: ROOT_ID BIGINT(19)
     */
    private Long rootId;

    /**
     * 描述:1代表全新建项 2代表建立委托招标后建项 3代表重新招标 4代表返回修改 字段: PROJECT_TYPE TINYINT(3)
     */
    private Integer projectType;

    /**
     * 描述:1代表项目建档 2代表资格预审 3代表招标公告 4代表项目开标 5代表项目评标 6代表中标候选人 7代表项目公示 8代表项目确定中标人
     * 9代表项目归档 10代表已重新招标 11代表已归档 12代表已撤项 字段: PROJECT_STATUS TINYINT(3)
     */
    private Integer projectStatus;

    /**
     * 描述:委托表ID 字段: PROJ_ENTRUST_ID BIGINT(19)
     */
    private Long projEntrustId;

    /**
     * 描述:项目英文内容 字段: ENGLISH_CONTENTS TEXT(65535)
     */
    private String englishContents;

    /**
     * 描述:建项人名称 字段: CREATER_NAME VARCHAR(255)
     */
    private String createrName;

    /**
     * 描述:建项日期 字段: CREATE_TIME DATETIME(19)
     */
    private Date createTime;
    // 【非数据库字段，查询时使用】
    private Date createTimeBegin;
    // 【非数据库字段，查询时使用】
    private Date createTimeEnd;

    /**
     * 描述:1 一家直采  非1代表非1家直采
     */
    private Integer isDirectBidding;

    /**
     * 更改允许现汇项目（两家或一家开标）oms修改调用     1 允许两家或一家  默认0不允许
     */
    private Integer bidCountValidateFlag;
    /**
     * 时间编号 政务唯一标识
     */
    private Long timeNumber;

    private String taskPlan;
    /**
     * 向政务发送数据的状态，目前只是用在项目公示阶段,如果为5代表已经发布过
     */
    private Integer sendStatus;

    /**
     * 是否向政务发送做中标公告
     **/
    private Integer isSendDecidedData;


    /**
     * 是否向政务发送过专家评价信息
     */
    private Integer isSendExpertJuderopinion;

    /**
     * 是否同步更新
     **/
    private Integer concurrentUpdate;

    public Integer getConcurrentUpdate() {
        return concurrentUpdate;
    }

    public void setConcurrentUpdate(Integer concurrentUpdate) {
        this.concurrentUpdate = concurrentUpdate;
    }

    public Integer getIsSendExpertJuderopinion() {
        return isSendExpertJuderopinion;
    }

    public void setIsSendExpertJuderopinion(Integer isSendExpertJuderopinion) {
        this.isSendExpertJuderopinion = isSendExpertJuderopinion;
    }

    public Integer getIsSendDecidedData() {
        return isSendDecidedData;
    }

    public void setIsSendDecidedData(Integer isSendDecidedData) {
        this.isSendDecidedData = isSendDecidedData;
    }


    /**
     * 临时数据 暂存
     */
    private Integer tempData;

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }


    @DateTimeFormat(pattern = DateUtils.DATE)
    private Date tenderTime;
    private String responsibility;
    private String responsiblePerson;
    private String legalPerson;
    private String projectDocId;
    private String projectDocName;

    private String techTenderDocId;
    private String techTenderDocName;

    public String getTechTenderDocId() {
        return techTenderDocId;
    }

    public void setTechTenderDocId(String techTenderDocId) {
        this.techTenderDocId = techTenderDocId;
    }

    public String getTechTenderDocName() {
        return techTenderDocName;
    }

    public void setTechTenderDocName(String techTenderDocName) {
        this.techTenderDocName = techTenderDocName;
    }


    private String invitationDocId;
    private String invitationDocName;
    private String entrustDocName;
    private String projectPropertyCode;
    private Long tenderMain;
    private String InvitationReason;
    private String entrustOrgCode;
    private Long createUserId;
    private Integer shield;
    private Integer tenderForm;
    private String entrustAuthorizeExplain;
    private Integer fundNature;
    private String createUserName;
    private Double projectAmountRmb;
    private Double projectAmountUsd;
    private String industryCode;
    private String projectNature;

    /**
     * 描述:是否已经保存 1为保存 非1为未保存
     * 字段: IS_SAVED  TINYINT(3)
     */
    private Integer isSaved;

    /**
     * 描述:捆绑项目ID
     * 字段: bind_ID  BIGINT(19)
     */
    private Long bindId;

    /**
     * 保存重招时的 项目节点
     */
    private Integer rebidMark;

    private Long preTenderMettingId;

    public Long getPreTenderMettingId() {
        return preTenderMettingId;
    }

    public void setPreTenderMettingId(Long preTenderMettingId) {
        this.preTenderMettingId = preTenderMettingId;
    }

    public Integer getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Integer isSaved) {
        this.isSaved = isSaved;
    }

    public Long getBindId() {
        return bindId;
    }

    public void setBindId(Long bindId) {
        this.bindId = bindId;
    }

    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Double getProjectAmountRmb() {
        return projectAmountRmb;
    }

    public void setProjectAmountRmb(Double projectAmountRmb) {
        this.projectAmountRmb = projectAmountRmb;
    }

    public Double getProjectAmountUsd() {
        return projectAmountUsd;
    }

    public void setProjectAmountUsd(Double projectAmountUsd) {
        this.projectAmountUsd = projectAmountUsd;
    }

    public Integer getTempData() {
        return tempData;
    }

    public void setTempData(Integer tempData) {
        this.tempData = tempData;
    }

    public Long getTimeNumber() {
        return timeNumber;
    }

    public void setTimeNumber(Long timeNumber) {
        this.timeNumber = timeNumber;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getFundNature() {
        return fundNature;
    }

    public void setFundNature(Integer fundNature) {
        this.fundNature = fundNature;
    }

    public Integer getShield() {
        return shield;
    }

    public void setShield(Integer shield) {
        this.shield = shield;
    }

    public Integer getTenderForm() {
        return tenderForm;
    }

    public void setTenderForm(Integer tenderForm) {
        this.tenderForm = tenderForm;
    }

    public String getEntrustAuthorizeExplain() {
        return entrustAuthorizeExplain;
    }

    public void setEntrustAuthorizeExplain(String entrustAuthorizeExplain) {
        this.entrustAuthorizeExplain = entrustAuthorizeExplain;
    }

    public String getEntrustOrgCode() {
        return entrustOrgCode;
    }

    public void setEntrustOrgCode(String entrustOrgCode) {
        this.entrustOrgCode = entrustOrgCode;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getTenderMain() {
        return tenderMain;
    }

    public void setTenderMain(Long tenderMain) {
        this.tenderMain = tenderMain;
    }

    public String getInvitationReason() {
        return InvitationReason;
    }

    public void setInvitationReason(String invitationReason) {
        InvitationReason = invitationReason;
    }

    public ProjInterProject() {
    }

    public String getProjectPropertyCode() {
        return projectPropertyCode;
    }

    public void setProjectPropertyCode(String projectPropertyCode) {
        this.projectPropertyCode = projectPropertyCode;
    }

    public String getTaskPlan() {
        return taskPlan;
    }


    public Date getTenderTime() {
        return tenderTime;
    }

    public Integer getRebidMark() {
        return rebidMark;
    }

    public void setRebidMark(Integer rebidMark) {
        this.rebidMark = rebidMark;
    }

    public void setTenderTime(Date tenderTime) {
        this.tenderTime = tenderTime;
    }

    public String getProjectDocId() {
        return projectDocId;
    }

    public void setProjectDocId(String projectDocId) {
        this.projectDocId = projectDocId;
    }

    public String getInvitationDocId() {
        return invitationDocId;
    }

    public void setInvitationDocId(String invitationDocId) {
        this.invitationDocId = invitationDocId;
    }

    public void setEntrustDocId(String entrustDocId) {
        this.entrustDocId = entrustDocId;
    }

    public void setTaskPlan(String taskPlan) {
        this.taskPlan = taskPlan;
    }


    public String getResponsibility() {
        return responsibility;
    }


    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }


    public String getResponsiblePerson() {
        return responsiblePerson;
    }


    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }


    public String getLegalPerson() {
        return legalPerson;
    }


    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getProjectDocName() {
        return projectDocName;
    }


    public void setProjectDocName(String projectDocName) {
        this.projectDocName = projectDocName;
    }

    public String getInvitationDocName() {
        return invitationDocName;
    }


    public void setInvitationDocName(String invitationDocName) {
        this.invitationDocName = invitationDocName;
    }


    public String getEntrustDocName() {
        return entrustDocName;
    }


    public void setEntrustDocName(String entrustDocName) {
        this.entrustDocName = entrustDocName;
    }

    public Integer getIsDirectBidding() {
        return isDirectBidding;
    }


    public void setIsDirectBidding(Integer isDirectBidding) {
        this.isDirectBidding = isDirectBidding;
    }


    public ProjInterProject(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber() {
        return this.projectNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishName() {
        return this.englishName;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setTenderings(String tenderings) {
        this.tenderings = tenderings;
    }

    public String getTenderings() {
        return this.tenderings;
    }

    public void setTenderNames(String tenderNames) {
        this.tenderNames = tenderNames;
    }

    public String getTenderNames() {
        return this.tenderNames;
    }

    public void setIsAccordingToTheLaw(Integer isAccordingToTheLaw) {
        this.isAccordingToTheLaw = isAccordingToTheLaw;
    }

    public Integer getIsAccordingToTheLaw() {
        return this.isAccordingToTheLaw;
    }

    public void setTenderMode(Integer tenderMode) {
        this.tenderMode = tenderMode;
    }

    public Integer getTenderMode() {
        return this.tenderMode;
    }

    public void setIsPrequalify(Integer isPrequalify) {
        this.isPrequalify = isPrequalify;
    }

    public Integer getIsPrequalify() {
        return this.isPrequalify;
    }

    public void setIsTwoStage(Integer isTwoStage) {
        this.isTwoStage = isTwoStage;
    }

    public Integer getIsTwoStage() {
        return this.isTwoStage;
    }

    public void setIsOnlineBidding(Integer isOnlineBidding) {
        this.isOnlineBidding = isOnlineBidding;
    }

    public Integer getIsOnlineBidding() {
        return this.isOnlineBidding;
    }

    public void setManageDepartmentId(String manageDepartmentId) {
        this.manageDepartmentId = manageDepartmentId;
    }

    public String getManageDepartmentId() {
        return this.manageDepartmentId;
    }

    public void setOtherManageDepartmentIds(String otherManageDepartmentIds) {
        this.otherManageDepartmentIds = otherManageDepartmentIds;
    }

    public String getOtherManageDepartmentIds() {
        return this.otherManageDepartmentIds;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Integer getKind() {
        return this.kind;
    }

    public void setFundsSource(Integer fundsSource) {
        this.fundsSource = fundsSource;
    }

    public Integer getFundsSource() {
        return this.fundsSource;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanNumber() {
        return this.loanNumber;
    }

    public void setLoanCountry(String loanCountry) {
        this.loanCountry = loanCountry;
    }

    public String getLoanCountry() {
        return this.loanCountry;
    }

    public void setIsSupportUnion(Integer isSupportUnion) {
        this.isSupportUnion = isSupportUnion;
    }

    public Integer getIsSupportUnion() {
        return this.isSupportUnion;
    }

    public void setManageMonad(String manageMonad) {
        this.manageMonad = manageMonad;
    }

    public String getManageMonad() {
        return this.manageMonad;
    }

    public void setRecordSymbol(String recordSymbol) {
        this.recordSymbol = recordSymbol;
    }

    public String getRecordSymbol() {
        return this.recordSymbol;
    }

    public String getEntrustDocId() {
        return entrustDocId;
    }

    public void setEntrustDate(Date entrustDate) {
        this.entrustDate = entrustDate;
    }

    public Date getEntrustDate() {
        return this.entrustDate;
    }

    public void setEntrustDateBegin(Date entrustDateBegin) {
        this.entrustDateBegin = entrustDateBegin;
    }

    public Date getEntrustDateBegin() {
        return this.entrustDateBegin;
    }

    public void setEntrustDateEnd(Date entrustDateEnd) {
        this.entrustDateEnd = entrustDateEnd;
    }

    public Date getEntrustDateEnd() {
        return this.entrustDateEnd;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return this.contents;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public Long getCreaterId() {
        return this.createrId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setIsChoosedUnion(Integer isChoosedUnion) {
        this.isChoosedUnion = isChoosedUnion;
    }

    public Integer getIsChoosedUnion() {
        return this.isChoosedUnion;
    }

    public void setIsProjectDirectory(Integer isProjectDirectory) {
        this.isProjectDirectory = isProjectDirectory;
    }

    public Integer getIsProjectDirectory() {
        return this.isProjectDirectory;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getRootId() {
        return this.rootId;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getProjectType() {
        return this.projectType;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Integer getProjectStatus() {
        return this.projectStatus;
    }

    public void setProjEntrustId(Long projEntrustId) {
        this.projEntrustId = projEntrustId;
    }

    public Long getProjEntrustId() {
        return this.projEntrustId;
    }

    public void setEnglishContents(String englishContents) {
        this.englishContents = englishContents;
    }

    public String getEnglishContents() {
        return this.englishContents;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreaterName() {
        return this.createrName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public Date getCreateTimeBegin() {
        return this.createTimeBegin;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Date getCreateTimeEnd() {
        return this.createTimeEnd;
    }

    public Integer getBidCountValidateFlag() {
        return bidCountValidateFlag;
    }

    public void setBidCountValidateFlag(Integer bidCountValidateFlag) {
        this.bidCountValidateFlag = bidCountValidateFlag;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "ProjInterProject [id=" + id + ", projectNumber="
                + projectNumber + ", projectName=" + projectName
                + ", englishName=" + englishName + ", regionCode=" + regionCode
                + ", tenderings=" + tenderings + ", tenderNames=" + tenderNames
                + ", isAccordingToTheLaw=" + isAccordingToTheLaw
                + ", tenderMode=" + tenderMode + ", isPrequalify="
                + isPrequalify + ", isTwoStage=" + isTwoStage
                + ", isOnlineBidding=" + isOnlineBidding
                + ", manageDepartmentId=" + manageDepartmentId
                + ", otherManageDepartmentIds=" + otherManageDepartmentIds
                + ", kind=" + kind + ", fundsSource=" + fundsSource
                + ", loanNumber=" + loanNumber + ", loanCountry=" + loanCountry
                + ", isSupportUnion=" + isSupportUnion + ", manageMonad="
                + manageMonad + ", recordSymbol=" + recordSymbol
                + ", entrustDocId=" + entrustDocId + ", entrustDate="
                + entrustDate + ", entrustDateBegin=" + entrustDateBegin
                + ", entrustDateEnd=" + entrustDateEnd + ", contents="
                + contents + ", createrId=" + createrId
                + ", processInstanceId=" + processInstanceId + ", taskId="
                + taskId + ", isChoosedUnion=" + isChoosedUnion
                + ", isProjectDirectory=" + isProjectDirectory + ", parentId="
                + parentId + ", rootId=" + rootId + ", projectType="
                + projectType + ", projectStatus=" + projectStatus
                + ", projEntrustId=" + projEntrustId + ", englishContents="
                + englishContents + ", createrName=" + createrName
                + ", createTime=" + createTime + ", createTimeBegin="
                + createTimeBegin + ", createTimeEnd=" + createTimeEnd
                + ", isDirectBidding=" + isDirectBidding + "]";
    }


}
