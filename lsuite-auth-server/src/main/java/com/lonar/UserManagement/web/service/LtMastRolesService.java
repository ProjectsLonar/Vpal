package com.lonar.UserManagement.web.service;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastRoles;
import com.lonar.UserManagement.web.model.RoleWithModule;
import com.lonar.UserManagement.web.model.Status;

public interface LtMastRolesService {

	public List<LtMastRoles> findByRole(String rolename,Long companyId) throws ServerException;

	public List<LtMastRoles> findInRoleId(List<Long> roleID) throws ServerException;

	public List<LtMastRoles> findAllActive(Long companyId) throws ServerException;

	public List<LtMastRoles> findByActiveLikeRoleName(String roleName, Long companyId) throws ServerException;
	
	public List<LtMastRoles>	findByLikeRoleName(String roleName, Long companyId) throws ServerException;

	//public Long getLtMastRolesCount(LtMastRoles input) throws Exception;
	//public List<LtMastRoles> getLtMastRolesDataTable(LtMastRoles input) throws Exception;
	
	CustomeDataTable getDataTable( LtMastRoles input, Long companyId);

	public ResponseEntity<Status> saveRole(LtMastRoles ltMastRoles) throws ServerException;

	public ResponseEntity<Status> updateRole(LtMastRoles ltMastRoles) throws ServerException;

	public ResponseEntity<Status> saveRoleWithModule(RoleWithModule roleWithModule) throws ServerException;

	public LtMastRoles getRolesByID(Long id) throws ServerException;

	public List<LtMastRoles> findAll(Long companyId) throws ServerException;

	//public ResponseEntity<Status> saveRole(LtMastRoles ltMastRoles) throws ServerException;

}
