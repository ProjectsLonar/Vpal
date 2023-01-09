package com.lonar.vendor.vendorportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DashboardDetails {
	
	private Double poAmount;
	private Double invoiceAmount;
	private Double amountPaid;
	
	private String status;
	private Long count;
	private Long qtr;
	
	public Double getPoAmount() {
		return poAmount;
	}
	public void setPoAmount(Double poAmount) {
		this.poAmount = poAmount;
	}
	public Double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getQtr() {
		return qtr;
	}
	public void setQtr(Long qtr) {
		this.qtr = qtr;
	}

}
