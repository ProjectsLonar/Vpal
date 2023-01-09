
package com.lonar.vendor.vendorportal.model;

import javax.persistence.Basic;
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
@Table(name = "LT_MAST_VENDOR_BANKS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorBanks extends BaseClass
{
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorBanks_seq")
	@SequenceGenerator(name = "vendorBanks_seq", sequenceName = "LT_MAST_VENDOR_BANKS_S", allocationSize = 1)
	@Column(name = "VENDOR_BANK_ID")
	private Long vendorBankId;
	
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "VENDOR_ADD_ID")
	private Long vendorAddId;
	
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name = "BANK_BRANCH")
	private String bankBranch;
	
	@Column(name = "IFSC_CODE")
	private String ifscCode;
	
	
	@Column(name = "MICR_NO")
	private String micrNo;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "BRANCH_ADDRESS")
	private String branchAddress;
	
	@Column(name = "BANK_ACCOUNT_NO")
	private String bankAccountNo;
	
	@Column(name = "INVOICE_CURRENCY")
	private String invoiceCurrency;

	@Transient
	private String vendorCode;
	@Transient
	private String vendorName;
	@Transient
	private String vendorStatus;
	@Transient
	private String addressCode;
	@Transient
	private String address;
	@Transient
	private String city;
	@Transient
	private String state;
	
	public Long getVendorBankId() {
		return vendorBankId;
	}

	public void setVendorBankId(Long vendorBankId) {
		this.vendorBankId = vendorBankId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getVendorAddId() {
		return vendorAddId;
	}

	public void setVendorAddId(Long vendorAddId) {
		this.vendorAddId = vendorAddId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMicrNo() {
		return micrNo;
	}

	public void setMicrNo(String micrNo) {
		this.micrNo = micrNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}

	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
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

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "LtMastVendorBanks [vendorBankId=" + vendorBankId + ", vendorId=" + vendorId + ", vendorAddId="
				+ vendorAddId + ", bankName=" + bankName + ", bankBranch=" + bankBranch + ", ifscCode=" + ifscCode
				+ ", micrNo=" + micrNo + ", accountType=" + accountType + ", branchAddress=" + branchAddress
				+ ", bankAccountNo=" + bankAccountNo + ", invoiceCurrency=" + invoiceCurrency + ", vendorCode="
				+ vendorCode + ", vendorName=" + vendorName + ", vendorStatus=" + vendorStatus + ", addressCode="
				+ addressCode + ", address=" + address + ", city=" + city + ", state=" + state + "]";
	}

	
}
