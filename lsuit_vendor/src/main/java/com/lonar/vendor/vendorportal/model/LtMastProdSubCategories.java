
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

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


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

	@Size(min = 3, max = 80)
	@Column(name = "SUB_CATEGORY")
	private String subCategory;

	@Column(name = "HSN_SAC_CODE")
	private String hsnSacCode;

	
	@NotNull
	@Column(name = "SUB_CATEGORY_CODE")
	private String subCategoryCode;

	@Column(name = "STATUS")
	private String status;


	@Column(name = "GL_ACCOUNT_ID")
	private Long glAccountId;

	@Size(max = 2000)
	@Column(name = "DELIVERY_TERMS")
	private String deliveryTerms;
	
	@Size(max = 2000)
	@Column(name = "PENALTY_TERMS")
	private String penaltyTerms;
	
	@Size(max = 2000)
	@Column(name = "WARRANTY_TERMS")
	private String warrantyTerms;
	
	@Size(max = 2000)
	@Column(name = "PRICING_TERMS")
	private String pricingTerms;
	
	@Size(max = 2000)
	@Column(name = "DOCS_FOR_PAYMENT")
	private String docsForPayment;
	
	
	@Size(max = 2000)
	@Column(name = "BILLING_ADDRESS")
	private String billingAddress;
	
	@Size(max = 2000)
	@Column(name = "CSA")
	private String csa;
	
	@Size(max = 2000)
	@Column(name = "OTHER_CONDITIONS")
	private String otherConditions;
	
	@Size(max = 2000)
	@Column(name = "SAFETY")
	private String safety;
	
	@Column(name="INVOICE_SUBMISSION_DATE")
	private String invoiceSubmissionDate;
	
	@Size(max = 2000)
	@Column(name = "PROD_WORK_PROPERTY")
	private String prodWorkProperty;
	
	@Size(max = 2000)
	@Column(name = "INSURANCE")
	private String insurance;
	
	@Size(max = 2000)
	@Column(name = "INVOICE_SUBMISSION")
	private String invoiceSubmission;

	@Column(name = "ADVANCE_GL_ACCOUNT")
	private Long advanceGlAccount;

	@Size(max = 8)
	@Column(name = "FA_MAJOR_CATEGORY")
	private String faMajorCategory;

	@Size(max = 8)
	@Column(name = "FA_MINOR_CATEGORY")
	private String faMinorCategory;
	
	@Column(name="Description")
	private String description;

	//Changes made by @RUTU on 12-09-2017
	@Transient
	private String advanceGlAccountName;
	
	//Changes made by @RUTU on 12-09-2017
	@Transient 
	private String advanceGlAccountCode;
	
	@Transient
	private String glAccountName;

	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String glAccountCode;

	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String categoryName;
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String categoryCode;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getGlAccountId() {
		return glAccountId;
	}

	public void setGlAccountId(Long glAccountId) {
		this.glAccountId = glAccountId;
	}

	public String getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public String getPenaltyTerms() {
		return penaltyTerms;
	}

	public void setPenaltyTerms(String penaltyTerms) {
		this.penaltyTerms = penaltyTerms;
	}

	public String getWarrantyTerms() {
		return warrantyTerms;
	}

	public void setWarrantyTerms(String warrantyTerms) {
		this.warrantyTerms = warrantyTerms;
	}

	public String getPricingTerms() {
		return pricingTerms;
	}

	public void setPricingTerms(String pricingTerms) {
		this.pricingTerms = pricingTerms;
	}

	public String getDocsForPayment() {
		return docsForPayment;
	}

	public void setDocsForPayment(String docsForPayment) {
		this.docsForPayment = docsForPayment;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCsa() {
		return csa;
	}

	public void setCsa(String csa) {
		this.csa = csa;
	}

	public String getOtherConditions() {
		return otherConditions;
	}

	public void setOtherConditions(String otherConditions) {
		this.otherConditions = otherConditions;
	}

	public String getSafety() {
		return safety;
	}

	public void setSafety(String safety) {
		this.safety = safety;
	}

	public String getInvoiceSubmissionDate() {
		return invoiceSubmissionDate;
	}

	public void setInvoiceSubmissionDate(String invoiceSubmissionDate) {
		this.invoiceSubmissionDate = invoiceSubmissionDate;
	}

	public String getProdWorkProperty() {
		return prodWorkProperty;
	}

	public void setProdWorkProperty(String prodWorkProperty) {
		this.prodWorkProperty = prodWorkProperty;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInvoiceSubmission() {
		return invoiceSubmission;
	}

	public void setInvoiceSubmission(String invoiceSubmission) {
		this.invoiceSubmission = invoiceSubmission;
	}

	public Long getAdvanceGlAccount() {
		return advanceGlAccount;
	}

	public void setAdvanceGlAccount(Long advanceGlAccount) {
		this.advanceGlAccount = advanceGlAccount;
	}

	public String getFaMajorCategory() {
		return faMajorCategory;
	}

	public void setFaMajorCategory(String faMajorCategory) {
		this.faMajorCategory = faMajorCategory;
	}

	public String getFaMinorCategory() {
		return faMinorCategory;
	}

	public void setFaMinorCategory(String faMinorCategory) {
		this.faMinorCategory = faMinorCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "LtP2pProdSubCategories [subCategoryId=" + subCategoryId + ", categoryId=" + categoryId
				+ ", subCategory=" + subCategory + ", hsnSacCode=" + hsnSacCode + ", subCategoryCode=" + subCategoryCode
				+ ", status=" + status + ", glAccountId=" + glAccountId + ", deliveryTerms=" + deliveryTerms
				+ ", penaltyTerms=" + penaltyTerms + ", warrantyTerms=" + warrantyTerms + ", pricingTerms="
				+ pricingTerms + ", docsForPayment=" + docsForPayment + ", billingAddress=" + billingAddress + ", csa="
				+ csa + ", otherConditions=" + otherConditions + ", safety=" + safety + ", invoiceSubmissionDate="
				+ invoiceSubmissionDate + ", prodWorkProperty=" + prodWorkProperty + ", insurance=" + insurance
				+ ", invoiceSubmission=" + invoiceSubmission + ", advanceGlAccount=" + advanceGlAccount
				+ ", faMajorCategory=" + faMajorCategory + ", faMinorCategory=" + faMinorCategory + ", description="
				+ description + ", advanceGlAccountName=" + advanceGlAccountName + ", advanceGlAccountCode="
				+ advanceGlAccountCode + ", glAccountName=" + glAccountName + ", glAccountCode=" + glAccountCode
				+ ", categoryName=" + categoryName + ", categoryCode=" + categoryCode + "]";
	}
	
	

}
