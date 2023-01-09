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
@Table(name = "LT_MAST_TAX_TYPE")
public class LtMastTaxType extends BaseClass {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
	@SequenceGenerator(name = "unit_seq", sequenceName = "LT_MAST_TAX_TYPE_S", allocationSize = 1)
	@Column(name = "TAX_TYPE_ID")
	private Long taxTypeId;
	
	@Column(name = "TAX_TYPE_CODE")
	private String taxTypeCode;
	
	@Column(name = "TAX_TYPE_NAME")
	private String taxTypeName;
	
	@Column(name = "TAX_TYPE_DESC")
	private String taxTypeDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(Long taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public String getTaxTypeCode() {
		return taxTypeCode;
	}

	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	public String getTaxTypeName() {
		return taxTypeName;
	}

	public void setTaxTypeName(String taxTypeName) {
		this.taxTypeName = taxTypeName;
	}

	public String getTaxTypeDesc() {
		return taxTypeDesc;
	}

	public void setTaxTypeDesc(String taxTypeDesc) {
		this.taxTypeDesc = taxTypeDesc;
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
		return "LtMastTaxType [taxTypeId=" + taxTypeId + ", taxTypeCode=" + taxTypeCode + ", taxTypeName=" + taxTypeName
				+ ", taxTypeDesc=" + taxTypeDesc + ", status=" + status + ", companyId=" + companyId + "]";
	}
	
	
}
