package com.lonar.UserManagement.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_USERS")
@JsonInclude(Include.NON_NULL)
public class LtMastUsers implements Serializable {

private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "LT_MAST_USERS_S", allocationSize = 1)
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "EMAIL")
	private String email;
	
	// Ingnore
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Basic(optional = false)
	@Column(name = "START_DATE")
	private Date startDate;
	
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "CHANGE_PWD")
	private String changePwd;
	
	@Column(name = "PASSWORD_DATE")
	private Date passwordDate;
	
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "LOGINFAILUREATTEMPT")
	private Long loginFailureAttempt;
	
	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;

	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private Long auditId;
	
	@Transient
	private String employeeName = "";

	@Transient
	private String costCenterName;

	@Transient
	private String locationName;

	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String stDate;
	
	@Transient
	private String enDate;
	
	@Transient
	private int columnNo;
	
	@Transient
	private String sort;
	
	@Transient
	private Long divisionId;
	
	@Transient
	private Long locationId;
	
	@Transient  
	private String vendorName;
	
	@Transient
	private String locationCode;

	@Transient
	private String divisionName;
	
	@Transient
	private String flag;
	
	@Transient
	private String roleName;
	
	@Transient
	private String statusValue;
	
	@Transient
	private String loginCheck;
	
	@Transient
	private String isBuyer;
	
	@Transient
	private String companyName;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getChangePwd() {
		return changePwd;
	}

	public void setChangePwd(String changePwd) {
		this.changePwd = changePwd;
	}

	public Date getPasswordDate() {
		return passwordDate;
	}

	public void setPasswordDate(Date passwordDate) {
		this.passwordDate = passwordDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getLoginFailureAttempt() {
		return loginFailureAttempt;
	}

	public void setLoginFailureAttempt(Long loginFailureAttempt) {
		this.loginFailureAttempt = loginFailureAttempt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String stDate) {
		this.stDate = stDate;
	}

	public String getEnDate() {
		return enDate;
	}

	public void setEnDate(String enDate) {
		this.enDate = enDate;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}



	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	
	public String getLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(String loginCheck) {
		this.loginCheck = loginCheck;
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
		return "LtMastUsers [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password="
				+ password + ", status=" + status + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", changePwd=" + changePwd + ", passwordDate=" + passwordDate
				+ ", employeeId=" + employeeId + ", vendorId=" + vendorId + ", loginFailureAttempt="
				+ loginFailureAttempt + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate="
				+ lastUpdateDate + ", companyId=" + companyId + ", auditId=" + auditId + ", employeeName="
				+ employeeName + ", costCenterName=" + costCenterName + ", locationName=" + locationName + ", draw="
				+ draw + ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate
				+ ", columnNo=" + columnNo + ", sort=" + sort + ", divisionId=" + divisionId + ", locationId="
				+ locationId + ", vendorName=" + vendorName + ", locationCode=" + locationCode + ", divisionName="
				+ divisionName + ", flag=" + flag + ", roleName=" + roleName + ", statusValue=" + statusValue
				+ ", loginCheck=" + loginCheck + ", isBuyer=" + isBuyer + ", companyName=" + companyName + "]";
	}

	

	
}
