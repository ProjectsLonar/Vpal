package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.UserMolule;
import com.lonar.UserManagement.web.model.UserRoleWithRoleName;

public interface LtMastUserRolesService {

	public List<LtMastUserRoles> findByUserIdAndRoleId(Long userID, Long roleID) throws Exception;

	public List<Long> findByUserId(Long userID) throws Exception;

	public List findByRoleIdWithUserId() throws Exception;

	public List<UserMolule> findByUserIdGetRoleName(Long userId) throws Exception ;

	public List<LtMastUserRoles> findAllActive() throws Exception;

	public List<LtMastUserRoles> findByUserIdWithList(Long userID) throws Exception;

	public List<UserRoleWithRoleName> findListWithRoleNameModuleName(Long userId) throws Exception;

	public List<LtMastUserRoles> findByRoleId(Long roleId) throws Exception;

	public List<String> findAllActiveRoleName(Long userID) throws Exception;

	public List<LtMastUserRoles> getByUserId(Long userId)throws Exception;
	
	CustomeDataTable getDataTable( LtMastUserRoles input);
	
	// New Api
	
	Status saveUserRole(LtMastUserRoles userRole)throws Exception;
	
	List<LtMastUserRoles> getRoleByUserId(Long userId)throws Exception;
	
	Status updateUserRole(LtMastUserRoles userRole)throws Exception;
	
	LtMastUserRoles getUserRoleById(Long userId)throws Exception;
	
	
}
