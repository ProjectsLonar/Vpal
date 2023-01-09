package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastRoleModules;
import com.lonar.UserManagement.web.model.Menu;
import com.lonar.UserManagement.web.model.ModuleList;
import com.lonar.UserManagement.web.model.RoleModule;
import com.lonar.UserManagement.web.model.Status;

public interface LtMastRoleModulesService {

	public List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleID, Long moduleID) throws BusinessException;

	public List<Long> findByRoleIdOutputModuleID(Long roleID) throws BusinessException;

	public List<LtMastRoleModules> findByUserIdANDRoleId(List<Long> roleId, List<Long> moduleId) throws BusinessException;

	public List<LtMastRoleModules> findInRoleIdAndModuleIdWithInDate(List<Long> roleId, List<Long> moduleId) throws BusinessException;

	public List findByRoleIdWithUserId() throws BusinessException;

	public List<Menu> findMenu(Long userID) throws BusinessException;

	public List<RoleModule> findByRoleIdGetModuleName(Long roleId) throws BusinessException;

	public List<LtMastRoleModules> findAllActive() throws BusinessException;

	public List<LtMastRoleModules> findByRoleId(Long roleId) throws BusinessException;

	public List<ModuleList> getModuleListWithUserId(Long userId) throws BusinessException;

	public List<ModuleList> getModuleListWithRoleId(List<Long> roleId) throws BusinessException;
	public List<Menu> findMenuWithModuleName(Long userId ,String moduleName) throws BusinessException;

	public List<LtMastRoleModules> getByModuleId(Long parseLong) throws BusinessException;
	
	CustomeDataTable getLtMastUsersDataTable(LtMastRoleModules input);

	public Status save(LtMastRoleModules ltMastRoleModules) throws BusinessException;

	public Status update(LtMastRoleModules ltMastRoleModules) throws ServiceException;
}
