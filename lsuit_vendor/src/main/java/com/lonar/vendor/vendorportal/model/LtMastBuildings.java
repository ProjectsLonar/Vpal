
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
/*@XmlRootElement
@NamedQueries({ 
	   @NamedQuery(name = "LtP2pBuildings.search", query = "select l from LtP2pBuildings l where nvl(l.branchId,branchId)=:branchId AND   nvl(l.buildingId,buildingId)=:buildingId "),// l.branchId = nvl(:branchId , l.branchId) AND l.buildingId = nvl(:buildingId , l.buildingId) AND l.buildingCode like nvl(:buildingCode , buildingCode) "),
		
	   @NamedQuery(name = "LtP2pBuildings.getBranchList", query = "SELECT l FROM LtP2pBranches  l where branchName like :branchName  "),
	
	  // and l.buildingId= nvl(:buildingId , l.buildingId)and l.buildingCode like nvl(:buildingCode,  buildingCode) and l.buildingAdress like nvl(:buildingAdress, buildingAdress)  "), 
	
	   // @NamedQuery(name = "LtP2pBuildings .getById", query = "SELECT * FROM LtP2pBuildings  where buildingId =: buildingId"),

		@NamedQuery(name = "LtP2pBuildings.findActiveLikeBuildingAddr", query = "SELECT l FROM LtP2pBuildings l WHERE  LOWER(l.buildingAddress) LIKE :buildingAddress AND l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pBuildings.findByLikeBuildingName", query = "SELECT l FROM LtP2pBuildings l WHERE LOWER(l.buildingName) LIKE :buildingName"),
		@NamedQuery(name = "LtP2pBuildings.findByActiveLikeBuildingName", query = "SELECT l FROM LtP2pBuildings l WHERE l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE()) AND (l.status = 'Active' OR l.status = 'ACTIVE' OR l.status = 'active') AND  LOWER(l.buildingName) LIKE :buildingName"),
		
		@NamedQuery(name = "LtP2pBuildings.findActiveLikeBuildingName", query = "SELECT l FROM LtP2pBuildings l WHERE  LOWER(l.buildingName) LIKE :buildingName AND l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),

	   
		@NamedQuery(name = "LtP2pBuildings .All", query = "SELECT count(*) FROM LtP2pBuildings  "),
	    @NamedQuery(name = "LtP2pBuildings .findAll", query = "SELECT l FROM LtP2pBuildings  l"),
		@NamedQuery(name = "LtP2pBuildings .findAllActive", query = "SELECT l FROM LtP2pBuildings  l WHERE l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pBuildings .findByBuildingId", query = "SELECT l FROM LtP2pBuildings  l WHERE l.buildingId = :buildingId"),
		@NamedQuery(name = "LtP2pBuildings .findByBuildingCode", query = "SELECT l FROM LtP2pBuildings  l WHERE l.buildingCode = :buildingCode"),
		@NamedQuery(name = "LtP2pBuildings .findByBranchId", query = "SELECT l FROM LtP2pBuildings  l WHERE l.branchId = :branchId"),
	    @NamedQuery(name = "LtP2pBuildings .getAddress", query = "SELECT l FROM LtP2pBuildings l where l.buildingAddress LIKE :buildingAddress ")

	 })*/
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
