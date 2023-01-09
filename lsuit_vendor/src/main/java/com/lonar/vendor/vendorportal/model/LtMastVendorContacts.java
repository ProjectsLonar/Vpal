
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
@Table(name = "LT_MAST_VENDOR_CONTACTS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorContacts extends BaseClass
{
	
	
	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorContacts_seq")
	@SequenceGenerator(name = "vendorContacts_seq", sequenceName = "LT_MAST_VENDOR_CONTACTS_S", allocationSize = 1)
	@Column(name = "VENDOR_CONTACT_ID")
	private Long vendorContactId;
	
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ADD_ID")
	private Long vendorAddId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_PERSON")
	private String contactPerson;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_MOBILE")
	private String contactMobile;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_TEL")
	private String contactTel;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_EXT")
	private String contactExt;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_FAX")
	private String contactFax;

	public Long getVendorContactId() {
		return vendorContactId;
	}

	public void setVendorContactId(Long vendorContactId) {
		this.vendorContactId = vendorContactId;
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

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactExt() {
		return contactExt;
	}

	public void setContactExt(String contactExt) {
		this.contactExt = contactExt;
	}

	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	@Override
	public String toString() {
		return "LtMastVendorContacts [vendorContactId=" + vendorContactId + ", vendorId=" + vendorId + ", vendorAddId="
				+ vendorAddId + ", contactPerson=" + contactPerson + ", contactMobile=" + contactMobile
				+ ", contactEmail=" + contactEmail + ", contactTel=" + contactTel + ", contactExt=" + contactExt
				+ ", contactFax=" + contactFax + "]";
	}
	
	
	
	

}
