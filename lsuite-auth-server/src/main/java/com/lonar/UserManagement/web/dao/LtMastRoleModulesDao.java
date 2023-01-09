package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.LtMastRoleModules;
import com.lonar.UserManagement.web.model.Menu;
import com.lonar.UserManagement.web.model.ModuleList;
import com.lonar.UserManagement.web.model.RoleModule;

public interface LtMastRoleModulesDao {
	public List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleID,Long moduleID) throws BusinessException;
	public List<Long> findByRoleIdOutputModuleID(Long roleID) throws BusinessException;
	public List<LtMastRoleModules> findByUserIdANDRoleId(List<Long> roleId,List<Long> moduleId) throws BusinessException;
	public List<LtMastRoleModules> findInRoleIdAndModuleIdWithInDate(List<Long> roleId,List<Long> moduleId) throws BusinessException;
	public List findByRoleIdWithUserId() throws BusinessException;
	public List<Menu> findMenu(Long userId) throws BusinessException;
	public List<Menu> findMenuWithModuleName(Long userId,String moduleName) throws BusinessException;

	public List<LtMastRoleModules>	findAllActive() throws BusinessException;
	public List<RoleModule> findByRoleIdGetModuleName(Long roleId) throws BusinessException;
	public List<LtMastRoleModules> findByRoleId(Long roleId) throws BusinessException;
	public List<ModuleList> getModuleListWithUserId(Long userId) throws BusinessException;
	public List<ModuleList> getModuleListWithRoleId(List<Long> roleId) throws BusinessException;
	public List<LtMastRoleModules> getByModuleId(Long moduleId) throws BusinessException;
	public boolean checkForDuplicate(LtMastRoleModules ltMastRoleModules) throws BusinessException;
}
