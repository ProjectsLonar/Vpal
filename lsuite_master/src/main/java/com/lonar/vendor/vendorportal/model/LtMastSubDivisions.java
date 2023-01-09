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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_SUB_DIVISIONS")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastSubDivisions extends BaseClass implements Serializable {

	private static final Long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subDivision_seq")
	@SequenceGenerator(name = "subDivision_seq", sequenceName = "LT_MAST_SUB_DIVISIONS_S", allocationSize = 1)

	@Column(name = "SUB_DIVISION_ID")
	private Long subDivisionId;

	@Basic(optional = false)
	// @NotNull
	@Column(name = "DIVISION_ID")
	private Long divisionId;

	@Basic(optional = false)
	/// @NotNull
	@Size(min = 1, max = 30)
	@Column(name = "SUB_DIVISION_CODE")
	private String subDivisionCode;

	@Basic(optional = false)
	// @NotNull
	@Size(min = 1, max = 240)
	@Column(name = "SUB_DIVISION_NAME")
	private String subDivisionName;

	@Transient
	private String divisionName;

	/*
	 * @PrePersist void preInsert() { PrePersistUtil.pre(this); }
	 */

	public LtMastSubDivisions() {
		super();

	}

	public Long getSubDivisionId() {
		return subDivisionId;
	}

	public void setSubDivisionId(Long subDivisionId) {
		this.subDivisionId = subDivisionId;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public String getSubDivisionCode() {
		return subDivisionCode;
	}

	public void setSubDivisionCode(String subDivisionCode) {
		this.subDivisionCode = subDivisionCode;
	}

	public String getSubDivisionName() {
		return subDivisionName;
	}

	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	@Override
	public String toString() {
		return "LtMastSubDivisions [subDivisionId=" + subDivisionId + ", divisionId=" + divisionId
				+ ", subDivisionCode=" + subDivisionCode + ", subDivisionName=" + subDivisionName + "]";
	}

}
