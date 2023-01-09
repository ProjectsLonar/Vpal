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
import javax.validation.constraints.Size;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_PRODUCT_PAYTERMS")
public class LtP2pProductPayterms extends BaseClass implements Serializable {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payterms_seq")
	@SequenceGenerator(name = "payterms_seq", sequenceName = "LT_MAST_PRODUCT_PAYTERMS_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PAY_TERM_ID")
	private Long payTermId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "PERCENTAGE")
	private Double percentage;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2000)
	@Column(name = "TERM_NAME")
	private String termName;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "TERM_CATEGORY")
	private String termCategory;
	
	@Column(name = "STATUS")
	private String status;

	@Transient
	private String productName;
	
	
	public Long getPayTermId() {
		return payTermId;
	}

	public void setPayTermId(Long payTermId) {
		this.payTermId = payTermId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getTermCategory() {
		return termCategory;
	}

	public void setTermCategory(String termCategory) {
		this.termCategory = termCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "LtP2pProductPayterms [payTermId=" + payTermId + ", productId=" + productId + ", percentage="
				+ percentage + ", termName=" + termName + ", termCategory=" + termCategory + ", status=" + status
				+ ", productName=" + productName + "]";
	}

	
	
}
