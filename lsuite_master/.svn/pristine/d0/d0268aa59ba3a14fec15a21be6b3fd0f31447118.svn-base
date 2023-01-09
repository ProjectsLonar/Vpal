package com.lonar.vendor.vendorportal.model;

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

@Entity
@Table(name = "LT_MAST_STATES")
public class LtMastStates extends BaseClass 
{

	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq")
	@SequenceGenerator(name = "state_seq", sequenceName = " LT_MAST_STATES_S", allocationSize = 1)
	@Column(name = "STATE_ID")
	private Long stateId;
	
	@Basic(optional = false)
	@Size(min = 1, max = 5)
	@Column(name = "STATE_CODE")
	private String stateCode;
	
	@Basic(optional = false)
	@Size(min = 3, max = 100)
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@Basic(optional = false)
	@Size(min = 1, max = 2)
	@Column(name = "GST_STATE_CODE")
	private String gstStateCode;
	
	@Basic(optional = false)
	@Size(min = 0, max =10)
	@Column(name = "STATE_TYPE")
	private String stateType;
	
	@Basic(optional = false)
	@Size(min = 1, max = 30)
	@Column(name = "STATUS")
	private String status;

	@Transient
	private String stateTypeValue;
	
	@Transient
	private String statusValue;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getGstStateCode() {
		return gstStateCode;
	}

	public void setGstStateCode(String gstStateCode) {
		this.gstStateCode = gstStateCode;
	}

	public String getStateType() {
		return stateType;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStateTypeValue() {
		return stateTypeValue;
	}

	public void setStateTypeValue(String stateTypeValue) {
		this.stateTypeValue = stateTypeValue;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	@Override
	public String toString() {
		return "LtMastStates [stateId=" + stateId + ", stateCode=" + stateCode + ", stateName=" + stateName
				+ ", gstStateCode=" + gstStateCode + ", stateType=" + stateType + ", status=" + status
				+ ", stateTypeValue=" + stateTypeValue + ", statusValue=" + statusValue + "]";
	}
	
	
}
