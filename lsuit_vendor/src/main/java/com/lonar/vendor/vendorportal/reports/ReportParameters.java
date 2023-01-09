package com.lonar.vendor.vendorportal.reports;

public class ReportParameters {
	
	private String reportName;
	private Long vendorId;
	private String status;
	private Long initiatorId;
	private String companyCategory;
	private Long divisionId;
	private Long lastUpdateLogin;
	private Long companyId;
	private String addressCode;
	private Long addressState;
	private String gstRegistered;
	private String gstRegStatus;
	
	
	
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getInitiatorId() {
		return initiatorId;
	}
	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}
	public String getCompanyCategory() {
		return companyCategory;
	}
	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}
	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public Long getAddressState() {
		return addressState;
	}
	public void setAddressState(Long addressState) {
		this.addressState = addressState;
	}
	public String getGstRegistered() {
		return gstRegistered;
	}
	public void setGstRegistered(String gstRegistered) {
		this.gstRegistered = gstRegistered;
	}
	public String getGstRegStatus() {
		return gstRegStatus;
	}
	public void setGstRegStatus(String gstRegStatus) {
		this.gstRegStatus = gstRegStatus;
	}
	@Override
	public String toString() {
		return "ReportParameters [reportName=" + reportName + ", vendorId=" + vendorId + ", status=" + status
				+ ", initiatorId=" + initiatorId + ", companyCategory=" + companyCategory + ", divisionId=" + divisionId
				+ ", lastUpdateLogin=" + lastUpdateLogin + ", companyId=" + companyId + ", addressCode=" + addressCode
				+ ", addressState=" + addressState + ", gstRegistered=" + gstRegistered + ", gstRegStatus="
				+ gstRegStatus + "]";
	}
	
	
	
}
