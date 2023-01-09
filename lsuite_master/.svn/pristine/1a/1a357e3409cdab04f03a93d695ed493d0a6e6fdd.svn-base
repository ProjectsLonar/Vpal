package com.lonar.vendor.vendorportal.additionalfields;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_ADDITIONAL_FIELDS")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastAdditionalFields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fieldDefinitionId_seq")
	@SequenceGenerator(name = "fieldDefinitionId_seq", sequenceName = "LT_MAST_ADDITIONAL_FIELDS_S", allocationSize = 1)
	@Column(name = "FIELD_DEFINITION_ID")
	private Long fieldDefinitionId;

	@Column(name = "FIELD_DEFINITION_NAME")
	private String fieldDefinitionName;

	@Column(name = "APPLICATION_TABLE_NAME")
	private String applicationTableName;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "COMPANY_ID")
	private String companyId;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;

	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String stDate;

	@Transient
	private String enDate;

	@Transient
	private int columnNo;

	@Transient
	private String sort;

	public Long getFieldDefinitionId() {
		return fieldDefinitionId;
	}

	public void setFieldDefinitionId(Long fieldDefinitionId) {
		this.fieldDefinitionId = fieldDefinitionId;
	}

	public String getFieldDefinitionName() {
		return fieldDefinitionName;
	}

	public void setFieldDefinitionName(String fieldDefinitionName) {
		this.fieldDefinitionName = fieldDefinitionName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String stDate) {
		this.stDate = stDate;
	}

	public String getEnDate() {
		return enDate;
	}

	public void setEnDate(String enDate) {
		this.enDate = enDate;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getApplicationTableName() {
		return applicationTableName;
	}

	public void setApplicationTableName(String applicationTableName) {
		this.applicationTableName = applicationTableName;
	}
	
}
