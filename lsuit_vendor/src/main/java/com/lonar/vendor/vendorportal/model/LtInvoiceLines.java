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
@Table(name = "LT_INVOICE_LINES")
@JsonInclude(Include.NON_NULL)
public class LtInvoiceLines 
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq")
	@SequenceGenerator(name = "vendor_seq", sequenceName = "LT_INVOICE_LINES_S", allocationSize = 1)
	@Column(name = "Invoice_Line_Id")
	private Long invoiceLineId;
	
	@Column(name = "Invoice_Header_Id")
	private Long invoiceHeaderId;
	
	@Column(name = "Inv_Line_No")
	private Long invLineNo;
	
	@Column(name = "Inv_Line_Type")
	private String invLineType;
	
	@Column(name = "PO_HEADER_ID")
	private Long poHeaderId;
	
	@Column(name = "PO_LINE_ID")
	private Long poLineId;
	
	@Column(name = "PO_SHIPMENT_LINE_ID")
	private Long poShipmentLineId;
	
	@Column(name = "Line_Type")
	private String lineType;
	
	@Column(name = "CATEGORY_ID")
	private Long categoryId;
	
	@Column(name = "SUB_CATEGORY_ID")
	private Long subCategoryId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "UOM")
	private String uom;
	
	@Column(name = "Invoice_Quantity")
	private Double invoiceQuantity;
	
	@Column(name = "Invoice_Rate")
	private Double invoiceRate;
	
	@Column(name = "Invoice_Line_Amount")
	private Double invoiceLineAmount;
	
	@Column(name = "HSN_SAC_NO")
	private String hsnSacNo;
	
	@Column(name = "Tax_Amount")
	private Double taxAmount;
	
	@Column(name = "Total_Amount")
	private Double totalAmount;
	
	@Column(name = "Asset_Flag")
	private String assetFlag;
	
	@Column(name = "Serial_Number")
	private String serialNumber;
	
	@Column(name = "Asset_Code")
	private String assetCode;
	
	@Column(name = "Installation_Date")
	private Date installationDate;
	
	@Column(name = "Delivery_Date")
	private Date deliveryDate;
	
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
	private String productName;
	
	@Transient
	private String categoryName;
	
	
	@Transient
	private String subCategory;
	
	@Transient
	private String quantity;
	
	@Transient
	private Double orderedQuantity;

	@Transient
	private Long rnum;
	
	@Transient
	private String poNumber;
	
	@Transient
	private Long lineNum;

	@Transient
	private String invoiceQunStr;
	 
	@Transient
	private String taxAmountStr;
	   
	@Transient
	private String totalAmountStr;
	
	public Long getInvoiceLineId() {
		return invoiceLineId;
	}

	public void setInvoiceLineId(Long invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}

	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public Long getInvLineNo() {
		return invLineNo;
	}

	public void setInvLineNo(Long invLineNo) {
		this.invLineNo = invLineNo;
	}

	public String getInvLineType() {
		return invLineType;
	}

	public void setInvLineType(String invLineType) {
		this.invLineType = invLineType;
	}

	public Long getPoHeaderId() {
		return poHeaderId;
	}

	public void setPoHeaderId(Long poHeaderId) {
		this.poHeaderId = poHeaderId;
	}

	public Long getPoLineId() {
		return poLineId;
	}

	public void setPoLineId(Long poLineId) {
		this.poLineId = poLineId;
	}

	public Long getPoShipmentLineId() {
		return poShipmentLineId;
	}

	public void setPoShipmentLineId(Long poShipmentLineId) {
		this.poShipmentLineId = poShipmentLineId;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Double getInvoiceLineAmount() {
		return invoiceLineAmount;
	}

	public void setInvoiceLineAmount(Double invoiceLineAmount) {
		this.invoiceLineAmount = invoiceLineAmount;
	}

	public String getHsnSacNo() {
		return hsnSacNo;
	}

	public void setHsnSacNo(String hsnSacNo) {
		this.hsnSacNo = hsnSacNo;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAssetFlag() {
		return assetFlag;
	}

	public void setAssetFlag(String assetFlag) {
		this.assetFlag = assetFlag;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(Double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public Long getRnum() {
		return rnum;
	}

	public void setRnum(Long rnum) {
		this.rnum = rnum;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Long getLineNum() {
		return lineNum;
	}

	public void setLineNum(Long lineNum) {
		this.lineNum = lineNum;
	}

	public String getInvoiceQunStr() {
		return invoiceQunStr;
	}

	public void setInvoiceQunStr(String invoiceQunStr) {
		this.invoiceQunStr = invoiceQunStr;
	}

	public String getTaxAmountStr() {
		return taxAmountStr;
	}

	public void setTaxAmountStr(String taxAmountStr) {
		this.taxAmountStr = taxAmountStr;
	}

	public String getTotalAmountStr() {
		return totalAmountStr;
	}

	public void setTotalAmountStr(String totalAmountStr) {
		this.totalAmountStr = totalAmountStr;
	}

	@Override
	public String toString() {
		return "LtInvoiceLines [invoiceLineId=" + invoiceLineId + ", invoiceHeaderId=" + invoiceHeaderId
				+ ", invLineNo=" + invLineNo + ", invLineType=" + invLineType + ", poHeaderId=" + poHeaderId
				+ ", poLineId=" + poLineId + ", poShipmentLineId=" + poShipmentLineId + ", lineType=" + lineType
				+ ", categoryId=" + categoryId + ", subCategoryId=" + subCategoryId + ", productId=" + productId
				+ ", description=" + description + ", uom=" + uom + ", invoiceQuantity=" + invoiceQuantity
				+ ", invoiceRate=" + invoiceRate + ", invoiceLineAmount=" + invoiceLineAmount + ", hsnSacNo=" + hsnSacNo
				+ ", taxAmount=" + taxAmount + ", totalAmount=" + totalAmount + ", assetFlag=" + assetFlag
				+ ", serialNumber=" + serialNumber + ", assetCode=" + assetCode + ", installationDate="
				+ installationDate + ", deliveryDate=" + deliveryDate + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", draw=" + draw + ", start=" + start + ", length=" + length
				+ ", columnNo=" + columnNo + ", sort=" + sort + ", productName=" + productName + ", categoryName="
				+ categoryName + ", subCategory=" + subCategory + ", quantity=" + quantity + ", orderedQuantity="
				+ orderedQuantity + ", rnum=" + rnum + ", poNumber=" + poNumber + ", lineNum=" + lineNum + "]";
	}
	
	
	
}
