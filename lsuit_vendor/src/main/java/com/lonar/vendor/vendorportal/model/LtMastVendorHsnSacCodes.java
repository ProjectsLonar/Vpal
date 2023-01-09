
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
@Table(name = "LT_MAST_VENDOR_HSN_SAC_CODES")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorHsnSacCodes extends BaseClass
{

	
	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorHsnSacCodes_seq")
	@SequenceGenerator(name = "vendorHsnSacCodes_seq", sequenceName = "lt_mast_vendor_hsn_sac_codes_s", allocationSize = 1)
	@Column(name = "VENDOR_HSN_ID")
	private Long vendorHsnId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ADD_ID")
	private Long vendorAddId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "HSN_SAC_CODE")
	private String hsnSacCode;

	public Long getVendorHsnId() {
		return vendorHsnId;
	}

	public void setVendorHsnId(Long vendorHsnId) {
		this.vendorHsnId = vendorHsnId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getVendorAddId() {
		return vendorAddId;
	}

	public void setVendorAddId(Long vendorAddId) {
		this.vendorAddId = vendorAddId;
	}

	public String getHsnSacCode() {
		return hsnSacCode;
	}

	public void setHsnSacCode(String hsnSacCode) {
		this.hsnSacCode = hsnSacCode;
	}

	@Override
	public String toString() {
		return "LtMastVendorHsnSacCodes [vendorHsnId=" + vendorHsnId + ", vendorId=" + vendorId + ", vendorAddId="
				+ vendorAddId + ", hsnSacCode=" + hsnSacCode + "]";
	}
	
	
	
	
	
}
