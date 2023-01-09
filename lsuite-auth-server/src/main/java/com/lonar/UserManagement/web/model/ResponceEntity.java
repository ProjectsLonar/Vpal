package com.lonar.UserManagement.web.model;

public class ResponceEntity {

	private Integer code;
	private  String message;
	private Object data;
	private Long userId;
	private Long employeeId;
	private Long vendorId;
	private String employeeName;
	private String role;
	private Long divisionId;
	private Long locationId;
	private String locationCode;
	private String divisionName;
	private Long companyId;
	private String isBuyer;
	private String companyName;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getIsBuyer() {
		return isBuyer;
	}
	public void setIsBuyer(String isBuyer) {
		this.isBuyer = isBuyer;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "ResponceEntity [code=" + code + ", message=" + message + ", data=" + data + ", userId=" + userId
				+ ", employeeId=" + employeeId + ", vendorId=" + vendorId + ", employeeName=" + employeeName + ", role="
				+ role + ", divisionId=" + divisionId + ", locationId=" + locationId + ", locationCode=" + locationCode
				+ ", divisionName=" + divisionName + ", companyId=" + companyId + ", isBuyer=" + isBuyer
				+ ", companyName=" + companyName + "]";
	}
	
	
	
	
}
