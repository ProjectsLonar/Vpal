package com.lonar.vendor.vendorportal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_MAST_DEPARTMENTS")
public class LtMastDepartments extends BaseClass{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
	@SequenceGenerator(name = "department_seq", sequenceName = "LT_MAST_DEPARTMENTS_S", allocationSize = 1)
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name = "DEPARTMENT_CODE")
	private String departmentCode;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name = "DEPARTMENT_DESC")
	private String departmentDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastDepartments [departmentId=" + departmentId + ", departmentCode=" + departmentCode
				+ ", departmentName=" + departmentName + ", departmentDesc=" + departmentDesc + ", status=" + status
				+ ", companyId=" + companyId + "]";
	}
	
	
}
