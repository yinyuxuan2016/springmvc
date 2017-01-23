/*
 * Copyright (c) 2001-2015 Bidlink(Beijing) E-Biz Tech Co.,Ltd.
 * All rights reserved.
 * 必联（北京）电子商务科技有限公司 版权所有
 */

package org.emall.cn.model.project;

public class ProjectVO extends ProjInterProject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long tenderFee;
	
	/**
	 * proj_inter_project.ID
	 */
	private Long id;
	
	/**
	 * expense_bps_project.Id
	 */
	private Long expenseId;

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 描述:标书费缴纳时间 字段: TENDER_FEE_PAYMENT_TIME DATETIME(19)
	 */
	private java.util.Date tenderFeePaymentTime;
	
	/**
	 * 投标人
	 */
	private Long bidDeposit;

	/**
	 * 描述:投标保证金缴纳时间 字段: BID_DEPOSIT_PAYMENT_TIME DATETIME(19)
	 */
	private java.util.Date bidDepositPaymentTime;
	
	
	private String supplierName;
	
	private Long supplierId ;
	
	

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getTenderFee() {
		return tenderFee;
	}

	public void setTenderFee(Long tenderFee) {
		this.tenderFee = tenderFee;
	}

	public java.util.Date getTenderFeePaymentTime() {
		return tenderFeePaymentTime;
	}

	public void setTenderFeePaymentTime(java.util.Date tenderFeePaymentTime) {
		this.tenderFeePaymentTime = tenderFeePaymentTime;
	}

	public Long getBidDeposit() {
		return bidDeposit;
	}

	public void setBidDeposit(Long bidDeposit) {
		this.bidDeposit = bidDeposit;
	}

	public java.util.Date getBidDepositPaymentTime() {
		return bidDepositPaymentTime;
	}

	public void setBidDepositPaymentTime(java.util.Date bidDepositPaymentTime) {
		this.bidDepositPaymentTime = bidDepositPaymentTime;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	

}
