
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
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "LT_MAST_USER_ROLES")
@XmlRootElement


public class LtMastUserRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	//@NotNull
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRole_seq")
	@SequenceGenerator(name = "userRole_seq", sequenceName = "LT_MAST_USER_ROLES_S", allocationSize = 1)
	@Column(name = "USER_ROLE_ID")
	private Long userRoleId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
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
	
	/*@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "STATUS")
	private String status; */
	
	@Transient
	private String updateFlag;

	@Transient
	private String roleName;
	
	@Transient
	private String roleDesc;

	public LtMastUserRoles() {
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		if (roleDesc == null || roleDesc.equals("null"))
			roleDesc = "";
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		if (roleName == null || roleName.equals("null"))
			roleName = "";
		this.roleName = roleName;
	}

	/*public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LtMastUserRoles other = (LtMastUserRoles) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "LtMastUserRoles [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

}
