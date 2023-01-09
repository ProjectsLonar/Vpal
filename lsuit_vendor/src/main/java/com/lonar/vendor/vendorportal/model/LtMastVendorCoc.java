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
@Table(name = "LT_MAST_VENDOR_COC" )
public class LtMastVendorCoc extends BaseClass{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_COMPANY_COC_S", allocationSize = 1)
	@Column(name = "Comp_Conduct_Id")
	private Long compConductId;
	
	@Column(name = "Vendor_Id")
	private Long vendorId;
	
	@Column(name = "Attachment_COC")
	private String attachmentCoc;

	@Column(name = "IS_AGREE")
	private String isAgree;
	
	@Transient
	private String fileName;
	
	@Transient
	private Long vendorAttachmentId;
	
	public Long getCompConductId() {
		return compConductId;
	}

	public void setCompConductId(Long compConductId) {
		this.compConductId = compConductId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getAttachmentCoc() {
		return attachmentCoc;
	}

	public void setAttachmentCoc(String attachmentCoc) {
		this.attachmentCoc = attachmentCoc;
	}

	public String getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getVendorAttachmentId() {
		return vendorAttachmentId;
	}

	public void setVendorAttachmentId(Long vendorAttachmentId) {
		this.vendorAttachmentId = vendorAttachmentId;
	}

	@Override
	public String toString() {
		return "LtMastVendorCoc [compConductId=" + compConductId + ", vendorId=" + vendorId + ", attachmentCoc="
				+ attachmentCoc + ", isAgree=" + isAgree + ", fileName=" + fileName + ", vendorAttachmentId="
				+ vendorAttachmentId + "]";
	}

	
	
}
