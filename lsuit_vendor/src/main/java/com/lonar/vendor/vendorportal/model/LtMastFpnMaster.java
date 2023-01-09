
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_FPN_MASTER")
/*@XmlRootElement

@NamedNativeQueries({
	@NamedNativeQuery(name = "LtP2pFpnMaster.getFpnUtilizedAmt", query="select LT_P2P_PO_VALIDATIONS_PUB.get_fpn_utilized_amount(?1, ?2) fpn_po_utilized_amt FROM DUAL")
})

@NamedQueries({
	//query to find out fpn utilization amount
		
	@NamedQuery(name = "LtP2pFpnMaster.getLikeByFpnNumber", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnNumber LIKE :fpnNumber"),
	
    @NamedQuery(name = "LtP2pFpnMaster.findAll", query = "SELECT l FROM LtP2pFpnMaster l"),
    @NamedQuery(name = "LtP2pFpnMaster.findByFpnId", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnId = :fpnId"),
    @NamedQuery(name = "LtP2pFpnMaster.findByFpnNumber", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnNumber = :fpnNumber"),
    @NamedQuery(name = "LtP2pFpnMaster.findByFpnDate", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnDate = :fpnDate"),
    @NamedQuery(name = "LtP2pFpnMaster.findByFpnValue", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnValue = :fpnValue"),
    @NamedQuery(name = "LtP2pFpnMaster.findByFpnUtilized", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnUtilized = :fpnUtilized"),
    @NamedQuery(name = "LtP2pFpnMaster.findByFpnBalance", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.fpnBalance = :fpnBalance"),
    @NamedQuery(name = "LtP2pFpnMaster.findByVendors", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.vendors = :vendors"),
    @NamedQuery(name = "LtP2pFpnMaster.findByCostCenters", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.costCenters = :costCenters"),
    @NamedQuery(name = "LtP2pFpnMaster.findByStartDate", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.startDate = :startDate"),
    @NamedQuery(name = "LtP2pFpnMaster.findByEndDate", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.endDate = :endDate"),
    @NamedQuery(name = "LtP2pFpnMaster.findByCreatedBy", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.createdBy = :createdBy"),
    @NamedQuery(name = "LtP2pFpnMaster.findByCreationDate", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.creationDate = :creationDate"),
    @NamedQuery(name = "LtP2pFpnMaster.findByLastUpdateLogin", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.lastUpdateLogin = :lastUpdateLogin"),
    @NamedQuery(name = "LtP2pFpnMaster.findByLastUpdatedBy", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "LtP2pFpnMaster.findByLastUpdateDate", query = "SELECT l FROM LtP2pFpnMaster l WHERE l.lastUpdateDate = :lastUpdateDate")})*/
public class LtMastFpnMaster extends BaseClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fpnmaster_seq")
	@SequenceGenerator(name = "fpnmaster_seq", sequenceName = "LT_MAST_FPN_MASTER_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
    
    @Column(name = "FPN_ID")
    private Long fpnId;
    
    @Size(max = 150)
    @Column(name = "FPN_NUMBER")
    private String fpnNumber;
    
    @Column(name = "FPN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fpnDate;
    
    @JsonView(DataTablesOutput.View.class)
    @Column(name = "FPN_VALUE")
    private Double fpnValue;
    
    @Column(name = "FPN_UTILIZED")
    private Double fpnUtilized;
    
    @Column(name = "FPN_BALANCE")
    private Double fpnBalance;
    
    @Size(max = 2000)
    @Column(name = "VENDORS")
    private String vendors;
    
    @Size(max = 2000)
    @Column(name = "COST_CENTERS")
    private String costCenters;
    
    @Transient
    private Long fpnUtilizedAmt;

	public Long getFpnId() {
		return fpnId;
	}

	public void setFpnId(Long fpnId) {
		this.fpnId = fpnId;
	}

	public String getFpnNumber() {
		return fpnNumber;
	}

	public void setFpnNumber(String fpnNumber) {
		this.fpnNumber = fpnNumber;
	}

	public Date getFpnDate() {
		return fpnDate;
	}

	public void setFpnDate(Date fpnDate) {
		this.fpnDate = fpnDate;
	}

	public Double getFpnValue() {
		return fpnValue;
	}

	public void setFpnValue(Double fpnValue) {
		this.fpnValue = fpnValue;
	}

	public Double getFpnUtilized() {
		return fpnUtilized;
	}

	public void setFpnUtilized(Double fpnUtilized) {
		this.fpnUtilized = fpnUtilized;
	}

	public Double getFpnBalance() {
		return fpnBalance;
	}

	public void setFpnBalance(Double fpnBalance) {
		this.fpnBalance = fpnBalance;
	}

	public String getVendors() {
		return vendors;
	}

	public void setVendors(String vendors) {
		this.vendors = vendors;
	}

	public String getCostCenters() {
		return costCenters;
	}

	public void setCostCenters(String costCenters) {
		this.costCenters = costCenters;
	}

	public Long getFpnUtilizedAmt() {
		return fpnUtilizedAmt;
	}

	public void setFpnUtilizedAmt(Long fpnUtilizedAmt) {
		this.fpnUtilizedAmt = fpnUtilizedAmt;
	}

	@Override
	public String toString() {
		return "LtP2pFpnMaster [fpnId=" + fpnId + ", fpnNumber=" + fpnNumber + ", fpnDate=" + fpnDate + ", fpnValue="
				+ fpnValue + ", fpnUtilized=" + fpnUtilized + ", fpnBalance=" + fpnBalance + ", vendors=" + vendors
				+ ", costCenters=" + costCenters + ", fpnUtilizedAmt=" + fpnUtilizedAmt + "]";
	}
    

}
