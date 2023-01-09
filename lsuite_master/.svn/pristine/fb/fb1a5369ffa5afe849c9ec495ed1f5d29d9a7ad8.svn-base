package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_VEND_COMPANY_SIST_CONCERNS" )
public class LtVendCompanySistConcern {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sist_conc_seq")
	@SequenceGenerator(name = "company_sist_conc_seq", sequenceName = "LT_VEND_COMPANY_SIST_CONC_S", allocationSize = 1)
	@Column(name = "COMP_SIST_CONCERNS_ID")
	private Long compSistConcernsId;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "INCLUDE_VENDOR")
	private String includeVendor;
	
	@Column(name = "MANDATORY_TAB")
	private String mandatoryTab;

	@Basic(optional = false)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Basic(optional = false)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Basic(optional = false)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	public Long getCompSistConcernsId() {
		return compSistConcernsId;
	}

	public void setCompSistConcernsId(Long compSistConcernsId) {
		this.compSistConcernsId = compSistConcernsId;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "LtVendCompanySistConcern [compSistConcernsId=" + compSistConcernsId + ", companyId=" + companyId
				+ ", includeVendor=" + includeVendor + ", mandatoryTab=" + mandatoryTab + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

	

	
	
}
