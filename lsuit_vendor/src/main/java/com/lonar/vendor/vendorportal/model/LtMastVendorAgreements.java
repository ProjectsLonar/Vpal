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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_VENDOR_AGREEMENTS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorAgreements extends BaseClass
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorAgreement_seq")
	@SequenceGenerator(name = "vendorAgreement_seq", sequenceName = "lt_mast_vendor_agreements_s", allocationSize = 1)
	@Column(name = "AGREEMENT_ID")
	private Long agreementId;
	
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "AGREEMENT_CODE")
	private String agreementCode;
	
	
	@Column(name = "AGREEMENT_DESC")
	private String agreementDesc;
	
	@Column(name = "ATTACHMENT")
	private String attachment;
	
	@Column(name = "PRODUCT_CATEGORY_ID")
	private Long productCategoryId;
	
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "TARGET_DATE")
	@Temporal(TemporalType.TIMESTAMP)       
	private Date targetDate;

	
	@Column(name = "VENDOR_ADD_ID")
	private Long vendorAddId;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String vendorName;
	
	@Transient
	private String vendorAddr;
	
	@Transient
	private String companyName;
	
	@Transient
	private String imageName;
	
	@Transient
	private String statusValue;
	
	@Transient
	private String addressCode;

	public Long getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(Long agreementId) {
		this.agreementId = agreementId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getAgreementCode() {
		return agreementCode;
	}

	public void setAgreementCode(String agreementCode) {
		this.agreementCode = agreementCode;
	}

	public String getAgreementDesc() {
		return agreementDesc;
	}

	public void setAgreementDesc(String agreementDesc) {
		this.agreementDesc = agreementDesc;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Long getVendorAddId() {
		return vendorAddId;
	}

	public void setVendorAddId(Long vendorAddId) {
		this.vendorAddId = vendorAddId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddr() {
		return vendorAddr;
	}

	public void setVendorAddr(String vendorAddr) {
		this.vendorAddr = vendorAddr;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	@Override
	public String toString() {
		return "LtMastVendorAgreements [agreementId=" + agreementId + ", vendorId=" + vendorId + ", agreementCode="
				+ agreementCode + ", agreementDesc=" + agreementDesc + ", attachment=" + attachment
				+ ", productCategoryId=" + productCategoryId + ", status=" + status + ", targetDate=" + targetDate
				+ ", vendorAddId=" + vendorAddId + ", companyId=" + companyId + ", vendorName=" + vendorName
				+ ", vendorAddr=" + vendorAddr + ", companyName=" + companyName + ", imageName=" + imageName
				+ ", statusValue=" + statusValue + ", addressCode=" + addressCode + "]";
	}
	
	
	
}
