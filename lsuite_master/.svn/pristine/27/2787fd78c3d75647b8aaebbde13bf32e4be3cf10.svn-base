
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


@Entity
@Table(name = "LT_MAST_TAX_MASTER")
public class LtMastTaxes extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxes_seq")
	@SequenceGenerator(name = "taxes_seq", sequenceName = "LT_MAST_TAXES_S", allocationSize = 1)
	@Column(name = "TAX_ID")
	private Long taxId;
	
	@Column(name = "TAX_NAME")
	private String taxName;
	
	@Column(name = "TAX_RATE")
	private Double taxRate;
	
	@Column(name = "TAX_DESC")
	private String taxDesc;
	
	@Column(name = "HSN_SAC_CODE")
	private String hsnSacCode;
	
	@Column(name = "SOURCE_STATE_CODE")
	private String sourceStateCode;
	
	@Column(name = "DESTINATION_STATE_CODE")
	private String destinationStateCode;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String statusValue;
	
	
	@Transient
	private String destinationStateCodeValue;
	
	@Transient
	private String sourceStateCodeValue;

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

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxDesc() {
		return taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	public String getHsnSacCode() {
		return hsnSacCode;
	}

	public void setHsnSacCode(String hsnSacCode) {
		this.hsnSacCode = hsnSacCode;
	}

	public String getSourceStateCode() {
		return sourceStateCode;
	}

	public void setSourceStateCode(String sourceStateCode) {
		this.sourceStateCode = sourceStateCode;
	}

	public String getDestinationStateCode() {
		return destinationStateCode;
	}

	public void setDestinationStateCode(String destinationStateCode) {
		this.destinationStateCode = destinationStateCode;
	}

	public String getDestinationStateCodeValue() {
		return destinationStateCodeValue;
	}

	public void setDestinationStateCodeValue(String destinationStateCodeValue) {
		this.destinationStateCodeValue = destinationStateCodeValue;
	}

	public String getSourceStateCodeValue() {
		return sourceStateCodeValue;
	}

	public void setSourceStateCodeValue(String sourceStateCodeValue) {
		this.sourceStateCodeValue = sourceStateCodeValue;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
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
		return "LtMastTaxes [taxId=" + taxId + ", taxName=" + taxName + ", taxRate=" + taxRate + ", taxDesc=" + taxDesc
				+ ", hsnSacCode=" + hsnSacCode + ", sourceStateCode=" + sourceStateCode + ", destinationStateCode="
				+ destinationStateCode + ", status=" + status + ", companyId=" + companyId + ", statusValue="
				+ statusValue + ", destinationStateCodeValue=" + destinationStateCodeValue + ", sourceStateCodeValue="
				+ sourceStateCodeValue + "]";
	}

	
	
}
