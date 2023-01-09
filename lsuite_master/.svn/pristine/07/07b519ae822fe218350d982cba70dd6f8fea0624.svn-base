
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;

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


@Entity
@Table(name = "LT_MAST_PRODUCTS")
public class LtMastProducts extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = " LT_MAST_PRODUCTS_S", allocationSize = 1)
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_DESC")
	private String productDesc;
	
	@Column(name = "UOM")
	private Long uom;
	
	@Column(name = "MIN_ORDER_QTY")
	private Double minOrderQty;
	
	@Column(name = "MAX_ORDER_QTY")
	private Double maxOrderQty;
	
	@Column(name = "CATEGORY_ID")
	private Long categoryId;

	@Column(name = "SUB_CATEGORY_ID")
	private Long subCategoryId;

	@Column(name = "PRODUCT_TYPE")
	private String productType;

	@Column(name = "GL_ACCOUNT_ID")
	private Long glAccountId;

	@Column(name = "LINE_TYPE")
	private String lineType;

	@Column(name = "PRODUCT_IMAGE")
	private String productImage;

	@Column(name = "HSN_SAC_Code")
	private String hsnSacCode;
	
	@Column(name = "STATUS")
	private String status;
	
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String categoryName;
	
	@Transient
	private String categoryCode;
	
	@Transient
	private String subCategoryName;
	
	@Transient
	private String subCategoryCode;
	
	@Transient
	private String glAccountName;

	@Transient
	private String glAccountCode;

	@Transient
	private String productImagePath;
	
	@Transient
	private String uomValue;
	
	@Transient
	private String productTypeValue;
	
	@Transient
	private String statusValue;
	
	@Transient
	private String lineTypeValue;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Long getUom() {
		return uom;
	}

	public void setUom(Long uom) {
		this.uom = uom;
	}

	public Double getMinOrderQty() {
		return minOrderQty;
	}

	public void setMinOrderQty(Double minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public Double getMaxOrderQty() {
		return maxOrderQty;
	}

	public void setMaxOrderQty(Double maxOrderQty) {
		this.maxOrderQty = maxOrderQty;
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

	

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Long getGlAccountId() {
		return glAccountId;
	}

	public void setGlAccountId(Long glAccountId) {
		this.glAccountId = glAccountId;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getHsnSacCode() {
		return hsnSacCode;
	}

	public void setHsnSacCode(String hsnSacCode) {
		this.hsnSacCode = hsnSacCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public String getGlAccountName() {
		return glAccountName;
	}

	public void setGlAccountName(String glAccountName) {
		this.glAccountName = glAccountName;
	}

	public String getGlAccountCode() {
		return glAccountCode;
	}

	public void setGlAccountCode(String glAccountCode) {
		this.glAccountCode = glAccountCode;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getUomValue() {
		return uomValue;
	}

	public void setUomValue(String uomValue) {
		this.uomValue = uomValue;
	}

	public String getProductTypeValue() {
		return productTypeValue;
	}

	public void setProductTypeValue(String productTypeValue) {
		this.productTypeValue = productTypeValue;
	}

	public String getLineTypeValue() {
		return lineTypeValue;
	}

	public void setLineTypeValue(String lineTypeValue) {
		this.lineTypeValue = lineTypeValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastProducts [productId=" + productId + ", productCode=" + productCode + ", productName="
				+ productName + ", productDesc=" + productDesc + ", uom=" + uom + ", minOrderQty=" + minOrderQty
				+ ", maxOrderQty=" + maxOrderQty + ", categoryId=" + categoryId + ", subCategoryId=" + subCategoryId
				+ ", productTypeId=" + productType + ", glAccountId=" + glAccountId + ", lineType=" + lineType
				+ ", productImage=" + productImage + ", hsnSacCode=" + hsnSacCode + ", status=" + status
				+ ", companyId=" + companyId + ", categoryName=" + categoryName + ", categoryCode=" + categoryCode
				+ ", subCategoryName=" + subCategoryName + ", subCategoryCode=" + subCategoryCode + ", glAccountName="
				+ glAccountName + ", glAccountCode=" + glAccountCode + ", productImagePath=" + productImagePath
				+ ", uomValue=" + uomValue + ", productTypeValue=" + productTypeValue + ", statusValue=" + statusValue
				+ ", lineTypeValue=" + lineTypeValue + "]";
	}

	
	
}
