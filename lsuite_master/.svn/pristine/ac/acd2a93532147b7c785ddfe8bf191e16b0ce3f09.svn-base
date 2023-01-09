
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "LT_MAST_PROD_SUB_CATEGORIES")
public class LtMastProdSubCategories extends BaseClass implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pro_sub_cat_seq")
	@SequenceGenerator(name = "pro_sub_cat_seq", sequenceName = "LT_MAST_PROD_SUB_CATEGORIES_S", allocationSize = 1)
	@Column(name = "SUB_CATEGORY_ID")
	private Long subCategoryId;

	@NotNull
	@Column(name = "CATEGORY_ID")
	private Long categoryId;

//	@Size(min = 3, max = 80)
	@Column(name = "SUB_CATEGORY")
	private String subCategory;

	@Column(name = "HSN_SAC_CODE")
	private String hsnSacCode;

	
	@NotNull
	@Column(name = "SUB_CATEGORY_CODE")
	private String subCategoryCode;

	@Column(name = "GL_ACCOUNT_ID")
	private Long glAccountId;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	
	@Transient
	private String advanceGlAccountName;
	
	
	@Transient 
	private String advanceGlAccountCode;
	
	@Transient
	private String glAccountName;

	@Transient
	private String glAccountCode;

	@Transient
	private String categoryName;
	
	@Transient
	private String categoryCode;
	
	@Transient
	private String statusValue;

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getHsnSacCode() {
		return hsnSacCode;
	}

	public void setHsnSacCode(String hsnSacCode) {
		this.hsnSacCode = hsnSacCode;
	}

	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public Long getGlAccountId() {
		return glAccountId;
	}

	public void setGlAccountId(Long glAccountId) {
		this.glAccountId = glAccountId;
	}

	public String getAdvanceGlAccountName() {
		return advanceGlAccountName;
	}

	public void setAdvanceGlAccountName(String advanceGlAccountName) {
		this.advanceGlAccountName = advanceGlAccountName;
	}

	public String getAdvanceGlAccountCode() {
		return advanceGlAccountCode;
	}

	public void setAdvanceGlAccountCode(String advanceGlAccountCode) {
		this.advanceGlAccountCode = advanceGlAccountCode;
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
		return "LtMastProdSubCategories [subCategoryId=" + subCategoryId + ", categoryId=" + categoryId
				+ ", subCategory=" + subCategory + ", hsnSacCode=" + hsnSacCode + ", subCategoryCode=" + subCategoryCode
				+ ", glAccountId=" + glAccountId + ", status=" + status + ", companyId=" + companyId
				+ ", advanceGlAccountName=" + advanceGlAccountName + ", advanceGlAccountCode=" + advanceGlAccountCode
				+ ", glAccountName=" + glAccountName + ", glAccountCode=" + glAccountCode + ", categoryName="
				+ categoryName + ", categoryCode=" + categoryCode + ", statusValue=" + statusValue + "]";
	}

	

}
