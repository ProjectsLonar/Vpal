/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonar.UserManagement.web.model;

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

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

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
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COST_CENTER_ID")
	private Long costCenterId;

	@Basic(optional = false)
	@NotNull(message = "notnull")
	@Size(min = 1, max = 80)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml(message = "UnsafeHtml")
	@Column(name = "COST_CENTER_CODE")
	private String costCenterCode;

	@Basic(optional = false)
	@NotNull(message = "notnull")
	@Size(min = 1, max = 240)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml(message = "UnsafeHtml")
	@Column(name = "COST_CENTER_NAME")
	private String costCenterName;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "APPROVER_ID")
	private Long approverId;

	@JsonView(DataTablesOutput.View.class)
	@SafeHtml(message = "UnsafeHtml")
	@Column(name = "STATUS")
	private String status;

	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String employeeName;

	@Transient
	@JsonView(DataTablesOutput.View.class)
	private String approverName;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String bcNameWithCode;

	@Transient
	private String cmpName;
	
	@Transient
	private String stDate;
	@Transient
	private String enDate;
 

	/*
	 * @PrePersist void preInsert() { PrePersistUtil.pre(this); }
	 */

	public LtMastCostCenters() {
		super();

	}

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

}
