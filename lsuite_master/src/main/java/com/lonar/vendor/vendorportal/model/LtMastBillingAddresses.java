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

@Entity
@Table(name = "LT_MAST_BILLING_ADDRESSES")
public class LtMastBillingAddresses extends BaseClass
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_seq")
	@SequenceGenerator(name = "billing_seq", sequenceName = "LT_MAST_BILLING_ADDRESSES_S", allocationSize = 1)
	@Column(name = "BILLING_ADDRESS_ID")
	private Long billingAddressId;
	
	@Column(name = "BILLING_ADDRESS_CODE")
	private String billingAddressCode;
	
	@Column(name = "BILLING_ADDRESS")
	private String billingAddress;
	
	@Column(name = "BILLING_ADDRESS_STATE")
	private String billingAddressState;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "GST_REG_NO")
	private String gstRegNo;
	
	@Column(name = "BRANCH_ID")
	private Long branchId;
	
	
	@Transient
	Long vendorId;
	
	@Transient
	String branchName;
	
	public LtMastBillingAddresses()
	{
		super();
	}

	
	public Long getVendorId() {
		return vendorId;
	}


	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}


	public Long getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(Long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getBillingAddressCode() {
		return billingAddressCode;
	}

	public void setBillingAddressCode(String billingAddressCode) {
		this.billingAddressCode = billingAddressCode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingAddressState() {
		return billingAddressState;
	}

	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGstRegNo() {
		return gstRegNo;
	}

	public void setGstRegNo(String gstRegNo) {
		this.gstRegNo = gstRegNo;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	@Override
	public String toString() {
		return "LtMastBillingAddresses [billingAddressId=" + billingAddressId + ", billingAddressCode="
				+ billingAddressCode + ", billingAddress=" + billingAddress + ", billingAddressState="
				+ billingAddressState + ", status=" + status + ", gstRegNo=" + gstRegNo + ", branchId=" + branchId
				+ ", vendorId=" + vendorId + ", branchName=" + branchName + "]";
	}


	
	
	

}
