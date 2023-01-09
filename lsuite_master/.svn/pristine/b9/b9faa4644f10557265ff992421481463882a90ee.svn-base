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
@Table(name="LT_MAST_VENDOR_MANAGMENT_DESG")
public class LtMastVenorManagmentDesg extends BaseClass{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ven_mgmt_desg_seq")
	@SequenceGenerator(name = "ven_mgmt_desg_seq", sequenceName = "LT_MAST_VENDOR_MANAGMENT_DES_S", allocationSize = 1)
	@Column(name = "VEN_MAN_DESG_ID")
	private Long venManDesgId;
	
	@Column(name = "VEN_MAN_DESG_CODE")
	private String venManDesgCode;
	
	@Column(name = "VEN_MAN_DESG_NAME")
	private String venManDesgName;
	
	@Column(name = "VEN_MAN_DESG_DESC")
	private String venManDesgDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getVenManDesgId() {
		return venManDesgId;
	}

	public void setVenManDesgId(Long venManDesgId) {
		this.venManDesgId = venManDesgId;
	}

	public String getVenManDesgCode() {
		return venManDesgCode;
	}

	public void setVenManDesgCode(String venManDesgCode) {
		this.venManDesgCode = venManDesgCode;
	}

	public String getVenManDesgName() {
		return venManDesgName;
	}

	public void setVenManDesgName(String venManDesgName) {
		this.venManDesgName = venManDesgName;
	}

	public String getVenManDesgDesc() {
		return venManDesgDesc;
	}

	public void setVenManDesgDesc(String venManDesgDesc) {
		this.venManDesgDesc = venManDesgDesc;
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
		return "LtMastVenorManagmentDesg [venManDesgId=" + venManDesgId + ", venManDesgCode=" + venManDesgCode
				+ ", venManDesgName=" + venManDesgName + ", venManDesgDesc=" + venManDesgDesc + ", status=" + status
				+ ", companyId=" + companyId + "]";
	}
	
	
}
