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
@Table(name = "LT_MAST_UNIT")
public class LtMastUnitMaster extends BaseClass{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
	@SequenceGenerator(name = "unit_seq", sequenceName = "LT_MAST_UNIT_S", allocationSize = 1)
	@Column(name = "UNIT_ID")
	private Long unitId;
	
	@Column(name = "UNIT_CODE")
	private String unitCode;
	
	@Column(name = "UNIT_NAME")
	private String unitName;
	
	@Column(name = "UNIT_DESC")
	private String unitDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitDesc() {
		return unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
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
		return "LtMastUnitMaster [unitId=" + unitId + ", unitCode=" + unitCode + ", unitName=" + unitName
				+ ", unitDesc=" + unitDesc + ", status=" + status + ", companyId=" + companyId + "]";
	}
}
