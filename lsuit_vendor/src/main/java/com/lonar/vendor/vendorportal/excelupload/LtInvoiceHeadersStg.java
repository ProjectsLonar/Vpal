package com.lonar.vendor.vendorportal.excelupload;

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

@Entity
@Table(name = "LT_INVOICE_HEADERS_STG")
public class LtInvoiceHeadersStg {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_stg_s")
	@SequenceGenerator(name = "invoice_stg_s", sequenceName = "LT_INVOICE_HEADERS_STG_S", allocationSize = 1)
	@Column(name = "INVOICE_IMPORT_ID")
	private Long invoiceImportId;
	
	@Column(name = "REQUEST_ID")
	private Long requestId;
	
	@Column(name = "SOURCE_SYSTEM")
	private String sourceSystem;
	
	@Column(name = "SOURCE_REF_NO")
	private String sourceRefNo;
	
	@Column(name = "SOURCE_DATE")
	private Date sourceDate;
	
	@Column(name = "INVOICE_TYPE")
	private String invoiceType;
	
	@Column(name = "INVOICE_NUMBER")
	private String invoiceNumber;
	
	@Column(name = "INVOICE_DATE")
	private Date invoiceDate;
	
	@Column(name = "INVOICE_RECEIVED_DATE")
	private Date invoiceReceivedDate;
	
	@Column(name = "PO_NUMBER")
	private String poNumber;
	
	@Column(name = "BUYER")
	private String buyer;
	
	@Column(name = "VENDOR_CODE")
	private String vendorCode;
	
	@Column(name = "VENDOR_ADDRESS_CODE")
	private String vendorAddressCode;
	
	@Column(name = "BILLING_ADDRESS")
	private String billingAddress;
	
	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAddress;
	
	@Column(name = "INVOICE_CURRENCY_CODE")
	private String invoiceCurrencyCode;
	
	@Column(name = "EXCHANGE_RATE")
	private Double exchangeRate;
	
	@Column(name = "PAYTERMS")
	private String payterms;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "RECORD_STATUS")
	private String recordStatus;
	
	@Column(name = "INVOICE_LINE_NUMBER")
	private Long invoiceLineNumber;
	
	@Column(name = "PO_LINE_NO")
	private Long poLineNo;
	
	@Column(name = "SHIPMENT_LINE_NO")
	private Long shipmentLineNo;
	
	@Column(name = "LINE_TYPE")
	private String lineType;
	
	@Column(name = "PRODUCT_CATEGORY_CODE")
	private String productCategoryCode;
	
	@Column(name = "SUB_CATEGORY_CODE")
	private String subCategoryCode;
	
	@Column(name = "PRODUCT")
	private String product;
	
	@Column(name = "LINE_DESCRIPTION")
	private String lineDescription;
	
	@Column(name = "UOM")
	private String uom;
	
	@Column(name = "INVOICE_QUANTITY")
	private Double invoiceQuantity;
	
	@Column(name = "INVOICE_RATE")
	private Double invoiceRate;
	
	/*@Column(name = "INVOICE_LINE_NO")
	private Long invoiceLineNo;*/
	
	@Column(name = "TAX_NAME")
	private String taxName;
	
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Basic(optional = false)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "ERROR_MESSAGE")
	private String errorMessage;
	
	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;
	
	@Transient
	private int columnNo;
	
	@Transient
	private String sort;
	
	@Transient
	private String iDate;
	
	public Long getInvoiceImportId() {
		return invoiceImportId;
	}

	public void setInvoiceImportId(Long invoiceImportId) {
		this.invoiceImportId = invoiceImportId;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getSourceRefNo() {
		return sourceRefNo;
	}

	public void setSourceRefNo(String sourceRefNo) {
		this.sourceRefNo = sourceRefNo;
	}

	public Date getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(Date sourceDate) {
		this.sourceDate = sourceDate;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorAddressCode() {
		return vendorAddressCode;
	}

	public void setVendorAddressCode(String vendorAddressCode) {
		this.vendorAddressCode = vendorAddressCode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getInvoiceCurrencyCode() {
		return invoiceCurrencyCode;
	}

	public void setInvoiceCurrencyCode(String invoiceCurrencyCode) {
		this.invoiceCurrencyCode = invoiceCurrencyCode;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getPayterms() {
		return payterms;
	}

	public void setPayterms(String payterms) {
		this.payterms = payterms;
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

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Long getInvoiceLineNumber() {
		return invoiceLineNumber;
	}

	public void setInvoiceLineNumber(Long invoiceLineNumber) {
		this.invoiceLineNumber = invoiceLineNumber;
	}

	public Long getPoLineNo() {
		return poLineNo;
	}

	public void setPoLineNo(Long poLineNo) {
		this.poLineNo = poLineNo;
	}

	public Long getShipmentLineNo() {
		return shipmentLineNo;
	}

	public void setShipmentLineNo(Long shipmentLineNo) {
		this.shipmentLineNo = shipmentLineNo;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getProductCategoryCode() {
		return productCategoryCode;
	}

	public void setProductCategoryCode(String productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}

	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getLineDescription() {
		return lineDescription;
	}

	public void setLineDescription(String lineDescription) {
		this.lineDescription = lineDescription;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Double getInvoiceQuantity() {
		return invoiceQuantity;
	}

	public void setInvoiceQuantity(Double invoiceQuantity) {
		this.invoiceQuantity = invoiceQuantity;
	}

	public Double getInvoiceRate() {
		return invoiceRate;
	}

	public void setInvoiceRate(Double invoiceRate) {
		this.invoiceRate = invoiceRate;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getiDate() {
		return iDate;
	}

	public void setiDate(String iDate) {
		this.iDate = iDate;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LtInvoiceHeadersStg [invoiceImportId=" + invoiceImportId + ", requestId=" + requestId
				+ ", sourceSystem=" + sourceSystem + ", sourceRefNo=" + sourceRefNo + ", sourceDate=" + sourceDate
				+ ", invoiceType=" + invoiceType + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
				+ ", invoiceReceivedDate=" + invoiceReceivedDate + ", poNumber=" + poNumber + ", buyer=" + buyer
				+ ", vendorCode=" + vendorCode + ", vendorAddressCode=" + vendorAddressCode + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + ", invoiceCurrencyCode="
				+ invoiceCurrencyCode + ", exchangeRate=" + exchangeRate + ", payterms=" + payterms + ", status="
				+ status + ", description=" + description + ", recordStatus=" + recordStatus + ", invoiceLineNumber="
				+ invoiceLineNumber + ", poLineNo=" + poLineNo + ", shipmentLineNo=" + shipmentLineNo + ", lineType="
				+ lineType + ", productCategoryCode=" + productCategoryCode + ", subCategoryCode=" + subCategoryCode
				+ ", product=" + product + ", lineDescription=" + lineDescription + ", uom=" + uom
				+ ", invoiceQuantity=" + invoiceQuantity + ", invoiceRate=" + invoiceRate + ", taxName=" + taxName
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", companyId=" + companyId
				+ ", errorMessage=" + errorMessage + ", draw=" + draw + ", start=" + start + ", length=" + length
				+ ", columnNo=" + columnNo + ", sort=" + sort + ", iDate=" + iDate + "]";
	}

	
}
