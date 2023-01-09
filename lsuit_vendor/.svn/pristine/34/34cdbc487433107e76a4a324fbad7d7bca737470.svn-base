/*package com.lonar.vendor.vendorportal.excelupload;

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

@Entity
@Table(name = "LT_INVOICE_LINES_STG")
public class LtInvoiceLinesStg {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_line_stg_s")
	@SequenceGenerator(name = "invoice_line_stg_s", sequenceName = "LT_INVOICE_LINES_STG_S", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "SOURCE_SYSTEM")
	private String sourceSystem;
	
	@Column(name = "SOURCE_REF_NO")
	private String sourceRefNo;
	
	@Column(name = "SOURCE_DATE")
	private Date sourceDate;
	
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
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "UOM")
	private String uom;
	
	@Column(name = "INVOICE_QUANTITY")
	private Double invoiceQuantity;
	
	@Column(name = "INVOICE_RATE")
	private Double invoiceRate;
	
	@Column(name = "RECORD_STATUS")
	private String recordStatus;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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

	@Override
	public String toString() {
		return "LtInvoiceLinesStg [id=" + id + ", sourceSystem=" + sourceSystem + ", sourceRefNo=" + sourceRefNo
				+ ", sourceDate=" + sourceDate + ", invoiceLineNumber=" + invoiceLineNumber + ", poLineNo=" + poLineNo
				+ ", shipmentLineNo=" + shipmentLineNo + ", lineType=" + lineType + ", productCategoryCode="
				+ productCategoryCode + ", subCategoryCode=" + subCategoryCode + ", product=" + product
				+ ", description=" + description + ", uom=" + uom + ", invoiceQuantity=" + invoiceQuantity
				+ ", invoiceRate=" + invoiceRate + ", recordStatus=" + recordStatus + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	
	
}
*/