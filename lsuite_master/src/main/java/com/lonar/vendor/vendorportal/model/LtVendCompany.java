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
	
	@Column(name = "STATE_ID")
	private Long stateId;
	
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

	@Column(name = "BUSINESS_GROUP_ID")
	private Long businessGroupId;
	
	@Column(name = "BUSINESS_GROUP_NAME")
	private String businessGroupName;
	
	@Transient
	private String fileName;
	
	@Transient
	private String statusValue;
	
	@Transient
	private String stateValue;

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


	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getStateValue() {
		return stateValue;
	}

	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}

	public Long getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(Long businessGroupId) {
		this.businessGroupId = businessGroupId;
	}

	public String getBusinessGroupName() {
		return businessGroupName;
	}

	public void setBusinessGroupName(String businessGroupName) {
		this.businessGroupName = businessGroupName;
	}

	@Override
	public String toString() {
		return "LtVendCompany [companyId=" + companyId + ", companyName=" + companyName + ", regdAddress=" + regdAddress
				+ ", city=" + city + ", stateId=" + stateId + ", status=" + status + ", pinCode=" + pinCode
				+ ", panNumber=" + panNumber + ", orgId=" + orgId + ", logoPath=" + logoPath + ", businessGroupId="
				+ businessGroupId + ", businessGroupName=" + businessGroupName + ", fileName=" + fileName
				+ ", statusValue=" + statusValue + ", stateValue=" + stateValue + "]";
	}

	
	
}
