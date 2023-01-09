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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_PAYMENT_TERMS")
@JsonInclude(Include.NON_NULL)
public class LtMastPaymentTerms extends BaseClass {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_term_seq")
	@SequenceGenerator(name = "payment_term_seq", sequenceName = "LT_MAST_PAYMENT_TERMS_S", allocationSize = 1)
	@Column(name = "PAYTERM_ID")
	private Long paytermId;
	
	@Column(name = "TERM_NAME")
	private String termName;
	
	@Column(name = "NO_DAY")
	private Double noDay;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String statusValue;

	public Long getPaytermId() {
		return paytermId;
	}

	public void setPaytermId(Long paytermId) {
		this.paytermId = paytermId;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public Double getNoDay() {
		return noDay;
	}

	public void setNoDay(Double noDay) {
		this.noDay = noDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "LtMastPaymentTerms [paytermId=" + paytermId + ", termName=" + termName + ", noDay=" + noDay
				+ ", status=" + status + ", companyId=" + companyId + ", statusValue=" + statusValue + "]";
	}

	
	
}
