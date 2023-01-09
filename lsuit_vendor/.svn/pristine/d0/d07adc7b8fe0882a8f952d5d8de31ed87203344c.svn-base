
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_TAXES")

public class LtMastTaxes extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxes_seq")
	@SequenceGenerator(name = "taxes_seq", sequenceName = "LT_MAST_TAXES_S", allocationSize = 1)
	@Column(name = "TAX_ID")
	private Long taxId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "TAX_NAME")
	private String taxName;
	@Column(name = "TAX_CATEGORY_ID")
	private Long taxCategoryId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "TAX_RATE")
	private Double taxRate;
	

	@Size(max = 30)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PRODUCT_TYPE")
	private String productType;
	@NotNull
	@Size(max = 80)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "HSN_SAC_CODE")
	private String hsnSacCode;
	@NotNull
	@Size(max = 30)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STATE_CODE")
	private String stateCode;
	
	@Size(max = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "ITC_FLAG")
	private String itcFlag;
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STATUS")
	private String status;
	public Long getTaxId() {
		return taxId;
	}
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public Long getTaxCategoryId() {
		return taxCategoryId;
	}
	public void setTaxCategoryId(Long taxCategoryId) {
		this.taxCategoryId = taxCategoryId;
	}
	public Double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getHsnSacCode() {
		return hsnSacCode;
	}
	public void setHsnSacCode(String hsnSacCode) {
		this.hsnSacCode = hsnSacCode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getItcFlag() {
		return itcFlag;
	}
	public void setItcFlag(String itcFlag) {
		this.itcFlag = itcFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LtP2pTaxes [taxId=" + taxId + ", taxName=" + taxName + ", taxCategoryId=" + taxCategoryId + ", taxRate="
				+ taxRate + ", productType=" + productType + ", hsnSacCode=" + hsnSacCode + ", stateCode=" + stateCode
				+ ", itcFlag=" + itcFlag + ", status=" + status + "]";
	} 
	
	
	
}
