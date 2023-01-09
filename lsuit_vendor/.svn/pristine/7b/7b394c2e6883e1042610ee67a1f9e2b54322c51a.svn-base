package com.lonar.vendor.vendorportal.model;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InvoiceApproval extends BaseClass
{
	
	private Long invoiceApprovalId;
	private Long moduleApprovalId;
	private Long approvalId;
	private String approvalLevel;
	private String currentApprovalLevel;
	private Long invoiceHeaderId;
	private String status;
	private Long delegationId;
	private String approvedByAnyone;
	
	@Transient
	private String invoiceNum;
		
	@Transient
	private String action;
	
	@Transient
	private String initiatorName;
	
	/*@Transient
	private String companyName;
	
	@Transient
	private String vendorName;*/

	public Long getInvoiceApprovalId() {
		return invoiceApprovalId;
	}

	public void setInvoiceApprovalId(Long invoiceApprovalId) {
		this.invoiceApprovalId = invoiceApprovalId;
	}

	public Long getModuleApprovalId() {
		return moduleApprovalId;
	}

	public void setModuleApprovalId(Long moduleApprovalId) {
		this.moduleApprovalId = moduleApprovalId;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalLevel() {
		return approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getCurrentApprovalLevel() {
		return currentApprovalLevel;
	}

	public void setCurrentApprovalLevel(String currentApprovalLevel) {
		this.currentApprovalLevel = currentApprovalLevel;
	}

	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(Long delegationId) {
		this.delegationId = delegationId;
	}

	public String getApprovedByAnyone() {
		return approvedByAnyone;
	}

	public void setApprovedByAnyone(String approvedByAnyone) {
		this.approvedByAnyone = approvedByAnyone;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	@Override
	public String toString() {
		return "InvoiceApproval [invoiceApprovalId=" + invoiceApprovalId + ", moduleApprovalId=" + moduleApprovalId
				+ ", approvalId=" + approvalId + ", approvalLevel=" + approvalLevel + ", currentApprovalLevel="
				+ currentApprovalLevel + ", invoiceHeaderId=" + invoiceHeaderId + ", status=" + status
				+ ", delegationId=" + delegationId + ", approvedByAnyone=" + approvedByAnyone + ", invoiceNum="
				+ invoiceNum + ", action=" + action + ", initiatorName=" + initiatorName + "]";
	}

	
	
		
}
