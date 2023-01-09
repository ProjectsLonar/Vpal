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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_CITY")
@JsonInclude(Include.NON_NULL)
public class LtMastCity extends BaseClass {
	
	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
	@SequenceGenerator(name = "city_seq", sequenceName = " LT_MAST_CITY_S", allocationSize = 1)
	@Column(name = "CITY_ID")
	//@JsonProperty("city id")
	private Long cityId;
	
	@Basic(optional = false)
	@Size(min = 1, max = 5)
	//@JsonProperty("city code")
	@Column(name = "CITY_CODE")
	private String cityCode;
	
	@Basic(optional = false)
	@Size(min = 3, max = 100)
//	@JsonProperty("city name")
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@Basic(optional = false)
	@Column(name = "STATE_ID")
	private Long stateId;
	
	
	@Basic(optional = false)
	@Size(min = 1, max = 30)
//	@JsonProperty("status")
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "AUDIT_ID")
	private Long auditId;

   @Transient
//   @JsonProperty("state name")
   private String stateName;
   
	public String getStateName() {
	return stateName;
}


public void setStateName(String stateName) {
	this.stateName = stateName;
}


	public Long getCityId() {
		return cityId;
	}


	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}


	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Long getStateId() {
		return stateId;
	}


	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getAuditId() {
		return auditId;
	}


	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}


	@Override
	public String toString() {
		return "LtMastCity [cityId=" + cityId + ", cityCode=" + cityCode + ", cityName=" + cityName + ", stateId="
				+ stateId + ", status=" + status + ", auditId=" + auditId + ", stateName=" + stateName + "]";
	}


	

	
	
}
