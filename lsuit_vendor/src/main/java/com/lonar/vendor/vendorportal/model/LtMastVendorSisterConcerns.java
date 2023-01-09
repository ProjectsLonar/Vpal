
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
@Table(name = "LT_MAST_VENDOR_SISTER_CONCERNS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorSisterConcerns extends BaseClass
{
	
	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorSisterConcerns_seq")
	@SequenceGenerator(name = "vendorSisterConcerns_seq", sequenceName = "LT_MAST_VEND_SIS_CONCE_S", allocationSize = 1)
	@Column(name = "VENDOR_SISTER_CONCERNS_ID")
	private Long vendorSisterConcernsId;
	
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "MAJOR_PRODUCTS")
	private String majorProducts;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_ADDRESS")
	private String companyAddress;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_CONTACT_PERSON")
	private String companyContactPerson;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_CONTACT_DESG")
	private String companyContactDesg;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_CONTACT_NO")
	private String companyContactNo;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_CONTACT_EMAIL")
	private String companyContactEmail;

	public Long getVendorSisterConcernsId() {
		return vendorSisterConcernsId;
	}

	public void setVendorSisterConcernsId(Long vendorSisterConcernsId) {
		this.vendorSisterConcernsId = vendorSisterConcernsId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMajorProducts() {
		return majorProducts;
	}

	public void setMajorProducts(String majorProducts) {
		this.majorProducts = majorProducts;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContactPerson() {
		return companyContactPerson;
	}

	public void setCompanyContactPerson(String companyContactPerson) {
		this.companyContactPerson = companyContactPerson;
	}

	public String getCompanyContactDesg() {
		return companyContactDesg;
	}

	public void setCompanyContactDesg(String companyContactDesg) {
		this.companyContactDesg = companyContactDesg;
	}

	public String getCompanyContactNo() {
		return companyContactNo;
	}

	public void setCompanyContactNo(String companyContactNo) {
		this.companyContactNo = companyContactNo;
	}

	public String getCompanyContactEmail() {
		return companyContactEmail;
	}

	public void setCompanyContactEmail(String companyContactEmail) {
		this.companyContactEmail = companyContactEmail;
	}

	@Override
	public String toString() {
		return "LtMastVendorSisterConcerns [vendorSisterConcernsId=" + vendorSisterConcernsId + ", vendorId=" + vendorId
				+ ", companyName=" + companyName + ", majorProducts=" + majorProducts + ", companyAddress="
				+ companyAddress + ", companyContactPerson=" + companyContactPerson + ", companyContactDesg="
				+ companyContactDesg + ", companyContactNo=" + companyContactNo + ", companyContactEmail="
				+ companyContactEmail + "]";
	}
	
	

	
	

}
