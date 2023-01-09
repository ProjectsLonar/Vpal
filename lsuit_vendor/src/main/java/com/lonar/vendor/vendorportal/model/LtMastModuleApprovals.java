package com.lonar.vendor.vendorportal.model;

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

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_MODULE_APPROVALS")
@JsonInclude(Include.NON_NULL)
public class LtMastModuleApprovals extends BaseClass implements Serializable
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moduleApproval_seq")
	@SequenceGenerator(name = "moduleApproval_seq", sequenceName = "LT_MAST_MODULE_APPROVALS_S", allocationSize = 1)
	@Column(name = "MODULE_APPROVAL_ID")
	@JsonView(DataTablesOutput.View.class)
	private Long moduleApprovalId;
	
	@Column(name = "MODULE")
	@JsonView(DataTablesOutput.View.class)
	private String module;
	
	@Column(name = "APPROVAL_LEVEL")
	@JsonView(DataTablesOutput.View.class)
	private String approvalLevel;
	
	@Column(name = "APPROVAL_ROLE_CODE")
	@JsonView(DataTablesOutput.View.class)
	private String approvalRoleCode;
	
	@Column(name = "APPROVAL_ROLE_NAME")
	@JsonView(DataTablesOutput.View.class)
	private String approvalRoleName;
	
	@Column(name = "APPROVED_BY_ANYONE")
	@JsonView(DataTablesOutput.View.class)
	private String approvedByAnyone;
	
	@Column(name = "DIVISION_ID")
	@JsonView(DataTablesOutput.View.class)
	private Long divisionId;
	
	@Column(name = "REQUIRED_LEVEL")
	@JsonView(DataTablesOutput.View.class)
	private String requiredLevel;
	
	@Column(name = "STATUS")
	@JsonView(DataTablesOutput.View.class)
	private String status;
	

	
	@Column(name = "ISDELETE")
	@JsonView(DataTablesOutput.View.class)
	private String isDelete;
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String divisionName;
	
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
	private List<LtMastModuleAppEmployees> empList;
	
	
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
	
	
	public int getColumnNo() {
		return columnNo;
	}
	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
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
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "LtExpModuleApprovals [moduleApprovalId=" + moduleApprovalId + ", module=" + module + ", approvalLevel="
				+ approvalLevel + ", approvalRoleCode=" + approvalRoleCode + ", approvalRoleName=" + approvalRoleName
				+ ", approvedByAnyone=" + approvedByAnyone + ", divisionId=" + divisionId + ", requiredLevel="
				+ requiredLevel + ", status=" + status + ", isDelete=" + isDelete + ", divisionName="
				+ divisionName + ", draw=" + draw + ", start=" + start + ", length=" + length + ", stDate=" + stDate
				+ ", enDate=" + enDate + ", columnNo=" + columnNo + ", sort=" + sort + ", empList=" + empList + "]";
	}
	
	
	
	
	
	
	
	
	
}
