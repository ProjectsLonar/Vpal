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
import javax.persistence.Transient;

@Entity
@Table(name = "LT_MAST_COMMUNICATION_TAB")
public class LtMastCommunicationTab {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communication_seq")
	@SequenceGenerator(name = "communication_seq", sequenceName = "LT_MAST_COMMUNICATION_TAB_SEQ", allocationSize = 1)
	@Column(name = "COMMUNICATION_ID")
	private Long communicationId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "BUYER_ID")
	private Long buyerId;
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	
	
	
	@Transient
	private String vendorName;
	
	@Transient
	private String buyerName;

	@Transient
	private String vendorMsg;
	
	@Transient
	private String buyerMsg;
	
	public Long getCommunicationId() {
		return communicationId;
	}

	public void setCommunicationId(Long communicationId) {
		this.communicationId = communicationId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getVendorMsg() {
		return vendorMsg;
	}

	public void setVendorMsg(String vendorMsg) {
		this.vendorMsg = vendorMsg;
	}

	public String getBuyerMsg() {
		return buyerMsg;
	}

	public void setBuyerMsg(String buyerMsg) {
		this.buyerMsg = buyerMsg;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastCommunicationTab [communicationId=" + communicationId + ", vendorId=" + vendorId + ", companyId="
				+ companyId + ", buyerId=" + buyerId + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate="
				+ lastUpdateDate + ", vendorName=" + vendorName + ", buyerName=" + buyerName + ", vendorMsg="
				+ vendorMsg + ", buyerMsg=" + buyerMsg + "]";
	}

	
	
	
}
