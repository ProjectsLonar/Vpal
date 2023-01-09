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
@Table(name = "LT_MAST_ADD_FIELDS_COL_USES")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastAddFieldsColUses implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appColumnId_seq")
	@SequenceGenerator(name = "appColumnId_seq", sequenceName = "LT_MAST_ADDITIONAL_FIELDS_S", allocationSize = 1)
	@Column(name = "APP_COLUMN_ID")
	private Long appColumnId;

	@Column(name = "APP_CATEGORY_NAME")
	private String appCategoryName;

	@Column(name = "APP_COLUMN_NAME")
	private String appColumnName;

	@Column(name = "END_USER_COLUMN_NAME")
	private String endUserColumnName;

	@Column(name = "APP_COLUMN_SEQ_NO")
	private Long appColumnSeqNo;

	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;

	@Column(name = "REQUIRED_FLAG")
	private String requiredFlag;

	@Column(name = "DISPLAY_FLAG")
	private String displayFlag;

	@Column(name = "DISPLAY_SIZE")
	private Long displaySize;
	
	/*@Column(name = "COMPANY_ID")
	private String companyId;*/

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

	@Column(name = "FIELD_DEFINITION_ID")
	private Long fieldDefinitionId;
	
	@Transient
	private String fieldDefinitionName; 
	
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
	
	@Transient
	private String displaySizeStr;

	@Transient
	private String appColumnSeqNoStr;
	
	@Transient
	private String title;

	public Long getAppColumnId() {
		return appColumnId;
	}

	public void setAppColumnId(Long appColumnId) {
		this.appColumnId = appColumnId;
	}

	public String getAppCategoryName() {
		return appCategoryName;
	}

	public void setAppCategoryName(String appCategoryName) {
		this.appCategoryName = appCategoryName;
	}

	public String getAppColumnName() {
		return appColumnName;
	}

	public void setAppColumnName(String appColumnName) {
		this.appColumnName = appColumnName;
	}

	public String getEndUserColumnName() {
		return endUserColumnName;
	}

	public void setEndUserColumnName(String endUserColumnName) {
		this.endUserColumnName = endUserColumnName;
	}

	public Long getAppColumnSeqNo() {
		return appColumnSeqNo;
	}

	public void setAppColumnSeqNo(Long appColumnSeqNo) {
		this.appColumnSeqNo = appColumnSeqNo;
	}

	public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public String getRequiredFlag() {
		return requiredFlag;
	}

	public void setRequiredFlag(String requiredFlag) {
		this.requiredFlag = requiredFlag;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public Long getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(Long displaySize) {
		this.displaySize = displaySize;
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

	public String getDisplaySizeStr() {
		return displaySizeStr;
	}

	public void setDisplaySizeStr(String displaySizeStr) {
		this.displaySizeStr = displaySizeStr;
	}

	public String getAppColumnSeqNoStr() {
		return appColumnSeqNoStr;
	}

	public void setAppColumnSeqNoStr(String appColumnSeqNoStr) {
		this.appColumnSeqNoStr = appColumnSeqNoStr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LtMastAddFieldsColUses [appColumnId=" + appColumnId + ", appCategoryName=" + appCategoryName
				+ ", appColumnName=" + appColumnName + ", endUserColumnName=" + endUserColumnName + ", appColumnSeqNo="
				+ appColumnSeqNo + ", enabledFlag=" + enabledFlag + ", requiredFlag=" + requiredFlag + ", displayFlag="
				+ displayFlag + ", displaySize=" + displaySize + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", fieldDefinitionId=" + fieldDefinitionId
				+ ", fieldDefinitionName=" + fieldDefinitionName + ", draw=" + draw + ", start=" + start + ", length="
				+ length + ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo + ", sort=" + sort
				+ ", displaySizeStr=" + displaySizeStr + ", appColumnSeqNoStr=" + appColumnSeqNoStr + ", title=" + title
				+ "]";
	} 
	
	
	
}
