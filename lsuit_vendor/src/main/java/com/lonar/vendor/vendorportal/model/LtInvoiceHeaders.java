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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_INVOICE_HEADERS")
@JsonInclude(Include.NON_NULL)
public class LtInvoiceHeaders {
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq")
	@SequenceGenerator(name = "vendor_seq", sequenceName = "LT_INVOICE_HEADERS_S", allocationSize = 1)
	@Column(name = "Invoice_Header_Id")
	private Long invoiceHeaderId;
	
	@Column(name = "Internal_Invoice_Number")
	private String internalInvoiceNumber;

	@Column(name = "INVOICE_TYPE")
	private String invoiceType;
	
	@Column(name = "INVOICE_NUM")
	private String invoiceNum;
	
	@Column(name = "Invoice_Date")
	private Date invoiceDate;
	
	@Column(name = "INVOICE_RECEIVED_DATE")
	private Date invoiceReceivedDate;
	
	@Column(name = "PO_Header_ID")
	private Long poHeaderId;
	
	@Column(name = "Buyer_id")
	private Long buyerId;
	
	@Column(name = "Vendor_id")
	private Long vendorId;
	
	@Column(name = "Vendor_Add_id")
	private Long vendorAddId;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Invoice_Amount")
	private Double invoiceAmount;
	
	@Column(name = "Billing_Add_ID")
	private Long billingAddId;
	
	@Column(name = "Shipping_Add_ID")
	private Long shippingAddId;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Amount_Paid")
	private Double amountPaid;
	
	@Column(name = "Voucher_Num")
	private String voucherNum;
	
	@Column(name = "Voucher_Date")
	private Date voucherDate;
	
	@Column(name = "Invoice_Currency")
	private String invoiceCurrency;
	
	@Column(name = "Source")
	private String source;
	
	@Column(name = "Source_Ref_No")
	private String sourceRefNo;
	
	@Column(name = "Created_by")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "Creation_date")
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@Column(name = "Last_updated_by")
	private Long lastUpdatedBy;
	
	@Column(name = "Last_update_date")
	private Date lastUpdateDate;
	
	@Column(name = "EXCHANGE_RATE")
	private Double exchangeRate;
	
	@Column(name = "BASE_AMOUNT")
	private Double baseAmount;
	
	@Column(name = "INITIATOR_ID")
	private Long initiatorId;
	
	@Column(name = "DIVISION_ID")
	private Long divisionId;
	
	@Column(name = "PAYTERM_ID")
	private Long paytermId;
	
	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String iDate;
	
	@Transient
	private String revDate;
	
	@Transient
	private int columnNo;
	
	@Transient
	private String sort;

	@Transient
	private String buyer;
	
	@Transient
	private String invoiceStatus;
	
	@Transient
	private String type;
	
	@Transient
	private String vendorName;
	
	@Transient
	private String initiatorName;
	
	@Transient
	private String divisionName;
	
	@Transient
	private String poNumber;
	
	@Transient
	private Double poAmount;
	
	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public String getInternalInvoiceNumber() {
		return internalInvoiceNumber;
	}

	public void setInternalInvoiceNumber(String internalInvoiceNumber) {
		this.internalInvoiceNumber = internalInvoiceNumber;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getInvoiceReceivedDate() {
		return invoiceReceivedDate;
	}

	public void setInvoiceReceivedDate(Date invoiceReceivedDate) {
		this.invoiceReceivedDate = invoiceReceivedDate;
	}

	public Long getPoHeaderId() {
		return poHeaderId;
	}

	public void setPoHeaderId(Long poHeaderId) {
		this.poHeaderId = poHeaderId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Long getBillingAddId() {
		return billingAddId;
	}

	public void setBillingAddId(Long billingAddId) {
		this.billingAddId = billingAddId;
	}

	public Long getShippingAddId() {
		return shippingAddId;
	}

	public void setShippingAddId(Long shippingAddId) {
		this.shippingAddId = shippingAddId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getVoucherNum() {
		return voucherNum;
	}

	public void setVoucherNum(String voucherNum) {
		this.voucherNum = voucherNum;
	}

	public Date getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}

	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
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

	public String getiDate() {
		return iDate;
	}

	public void setiDate(String iDate) {
		this.iDate = iDate;
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

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Long getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getPaytermId() {
		return paytermId;
	}

	public void setPaytermId(Long paytermId) {
		this.paytermId = paytermId;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Double getPoAmount() {
		return poAmount;
	}

	public void setPoAmount(Double poAmount) {
		this.poAmount = poAmount;
	}

	@Override
	public String toString() {
		return "LtInvoiceHeaders [invoiceHeaderId=" + invoiceHeaderId + ", internalInvoiceNumber="
				+ internalInvoiceNumber + ", invoiceType=" + invoiceType + ", invoiceNum=" + invoiceNum
				+ ", invoiceDate=" + invoiceDate + ", invoiceReceivedDate=" + invoiceReceivedDate + ", poHeaderId="
				+ poHeaderId + ", buyerId=" + buyerId + ", vendorId=" + vendorId + ", vendorAddId=" + vendorAddId
				+ ", description=" + description + ", invoiceAmount=" + invoiceAmount + ", billingAddId=" + billingAddId
				+ ", shippingAddId=" + shippingAddId + ", status=" + status + ", amountPaid=" + amountPaid
				+ ", voucherNum=" + voucherNum + ", voucherDate=" + voucherDate + ", invoiceCurrency=" + invoiceCurrency
				+ ", source=" + source + ", sourceRefNo=" + sourceRefNo + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", exchangeRate=" + exchangeRate + ", baseAmount=" + baseAmount
				+ ", initiatorId=" + initiatorId + ", divisionId=" + divisionId + ", paytermId=" + paytermId + ", draw="
				+ draw + ", start=" + start + ", length=" + length + ", iDate=" + iDate + ", revDate=" + revDate
				+ ", columnNo=" + columnNo + ", sort=" + sort + ", buyer=" + buyer + ", invoiceStatus=" + invoiceStatus
				+ ", type=" + type + ", vendorName=" + vendorName + ", initiatorName=" + initiatorName
				+ ", divisionName=" + divisionName + ", poNumber=" + poNumber + ", poAmount=" + poAmount + "]";
	}

	


	
	
}
