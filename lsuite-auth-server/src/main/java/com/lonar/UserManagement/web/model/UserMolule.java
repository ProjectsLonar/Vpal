package com.lonar.UserManagement.web.model;

import java.util.Date;

public class UserMolule {

	private Long roleId;
	private String roleName;
	private String roleDesc;
	private Long userRoleId;
	private Date startDate;
	private Date endDate;

	public UserMolule() {

	}

	public UserMolule(Long roleId, String roleName, String roleDesc, Long userRoleId, Date startDate, Date endDate) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.userRoleId = userRoleId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

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

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
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

}
