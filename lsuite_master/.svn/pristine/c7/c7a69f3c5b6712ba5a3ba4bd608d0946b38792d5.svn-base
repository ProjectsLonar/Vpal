package com.lonar.vendor.vendorportal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LT_MAST_POSITION")
public class LtMastPositionMaster extends BaseClass {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq")
	@SequenceGenerator(name = "position_seq", sequenceName = "LT_MAST_POSITION_S", allocationSize = 1)
	@Column(name = "POSITION_ID")
	private Long positionId;
	
	@Column(name = "POSITION_CODE")
	private String positionCode;
	
	@Column(name = "POSITION_NAME")
	private String positionName;
	
	@Column(name = "POSITION_DESC")
	private String positionDesc;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDesc() {
		return positionDesc;
	}

	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LtMastPositionMaster [positionId=" + positionId + ", positionCode=" + positionCode + ", positionName="
				+ positionName + ", positionDesc=" + positionDesc + ", status=" + status + ", companyId=" + companyId
				+ "]";
	}

	
	
}
