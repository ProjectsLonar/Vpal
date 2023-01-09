package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_COMPANY_VEN_MGMT_MISC")
public class LtCompanyVenMgmtMisc extends BaseClass{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_misc_seq")
	@SequenceGenerator(name = "company_misc_seq", sequenceName = "LT_COMPANY_VEN_MGMT_MISC_S", allocationSize = 1)
	@Column(name = "COMP_VEN_MGMT_MISC_ID")
	private Long compVenMgmtMiscId;
	
	
	@Column(name = "COMP_MISCELLANEOUS_ID")
	private Long compMiscellaneousId;
	
	@Column(name = "Company_Id")
	private Long companyId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
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

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
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

	public Long getCompVenMgmtMiscId() {
		return compVenMgmtMiscId;
	}

	public void setCompVenMgmtMiscId(Long compVenMgmtMiscId) {
		this.compVenMgmtMiscId = compVenMgmtMiscId;
	}

	@Override
	public String toString() {
		return "LtCompanyVenMgmtMisc [compVenMgmtMiscId=" + compVenMgmtMiscId + ", compMiscellaneousId="
				+ compMiscellaneousId + ", companyId=" + companyId + ", vendorId=" + vendorId + ", includeVendor="
				+ includeVendor + ", mandatoryTab=" + mandatoryTab + "]";
	}

	

	
}
