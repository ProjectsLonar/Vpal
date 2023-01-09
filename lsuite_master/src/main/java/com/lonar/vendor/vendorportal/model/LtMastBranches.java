package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "LT_MAST_BRANCHES")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastBranches extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	//@NotNull(message="notnull")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_seq")
	@SequenceGenerator(name = "branch_seq", sequenceName = "LT_MAST_BRANCHES_S", allocationSize = 1)
	@Column(name = "BRANCH_ID")
	private Long branchId;
	
	@Basic(optional = false)
	@NotNull(message="notnull")
	@Size(min = 1, max = 30)
	@Column(name = "BRANCH_CODE")
	private String branchCode;
	
	@Basic(optional = false)
	@NotNull(message="notnull")
	@Size(min = 1, max = 240)
	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	@Basic(optional = false)
	@NotNull(message="notnull")
	@Size(min = 1, max = 80)
	@Column(name = "CITY")
	private String city;
	
	@Size(max = 80)
	@Column(name = "REGION")
	private String region;
	
	
	@Column(name = "STATE_ID")
	private Long stateId;
	
	@Size(max = 80)
	@Column(name = "COUNTRY")
	private String country;
	
	
	@Column(name = "REPORTING_BRANCH")
	private Long reportingBranch;
	
	@Column(name = "OPENING_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date openingDate;
	
	
	@Column(name = "MANAGER_ID")
	private Long managerId;

	@Size(max = 30)
	@Column(name = "STATE_CODE")
	private String stateCode;
	
	@NotNull(message="notnull")
	@Size(max = 15)
	@Column(name = "GST_REG_NO")
	private String gstRegNo;
	
	
	@Column(name = "STATUS")
	private String status;
	
	
	@Column(name = "BRANCH_TYPE")
	private String branchType;
	
	@Column(name = "BILLABLE_LOCATION")
	private String billableLocation;
	
	@Column(name = "SHIPPING_LOCATION")
	private String shippingLocation;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	@Transient
	private String managerName;
	
	@Transient
	private String managerCode;
	
	@Transient
	private String managerOfficalEmailId;
	
	@Transient
	private String reportingBranchName;
	
	@Transient
	private String reportingBranchCode;
	
	@Transient
	private String companyName;
	
	@Transient
	private String statusValue;
	
	@Transient
	private String countryValue;
	
	@Transient
	private String branchTypeValue;
	
	@Transient
	private String stateName;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getReportingBranch() {
		return reportingBranch;
	}

	public void setReportingBranch(Long reportingBranch) {
		this.reportingBranch = reportingBranch;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getGstRegNo() {
		return gstRegNo;
	}

	public void setGstRegNo(String gstRegNo) {
		this.gstRegNo = gstRegNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getBillableLocation() {
		return billableLocation;
	}

	public void setBillableLocation(String billableLocation) {
		this.billableLocation = billableLocation;
	}

	public String getShippingLocation() {
		return shippingLocation;
	}

	public void setShippingLocation(String shippingLocation) {
		this.shippingLocation = shippingLocation;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getManagerOfficalEmailId() {
		return managerOfficalEmailId;
	}

	public void setManagerOfficalEmailId(String managerOfficalEmailId) {
		this.managerOfficalEmailId = managerOfficalEmailId;
	}

	public String getReportingBranchName() {
		return reportingBranchName;
	}

	public void setReportingBranchName(String reportingBranchName) {
		this.reportingBranchName = reportingBranchName;
	}

	public String getReportingBranchCode() {
		return reportingBranchCode;
	}

	public void setReportingBranchCode(String reportingBranchCode) {
		this.reportingBranchCode = reportingBranchCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getCountryValue() {
		return countryValue;
	}

	public void setCountryValue(String countryValue) {
		this.countryValue = countryValue;
	}

	public String getBranchTypeValue() {
		return branchTypeValue;
	}

	public void setBranchTypeValue(String branchTypeValue) {
		this.branchTypeValue = branchTypeValue;
	}

	

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "LtMastBranches [branchId=" + branchId + ", branchCode=" + branchCode + ", branchName=" + branchName
				+ ", city=" + city + ", region=" + region + ", stateId=" + stateId + ", country=" + country
				+ ", reportingBranch=" + reportingBranch + ", openingDate=" + openingDate + ", managerId=" + managerId
				+ ", stateCode=" + stateCode + ", gstRegNo=" + gstRegNo + ", status=" + status + ", branchType="
				+ branchType + ", billableLocation=" + billableLocation + ", shippingLocation=" + shippingLocation
				+ ", companyId=" + companyId + ", managerName=" + managerName + ", managerCode=" + managerCode
				+ ", managerOfficalEmailId=" + managerOfficalEmailId + ", reportingBranchName=" + reportingBranchName
				+ ", reportingBranchCode=" + reportingBranchCode + ", companyName=" + companyName + ", statusValue="
				+ statusValue + ", countryValue=" + countryValue + ", branchTypeValue=" + branchTypeValue
				+ ", stateValue=" + stateName + "]";
	}

	
}
