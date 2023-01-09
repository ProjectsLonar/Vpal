package com.lonar.vendor.vendorportal.model;

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

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_VENDOR_APPROVAL")
@JsonInclude(Include.NON_NULL)
public class LtVendorApproval {
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorApproval_seq")
	@SequenceGenerator(name = "vendorApproval_seq", sequenceName = "LT_VENDOR_APPROVAL_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_APPROVAL_ID")
	private Long vendorApprovalId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "MODULE_APPROVAL_ID")
	private Long moduleApprovalId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "APPROVAL_ID")
	private Long approvalId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "APPROVAL_LEVEL")
	private String approvalLevel;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CURRENT_APPROVAL_LEVEL")
	private String currentApprovalLevel;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STATUS")
	private String status;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "DELEGATION_ID")
	private Long delegationId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String approvalName;
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String approvalLevelName;
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String expenseNumber;
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private Double expenseAmount;
	
	@JsonView(DataTablesOutput.View.class)
	@Transient
	private String initiatorName;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "MODULE_APP_EMPLOYEES_ID")
	private Long moduleAppEmployeesId;
	
	@Transient
	private Long employeesId;

	public Long getVendorApprovalId() {
		return vendorApprovalId;
	}

	public void setVendorApprovalId(Long vendorApprovalId) {
		this.vendorApprovalId = vendorApprovalId;
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

	public Long getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(Long delegationId) {
		this.delegationId = delegationId;
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

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalLevelName() {
		return approvalLevelName;
	}

	public void setApprovalLevelName(String approvalLevelName) {
		this.approvalLevelName = approvalLevelName;
	}

	public String getExpenseNumber() {
		return expenseNumber;
	}

	public void setExpenseNumber(String expenseNumber) {
		this.expenseNumber = expenseNumber;
	}

	public Double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(Double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public Long getModuleAppEmployeesId() {
		return moduleAppEmployeesId;
	}

	public void setModuleAppEmployeesId(Long moduleAppEmployeesId) {
		this.moduleAppEmployeesId = moduleAppEmployeesId;
	}

	public Long getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(Long employeesId) {
		this.employeesId = employeesId;
	}

	@Override
	public String toString() {
		return "LtExpenseApproval [vendorApprovalId=" + vendorApprovalId + ", moduleApprovalId=" + moduleApprovalId
				+ ", approvalId=" + approvalId + ", approvalLevel=" + approvalLevel + ", currentApprovalLevel="
				+ currentApprovalLevel + ", vendorId=" + vendorId + ", status=" + status + ", delegationId="
				+ delegationId + ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateLogin="
				+ lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", approvalName=" + approvalName
				+ ", approvalLevelName=" + approvalLevelName + ", expenseNumber=" + expenseNumber + ", expenseAmount="
				+ expenseAmount + ", initiatorName=" + initiatorName + ", moduleAppEmployeesId=" + moduleAppEmployeesId
				+ ", employeesId=" + employeesId + "]";
	}
	
	
}
