package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.UserMolule;
import com.lonar.UserManagement.web.model.UserRoleWithRoleName;


public interface LtMastUserRolesDao {
	
	public List<LtMastUserRoles> findByUserIdAndRoleId(Long userID,Long roleID) throws Exception; 
	public List<LtMastUserRoles> findByUserId(Long userID) throws Exception; 
	public List<UserMolule> findByUserIdGetRoleName(Long userId) throws Exception;
	public List<LtMastUserRoles>	findAllActive() throws Exception;
	public List<LtMastUserRoles> findByUserIdWithList(Long userID) throws Exception;
	public List<UserRoleWithRoleName> findListWithRoleNameModuleName(Long userID) throws Exception;
	public List<LtMastUserRoles> findByRoleId(Long roleId) throws Exception;
	public List<String> findAllActiveRoleName(Long userID) throws Exception;
	public List<LtMastUserRoles> getByUserId(Long userId) throws Exception;
	
	///New 
	public Status saveUserRole(LtMastUserRoles userRole) throws Exception; ;
	public List<LtMastUserRoles> getRoleByUserId(Long userId)throws Exception;
	Status updateUserRole(LtMastUserRoles userRole)throws Exception;
	LtMastUserRoles getUserRoleById(Long userId)throws Exception;
	public boolean chkDuplicate(LtMastUserRoles userRole) throws Exception;
}
