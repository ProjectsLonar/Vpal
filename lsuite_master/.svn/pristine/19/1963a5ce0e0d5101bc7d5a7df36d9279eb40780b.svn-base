package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public class BaseClass {

	@Basic(optional = false)
	//@NotNull
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)           
	private Date endDate;
	
	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Basic(optional = false)
	//@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String stDate;
	@Transient
	private String enDate;
	@Transient
	private int columnNo;
	@Transient
	private String sort;
	
	@Transient
	private String masterName;
	
	@Column(name = "ADDITIONAL_FIELD_1")
	private String additionalField1;

	@Column(name = "ADDITIONAL_FIELD_2")
	private String additionalField2;
	
	@Column(name = "ADDITIONAL_FIELD_3")
	private String additionalField3;
	
	@Column(name = "ADDITIONAL_FIELD_4")
	private String additionalField4;
	
	@Column(name = "ADDITIONAL_FIELD_5")
	private String additionalField5;
	
	@Column(name = "ADDITIONAL_FIELD_6")
	private String additionalField6;
	
	@Column(name = "ADDITIONAL_FIELD_7")
	private String additionalField7;
	
	@Column(name = "ADDITIONAL_FIELD_8")
	private String additionalField8;
	
	@Column(name = "ADDITIONAL_FIELD_9")
	private String additionalField9;
	
	@Column(name = "ADDITIONAL_FIELD_10")
	private String additionalField10;
	
	@Column(name = "ADDITIONAL_FIELD_11")
	private String additionalField11;
	
	@Column(name = "ADDITIONAL_FIELD_12")
	private String additionalField12;
	
	@Column(name = "ADDITIONAL_FIELD_13")
	private String additionalField13;
	
	@Column(name = "ADDITIONAL_FIELD_14")
	private String additionalField14;
	
	@Column(name = "ADDITIONAL_FIELD_15")
	private String additionalField15;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String stDate) {
		this.stDate = stDate;
	}

	public String getEnDate() {
		return enDate;
	}

	public void setEnDate(String enDate) {
		this.enDate = enDate;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getAdditionalField1() {
		return additionalField1;
	}

	public void setAdditionalField1(String additionalField1) {
		this.additionalField1 = additionalField1;
	}

	public String getAdditionalField2() {
		return additionalField2;
	}

	public void setAdditionalField2(String additionalField2) {
		this.additionalField2 = additionalField2;
	}

	public String getAdditionalField3() {
		return additionalField3;
	}

	public void setAdditionalField3(String additionalField3) {
		this.additionalField3 = additionalField3;
	}

	public String getAdditionalField4() {
		return additionalField4;
	}

	public void setAdditionalField4(String additionalField4) {
		this.additionalField4 = additionalField4;
	}

	public String getAdditionalField5() {
		return additionalField5;
	}

	public void setAdditionalField5(String additionalField5) {
		this.additionalField5 = additionalField5;
	}

	public String getAdditionalField6() {
		return additionalField6;
	}

	public void setAdditionalField6(String additionalField6) {
		this.additionalField6 = additionalField6;
	}

	public String getAdditionalField7() {
		return additionalField7;
	}

	public void setAdditionalField7(String additionalField7) {
		this.additionalField7 = additionalField7;
	}

	public String getAdditionalField8() {
		return additionalField8;
	}

	public void setAdditionalField8(String additionalField8) {
		this.additionalField8 = additionalField8;
	}

	public String getAdditionalField9() {
		return additionalField9;
	}

	public void setAdditionalField9(String additionalField9) {
		this.additionalField9 = additionalField9;
	}

	public String getAdditionalField10() {
		return additionalField10;
	}

	public void setAdditionalField10(String additionalField10) {
		this.additionalField10 = additionalField10;
	}

	public String getAdditionalField11() {
		return additionalField11;
	}

	public void setAdditionalField11(String additionalField11) {
		this.additionalField11 = additionalField11;
	}

	public String getAdditionalField12() {
		return additionalField12;
	}

	public void setAdditionalField12(String additionalField12) {
		this.additionalField12 = additionalField12;
	}

	public String getAdditionalField13() {
		return additionalField13;
	}

	public void setAdditionalField13(String additionalField13) {
		this.additionalField13 = additionalField13;
	}

	public String getAdditionalField14() {
		return additionalField14;
	}

	public void setAdditionalField14(String additionalField14) {
		this.additionalField14 = additionalField14;
	}

	public String getAdditionalField15() {
		return additionalField15;
	}

	public void setAdditionalField15(String additionalField15) {
		this.additionalField15 = additionalField15;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	@Override
	public String toString() {
		return "BaseClass [startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", draw=" + draw + ", start=" + start
				+ ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo
				+ ", sort=" + sort + ", masterName=" + masterName + ", additionalField1=" + additionalField1
				+ ", additionalField2=" + additionalField2 + ", additionalField3=" + additionalField3
				+ ", additionalField4=" + additionalField4 + ", additionalField5=" + additionalField5
				+ ", additionalField6=" + additionalField6 + ", additionalField7=" + additionalField7
				+ ", additionalField8=" + additionalField8 + ", additionalField9=" + additionalField9
				+ ", additionalField10=" + additionalField10 + ", additionalField11=" + additionalField11
				+ ", additionalField12=" + additionalField12 + ", additionalField13=" + additionalField13
				+ ", additionalField14=" + additionalField14 + ", additionalField15=" + additionalField15 + "]";
	}

	

	
}
