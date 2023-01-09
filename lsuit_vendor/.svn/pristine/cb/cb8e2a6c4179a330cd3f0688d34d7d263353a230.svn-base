
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
@Table(name = "LT_MAST_VENDOR_MANAGEMENTS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorManagements extends BaseClass
{	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorManagements_seq")
	@SequenceGenerator(name = "vendorManagements_seq", sequenceName = "LT_MAST_VENDOR_MANAGEMENTS_S", allocationSize = 1)
	@Column(name = "VENDOR_MANAGEMENT_ID")
	private Integer vendorManagementId;
	
	@Column(name = "VENDOR_ID")
	private Integer vendorId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VEN_MAN_DESG_ID")
	private String venManDesgId;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	
	@Column(name = "PHONE_NO")
	private String phoneNo;
	
	@Column(name = "EMAIL_ADD")
	private String emailAdd;

	@Transient
	private String designationValueName;

	public Integer getVendorManagementId() {
		return vendorManagementId;
	}

	public void setVendorManagementId(Integer vendorManagementId) {
		this.vendorManagementId = vendorManagementId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenManDesgId() {
		return venManDesgId;
	}

	public void setVenManDesgId(String venManDesgId) {
		this.venManDesgId = venManDesgId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public String getDesignationValueName() {
		return designationValueName;
	}

	public void setDesignationValueName(String designationValueName) {
		this.designationValueName = designationValueName;
	}

	@Override
	public String toString() {
		return "LtMastVendorManagements [vendorManagementId=" + vendorManagementId + ", vendorId=" + vendorId
				+ ", name=" + name + ", venManDesgId=" + venManDesgId + ", mobileNo=" + mobileNo + ", phoneNo="
				+ phoneNo + ", emailAdd=" + emailAdd + ", designationValueName=" + designationValueName + "]";
	}
	

}
