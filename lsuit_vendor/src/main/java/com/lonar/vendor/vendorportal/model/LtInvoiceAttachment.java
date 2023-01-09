package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_INVOICE_ATTACHMENT")
@JsonInclude(Include.NON_NULL)
public class LtInvoiceAttachment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceAttachment_seq")
	@SequenceGenerator(name = "invoiceAttachment_seq", sequenceName = "LT_INVOICE_ATTACHMENT_S", allocationSize = 1)
	@Column(name = "INVOICE_ATTACHMENT_ID")
	private Long invoiceAttachmentId;

	@Column(name = "INVOICE_ID")
	private Long invoiceId;

	@Column(name = "ATTACHMENT_TYPE_ID")
	private Long attachmentTypeId;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_PATH")
	private String filePath;
	
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@Transient
	private String attachmentType;

	public Long getInvoiceAttachmentId() {
		return invoiceAttachmentId;
	}

	public void setInvoiceAttachmentId(Long invoiceAttachmentId) {
		this.invoiceAttachmentId = invoiceAttachmentId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getAttachmentTypeId() {
		return attachmentTypeId;
	}

	public void setAttachmentTypeId(Long attachmentTypeId) {
		this.attachmentTypeId = attachmentTypeId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	
}

