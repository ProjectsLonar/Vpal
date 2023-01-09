package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
import java.util.List;

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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_DIVISIONS")
@XmlRootElement

@JsonInclude(Include.NON_NULL)
public class LtMastDivisions extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	// @NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq")
	@SequenceGenerator(name = "division_seq", sequenceName = "LT_MAST_DIVISIONS_S", allocationSize = 1)
	@Column(name = "DIVISION_ID")
	private Long divisionId;

	@Basic(optional = false)
	@NotNull
	// @Size(min = 1, max = 30)
	@Column(name = "DIVISION_CODE")
	private String divisionCode;

	@Basic(optional = false)
	@NotNull
	// @Size(min = 1, max = 240)
	@Column(name = "DIVISION_NAME")
	private String divisionName;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String cmpName;
	
	
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
	private List<LtMastSubDivisions> ltMastSubDivisionsList;

	/*
	 * @PrePersist void preInsert() { PrePersistUtil.pre(this); }
	 */

	public LtMastDivisions() {
		super();
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public List<LtMastSubDivisions> getLtMastSubDivisionsList() {
		return ltMastSubDivisionsList;
	}

	public void setLtMastSubDivisionsList(List<LtMastSubDivisions> ltMastSubDivisionsList) {
		this.ltMastSubDivisionsList = ltMastSubDivisionsList;
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

	@Override
	public String toString() {
		return "LtMastDivisions [divisionId=" + divisionId + ", divisionCode=" + divisionCode + ", divisionName="
				+ divisionName + ", status=" + status + ", companyId=" + companyId + ", cmpName=" + cmpName
				+ ", stDate=" + stDate + ", enDate=" + enDate + ", subDate=" + subDate + ", draw=" + draw + ", start="
				+ start + ", length=" + length + ", columnNo=" + columnNo + ", sort=" + sort
				+ ", ltMastSubDivisionsList=" + ltMastSubDivisionsList + "]";
	}

	
}
