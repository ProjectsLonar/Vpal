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
@Table(name = "LT_MAST_BUSINESS_NATURE")
public class LtMastBusinessNature extends BaseClass{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "businessNature_seq")
	@SequenceGenerator(name = "businessNature_seq", sequenceName = "LT_MAST_BUSINESS_NATURE_S", allocationSize = 1)
	@Column(name = "BUSINESS_NATURE_ID")
	private Long businessNatureId;
	
	@Column(name = "BUSINESS_NATURE_CODE")
	private String businessNatureCode;
	
	@Column(name = "BUSINESS_NATURE_NAME")
	private String businessNatureName;
	
	@Column(name = "BUSINESS_NATURE_DESC")
	private String businessNatureDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getBusinessNatureId() {
		return businessNatureId;
	}

	public void setBusinessNatureId(Long businessNatureId) {
		this.businessNatureId = businessNatureId;
	}

	public String getBusinessNatureCode() {
		return businessNatureCode;
	}

	public void setBusinessNatureCode(String businessNatureCode) {
		this.businessNatureCode = businessNatureCode;
	}

	public String getBusinessNatureName() {
		return businessNatureName;
	}

	public void setBusinessNatureName(String businessNatureName) {
		this.businessNatureName = businessNatureName;
	}

	public String getBusinessNatureDesc() {
		return businessNatureDesc;
	}

	public void setBusinessNatureDesc(String businessNatureDesc) {
		this.businessNatureDesc = businessNatureDesc;
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
		return "LtMastBusinessNature [businessNatureId=" + businessNatureId + ", businessNatureCode="
				+ businessNatureCode + ", businessNatureName=" + businessNatureName + ", businessNatureDesc="
				+ businessNatureDesc + ", status=" + status + ", companyId=" + companyId + "]";
	}

	
}
