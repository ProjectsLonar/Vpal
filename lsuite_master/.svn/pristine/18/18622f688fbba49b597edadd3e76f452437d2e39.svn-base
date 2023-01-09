
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_COMN_MASTER")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastComnMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comnMaster_seq")
	@SequenceGenerator(name = "comnMaster_seq", sequenceName = "LT_MAST_COMN_MASTER_S", allocationSize = 1)
	@Column(name = "MASTER_ID")
	private Long masterId;

	@Basic(optional = false)
	@Column(name = "MASTER_NAME")
	private String masterName;

	// @Size(max = 240)
	@Column(name = "MASTER_DESC")
	private String masterDesc;

	@Column(name = "STATUS")
	private String status;

	@Basic(optional = false)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private long createdBy;

	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Basic(optional = false)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;

	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;

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
	private String enDate;
	@Transient
	private int columnNo;

	@Transient
	private String sort;
	
	@Transient
	private String statusValue;

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

	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getMasterDesc() {
		return masterDesc;
	}

	public void setMasterDesc(String masterDesc) {
		this.masterDesc = masterDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	@Override
	public String toString() {
		return "LtMastComnMaster [masterId=" + masterId + ", masterName=" + masterName + ", masterDesc=" + masterDesc
				+ ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", draw=" + draw
				+ ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate
				+ ", columnNo=" + columnNo + ", sort=" + sort + ", statusValue=" + statusValue + "]";
	}

	
	
}
