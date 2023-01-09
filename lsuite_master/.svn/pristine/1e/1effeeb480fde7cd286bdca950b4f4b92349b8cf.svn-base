
 
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


@Entity
@Table(name = "LT_MAST_DIV_EMPLOYEE_GRADE")
/*@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findAll", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findAllActive", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findActiveLikeDivisionName", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l, LtP2pDivisions division WHERE l.divisionId = division.divisionId AND LOWER(CONCAT(division.divisionName,' ',division.divisionCode)) LIKE :divisionName AND division.startDate <= CURRENT_DATE() AND (division.endDate IS NULL OR division.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByDivisionEmployeeGradeId", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.divisionEmployeeGradeId = :divisionEmployeeGradeId"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByDivisionId", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.divisionId = :divisionId"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByDivisionIdANDGrade", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.divisionId = :divisionId AND l.grade = :grade"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByGrade", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.grade = :grade"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByMinAmount", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.minAmount = :minAmount"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByMaxAmount", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.maxAmount = :maxAmount"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByStartDate", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.startDate = :startDate"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByEndDate", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.endDate = :endDate"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByCreatedBy", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.createdBy = :createdBy"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByCreationDate", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.creationDate = :creationDate"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByLastUpdateLogin", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.lastUpdateLogin = :lastUpdateLogin"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByLastUpdatedBy", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.lastUpdatedBy = :lastUpdatedBy"),
		@NamedQuery(name = "LtP2pDivisionEmployeeGrade.findByLastUpdateDate", query = "SELECT l FROM LtP2pDivisionEmployeeGrade l WHERE l.lastUpdateDate = :lastUpdateDate") })*/
public class LtMastDivisionEmployeeGrade extends BaseClass implements Serializable {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "divisionGrade_seq")
	@SequenceGenerator(name = "divisionGrade_seq", sequenceName = "LT_MAST_DIV_EMPLOYEE_GRADE_S", allocationSize = 1)
	@Column(name = "DIV_EMPLOYEE_GRADE_ID")
	private Long divEmployeeGradeId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DIVISION_ID")
	private Long divisionId;
	@Basic(optional = false)
	@NotNull
	//@Size(min = 1, max = 20)
	@Column(name = "GRADE")
	private String grade;
	@Basic(optional = false)
	@NotNull
	@Column(name = "MIN_AMOUNT")
	private Double minAmount;
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAX_AMOUNT")
	private Double maxAmount;
	
	@Transient
	private String divisionName;
	
	@Transient
	private String divisionCode;

	

	public Long getDivEmployeeGradeId() {
		return divEmployeeGradeId;
	}

	public void setDivEmployeeGradeId(Long divEmployeeGradeId) {
		this.divEmployeeGradeId = divEmployeeGradeId;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	public Double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	@Override
	public String toString() {
		return "LtP2pDivisionEmployeeGrade [divisionEmployeeGradeId=" + divEmployeeGradeId + ", divisionId="
				+ divisionId + ", grade=" + grade + ", minAmount=" + minAmount + ", maxAmount=" + maxAmount
				+ ", divisionName=" + divisionName + ", divisionCode=" + divisionCode + "]";
	}

	

	
}
