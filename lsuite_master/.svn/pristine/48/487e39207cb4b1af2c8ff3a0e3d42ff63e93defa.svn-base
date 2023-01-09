
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


@Entity
@Table(name = "LT_MAST_BUILDINGS")
public class LtMastBuildings extends BaseClass implements Serializable
{


	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buildings_seq")
	@SequenceGenerator(name = "buildings_seq", sequenceName = "LT_MAST_BUILDINGS_S", allocationSize = 1)
	@Column(name = "BUILDING_ID")
	private Long buildingId;
	
	@Column(name = "BRANCH_ID")
	private Long branchId;
 
	@Column(name = "BUILDING_CODE")
	private String buildingCode;
	
	@Column(name = "BUILDING_NAME")
	private String buildingName;
 
	@Column(name = "BUILDING_ADDRESS")
	private String buildingAddress;
 
	@Column(name = "BUILDING_DESC")
	private String buildingDesc;
 
	@Column(name = "STATUS")
	private String status;
 
	@Transient
	private String branchName;
	

	public Long getBuildingId() {
		return buildingId;
	}


	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}


	public Long getBranchId() {
		return branchId;
	}


	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}


	public String getBuildingCode() {
		return buildingCode;
	}


	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	public String getBuildingAddress() {
		return buildingAddress;
	}


	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}


	public String getBuildingDesc() {
		return buildingDesc;
	}


	public void setBuildingDesc(String buildingDesc) {
		this.buildingDesc = buildingDesc;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	@Override
	public String toString() {
		return "LtMastBuildings [buildingId=" + buildingId + ", branchId=" + branchId + ", buildingCode=" + buildingCode
				+ ", buildingName=" + buildingName + ", buildingAddress=" + buildingAddress + ", buildingDesc="
				+ buildingDesc + ", status=" + status + ", branchName=" + branchName + "]";
	}


	

}
