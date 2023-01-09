package com.lonar.UserManagement.web.model;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "lt_mast_module_approvals")
@JsonInclude(Include.NON_NULL)
public class LtModuleApprovals extends BaseClass implements Serializable
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moduleApproval_seq")
	@SequenceGenerator(name = "moduleApproval_seq", sequenceName = "lt_mast_module_approvals_s", allocationSize = 1)
	@Column(name = "MODULE_APPROVAL_ID")
	private Long moduleApprovalId;
	
	@Column(name = "MODULE")
	private String module;
	
	@Column(name = "APPROVAL_LEVEL")
	private String approvalLevel;
	
	@Column(name = "APPROVAL_ROLE_CODE")
	private String approvalRoleCode;
	
	@Column(name = "APPROVAL_ROLE_NAME")
	private String approvalRoleName;
	
	@Column(name = "APPROVED_BY_ANYONE")
	private String approvedByAnyone;
	
	@Column(name = "DIVISION_ID")
	private Long divisionId;
	
	@Column(name = "REQUIRED_LEVEL")
	private String requiredLevel;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ISDELETE")
	private String isDelete;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String divisionName;
	
	
	@Transient
	private List<LtMastModuleAppEmployees> empList;

	@Transient
	private String stDate;
	
	@Transient
	private String enDate;
	
	@Transient
	private String statusValue;

	public Long getModuleApprovalId() {
		return moduleApprovalId;
	}


	public void setModuleApprovalId(Long moduleApprovalId) {
		this.moduleApprovalId = moduleApprovalId;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getApprovalLevel() {
		return approvalLevel;
	}


	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}


	public String getApprovalRoleCode() {
		return approvalRoleCode;
	}


	public void setApprovalRoleCode(String approvalRoleCode) {
		this.approvalRoleCode = approvalRoleCode;
	}


	public String getApprovalRoleName() {
		return approvalRoleName;
	}


	public void setApprovalRoleName(String approvalRoleName) {
		this.approvalRoleName = approvalRoleName;
	}


	public String getApprovedByAnyone() {
		return approvedByAnyone;
	}


	public void setApprovedByAnyone(String approvedByAnyone) {
		this.approvedByAnyone = approvedByAnyone;
	}


	public Long getDivisionId() {
		return divisionId;
	}


	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}


	public String getRequiredLevel() {
		return requiredLevel;
	}


	public void setRequiredLevel(String requiredLevel) {
		this.requiredLevel = requiredLevel;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}


	public String getDivisionName() {
		return divisionName;
	}


	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}


	public List<LtMastModuleAppEmployees> getEmpList() {
		return empList;
	}


	public void setEmpList(List<LtMastModuleAppEmployees> empList) {
		this.empList = empList;
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


	@Override
	public String toString() {
		return "LtModuleApprovals [moduleApprovalId=" + moduleApprovalId + ", module=" + module + ", approvalLevel="
				+ approvalLevel + ", approvalRoleCode=" + approvalRoleCode + ", approvalRoleName=" + approvalRoleName
				+ ", approvedByAnyone=" + approvedByAnyone + ", divisionId=" + divisionId + ", requiredLevel="
				+ requiredLevel + ", status=" + status + ", isDelete=" + isDelete + ", companyId=" + companyId
				+ ", divisionName=" + divisionName + ", empList=" + empList + ", stDate=" + stDate + ", enDate="
				+ enDate + ", statusValue=" + statusValue + "]";
	}


	
}
