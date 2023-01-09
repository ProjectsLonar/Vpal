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
@Table(name = "LT_MAST_PERSON_TYPE")
public class LtMastPersonType extends BaseClass{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_type_seq")
	@SequenceGenerator(name = "person_type_seq", sequenceName = "LT_MAST_PERSON_TYPE_S", allocationSize = 1)
	@Column(name = "PERSON_TYPE_ID")
	private Long personTypeId;
	
	@Column(name = "PERSON_TYPE_CODE")
	private String personTypeCode;
	
	@Column(name = "PERSON_TYPE_NAME")
	private String personTypeName;
	
	@Column(name = "PERSON_TYPE_DESC")
	private String personTypeDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getPersonTypeId() {
		return personTypeId;
	}

	public void setPersonTypeId(Long personTypeId) {
		this.personTypeId = personTypeId;
	}

	public String getPersonTypeCode() {
		return personTypeCode;
	}

	public void setPersonTypeCode(String personTypeCode) {
		this.personTypeCode = personTypeCode;
	}

	public String getPersonTypeName() {
		return personTypeName;
	}

	public void setPersonTypeName(String personTypeName) {
		this.personTypeName = personTypeName;
	}

	public String getPersonTypeDesc() {
		return personTypeDesc;
	}

	public void setPersonTypeDesc(String personTypeDesc) {
		this.personTypeDesc = personTypeDesc;
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
		return "LtMastPersonType [personTypeId=" + personTypeId + ", personTypeCode=" + personTypeCode
				+ ", personTypeName=" + personTypeName + ", personTypeDesc=" + personTypeDesc + ", status=" + status
				+ ", companyId=" + companyId + "]";
	}
	
	
}
