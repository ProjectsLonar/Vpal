package com.lonar.UserManagement.web.dao;

import java.rmi.ServerException;
import java.util.List;

import com.lonar.UserManagement.web.model.LtMastRoles;


public interface LtMastRolesDao {
	public List<LtMastRoles> findByRole(String rolename, Long companyId) throws ServerException;
	public List<LtMastRoles> findInRoleId(List<Long> roleID) throws ServerException;
	public List<LtMastRoles> findAllActive(Long companyId) throws ServerException;
	public List<LtMastRoles> findByActiveLikeRoleName(String roleName, Long companyId) throws ServerException;
	public List<LtMastRoles> findByLikeRoleName(String roleName, Long companyId) throws ServerException;
	public Long getLtMastRolesCount(LtMastRoles input, Long companyId);
	public List<LtMastRoles> getLtMastRolesDataTable(LtMastRoles input, Long companyId) ;
	public LtMastRoles getRolesByID(Long id) throws ServerException;
	public List<LtMastRoles> findAll(Long companyId) throws ServerException;
}
