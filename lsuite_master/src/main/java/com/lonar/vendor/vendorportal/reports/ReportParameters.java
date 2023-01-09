package com.lonar.vendor.vendorportal.reports;

public class ReportParameters {
	
	private String masterName;
	private String status;
	private String startDate;
	private String endDate;
	private Long lastUpdateLogin;
	private Long companyId;
	
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	@Override
	public String toString() {
		return "ReportParameters [masterName=" + masterName + ", status=" + status + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", lastUpdateLogin=" + lastUpdateLogin + ", companyId=" + companyId + "]";
	}
	
}
