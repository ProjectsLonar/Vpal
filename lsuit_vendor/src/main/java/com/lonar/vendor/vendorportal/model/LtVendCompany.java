package com.lonar.vendor.vendorportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "LT_VEND_COMPANY_MASTER")
@JsonInclude(Include.NON_NULL)
public class LtVendCompany extends BaseClass
{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	@SequenceGenerator(name = "company_seq", sequenceName = "LT_VEND_COMPANY_MASTER_S", allocationSize = 1)
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	/*@Column(name = "COMPANY_CODE")
	private String companyCode;*/
	
	@Column(name = "Regd_Address")
	private String regdAddress;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	/*@Column(name = "GST_NUMBER")
	private String gstNumber;*/
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "PIN_CODE")
	private String pinCode;
	
	@Column(name = "PAN_NUMBER")
	private String panNumber;
	
	@Column(name = "ORG_ID")
	private Long orgId;
	
	@Column(name = "LOGO_PATH")
	private String logoPath;

	@Transient
	private String fileName;
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public String getRegdAddress() {
		return regdAddress;
	}

	public void setRegdAddress(String regdAddress) {
		this.regdAddress = regdAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LtVendCompany [companyId=" + companyId + ", companyName=" + companyName + ", regdAddress=" + regdAddress
				+ ", city=" + city + ", state=" + state + ", status=" + status + ", pinCode=" + pinCode + ", panNumber="
				+ panNumber + ", orgId=" + orgId + ", logoPath=" + logoPath + ", fileName=" + fileName + "]";
	}

	

	
	
	
	

}
