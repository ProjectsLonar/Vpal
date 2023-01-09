package com.lonar.UserManagement.web.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LT_MAST_LOGGER")
public class LtMastLogger 
{
	@Id
	@Basic(optional = false)
	//@NotNull(message="notnull")
	@Column(name = "LOGGER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logger_seq")
	@SequenceGenerator(name = "logger_seq", sequenceName = "LT_MAST_LOGGER_S", allocationSize = 1)
	private Long loggerId;
	
	@Column(name = "CODE")
	private Integer code;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "CLASS_NAME")
	private String className;
	
	@Column(name = "EXCEPTION_CAUSE")
	private String exceptionCause;

	@Column(name = "LAST_UPDATE_DATE")
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
	private int columnNo;
	@Transient
	private String sort;
	public Long getLoggerId() {
		return loggerId;
	}
	public void setLoggerId(Long loggerId) {
		this.loggerId = loggerId;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getExceptionCause() {
		return exceptionCause;
	}
	public void setExceptionCause(String exceptionCause) {
		this.exceptionCause = exceptionCause;
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
		return "LtMastLogger [loggerId=" + loggerId + ", code=" + code + ", message=" + message + ", className="
				+ className + ", exceptionCause=" + exceptionCause + ", lastUpdateDate=" + lastUpdateDate + ", draw="
				+ draw + ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", columnNo=" + columnNo
				+ ", sort=" + sort + "]";
	}
	
	
	
}
