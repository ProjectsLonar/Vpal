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
@Table(name = "LT_MAST_COMMUNICATION_TAB_DET")
public class LtMastCommunicationTabDet {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "communication_det_seq")
	@SequenceGenerator(name = "communication_det_seq", sequenceName = "LT_MAST_COMM_TAB_DET_SEQ", allocationSize = 1)
	@Column(name = "MESSAGE_ID")
	private Long messageId;
	
	@Column(name = "COMMUNICATION_ID")
	private Long communicationId;
	
	@Column(name = "VENDOR_MSG")
	private String vendorMsg;
	
	@Column(name = "BUYER_MSG")
	private String buyerMsg;
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getCommunicationId() {
		return communicationId;
	}

	public void setCommunicationId(Long communicationId) {
		this.communicationId = communicationId;
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
		return "LtMastCommunicationTabDet [messageId=" + messageId + ", communicationId=" + communicationId
				+ ", vendorMsg=" + vendorMsg + ", buyerMsg=" + buyerMsg + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	
}
