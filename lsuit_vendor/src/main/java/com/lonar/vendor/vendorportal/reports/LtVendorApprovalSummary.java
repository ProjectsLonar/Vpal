package com.lonar.vendor.vendorportal.reports;

import java.util.Date;

public class LtVendorApprovalSummary {
	private String vendorCode;
	private String vendorName;
	private String status;
	private String initiatorName;
	private String approverName;
	private String approvalStatus;
	private Date approvedDate;
	private String remark;
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInitiatorName() {
		return initiatorName;
	}
	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "LtVendorApprovalSummary [vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", status=" + status
				+ ", initiatorName=" + initiatorName + ", approverName=" + approverName + ", approvalStatus="
				+ approvalStatus + ", approvedDate=" + approvedDate + ", remark=" + remark + "]";
	}
	
	

}
