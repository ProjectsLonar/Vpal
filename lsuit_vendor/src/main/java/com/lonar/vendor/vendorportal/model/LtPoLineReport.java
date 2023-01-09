package com.lonar.vendor.vendorportal.model;

import java.util.Date;

public class LtPoLineReport {

	private String lineNum; // int
	private String shipmentNum; // int
	private String item;
	private String itemDescription;
	private Date deliveryDate;
	private String quantity; // int
	private String UOM;
	private String unitPrice; // double
	private String subAmount; // double

	private String lineNoOne;
	private String taxNameAndDescriptionCGST;
	private String taxAmountCGST;

	private String lineNoTwo;
	private String taxNameAndDescriptionSGST;
	private String taxAmountSGST;
	private String rateCGST;
	private String rateSGST;
	private String totalTaxAmount;
	private String totalLineTax;
	
	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getShipmentNum() {
		return shipmentNum;
	}

	public void setShipmentNum(String shipmentNum) {
		this.shipmentNum = shipmentNum;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	 

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(String subAmount) {
		this.subAmount = subAmount;
	}

	public String getLineNoOne() {
		return lineNoOne;
	}

	public void setLineNoOne(String lineNoOne) {
		this.lineNoOne = lineNoOne;
	}

	public String getTaxNameAndDescriptionCGST() {
		return taxNameAndDescriptionCGST;
	}

	public void setTaxNameAndDescriptionCGST(String taxNameAndDescriptionCGST) {
		this.taxNameAndDescriptionCGST = taxNameAndDescriptionCGST;
	}

	public String getTaxAmountCGST() {
		return taxAmountCGST;
	}

	public void setTaxAmountCGST(String taxAmountCGST) {
		this.taxAmountCGST = taxAmountCGST;
	}

	public String getLineNoTwo() {
		return lineNoTwo;
	}

	public void setLineNoTwo(String lineNoTwo) {
		this.lineNoTwo = lineNoTwo;
	}

	public String getTaxNameAndDescriptionSGST() {
		return taxNameAndDescriptionSGST;
	}

	public void setTaxNameAndDescriptionSGST(String taxNameAndDescriptionSGST) {
		this.taxNameAndDescriptionSGST = taxNameAndDescriptionSGST;
	}

	public String getTaxAmountSGST() {
		return taxAmountSGST;
	}

	public void setTaxAmountSGST(String taxAmountSGST) {
		this.taxAmountSGST = taxAmountSGST;
	}

	public String getRateCGST() {
		return rateCGST;
	}

	public void setRateCGST(String rateCGST) {
		this.rateCGST = rateCGST;
	}

	public String getRateSGST() {
		return rateSGST;
	}

	public void setRateSGST(String rateSGST) {
		this.rateSGST = rateSGST;
	}
	

	public String getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(String totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public String getTotalLineTax() {
		return totalLineTax;
	}

	public void setTotalLineTax(String totalLineTax) {
		this.totalLineTax = totalLineTax;
	}

	@Override
	public String toString() {
		return "LtPoLineReport [lineNum=" + lineNum + ", shipmentNum=" + shipmentNum + ", item=" + item
				+ ", itemDescription=" + itemDescription + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity
				+ ", UOM=" + UOM + ", unitPrice=" + unitPrice + ", subAmount=" + subAmount + ", lineNoOne=" + lineNoOne
				+ ", taxNameAndDescriptionCGST=" + taxNameAndDescriptionCGST + ", taxAmountCGST=" + taxAmountCGST
				+ ", lineNoTwo=" + lineNoTwo + ", taxNameAndDescriptionSGST=" + taxNameAndDescriptionSGST
				+ ", taxAmountSGST=" + taxAmountSGST + ", rateCGST=" + rateCGST + ", rateSGST=" + rateSGST
				+ ", totalTaxAmount=" + totalTaxAmount + ", totalLineTax=" + totalLineTax + "]";
	}


}
