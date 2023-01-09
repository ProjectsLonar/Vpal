package com.lonar.vendor.vendorportal.model;

import java.sql.Blob;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "lt_po_headers")
@JsonInclude(Include.NON_NULL)
public class LtPoHeaders 
{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq")
	@SequenceGenerator(name = "vendor_seq", sequenceName = "lt_po_headers_s", allocationSize = 1)
	@Column(name = "PO_HEADER_ID")
	private Long poHeaderId;
	
	@Column(name = "Parent_PO_Header_Id")
	private Long parentPoHeaderId;
	
	@Column(name = "PO_Type")
	private String poType;
	
	@Column(name = "PO_NUMBER")
	private String poNumber;
	
	@Column(name = "Internal_PO_Number")
	private String internalPoNumber;
	
	@Column(name = "REVISION_NUM")
	private Long revisionNum;
	
	@Column(name = "PO_DATE")
	private Date poDate;
	
	@Column(name = "Revision_Date")
	private Date revisionDate;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "Vendor_Add_id")
	private Long vendorAddId;
	
	@Column(name = "VENDOR_CONTACT_ID")
	private String vendorContactId;
	
	@Column(name = "Billing_Add_ID")
	private Long billingAddId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Note_to_Approver")
	private String noteToApprover;
	
	@Column(name = "PO_AMOUNT")
	private Double poAmount;
	
	@Column(name = "Division_Id")
	private Long divisionId;
	
	@Column(name = "Sub_Division_Id")
	private Long subDivisionId;
	
	@Column(name = "Buyer_Id")
	private Long buyerId;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "source_ref_no")
	private String sourceRefNo;
	
	@Column(name = "Terms_Id")
	private Long termsId;
	
	@Column(name = "Terms_Date")
	private Date termsDate;
	
	@Column(name = "Currency_Code")
	private String currencyCode;
	
	@Column(name = "PO_PDF")
	private Blob  poPdf;
	
	@Column(name = "Created_by")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "Creation_date")
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "Last_update_login")
	private Long lastUpdateLogin;
	
	@Column(name = "Last_updated_by")
	private Long lastUpdatedBy;
	
	@Column(name = "Last_update_date")
	private Date lastUpdateDate;
	
	@Column(name = "ACK_FLAG")
	private String ackFlag;
	
	@Column(name = "ACK_MSG")
	private String ackMsg;
	
	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String pDate;
	
	@Transient
	private String revDate;
	
	@Transient
	private int columnNo;
	
	@Transient
	private String sort;
	
	@Transient
	private String vendorName;
	
	@Transient
	private String vendorAddress;
	
	@Transient
	private String billingAddress;
	
	@Transient
	private String agent;

	@Transient
	private String buyer;
	
	public Long getPoHeaderId() {
		return poHeaderId;
	}

	public void setPoHeaderId(Long poHeaderId) {
		this.poHeaderId = poHeaderId;
	}

	public Long getParentPoHeaderId() {
		return parentPoHeaderId;
	}

	public void setParentPoHeaderId(Long parentPoHeaderId) {
		this.parentPoHeaderId = parentPoHeaderId;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getInternalPoNumber() {
		return internalPoNumber;
	}

	public void setInternalPoNumber(String internalPoNumber) {
		this.internalPoNumber = internalPoNumber;
	}


	public Long getRevisionNum() {
		return revisionNum;
	}

	public void setRevisionNum(Long revisionNum) {
		this.revisionNum = revisionNum;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getVendorAddId() {
		return vendorAddId;
	}

	public void setVendorAddId(Long vendorAddId) {
		this.vendorAddId = vendorAddId;
	}

	

	public String getVendorContactId() {
		return vendorContactId;
	}

	public void setVendorContactId(String vendorContactId) {
		this.vendorContactId = vendorContactId;
	}

	public Long getBillingAddId() {
		return billingAddId;
	}

	public void setBillingAddId(Long billingAddId) {
		this.billingAddId = billingAddId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNoteToApprover() {
		return noteToApprover;
	}

	public void setNoteToApprover(String noteToApprover) {
		this.noteToApprover = noteToApprover;
	}

	public Double getPoAmount() {
		return poAmount;
	}

	public void setPoAmount(Double poAmount) {
		this.poAmount = poAmount;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getSubDivisionId() {
		return subDivisionId;
	}

	public void setSubDivisionId(Long subDivisionId) {
		this.subDivisionId = subDivisionId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceRefNo() {
		return sourceRefNo;
	}

	public void setSourceRefNo(String sourceRefNo) {
		this.sourceRefNo = sourceRefNo;
	}

	public Long getTermsId() {
		return termsId;
	}

	public void setTermsId(Long termsId) {
		this.termsId = termsId;
	}

	public Date getTermsDate() {
		return termsDate;
	}

	public void setTermsDate(Date termsDate) {
		this.termsDate = termsDate;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	

	public Blob getPoPdf() {
		return poPdf;
	}

	public void setPoPdf(Blob poPdf) {
		this.poPdf = poPdf;
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

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAckFlag() {
		return ackFlag;
	}

	public void setAckFlag(String ackFlag) {
		this.ackFlag = ackFlag;
	}

	public String getAckMsg() {
		return ackMsg;
	}

	public void setAckMsg(String ackMsg) {
		this.ackMsg = ackMsg;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	@Override
	public String toString() {
		return "LtPoHeaders [poHeaderId=" + poHeaderId + ", parentPoHeaderId=" + parentPoHeaderId + ", poType=" + poType
				+ ", poNumber=" + poNumber + ", internalPoNumber=" + internalPoNumber + ", revisionNum=" + revisionNum
				+ ", poDate=" + poDate + ", revisionDate=" + revisionDate + ", vendorId=" + vendorId + ", vendorAddId="
				+ vendorAddId + ", vendorContactId=" + vendorContactId + ", billingAddId=" + billingAddId
				+ ", description=" + description + ", status=" + status + ", noteToApprover=" + noteToApprover
				+ ", poAmount=" + poAmount + ", divisionId=" + divisionId + ", subDivisionId=" + subDivisionId
				+ ", buyerId=" + buyerId + ", source=" + source + ", sourceRefNo=" + sourceRefNo + ", termsId="
				+ termsId + ", termsDate=" + termsDate + ", currencyCode=" + currencyCode + ", poPdf=" + poPdf
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", ackFlag=" + ackFlag
				+ ", ackMsg=" + ackMsg + ", draw=" + draw + ", start=" + start + ", length=" + length + ", pDate="
				+ pDate + ", revDate=" + revDate + ", columnNo=" + columnNo + ", sort=" + sort + ", vendorName="
				+ vendorName + ", vendorAddress=" + vendorAddress + ", billingAddress=" + billingAddress + ", agent="
				+ agent + ", buyer=" + buyer + "]";
	}
	
}
