package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LT_COMPANY_VEN_MGMT_ATTACHMENT" )
public class LtCompanyVenMgmtAttachment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_COMPANY_VEN_MGMT_ATTACH_S", allocationSize = 1)
	@Column(name = "COMPANY_VEN_ATTACHMENT_ID")
	private Long companyVenAttachmentId;
	
	@Column(name = "Comp_Attachment_Id")
	private Long compAttachmentId;
	
	@Column(name = "Company_Id")
	private Long companyId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "Include_Vendor")
	private String includeVendor;
	
	@Column(name = "Mandatory_Tab")
	private String mandatoryTab;

	@Column(name = "ATTACHMENT_NAME")
	private String attachmentName;
	
	@Column(name = "ATTACHMENT_MANDATORY")
	private String attachmentMandatory;

	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;
	
	public Long getCompAttachmentId() {
		return compAttachmentId;
	}

	public void setCompAttachmentId(Long compAttachmentId) {
		this.compAttachmentId = compAttachmentId;
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

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentMandatory() {
		return attachmentMandatory;
	}

	public void setAttachmentMandatory(String attachmentMandatory) {
		this.attachmentMandatory = attachmentMandatory;
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

	public Long getCompanyVenAttachmentId() {
		return companyVenAttachmentId;
	}

	public void setCompanyVenAttachmentId(Long companyVenAttachmentId) {
		this.companyVenAttachmentId = companyVenAttachmentId;
	}

	@Override
	public String toString() {
		return "LtCompanyVenMgmtAttachment [companyVenAttachmentId=" + companyVenAttachmentId + ", compAttachmentId="
				+ compAttachmentId + ", companyId=" + companyId + ", vendorId=" + vendorId + ", includeVendor="
				+ includeVendor + ", mandatoryTab=" + mandatoryTab + ", attachmentName=" + attachmentName
				+ ", attachmentMandatory=" + attachmentMandatory + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	

	
	
}
