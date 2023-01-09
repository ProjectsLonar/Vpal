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

@Entity
@Table(name = "LT_MAST_AUDIT")
public class LtMastAudit {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_seq")
	@SequenceGenerator(name = "audit_seq", sequenceName = "LT_MAST_AUDIT_S", allocationSize = 1)
	@Column(name = "AUDIT_ID")
	private Long auditId;
	
	@Basic(optional = false)
	@NotNull(message="notnull")
	@Column(name = "MASTER_NAME")
	private String masterName;
	
	@Basic(optional = false)
	@Column(name = "OLD_ENTITY")
	private String oldEntity;
	
	@Basic(optional = false)
	@Column(name = "NEW_ENTITY")
	private String newEntity;
	
	@Basic(optional = false)
	@Column(name = "DIFFERENCE")
	private String difference;
	
	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "VALUE_NAME")
	private String valueName;
	
	@Column(name = "OLD_VALUE")
	private String oldValue;
	
	@Column(name = "NEW_VALUE")
	private String newValue;

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getOldEntity() {
		return oldEntity;
	}

	public void setOldEntity(String oldEntity) {
		this.oldEntity = oldEntity;
	}

	public String getNewEntity() {
		return newEntity;
	}

	public void setNewEntity(String newEntity) {
		this.newEntity = newEntity;
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

	public String getDifference() {
		return difference;
	}

	public void setDifference(String difference) {
		this.difference = difference;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	@Override
	public String toString() {
		return "LtMastAudit [auditId=" + auditId + ", masterName=" + masterName + ", oldEntity=" + oldEntity
				+ ", newEntity=" + newEntity + ", difference=" + difference + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", valueName=" + valueName + ", oldValue=" + oldValue
				+ ", newValue=" + newValue + "]";
	}

	
	
	
	
}
