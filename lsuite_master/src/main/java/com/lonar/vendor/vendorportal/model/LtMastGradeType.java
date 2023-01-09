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
@Table(name="LT_MAST_GRADE_TYPE")
public class LtMastGradeType extends BaseClass{
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_type_seq")
	@SequenceGenerator(name = "grade_type_seq", sequenceName = "LT_MAST_GRADE_TYPE_S", allocationSize = 1)
	@Column(name = "GRADE_TYPE_ID")
	private Long gradeTypeId;
	
	@Column(name = "GRADE_TYPE_CODE")
	private String gradeTypeCode;
	
	@Column(name = "GRADE_TYPE_NAME")
	private String gradeTypeName;
	
	@Column(name = "GRADE_TYPE_DESC")
	private String gradeTypeDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getGradeTypeId() {
		return gradeTypeId;
	}

	public void setGradeTypeId(Long gradeTypeId) {
		this.gradeTypeId = gradeTypeId;
	}

	public String getGradeTypeCode() {
		return gradeTypeCode;
	}

	public void setGradeTypeCode(String gradeTypeCode) {
		this.gradeTypeCode = gradeTypeCode;
	}

	public String getGradeTypeName() {
		return gradeTypeName;
	}

	public void setGradeTypeName(String gradeTypeName) {
		this.gradeTypeName = gradeTypeName;
	}

	public String getGradeTypeDesc() {
		return gradeTypeDesc;
	}

	public void setGradeTypeDesc(String gradeTypeDesc) {
		this.gradeTypeDesc = gradeTypeDesc;
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
		return "LtMastGradeType [gradeTypeId=" + gradeTypeId + ", gradeTypeCode=" + gradeTypeCode + ", gradeTypeName="
				+ gradeTypeName + ", gradeTypeDesc=" + gradeTypeDesc + ", status=" + status + ", companyId=" + companyId
				+ "]";
	}
	
	
}
