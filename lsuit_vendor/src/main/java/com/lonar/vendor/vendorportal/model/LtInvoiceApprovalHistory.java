package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LtInvoiceApprovalHistory {

	private Long invoiceApprovalHistoryId;
	private Long invoiceApprovalId;
	private String status;
	private String note;
	private Date lastUpdateDate;
	
	private Long invoiceHeaderId;
	private String remark;
	private Long employeeId;
	private String userType;
	private Long vendorId;
	private Long lastUpdateLogin;
	
	@Transient
	private String approvalName;

	public Long getInvoiceApprovalHistoryId() {
		return invoiceApprovalHistoryId;
	}

	public void setInvoiceApprovalHistoryId(Long invoiceApprovalHistoryId) {
		this.invoiceApprovalHistoryId = invoiceApprovalHistoryId;
	}

	public Long getInvoiceApprovalId() {
		return invoiceApprovalId;
	}

	public void setInvoiceApprovalId(Long invoiceApprovalId) {
		this.invoiceApprovalId = invoiceApprovalId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	@Override
	public String toString() {
		return "LtInvoiceApprovalHistory [invoiceApprovalHistoryId=" + invoiceApprovalHistoryId + ", invoiceApprovalId="
				+ invoiceApprovalId + ", status=" + status + ", note=" + note + ", lastUpdateDate=" + lastUpdateDate
				+ ", invoiceHeaderId=" + invoiceHeaderId + ", remark=" + remark + ", employeeId=" + employeeId
				+ ", userType=" + userType + ", vendorId=" + vendorId + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", approvalName=" + approvalName + "]";
	}

	
	
}
