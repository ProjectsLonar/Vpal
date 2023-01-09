
package com.lonar.vendor.vendorportal.model;

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


@Entity
@Table(name = "LT_MAST_PRODUCT_CATEGORIES")
public class LtMastProductCategories extends BaseClass  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productCategory_seq")
	@SequenceGenerator(name = "productCategory_seq", sequenceName = "LT_MAST_PRODUCT_CATEGORIES_S", allocationSize = 1)
	@Basic(optional = false)
	@Column(name = "CATEGORY_ID")
	private Long categoryId;
	
	@Size(min = 3, max = 80)
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "CATEGORY_CODE")
	private String categoryCode;

	
	@Column(name = "STATUS")
	private String status;


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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


	@Override
	public String toString() {
		return "LtP2pProductCategories [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryCode="
				+ categoryCode + ", status=" + status + "]";
	}


}
