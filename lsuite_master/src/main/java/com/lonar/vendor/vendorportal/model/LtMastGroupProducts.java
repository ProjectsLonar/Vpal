
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
@Table(name = "LT_MAST_GROUP_PRODUCTS")
public class LtMastGroupProducts extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupProduct_seq")
	@SequenceGenerator(name = "groupProduct_seq", sequenceName = "LT_MAST_GROUP_PRODUCTS_S", allocationSize = 1)
	@Column(name = "GROUP_PRODUCTS_ID")
	private Long groupProductsId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "PARENT_PRODUCT_ID")
	private Long parentProductId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "CHILD_PRODUCT_ID")
	private Long childProductId;
	
	@Column(name = "QUANTITY")
	private Long quantity;
	
	@Column(name = "REMARK")
	private String remark; 
	
	@Column(name = "STATUS") 
	private String status; 
	
	@Transient
	private String productCode;
	@Transient
	private String productName;
	@Transient
	private String UOM;
	
	

	@Transient
	private String updateFlag;

	@Transient
	private String childProductName;

	public Long getGroupProductsId() {
		return groupProductsId;
	}

	public void setGroupProductsId(Long groupProductsId) {
		this.groupProductsId = groupProductsId;
	}

	public Long getParentProductId() {
		return parentProductId;
	}

	public void setParentProductId(Long parentProductId) {
		this.parentProductId = parentProductId;
	}

	public long getChildProductId() {
		return childProductId;
	}

	public void setChildProductId(long childProductId) {
		this.childProductId = childProductId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getChildProductName() {
		return childProductName;
	}

	public void setChildProductName(String childProductName) {
		this.childProductName = childProductName;
	}

	@Override
	public String toString() {
		return "LtP2pGroupProducts [groupProductsId=" + groupProductsId + ", parentProductId=" + parentProductId
				+ ", childProductId=" + childProductId + ", quantity=" + quantity + ", remark=" + remark + ", status="
				+ status + ", productCode=" + productCode + ", productName=" + productName + ", UOM=" + UOM
				+ ", updateFlag=" + updateFlag + ", childProductName=" + childProductName + "]";
	}

	

	

}
