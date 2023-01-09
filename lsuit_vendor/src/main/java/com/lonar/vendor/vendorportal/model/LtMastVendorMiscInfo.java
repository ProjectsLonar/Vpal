
package com.lonar.vendor.vendorportal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_VENDOR_MISC_INFO")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorMiscInfo extends BaseClass
{
	
	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorMiscInfo_seq")
	@SequenceGenerator(name = "vendorMiscInfo_seq", sequenceName = "LT_MAST_VENDOR_MISC_INFO_S", allocationSize = 1)
	@Column(name = "VENDOR_ADD_ID")
	private Long vendorMiscInfoId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "REVENUE")
	private String revenue;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "NO_OF_EMPLOYEES")
	private String noOfEmployees;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "GOODWILL")
	private String goodWill;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "SUPPORT_PRESENT")
	private String supportPresent;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "NET_PROFIT")
	private String netProfit;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "DR_CAPABILITIES")
	private String drCapabilities;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "EXISTING_DEPENDENCY")
	private String existingDependency;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "RELATIONSHIP_MANAGEMENT")
	private String relationshipManagement;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CERTIFICATIONS")
	private String certifications;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "IMPACT_ON_SERVICES")
	private String impactOnServices;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPETITION")
	private String competition;
	
	
	/*@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	*/
	

	public Long getVendorMiscInfoId() {
		return vendorMiscInfoId;
	}

	public void setVendorMiscInfoId(Long vendorMiscInfoId) {
		this.vendorMiscInfoId = vendorMiscInfoId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getGoodWill() {
		return goodWill;
	}

	public void setGoodWill(String goodWill) {
		this.goodWill = goodWill;
	}

	public String getSupportPresent() {
		return supportPresent;
	}

	public void setSupportPresent(String supportPresent) {
		this.supportPresent = supportPresent;
	}

	public String getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(String netProfit) {
		this.netProfit = netProfit;
	}

	public String getDrCapabilities() {
		return drCapabilities;
	}

	public void setDrCapabilities(String drCapabilities) {
		this.drCapabilities = drCapabilities;
	}

	public String getExistingDependency() {
		return existingDependency;
	}

	public void setExistingDependency(String existingDependency) {
		this.existingDependency = existingDependency;
	}

	public String getRelationshipManagement() {
		return relationshipManagement;
	}

	public void setRelationshipManagement(String relationshipManagement) {
		this.relationshipManagement = relationshipManagement;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public String getImpactOnServices() {
		return impactOnServices;
	}

	public void setImpactOnServices(String impactOnServices) {
		this.impactOnServices = impactOnServices;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	@Override
	public String toString() {
		return "LtMastVendorMiscInfo [vendorMiscInfoId=" + vendorMiscInfoId + ", vendorId=" + vendorId + ", revenue="
				+ revenue + ", noOfEmployees=" + noOfEmployees + ", goodWill=" + goodWill + ", supportPresent="
				+ supportPresent + ", netProfit=" + netProfit + ", drCapabilities=" + drCapabilities
				+ ", existingDependency=" + existingDependency + ", relationshipManagement=" + relationshipManagement
				+ ", certifications=" + certifications + ", impactOnServices=" + impactOnServices + ", competition="
				+ competition + "]";
	}
	
	
	
	
	
	
	

}
