package com.lonar.vendor.vendorportal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_MAST_PRODUCT_TYPE")
public class LtMastProductType extends BaseClass{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_seq")
	@SequenceGenerator(name = "product_type_seq", sequenceName = "LT_MAST_PRODUCT_TYPE_S", allocationSize = 1)
	@Column(name = "PRODUCT_TYPE_ID")
	private Long productTypeId;
	
	@Column(name = "PRODUCT_TYPE_CODE")
	private String productTypeCode;
	
	@Column(name = "PRODUCT_TYPE_NAME")
	private String productTypeName;
	
	@Column(name = "PRODUCT_TYPE_DESC")
	private String productTypeDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductTypeDesc() {
		return productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastProductType [productTypeId=" + productTypeId + ", productTypeCode=" + productTypeCode
				+ ", productTypeName=" + productTypeName + ", productTypeDesc=" + productTypeDesc + ", status=" + status
				+ ", companyId=" + companyId + "]";
	}
	
	
}
