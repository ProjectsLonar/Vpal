package com.lonar.vendor.vendorportal.reports;

import java.util.Date;

public class DivisionSubDivision {
	
	private String divisionCode;
	private String divisionName;
	private String status;
	private Date divisionStartDate;
	private Date divisionEndDate;
	private String subDivisionCode;
	private String subDivisionName;
	private Date subDivisionStartDate;
	private Date subDivisionEndDate;
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDivisionStartDate() {
		return divisionStartDate;
	}
	public void setDivisionStartDate(Date divisionStartDate) {
		this.divisionStartDate = divisionStartDate;
	}
	public Date getDivisionEndDate() {
		return divisionEndDate;
	}
	public void setDivisionEndDate(Date divisionEndDate) {
		this.divisionEndDate = divisionEndDate;
	}
	public String getSubDivisionCode() {
		return subDivisionCode;
	}
	public void setSubDivisionCode(String subDivisionCode) {
		this.subDivisionCode = subDivisionCode;
	}
	public String getSubDivisionName() {
		return subDivisionName;
	}
	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}
	public Date getSubDivisionStartDate() {
		return subDivisionStartDate;
	}
	public void setSubDivisionStartDate(Date subDivisionStartDate) {
		this.subDivisionStartDate = subDivisionStartDate;
	}
	public Date getSubDivisionEndDate() {
		return subDivisionEndDate;
	}
	public void setSubDivisionEndDate(Date subDivisionEndDate) {
		this.subDivisionEndDate = subDivisionEndDate;
	}
	@Override
	public String toString() {
		return "DivisionSubDivision [divisionCode=" + divisionCode + ", divisionName=" + divisionName + ", status="
				+ status + ", divisionStartDate=" + divisionStartDate + ", divisionEndDate=" + divisionEndDate
				+ ", subDivisionCode=" + subDivisionCode + ", subDivisionName=" + subDivisionName
				+ ", subDivisionStartDate=" + subDivisionStartDate + ", subDivisionEndDate=" + subDivisionEndDate + "]";
	}
	
	

}
