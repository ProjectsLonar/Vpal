
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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "LT_MAST_GL_ACCOUNTS")
@JsonInclude(Include.NON_NULL)
public class LtMastGlAccounts extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glAccount_seq")
	@SequenceGenerator(name = "glAccount_seq", sequenceName = "LT_MAST_GL_ACCOUNTS_S", allocationSize = 1)
	@Column(name = "GL_ACCOUNT_ID")
	private Long glAccountId;
	
	@Basic(optional = false)
	@Size(min = 1, max = 80)
	@Column(name = "ACCOUNT_CODE")
	private String accountCode;
	
	@Size(max = 240)
	@Column(name = "ACCOUNT_NAME")
	private String accountName;
	
	@Size(max = 240)
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Size(max = 240)
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String accountTypeValue;
	
	@Transient
	private String statusValue;
	
	public Long getGlAccountId() {
		return glAccountId;
	}

	public void setGlAccountId(Long glAccountId) {
		this.glAccountId = glAccountId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountTypeValue() {
		return accountTypeValue;
	}

	public void setAccountTypeValue(String accountTypeValue) {
		this.accountTypeValue = accountTypeValue;
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
		return "LtMastGlAccounts [glAccountId=" + glAccountId + ", accountCode=" + accountCode + ", accountName="
				+ accountName + ", accountType=" + accountType + ", status=" + status + ", companyId=" + companyId
				+ ", accountTypeValue=" + accountTypeValue + ", statusValue=" + statusValue + "]";
	}


	
}
