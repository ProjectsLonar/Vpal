package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.LtMastModules;

public interface LtMastModulesDao {
	public List<LtMastModules> findByModuleName(String moduleName, Long companyId) throws Exception;
	public List<LtMastModules> findByModuleUrl(String moduleUrl, Long companyId) throws Exception;
	public List<LtMastModules> findInModuleId(List<Long> moduleid) throws Exception;
	public List<LtMastModules> findAllActive(Long companyId) throws Exception;
	public List<LtMastModules> findByActiveLikeModuleName(String moduleName, Long companyId) throws Exception;
	public List<LtMastModules> findByLikeModuleName(String moduleName) throws Exception;
	public LtMastModules save(LtMastModules ltMastModules) throws Exception;
	public List<LtMastModules> findByModuleCode(String moduleCode, Long long1) throws Exception;
	public List<LtMastModules> findByModuleSequence(Long sequenceNumber, Long long1) throws Exception;
	public Long getCount(LtMastModules input, Long companyId);
	public List<LtMastModules> getModuleData(LtMastModules input, Long companyId);
	public LtMastModules getLtMastModulesByID(Long moduleId) throws Exception;
	public List<LtMastModules> getLikeModuleNameAndUser(Long userId, String moduleName) throws ServiceException;
}
