package com.lonar.vendor.vendorportal.controller;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VendorBuyerDetails {
	
	private String vendorName;
	private String firstName;
	private String lastName;
	private Long initiatorId;
	private String title; 
	private String vendorMsg;
	private Long vendorId;
	private String buyerMsg;
	private Date creationDate;
	private String imagePath;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getInitiatorId() {
		return initiatorId;
	}
	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVendorMsg() {
		return vendorMsg;
	}
	public void setVendorMsg(String vendorMsg) {
		this.vendorMsg = vendorMsg;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getBuyerMsg() {
		return buyerMsg;
	}
	public void setBuyerMsg(String buyerMsg) {
		this.buyerMsg = buyerMsg;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "VendorBuyerDetails [vendorName=" + vendorName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", initiatorId=" + initiatorId + ", title=" + title + ", vendorMsg=" + vendorMsg + ", vendorId="
				+ vendorId + ", buyerMsg=" + buyerMsg + ", creationDate=" + creationDate + ", imagePath=" + imagePath
				+ "]";
	}
	
	
	
	
}
