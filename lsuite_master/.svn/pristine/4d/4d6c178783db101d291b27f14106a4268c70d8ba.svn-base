package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_COST_CENTERS")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastCostCenters extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costCenter_seq")
	@SequenceGenerator(name = "costCenter_seq", sequenceName = "LT_MAST_COST_CENTERS_S", allocationSize = 1)
	@Column(name = "COST_CENTER_ID")
	private Long costCenterId;

	@Basic(optional = false)
	@NotNull(message = "notnull")
	@Size(min = 1, max = 80)
	@Column(name = "COST_CENTER_CODE")
	private String costCenterCode;

	@Basic(optional = false)
	@NotNull(message = "notnull")
	@Size(min = 1, max = 240)
	@Column(name = "COST_CENTER_NAME")
	private String costCenterName;

	@Column(name = "APPROVER_ID")
	private Long approverId;

	@Column(name = "STATUS")
	private String status;

	@Transient
	private String employeeName;

	@Transient
	private String approverName;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String bcNameWithCode;

	@Transient
	private String cmpName;
	
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
	
	public Long getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(Long costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public Long getApproverId() {
		return approverId;
	}

	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getBcNameWithCode() {
		return bcNameWithCode;
	}

	public void setBcNameWithCode(String bcNameWithCode) {
		this.bcNameWithCode = bcNameWithCode;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
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

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LtMastCostCenters [costCenterId=" + costCenterId + ", costCenterCode=" + costCenterCode
				+ ", costCenterName=" + costCenterName + ", approverId=" + approverId + ", status=" + status
				+ ", employeeName=" + employeeName + ", approverName=" + approverName + ", companyId=" + companyId
				+ ", bcNameWithCode=" + bcNameWithCode + ", cmpName=" + cmpName + ", draw=" + draw + ", start=" + start
				+ ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo
				+ ", sort=" + sort + ", statusValue=" + statusValue + "]";
	}

	
	

}
