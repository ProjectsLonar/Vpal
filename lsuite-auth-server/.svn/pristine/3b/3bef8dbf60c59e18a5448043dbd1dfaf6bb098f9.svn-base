/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonar.UserManagement.web.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
	private String createFlag;
	
	@Size(max = 1)
	@Column(name ="EDIT_FLAG")
	private String editFlag;
	
	@Size(max = 1)
	@Column(name = "READ_FLAG")
	private String readFlag;
	
	@Size(max = 1)
	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Size(max = 1)
	@Column(name = "UPDATE_FLAG")
	private String updateFlag;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "CREATED_BY")
	private long createdBy;
	
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "LAST_UPDATE_LOGIN")
	private long lastUpdateLogin;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	
	@Column(name = "STATUS")
	private String status; 
	
	
	/*@Transient
	private String updateFlag;*/

	@Transient
	private String moduleName;

	@Transient
	private String moduleDescription;

	public LtMastRoleModules() {
	}

	public LtMastRoleModules(Long roleFuncId) {
		this.roleFuncId = roleFuncId;
	}

	public LtMastRoleModules(Long roleFuncId, Date startDate, long createdBy, Date creationDate, long lastUpdateLogin) {
		this.roleFuncId = roleFuncId;
		this.startDate = startDate;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.lastUpdateLogin = lastUpdateLogin;
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

	public String getCreateFlag() {
		return createFlag;
	}

	public void setCreateFlag(String createFlag) {
		this.createFlag = createFlag;
	}

	public String getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}

	public String getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}

	

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "LtMastRoleModules [roleFuncId=" + roleFuncId + ", roleId=" + roleId + ", moduleId=" + moduleId
				+ ", createFlag=" + createFlag + ", editFlag=" + editFlag + ", readFlag=" + readFlag + ", deleteflag="
				+ deleteFlag + ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", status=" + status + ", updateFlag="
				+ updateFlag + ", moduleName=" + moduleName + ", moduleDescription=" + moduleDescription + "]";
	}

	
}
