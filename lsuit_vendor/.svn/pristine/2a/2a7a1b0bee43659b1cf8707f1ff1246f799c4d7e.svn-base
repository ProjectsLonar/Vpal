
package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "lt_mast_vendor_addresses")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorAddress extends BaseClass
{
	
	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorAddress_seq")
	@SequenceGenerator(name = "vendorAddress_seq", sequenceName = "lt_mast_vendor_addresses_s", allocationSize = 1)
	@Column(name = "VENDOR_ADD_ID")
	private Long vendorAddId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;

	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "ADDRESS_CODE")
	private String addressCode;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "ADDRESS_1")
	private String address1;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "ADDRESS_2")
	private String address2;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "ADDRESS_3")
	private String address3;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CITY")
	private String city;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STATE_ID")
	private Long stateId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COUNTRY")
	private String country;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PIN_CODE")
	private String pinCode;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PRIMARY_ADDRESS")
	private String primaryAddress;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "BILLING")
	private String billing;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "SHIPPING")
	private String shipping;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STATE_CODE")
	private String stateCode;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PAN_BASED_PROV_ID")
	private String panBasedProvId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "GST_REG_NO")
	private String gstRegNo;
	
	@Column(name = "GST_REG")
	private String gstReg;
	
	@Column(name = "FOB_TERMS")
	private String fobTerms;
	
	@Column(name = "FREIGHT_TERMS")
	private String freightTerms;
	
	@Column(name = "GST_VENDOR_TYPE")
	private String gstVendorType;
	
	@Column(name = "VENDOR_REG_STATUS")
	private String vendorRegStatus;
	
	@Column(name = "GST_Start_Date")
	private Date gstStartDate;
	
	@Column(name = "GST_End_Date")
	private Date gstEndDate;
	
	@Column(name = "GST_Registered")
	private String  gstRegistered;
	
	@Column(name = "PAYTERM_ID")
	private Long  paytermId;
	
	@Transient
	private String stateName;
	
	@Transient
	private String vendorCode;
	@Transient
	private String vendorName;
	@Transient
	private String vendorStatus;
	@Transient
	private String addressLine;
	
	public Long getVendorAddId() {
		return vendorAddId;
	}
	public void setVendorAddId(Long vendorAddId) {
		this.vendorAddId = vendorAddId;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	public String getBilling() {
		return billing;
	}
	public void setBilling(String billing) {
		this.billing = billing;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getPanBasedProvId() {
		return panBasedProvId;
	}
	public void setPanBasedProvId(String panBasedProvId) {
		this.panBasedProvId = panBasedProvId;
	}
	public String getGstRegNo() {
		return gstRegNo;
	}
	public void setGstRegNo(String gstRegNo) {
		this.gstRegNo = gstRegNo;
	}
	public String getGstReg() {
		return gstReg;
	}
	public void setGstReg(String gstReg) {
		this.gstReg = gstReg;
	}
	public String getFobTerms() {
		return fobTerms;
	}
	public void setFobTerms(String fobTerms) {
		this.fobTerms = fobTerms;
	}
	public String getFreightTerms() {
		return freightTerms;
	}
	public void setFreightTerms(String freightTerms) {
		this.freightTerms = freightTerms;
	}
	public String getGstVendorType() {
		return gstVendorType;
	}
	public void setGstVendorType(String gstVendorType) {
		this.gstVendorType = gstVendorType;
	}
	public String getVendorRegStatus() {
		return vendorRegStatus;
	}
	public void setVendorRegStatus(String vendorRegStatus) {
		this.vendorRegStatus = vendorRegStatus;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public Date getGstStartDate() {
		return gstStartDate;
	}
	public void setGstStartDate(Date gstStartDate) {
		this.gstStartDate = gstStartDate;
	}
	public Date getGstEndDate() {
		return gstEndDate;
	}
	public void setGstEndDate(Date gstEndDate) {
		this.gstEndDate = gstEndDate;
	}
	public String getGstRegistered() {
		return gstRegistered;
	}
	public void setGstRegistered(String gstRegistered) {
		this.gstRegistered = gstRegistered;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public Long getPaytermId() {
		return paytermId;
	}
	public void setPaytermId(Long paytermId) {
		this.paytermId = paytermId;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	@Override
	public String toString() {
		return "LtMastVendorAddress [vendorAddId=" + vendorAddId + ", vendorId=" + vendorId + ", addressCode="
				+ addressCode + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", city=" + city + ", stateId=" + stateId + ", country=" + country + ", pinCode=" + pinCode
				+ ", primaryAddress=" + primaryAddress + ", billing=" + billing + ", shipping=" + shipping
				+ ", stateCode=" + stateCode + ", panBasedProvId=" + panBasedProvId + ", gstRegNo=" + gstRegNo
				+ ", gstReg=" + gstReg + ", fobTerms=" + fobTerms + ", freightTerms=" + freightTerms
				+ ", gstVendorType=" + gstVendorType + ", vendorRegStatus=" + vendorRegStatus + ", gstStartDate="
				+ gstStartDate + ", gstEndDate=" + gstEndDate + ", gstRegistered=" + gstRegistered + ", paytermId="
				+ paytermId + ", stateName=" + stateName + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName
				+ ", vendorStatus=" + vendorStatus + ", addressLine=" + addressLine + "]";
	}
	
	
}
