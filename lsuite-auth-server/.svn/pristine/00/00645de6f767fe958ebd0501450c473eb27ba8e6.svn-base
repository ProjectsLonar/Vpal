package com.lonar.UserManagement.web.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public class BaseClass {

	
	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Transient
	private String strStartDate;
	
	@Transient
	private String strEndDate;
	
	@Transient
	private Integer start;

	@Transient
	private Integer length;
	
	@Transient
	private Integer columnNo;
	
	@Transient
	private String sort;
	

	
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

	public String getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}

	public String getStrEndDate() {
		return strEndDate;
	}

	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(Integer columnNo) {
		this.columnNo = columnNo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
}
