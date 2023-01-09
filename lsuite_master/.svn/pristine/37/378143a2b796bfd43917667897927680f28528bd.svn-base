package com.lonar.vendor.vendorportal.csvupload;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_SYS_REQUESTS ")
public class LtMastSysRequests 
{
	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_req_seq")
	@SequenceGenerator(name = "sys_req_seq", sequenceName = "LT_MAST_SYS_REQUESTS_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "REQUEST_ID")
	private Long requestId;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "REQUEST_NAME")
	private String requestName;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "REQUESTOR_NAME")
	private String requestorName;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PHASE")
	private String phase;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STATUS")
	private String status;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "REQUESTOR_ID")
	private Long reqeustorId;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "STG_TAB_NAME")
	private String stgTabName;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "FILE_NAME")
	private String fileName;

	@Basic(optional = false)
	//@JsonView(DataTablesOutput.View.class)
	@Column(name = "ACTUAL_START_DATE")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Basic(optional = false)
	//@JsonView(DataTablesOutput.View.class)
	@Column(name = "ACTUAL_END_DATE")
	//@Temporal(TemporalType.TIMESTAMP)
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;

	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
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

	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getReqeustorId() {
		return reqeustorId;
	}

	public void setReqeustorId(Long reqeustorId) {
		this.reqeustorId = reqeustorId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public void setCreatedBy(Long createdBy) {
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

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getStgTabName() {
		return stgTabName;
	}

	public void setStgTabName(String stgTabName) {
		this.stgTabName = stgTabName;
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

	@Override
	public String toString() {
		return "LtMastSysRequests [requestId=" + requestId + ", requestName=" + requestName + ", requestorName="
				+ requestorName + ", phase=" + phase + ", status=" + status + ", reqeustorId=" + reqeustorId
				+ ", stgTabName=" + stgTabName + ", fileName=" + fileName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin="
				+ lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate
				+ ", draw=" + draw + ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", enDate="
				+ enDate + ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}

	
}
