
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_VENDOR_FILE_ATTACHMENT")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastVendorAttachment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorAttachment_seq")
	@SequenceGenerator(name = "vendorAttachment_seq", sequenceName = "lt_mast_vendor_file_attach_s", allocationSize = 1)
	@Column(name = "VENDOR_ATTACHMENT_ID")
	private Long vendorAttachmentId;

	/*
	 * // @Basic(optional = false) // @JsonView(DataTablesOutput.View.class)
	 * 
	 * @Column(name = "user_id") private Long userId;
	 */
	// @JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;

	// @JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_AGREEMENT_ID")
	private Long vendorAgreementId;

	@Column(name = "VENDOR_ATTACHMENT_TYPE")
	private String vendorAttachmentType;

	// @JsonView(DataTablesOutput.View.class)
	@Column(name = "FILE_NAME")
	private String fileName;

	// @JsonView(DataTablesOutput.View.class)
	@Column(name = "FILE_PATH")
	private String filePath;

	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@Transient
	private String attachmentType;

	public Long getVendorAttachmentId() {
		return vendorAttachmentId;
	}

	public void setVendorAttachmentId(Long vendorAttachmentId) {
		this.vendorAttachmentId = vendorAttachmentId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getVendorAgreementId() {
		return vendorAgreementId;
	}

	public void setVendorAgreementId(Long vendorAgreementId) {
		this.vendorAgreementId = vendorAgreementId;
	}

	public String getVendorAttachmentType() {
		return vendorAttachmentType;
	}

	public void setVendorAttachmentType(String vendorAttachmentType) {
		this.vendorAttachmentType = vendorAttachmentType;
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

	@Override
	public String toString() {
		return "LtMastVendorAttachment [vendorAttachmentId=" + vendorAttachmentId + ", vendorId=" + vendorId
				+ ", vendorAgreementId=" + vendorAgreementId + ", vendorAttachmentType=" + vendorAttachmentType
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", attachmentType=" + attachmentType + "]";
	}
	
	
	
}
