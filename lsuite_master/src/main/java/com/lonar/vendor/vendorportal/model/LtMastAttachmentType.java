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
@Table(name = "LT_MAST_ATTACHMENT_TYPE")
public class LtMastAttachmentType extends BaseClass{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachment_seq")
	@SequenceGenerator(name = "attachment_seq", sequenceName = "LT_MAST_ATTACHMENT_TYPE_S", allocationSize = 1)
	@Column(name = "ATTACHMENT_TYPE_ID")
	private Long attachmentTypeId;
	
	@Column(name = "MODULE_CODE")
	private String moduleCode;
	
	@Column(name = "ATTACHMENT_NAME")
	private String attachmentName;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "FILE_SIZE")
	private Long fileSize;
	
	@Column(name = "PDF")
	private String pdf;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "DOCUMENT")
	private String document;
	
	@Column(name = "EXCEL")
	private String excel;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "IS_MANDATORY")
	private String isMandatory;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	@Transient
	private String module;
	
	@Transient
	private String statusValue;
	
	@Transient
	private Long fileSizeValue;
	
	public Long getAttachmentTypeId() {
		return attachmentTypeId;
	}

	public void setAttachmentTypeId(Long attachmentTypeId) {
		this.attachmentTypeId = attachmentTypeId;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getExcel() {
		return excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public Long getFileSizeValue() {
		return fileSizeValue;
	}

	public void setFileSizeValue(Long fileSizeValue) {
		this.fileSizeValue = fileSizeValue;
	}

	public String getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

	@Override
	public String toString() {
		return "LtMastAttachmentType [attachmentTypeId=" + attachmentTypeId + ", moduleCode=" + moduleCode
				+ ", attachmentName=" + attachmentName + ", status=" + status + ", description=" + description
				+ ", fileSize=" + fileSize + ", pdf=" + pdf + ", image=" + image + ", document=" + document + ", excel="
				+ excel + ", zip=" + zip + ", isMandatory=" + isMandatory + ", companyId=" + companyId + ", module="
				+ module + ", statusValue=" + statusValue + ", fileSizeValue=" + fileSizeValue + "]";
	}

	
	
}
