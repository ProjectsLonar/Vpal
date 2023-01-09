
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

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_GROUP_PRODUCTS")
/*@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LtP2pGroupProducts.findAll", query = "SELECT l FROM LtP2pGroupProducts l"),
		@NamedQuery(name = "LtP2pGroupProducts.findAllActive", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pGroupProducts.findByGroupProductsId", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.groupProductsId = :groupProductsId"),
		@NamedQuery(name = "LtP2pGroupProducts.findByParentProductId", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.parentProductId = :parentProductId"),
		@NamedQuery(name = "LtP2pGroupProducts.findByChildProductId", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.childProductId = :childProductId"),
		@NamedQuery(name = "LtP2pGroupProducts.findByStartDate", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.startDate = :startDate"),
		@NamedQuery(name = "LtP2pGroupProducts.findByEndDate", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.endDate = :endDate"),
		@NamedQuery(name = "LtP2pGroupProducts.findByCreatedBy", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.createdBy = :createdBy"),
		@NamedQuery(name = "LtP2pGroupProducts.findByCreationDate", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.creationDate = :creationDate"),
		@NamedQuery(name = "LtP2pGroupProducts.findByLastUpdateLogin", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.lastUpdateLogin = :lastUpdateLogin"),
		@NamedQuery(name = "LtP2pGroupProducts.findByLastUpdatedBy", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.lastUpdatedBy = :lastUpdatedBy"),
		@NamedQuery(name = "LtP2pGroupProducts.findByLastUpdateDate", query = "SELECT l FROM LtP2pGroupProducts l WHERE l.lastUpdateDate = :lastUpdateDate") })*/
public class LtMastGroupProducts extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupProduct_seq")
	@SequenceGenerator(name = "groupProduct_seq", sequenceName = "LT_MAST_GROUP_PRODUCTS_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@NotNull
	@Column(name = "GROUP_PRODUCTS_ID")
	private Long groupProductsId;
	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PARENT_PRODUCT_ID")
	private Long parentProductId;
	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CHILD_PRODUCT_ID")
	private Long childProductId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "QUANTITY")
	private Long quantity;
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "REMARK")
	private String remark; 
	
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "STATUS")
	private String status; 
	
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String productCode;
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String productName;
	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String UOM;
	
	

	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String updateFlag;

	@Transient
	@JsonView(DataTablesOutput.View.class)
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
