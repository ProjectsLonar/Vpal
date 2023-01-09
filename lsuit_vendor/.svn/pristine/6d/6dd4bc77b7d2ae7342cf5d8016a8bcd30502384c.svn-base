
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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "LT_MAST_GL_ACCOUNTS")
/*@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LtP2pGlAccounts.findAll", query = "SELECT l FROM LtP2pGlAccounts l"),
		@NamedQuery(name = "LtP2pGlAccounts.findAllActive", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.startDate <= CURRENT_DATE() AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE())"),
		@NamedQuery(name = "LtP2pGlAccounts.findLikeAccountName", query = "SELECT l FROM LtP2pGlAccounts l WHERE LOWER(CONCAT(l.accountName,' ',l.accountCode)) LIKE  :accountName "),
		@NamedQuery(name = "LtP2pGlAccounts.findActiveLikeAccountName", query = "SELECT l FROM LtP2pGlAccounts l WHERE LOWER(CONCAT(l.accountName,' ',l.accountCode)) LIKE  :accountName  AND (l.endDate IS NULL OR l.endDate >= CURRENT_DATE()) "),
		@NamedQuery(name = "LtP2pGlAccounts.findByAccountId", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.accountId = :accountId"),
		@NamedQuery(name = "LtP2pGlAccounts.findByAccountCode", query = "SELECT l FROM LtP2pGlAccounts l WHERE UPPER(l.accountCode) = UPPER(:accountCode)"),
		@NamedQuery(name = "LtP2pGlAccounts.findByAccountName", query = "SELECT l FROM LtP2pGlAccounts l WHERE LOWER(l.accountName) = LOWER(:accountName)"),
		@NamedQuery(name = "LtP2pGlAccounts.findByStartDate", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.startDate = :startDate"),
		@NamedQuery(name = "LtP2pGlAccounts.findByEndDate", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.endDate = :endDate"),
		@NamedQuery(name = "LtP2pGlAccounts.findByCreatedBy", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.createdBy = :createdBy"),
		@NamedQuery(name = "LtP2pGlAccounts.findByCreationDate", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.creationDate = :creationDate"),
		@NamedQuery(name = "LtP2pGlAccounts.findByLastUpdateLogin", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.lastUpdateLogin = :lastUpdateLogin"),
		@NamedQuery(name = "LtP2pGlAccounts.findByLastUpdatedBy", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.lastUpdatedBy = :lastUpdatedBy"),
		@NamedQuery(name = "LtP2pGlAccounts.findByLastUpdateDate", query = "SELECT l FROM LtP2pGlAccounts l WHERE l.lastUpdateDate = :lastUpdateDate") })*/
@JsonInclude(Include.NON_NULL)
public class LtMastGlAccounts extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glAccount_seq")
	@SequenceGenerator(name = "glAccount_seq", sequenceName = "LT_MAST_GL_ACCOUNTS_S", allocationSize = 1)
	@Column(name = "ACCOUNT_ID")
	private Long accountId;
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
	@Column(name = "STATUS")
	private String status; 


	
	public LtMastGlAccounts() {
	}

	public LtMastGlAccounts(Long accountId) {
		this.accountId = accountId;
	}


	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LtMastGlAccounts [accountId=" + accountId + ", accountCode=" + accountCode + ", accountName="
				+ accountName + ", accountType=" + accountType + ", status=" + status + "]";
	}

	

}
