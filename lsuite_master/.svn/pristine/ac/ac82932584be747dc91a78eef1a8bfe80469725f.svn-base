package com.lonar.vendor.vendorportal.model;

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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
@Table(name = "LT_MAST_REPORT_REQUEST")
@XmlRootElement
public class LtMastReportRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportRequest_seq")
	@SequenceGenerator(name = "reportRequest_seq", sequenceName = "LT_MAST_REPORT_REQUEST_S", allocationSize = 1)
	@Column(name = "REQUEST_ID")
	private Long requestId;

	@Column(name = "REQUEST_URL")
	private String requestURL;

	@Column(name = "FILTER_DATA")
	private String filterData;

	@Column(name = "FILE_PATH")
	private String filePath;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "USER_ID")
	private Long userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REQUEST_DATE")
	private Date requestDate;

	@Column(name = "COMPLETED_DATE")
	private Date completedDate;

	@Column(name = "SUBMITTED_DATE")
	private Date submittedDate;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "REQUEST_NAME")
	private String requestName;

	@Column(name = "PHASE")
	private String phase;

	@Column(name = "LOG_DETAILS")
	private String logDetails;

	@Basic(optional = false)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Transient
	private String userName;

	@Transient
	private String requestorName;

	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String reqDate;
	@Transient
	private String compDate;
	@Transient
	private int columnNo;

	@Transient
	private String sort;

	@Transient
	private String requestIdStr;
	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRequestURL() {
		return requestURL;
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	public String getFilterData() {
		return filterData;
	}

	public void setFilterData(String filterData) {
		this.filterData = filterData;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getLogDetails() {
		return logDetails;
	}

	public void setLogDetails(String logDetails) {
		this.logDetails = logDetails;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getCompDate() {
		return compDate;
	}

	public void setCompDate(String compDate) {
		this.compDate = compDate;
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

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public String getRequestIdStr() {
		return requestIdStr;
	}

	public void setRequestIdStr(String requestIdStr) {
		this.requestIdStr = requestIdStr;
	}

	@Override
	public String toString() {
		return "LtMastReportRequest [requestId=" + requestId + ", requestURL=" + requestURL + ", filterData="
				+ filterData + ", filePath=" + filePath + ", status=" + status + ", userId=" + userId + ", requestDate="
				+ requestDate + ", completedDate=" + completedDate + ", submittedDate=" + submittedDate + ", fileName="
				+ fileName + ", requestName=" + requestName + ", phase=" + phase + ", logDetails=" + logDetails
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", userName=" + userName + ", requestorName="
				+ requestorName + ", draw=" + draw + ", start=" + start + ", length=" + length + ", reqDate=" + reqDate
				+ ", compDate=" + compDate + ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}

}
