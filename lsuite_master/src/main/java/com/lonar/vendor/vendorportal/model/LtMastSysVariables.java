
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "LT_MAST_SYS_VARIABLES")
@XmlRootElement
public class LtMastSysVariables extends BaseClass implements Serializable 
{

	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variables_seq")
	@SequenceGenerator(name = "variables_seq", sequenceName = "LT_MAST_SYS_VARIABLES_S", allocationSize = 1)
	@Basic(optional = false)
	//@NotNull
	@Column(name = "VARIABLE_ID")
	private Long variableId;
	
	@Basic(optional = false)
	//@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "VARIABLE_CODE")
	private String variableCode;
	
	@Size(max = 240)
	@Column(name = "VARIABLE_NAME")
	private String variableName;
	
	@Basic(optional = false)
	//@NotNull
	@Size(min = 1, max = 2000)
	@Column(name = "SYSTEM_VALUE")
	private String systemValue;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	

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

	
	public LtMastSysVariables() {
	}

	public Long getVariableId() {
		return variableId;
	}

	public void setVariableId(Long variableId) {
		this.variableId = variableId;
	}

	public String getVariableCode() {
		return variableCode;
	}

	public void setVariableCode(String variableCode) {
		this.variableCode = variableCode;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	
	
	public String getSystemValue() {
		return systemValue;
	}

	public void setSystemValue(String systemValue) {
		this.systemValue = systemValue;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastSysVariables [variableId=" + variableId + ", variableCode=" + variableCode + ", variableName="
				+ variableName + ", systemValue=" + systemValue + ", companyId=" + companyId + ", draw=" + draw
				+ ", start=" + start + ", length=" + length + ", stDate=" + stDate + ", enDate=" + enDate
				+ ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}

	
	

}
