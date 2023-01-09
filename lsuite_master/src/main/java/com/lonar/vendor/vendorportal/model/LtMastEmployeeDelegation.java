package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_EMP_DELEGATION")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastEmployeeDelegation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeDelegation_seq")
	@SequenceGenerator(name = "employeeDelegation_seq", sequenceName = "LT_MAST_EMP_DELEGATIONS_S", allocationSize = 1)
	@Column(name = "EMPLOYEE_DELEGATION_ID")
	private Long employeeDelegationId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DELEGATION_ID")
	private Long delegationId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Column(name = "STATUS")
	private String status;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "START_DATE")
	private Date startDate;

	@JsonView(DataTablesOutput.View.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	private Date endDate;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CREATED_BY")
	private long createdBy;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private long lastUpdateLogin;

	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Transient
	private String delegationName;
	
	@Transient
	private String employeeName;

	@Transient
	private String delegatedByName;
	
	@Transient
	private String stDate;
	@Transient
	private String enDate;
	@Transient
	private String subDate;
	@Transient
	private Long draw;
	@Transient
	private Long start;
	@Transient
	private Long length;
	
	@Transient
	private int columnNo;

	@Transient
	private String sort;
	
	@Transient
	private String startDate1;
	
	@Transient
	private String endDate1;
	
	public LtMastEmployeeDelegation() {
	}

	

	public Long getEmployeeDelegationId() {
		return employeeDelegationId;
	}

	public void setEmployeeDelegationId(Long employeeDelegationId) {
		this.employeeDelegationId = employeeDelegationId;
	}

	public Long getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(Long delegationId) {
		this.delegationId = delegationId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public long getCreatedBy() {
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

	public long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(long lastUpdateLogin) {
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

	public String getDelegationName() {
		return delegationName;
	}

	public void setDelegationName(String delegationName) {
		if (delegationName == null || delegationName.equals("null(null)"))
			delegationName = "";
		this.delegationName = delegationName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getSubDate() {
		return subDate;
	}

	public void setSubDate(String subDate) {
		this.subDate = subDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getDelegatedByName() {
		return delegatedByName;
	}



	public void setDelegatedByName(String delegatedByName) {
		this.delegatedByName = delegatedByName;
	}

	public String getStartDate1() {
		return startDate1;
	}

	public void setStartDate1(String startDate1) {
		this.startDate1 = startDate1;
	}

	public String getEndDate1() {
		return endDate1;
	}

	public void setEndDate1(String endDate1) {
		this.endDate1 = endDate1;
	}



	@Override
	public String toString() {
		return "LtMastEmployeeDelegation [employeeDelegationId=" + employeeDelegationId + ", delegationId="
				+ delegationId + ", employeeId=" + employeeId + ", status=" + status + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate="
				+ lastUpdateDate + ", delegationName=" + delegationName + ", employeeName=" + employeeName
				+ ", delegatedByName=" + delegatedByName + ", stDate=" + stDate + ", enDate=" + enDate + ", subDate="
				+ subDate + ", draw=" + draw + ", start=" + start + ", length=" + length + ", columnNo=" + columnNo
				+ ", sort=" + sort + ", startDate1=" + startDate1 + ", endDate1=" + endDate1 + "]";
	}



	
}
