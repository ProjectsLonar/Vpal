
package com.lonar.vendor.vendorportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_ROLE_MODULES")
@XmlRootElement

public class LtMastRoleModules implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	//@NotNull
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleFunc_seq")
	@SequenceGenerator(name = "roleFunc_seq", sequenceName = "LT_MAST_ROLE_MODULES_S", allocationSize = 1)
	@Column(name = "ROLE_FUNC_ID")
	private Long roleFuncId;
	
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@Column(name = "MODULE_ID")
	private Long moduleId;
	
	@Size(max = 1)
	@Column(name ="CREATE_FLAG")
	private String create;
	
	@Size(max = 1)
	@Column(name ="EDIT_FLAG")
	private String edit;
	
	@Size(max = 1)
	@Column(name = "READ_FLAG")
	private String read;
	
	@Size(max = 1)
	@Column(name = "DELETE_FLAG")
	private String deleteflag;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "CREATED_BY")
	private long createdBy;
	
	@Basic(optional = false)
	//@NotNull
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private long lastUpdateLogin;
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;
	
	@Column(name = "STATUS")
	private String status; 
	
	
	@Transient
	private String updateFlag;

	@Transient
	private String moduleName;

	@Transient
	private String moduleDescription;

	public LtMastRoleModules() {
	}

	

	public Long getRoleFuncId() {
		return roleFuncId;
	}

	public void setRoleFuncId(Long roleFuncId) {
		this.roleFuncId = roleFuncId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
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

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}


	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	

	

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public void setModuleName(String moduleName) {
		if (moduleName == null || moduleName.equals("null"))
			moduleName = "";
		this.moduleName = moduleName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		if (moduleDescription == null || moduleDescription.equals("null"))
			moduleDescription = "";
		this.moduleDescription = moduleDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (roleFuncId != null ? roleFuncId.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LtMastRoleModules)) {
			return false;
		}
		LtMastRoleModules other = (LtMastRoleModules) object;
		if ((this.roleFuncId == null && other.roleFuncId != null)
				|| (this.roleFuncId != null && !this.roleFuncId.equals(other.roleFuncId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "LtMastRoleModules [roleFuncId=" + roleFuncId + ", roleId="
				+ roleId + ", moduleId=" + moduleId + ", create=" + create
				+ ", update=" + edit + ", read=" + read + ", delete="
				+ deleteflag + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate
				+ ", status=" + status + ", updateFlag=" + updateFlag
				+ ", moduleName=" + moduleName + ", moduleDescription="
				+ moduleDescription + "]";
	}
}
