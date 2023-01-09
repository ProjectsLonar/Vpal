package com.lonar.vendor.vendorportal.model;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_INVOICE_LINE_TAXES")
@JsonInclude(Include.NON_NULL)
public class LtInvoiceLineTaxes 
{

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_line_tax_seq")
	@SequenceGenerator(name = "invoice_line_tax_seq", sequenceName = "LT_INVOICE_LINE_TAXES_S", allocationSize = 1)
	@Column(name = "Invoice_Line_Tax_Id")
	private Long invoiceLineTaxId;
	
	@Column(name = "INVOICE_HEADER_ID")
	private Long invoiceHeaderId;
	
	@Column(name = "INVOICE_LINE_ID")
	private Long invoiceLineId;
	
	@Column(name = "TAX_ID")
	private Long taxId;
	
	@Column(name = "TAX_RATE")
	private Double taxRate;
	
	@Column(name = "TAX_AMOUNT")
	private Double taxAmount;
	
	@Column(name = "Created_by")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "Creation_date")
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;
	
	@Column(name = "Last_updated_by")
	private Long lastUpdatedBy;
	
	@Column(name = "Last_update_date")
	private Date lastUpdateDate;

	@Transient
	private String taxName;
	
	@Transient
	private String taxDesc;
	
	public Long getInvoiceLineTaxId() {
		return invoiceLineTaxId;
	}

	public void setInvoiceLineTaxId(Long invoiceLineTaxId) {
		this.invoiceLineTaxId = invoiceLineTaxId;
	}

	public Long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(Long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public Long getInvoiceLineId() {
		return invoiceLineId;
	}

	public void setInvoiceLineId(Long invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}

	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getTaxDesc() {
		return taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	@Override
	public String toString() {
		return "LtInvoiceLineTaxes [invoiceLineTaxId=" + invoiceLineTaxId + ", invoiceHeaderId=" + invoiceHeaderId
				+ ", invoiceLineId=" + invoiceLineId + ", taxId=" + taxId + ", taxRate=" + taxRate + ", taxAmount="
				+ taxAmount + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin="
				+ lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate
				+ ", taxName=" + taxName + ", taxDesc=" + taxDesc + "]";
	}

	
	
	
}
