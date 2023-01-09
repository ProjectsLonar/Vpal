
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
@Table(name = "LT_MAST_VENDOR_CLIENTS")
@JsonInclude(Include.NON_NULL)
public class LtMastVendorClients extends BaseClass {
	
	
	
	@Id
	@Basic(optional = false)
	@JsonView(DataTablesOutput.View.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorClients_seq")
	@SequenceGenerator(name = "vendorClients_seq", sequenceName = "LT_MAST_VENDOR_CLIENTS_S", allocationSize = 1)
	@Column(name = "VENDOR_CLIENTS_ID")
	private Long vendorClientsId;
	
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VENDOR_ID")
	private Long vendorId;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CLIENT_NAME")
	private String clientName;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CLIENT_ADDRESS")
	private String clientAddress;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CLIENT_CONTACT_PERSON")
	private String clientContactPerson;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CLIENT_CONTACT_DESG")
	private String clientContactDesg;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CLIENT_CONTACT_NO")
	private String clientContactNo;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "PRODUCT_SUPPLIED")
	private String productSupplied;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "VALUE_SUPPLIES")
	private String valueSupplies;
	
	
	
	/*private Long createdBy;
	private Date creationDate;
	private Long lastUpdateLogin;
	private Long	 lastUpdatedBy;
	private Date lastUpdateDate;*/
	
	

	public Long getVendorClientsId() {
		return vendorClientsId;
	}

	public void setVendorClientsId(Long vendorClientsId) {
		this.vendorClientsId = vendorClientsId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientContactPerson() {
		return clientContactPerson;
	}

	public void setClientContactPerson(String clientContactPerson) {
		this.clientContactPerson = clientContactPerson;
	}

	public String getClientContactDesg() {
		return clientContactDesg;
	}

	public void setClientContactDesg(String clientContactDesg) {
		this.clientContactDesg = clientContactDesg;
	}

	public String getClientContactNo() {
		return clientContactNo;
	}

	public void setClientContactNo(String clientContactNo) {
		this.clientContactNo = clientContactNo;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getProductSupplied() {
		return productSupplied;
	}

	public void setProductSupplied(String productSupplied) {
		this.productSupplied = productSupplied;
	}

	public String getValueSupplies() {
		return valueSupplies;
	}

	public void setValueSupplies(String valueSupplies) {
		this.valueSupplies = valueSupplies;
	}

	@Override
	public String toString() {
		return "LtMastVendorClients [vendorClientsId=" + vendorClientsId + ", vendorId=" + vendorId + ", clientName="
				+ clientName + ", clientAddress=" + clientAddress + ", clientContactPerson=" + clientContactPerson
				+ ", clientContactDesg=" + clientContactDesg + ", clientContactNo=" + clientContactNo
				+ ", contactEmail=" + contactEmail + ", productSupplied=" + productSupplied + ", valueSupplies="
				+ valueSupplies + "]";
	}
	
	
	
	
	
	
	
	
	
}
