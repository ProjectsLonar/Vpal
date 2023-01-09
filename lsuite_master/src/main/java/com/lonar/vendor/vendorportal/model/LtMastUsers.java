
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_USERS")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastUsers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	//@NotNull
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "LT_MAST_USERS_S", allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "USER_NAME")
	private String userName;
	
	@Size(max = 240)
	@Column(name = "EMAIL")
	private String email;
	
	// Ingnore
	@Size(min = 0, max = 240)
	@Column(name = "PASSWORD")
	private String password;
	
	@Size(max = 80)
	@Column(name = "STATUS")
	private String status;
	
	@Size(max = 240)
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "CHANGE_PWD")
	private String changePwd;
	
	@Column(name = "PASSWORD_DATE")
	private Date passwordDate;
	
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	
	@Column(name = "LOGINFAILUREATTEMPT")
	private Long loginFailureAttempt;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String employeeName ;
	
	@Transient
	private String costCenterName;
	
	@Transient
	private String branchName;
	
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


	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Transient
	private String vendorName;
	
	public LtMastUsers() {
		super();
		
	}
	
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastUsers [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password="
				+ password + ", status=" + status + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", changePwd=" + changePwd + ", passwordDate=" + passwordDate
				+ ", employeeId=" + employeeId + ", loginFailureAttempt=" + loginFailureAttempt + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", companyId=" + companyId
				+ ", employeeName=" + employeeName + ", costCenterName=" + costCenterName + ", branchName=" + branchName
				+ ", draw=" + draw + ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", enDate="
				+ enDate + ", columnNo=" + columnNo + ", sort=" + sort + ", vendorId=" + vendorId + ", vendorName="
				+ vendorName + "]";
	}


	
}
