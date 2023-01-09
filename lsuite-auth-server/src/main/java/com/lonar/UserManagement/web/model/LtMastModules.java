 
package com.lonar.UserManagement.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "LT_MAST_MODULES")
@XmlRootElement
public class LtMastModules implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_seq")
	@SequenceGenerator(name = "module_seq", sequenceName = "LT_MAST_MODULES_S", allocationSize = 1)
	@Column(name = "MODULE_ID")
	private Long moduleId;
	
	@Column(name ="MODULE_CODE")
	private String moduleCode;
	
	@Column(name = "MODULE_NAME")
	private String moduleName;
	
	@Column(name = "MODULE_DESC")
	private String moduleDesc;
	
	@Column(name = "MODULE_URL")
	private String moduleUrl;
	
	@Column(name = "MODULE_GROUP")
	private String moduleGroup;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "CREATED_BY")
	private long createdBy;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "LAST_UPDATE_LOGIN")
	private long lastUpdateLogin;
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "SEQUENCE_NUMBER")
	private Long sequenceNumber;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
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
	private String statusValue;
	
	@Transient
	private String moduleGroupValue;
	
	public LtMastModules() {
	}


	public LtMastModules(Long moduleId) {
		this.moduleId = moduleId;
	}

	

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	
	
	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		
		this.moduleName = moduleName;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public Date getStartDate() {

		return startDate;
	}

	public void setStartDate(Date startDate) {

		this.startDate = startDate;

	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;

	}

	public long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(long lastUpdateLogin) {
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

	public String getModuleGroup() {
		return moduleGroup;
	}

	public void setModuleGroup(String moduleGroup) {
		this.moduleGroup = moduleGroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	


	public Long getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (moduleId != null ? moduleId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LtMastModules)) {
			return false;
		}
		LtMastModules other = (LtMastModules) object;
		if ((this.moduleId == null && other.moduleId != null)
				|| (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
			return false;
		}
		return true;
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


	public String getStatusValue() {
		return statusValue;
	}


	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}


	public String getModuleGroupValue() {
		return moduleGroupValue;
	}


	public void setModuleGroupValue(String moduleGroupValue) {
		this.moduleGroupValue = moduleGroupValue;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	@Override
	public String toString() {
		return "LtMastModules [moduleId=" + moduleId + ", moduleCode=" + moduleCode + ", moduleName=" + moduleName
				+ ", moduleDesc=" + moduleDesc + ", moduleUrl=" + moduleUrl + ", moduleGroup=" + moduleGroup
				+ ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", sequenceNumber=" + sequenceNumber + ", lastUpdateDate="
				+ lastUpdateDate + ", companyId=" + companyId + ", draw=" + draw + ", start=" + start + ", length="
				+ length + ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo + ", sort=" + sort
				+ ", statusValue=" + statusValue + ", moduleGroupValue=" + moduleGroupValue + "]";
	}


	

	
}
