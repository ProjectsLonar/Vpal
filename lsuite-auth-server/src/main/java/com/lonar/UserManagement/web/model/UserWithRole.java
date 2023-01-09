package com.lonar.UserManagement.web.model;

import java.util.List;

import javax.validation.Valid;

public class UserWithRole {
	private @Valid LtMastUsers ltMastUsers;
	private @Valid List<LtMastUserRoles> ltMastUserRoles;
	public LtMastUsers getLtMastUsers() {
		return ltMastUsers;
	}
	public void setLtMastUsers(LtMastUsers ltMastUsers) {
		this.ltMastUsers = ltMastUsers;
	}
	public List<LtMastUserRoles> getLtMastUserRoles() {
		return ltMastUserRoles;
	}
	public void setLtMastUserRoles(List<LtMastUserRoles> ltMastUserRoles) {
		this.ltMastUserRoles = ltMastUserRoles;
	}
	@Override
	public String toString() {
		return "UserWithRole [ltMastUsers=" + ltMastUsers + ", ltMastUserRoles=" + ltMastUserRoles + "]";
	}

	
}
