package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LtVendorApprovalHistory {

	private Long vendorApprovalHistoryId;
	private Long vendorApprovalId;
	private String status;
	private String note;
	private Date lastUpdateDate;
	
	private Long vendorId;
	private String remark;
	private Long employeeId;
	private String userType;
	
	@Transient
	private String approvalName;

	public Long getVendorApprovalHistoryId() {
		return vendorApprovalHistoryId;
	}

	public void setVendorApprovalHistoryId(Long vendorApprovalHistoryId) {
		this.vendorApprovalHistoryId = vendorApprovalHistoryId;
	}

	public Long getVendorApprovalId() {
		return vendorApprovalId;
	}

	public void setVendorApprovalId(Long vendorApprovalId) {
		this.vendorApprovalId = vendorApprovalId;
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

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
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

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "LtVendorApprovalHistory [vendorApprovalHistoryId=" + vendorApprovalHistoryId + ", vendorApprovalId="
				+ vendorApprovalId + ", status=" + status + ", note=" + note + ", lastUpdateDate=" + lastUpdateDate
				+ ", vendorId=" + vendorId + ", remark=" + remark + ", employeeId=" + employeeId + ", userType="
				+ userType + ", approvalName=" + approvalName + "]";
	}

	

	
}
