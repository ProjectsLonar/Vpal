
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
@Table(name = "LT_MAST_PRODUCT_DIVISIONS")
/*@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LtP2pProductDivisions.findAll", query = "SELECT l FROM LtP2pProductDivisions l"),
		@NamedQuery(name = "LtP2pProductDivisions.findByProductId", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.productId = :productId"),
		@NamedQuery(name = "LtP2pProductDivisions.findAllActive", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pProductDivisions.findByProductIdAndDivisionId", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.productId = :productId AND l.divisionId = :divisionId"),
		@NamedQuery(name = "LtP2pProductDivisions.findByDivisionId", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.divisionId = :divisionId"),
		@NamedQuery(name = "LtP2pProductDivisions.findByStartDate", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.startDate = :startDate"),
		@NamedQuery(name = "LtP2pProductDivisions.findByEndDate", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.endDate = :endDate"),
		@NamedQuery(name = "LtP2pProductDivisions.findByCreatedBy", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.createdBy = :createdBy"),
		@NamedQuery(name = "LtP2pProductDivisions.findByCreationDate", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.creationDate = :creationDate"),
		@NamedQuery(name = "LtP2pProductDivisions.findByLastUpdateLogin", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.lastUpdateLogin = :lastUpdateLogin"),
		@NamedQuery(name = "LtP2pProductDivisions.findByLastUpdatedBy", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.lastUpdatedBy = :lastUpdatedBy"),
		@NamedQuery(name = "LtP2pProductDivisions.findByLastUpdateDate", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.lastUpdateDate = :lastUpdateDate"),
		@NamedQuery(name = "LtP2pProductDivisions.findByProductdivisionid", query = "SELECT l FROM LtP2pProductDivisions l WHERE l.productdivisionid = :productdivisionid") })*/
public class LtMastProductDivisions extends BaseClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productDivision_seq")
	@SequenceGenerator(name = "productDivision_seq", sequenceName = " LT_MAST_PRODUCT_DIVISIONS_S", allocationSize = 1)
	@Basic(optional = false)
	@Column(name = "PRODUCT_DIVISION_ID")
	private Long productDivisionId;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "DIVISION_ID")
	private Long divisionId;
	
	@Column(name = "STATUS")
	private String status; 

	@Transient
	private String updateFlag;

	@Transient
	private String divisionCode;
	
	@Transient
	private String divisionName;

	public Long getProductDivisionId() {
		return productDivisionId;
	}

	public void setProductDivisionId(Long productDivisionId) {
		this.productDivisionId = productDivisionId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	@Override
	public String toString() {
		return "LtP2pProductDivisions [productDivisionId=" + productDivisionId + ", productId=" + productId
				+ ", divisionId=" + divisionId + ", status=" + status + ", updateFlag=" + updateFlag + ", divisionCode="
				+ divisionCode + ", divisionName=" + divisionName + "]";
	}

	
	

}
