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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "LT_VEND_COMPANY_CLIENT_DETAILS" )
public class LtVendCompanyClientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_COMP_CLIENT_DETAILS_S", allocationSize = 1)
	@Column(name = "COMP_CLIENT_ID")
	private Long compClientId;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "INCLUDE_VENDOR")
	private String includeVendor;
	
	@Column(name = "MANDATORY_TAB")
	private String mandatoryTab;

	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	public Long getCompClientId() {
		return compClientId;
	}

	public void setCompClientId(Long compClientId) {
		this.compClientId = compClientId;
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

	@Override
	public String toString() {
		return "LtVendCompanyClientDetails [compClientId=" + compClientId + ", companyId=" + companyId
				+ ", includeVendor=" + includeVendor + ", mandatoryTab=" + mandatoryTab + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	
	
}