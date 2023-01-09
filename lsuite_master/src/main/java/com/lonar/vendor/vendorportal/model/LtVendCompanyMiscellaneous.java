package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lonar.vendor.vendorportal.model.BaseClass;

@Entity
@Table(name = "LT_VEND_COMPANY_MISCELLANEOUS")
public class LtVendCompanyMiscellaneous extends BaseClass {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_COMP_MISCELLANEOUS_S", allocationSize = 1)
	@Column(name = "COMP_MISCELLANEOUS_ID")
	private Long compMiscellaneousId;
	
	@Column(name = "Company_Id")
	private Long companyId;
	
	@Column(name = "Include_Vendor")
	private String includeVendor;
	
	@Column(name = "Mandatory_Tab")
	private String mandatoryTab;

	public Long getCompMiscellaneousId() {
		return compMiscellaneousId;
	}

	public void setCompMiscellaneousId(Long compMiscellaneousId) {
		this.compMiscellaneousId = compMiscellaneousId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getIncludeVendor() {
		return includeVendor;
	}

	public void setIncludeVendor(String includeVendor) {
		this.includeVendor = includeVendor;
	}

	public String getMandatoryTab() {
		return mandatoryTab;
	}

	public void setMandatoryTab(String mandatoryTab) {
		this.mandatoryTab = mandatoryTab;
	}

	@Override
	public String toString() {
		return "LtVendCompanyMiscellaneous [compMiscellaneousId=" + compMiscellaneousId + ", companyId=" + companyId
				+ ", includeVendor=" + includeVendor + ", mandatoryTab=" + mandatoryTab + "]";
	}

	
}
