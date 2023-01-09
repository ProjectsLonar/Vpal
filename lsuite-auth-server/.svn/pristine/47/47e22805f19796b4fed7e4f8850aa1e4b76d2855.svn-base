
package com.lonar.UserManagement.web.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "LT_MAST_ROLES")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastRoles extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq", sequenceName = "LT_MAST_ROLES_S", allocationSize = 1)
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Size(max = 240)
	@Column(name = "ROLE_DESC")
	private String roleDesc;
	

	@Column(name = "STATUS")
	private String status;

	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Transient
	private String statusValue;

	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleDesc() {
		return roleDesc;
	}


	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
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
		return "LtMastRoles [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", status="
				+ status + ", companyId=" + companyId + ", statusValue=" + statusValue + "]";
	}




}
