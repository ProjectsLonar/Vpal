package com.lonar.vendor.vendorportal.csvupload;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.lonar.vendor.vendorportal.model.BaseClass;


@Entity
@Table(name="LT_MAST_SYS_REQUEST_REPORT")
public class LtMastSysRequestReport extends BaseClass
{

	@Id
    @Basic(optional = false)
    @NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_req_seq")
	@SequenceGenerator(name = "sys_req_seq", sequenceName = "LT_MAST_SYS_REQUEST_REPORT_S", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUEST_ID")
    private Long requestId;
	
    @Column(name = "CODE")
    private String code;
	
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "STATUS")
    private String status;
	
    @Column(name = "ERROR_CODE")
    private String errorCode;
	
    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

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

    
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getRequestId() {
		return requestId;
	}



	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getErrorCode() {
		return errorCode;
	}



	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
		return "LtMastSysRequestReport [id=" + id + ", requestId=" + requestId + ", code=" + code + ", description="
				+ description + ", status=" + status + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", draw=" + draw + ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", enDate="
				+ enDate + ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}



   
	
   
}
