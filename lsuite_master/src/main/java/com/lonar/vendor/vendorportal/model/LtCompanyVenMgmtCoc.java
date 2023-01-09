package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LT_COMPANY_VEN_MGMT_COC" )
public class LtCompanyVenMgmtCoc extends BaseClass{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_ven_seq")
	@SequenceGenerator(name = "company_ven_seq", sequenceName = "LT_COMPANY_VEN_MGMT_COC_S", allocationSize = 1)
	@Column(name = "COMPANY_VEN_MGMT_COC_ID")
	private Long companyVenMgmtCocId;
	
	@Column(name = "Comp_Conduct_Id")
	private Long compConductId;
	
	@Column(name = "Company_Id")
	private Long companyId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "Code_Conduct_Id")
	private String codeConductId;
	
	@Column(name = "Include_Vendor")
	private String includeVendor;
	
	@Column(name = "Mandatory_Tab")
	private String mandatoryTab;

	@Transient
	private String imgName;

	
	public Long getCompConductId() {
		return compConductId;
	}


	public void setCompConductId(Long compConductId) {
		this.compConductId = compConductId;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getCodeConductId() {
		return codeConductId;
	}


	public void setCodeConductId(String codeConductId) {
		this.codeConductId = codeConductId;
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


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Long getVendorId() {
		return vendorId;
	}


	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}


	public Long getCompanyVenMgmtCocId() {
		return companyVenMgmtCocId;
	}


	public void setCompanyVenMgmtCocId(Long companyVenMgmtCocId) {
		this.companyVenMgmtCocId = companyVenMgmtCocId;
	}


	@Override
	public String toString() {
		return "LtCompanyVenMgmtCoc [companyVenMgmtCocId=" + companyVenMgmtCocId + ", compConductId=" + compConductId
				+ ", companyId=" + companyId + ", vendorId=" + vendorId + ", codeConductId=" + codeConductId
				+ ", includeVendor=" + includeVendor + ", mandatoryTab=" + mandatoryTab + ", imgName=" + imgName + "]";
	}


	
}
