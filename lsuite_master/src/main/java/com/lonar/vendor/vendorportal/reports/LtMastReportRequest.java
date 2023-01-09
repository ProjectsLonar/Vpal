/*package com.lonar.vendor.vendorportal.reports;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
@Table(name = "LT_MAST_REPORT_REQUEST")
@XmlRootElement
public class LtMastReportRequest {
	
	@JsonView(DataTablesOutput.View.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportRequest_seq")
	@SequenceGenerator(name = "reportRequest_seq", sequenceName = "LT_MAST_REPORT_REQUEST_S", allocationSize = 1)
	@Column(name = "REQUEST_ID")
	private Long requestId;
	 
	private String requestURL;
	
	private String filterData;
	
	private String filePath;
	
	private String fileStatus;
	
	private Long userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;
	
	private String fileName;
	
	private String requestName;
	private Date completedDate;
	private String strCompletedDate;
	private Date submittedDate;
	private String strSubmittedDate;
	private String phase;
	private String logDetails;
	 
	private long start;
	 
	private long length;
	 
	private long totalCount;
	
	private Integer columnNo;
	
    private String columnSort;
	
	private String userName;
	
	private String strRequestDate; 
	
	
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

	
	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(Integer columnNo) {
		this.columnNo = columnNo;
	}

	public String getColumnSort() {
		return columnSort;
	}

	public void setColumnSort(String columnSort) {
		this.columnSort = columnSort;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	
	public String getStrRequestDate() {
		return strRequestDate;
	}

	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
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

	public String getStrCompletedDate() {
		return strCompletedDate;
	}

	public void setStrCompletedDate(String strCompletedDate) {
		this.strCompletedDate = strCompletedDate;
	}

	public String getStrSubmittedDate() {
		return strSubmittedDate;
	}

	public void setStrSubmittedDate(String strSubmittedDate) {
		this.strSubmittedDate = strSubmittedDate;
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


}
*/