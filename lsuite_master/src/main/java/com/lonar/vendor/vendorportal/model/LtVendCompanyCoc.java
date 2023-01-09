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
@Table(name = "LT_VEND_COMPANY_COC" )
public class LtVendCompanyCoc extends BaseClass{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_COMPANY_COC_S", allocationSize = 1)
	@Column(name = "COMP_CONDUCT_ID")
	private Long compConductId;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "CODE_CONDUCT_ID")
	private String codeConductId;
	
	@Column(name = "INCLUDE_VENDOR")
	private String includeVendor;
	
	@Column(name = "MANDATORY_TAB")
	private String mandatoryTab;

	@Transient
	private String fileName;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "LtVendCompanyCoc [compConductId=" + compConductId + ", companyId=" + companyId + ", codeConductId="
				+ codeConductId + ", includeVendor=" + includeVendor + ", mandatoryTab=" + mandatoryTab + ", fileName="
				+ fileName + "]";
	}
	
	
	
}
