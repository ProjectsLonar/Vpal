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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_INVOICE_ACCOUNTING")
@JsonInclude(Include.NON_NULL)
public class LtInvoiceAccounting 
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_accounting_seq")
	@SequenceGenerator(name = "invoice_accounting_seq", sequenceName = "LT_INVOICE_ACCOUNTING_S", allocationSize = 1)
	@Column(name = "invoice_accounting_id")
	private Long invoiceAccountingId;
	
	@Column(name = "INVOICE_HEADER_ID")
	private Long invoiceHeaderId;
	
	@Column(name = "INVOICE_LINE_ID")
	private Long invoiceLineId;

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

	public Long getInvoiceAccountingId() {
		return invoiceAccountingId;
	}

	public void setInvoiceAccountingId(Long invoiceAccountingId) {
		this.invoiceAccountingId = invoiceAccountingId;
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

	@Override
	public String toString() {
		return "LtInvoiceAccounting [invoiceAccountingId=" + invoiceAccountingId + ", invoiceHeaderId="
				+ invoiceHeaderId + ", invoiceLineId=" + invoiceLineId + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	
}
