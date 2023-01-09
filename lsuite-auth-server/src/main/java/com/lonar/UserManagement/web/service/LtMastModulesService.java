package com.lonar.UserManagement.web.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;

import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastModules;
import com.lonar.UserManagement.web.model.Status;

public interface LtMastModulesService {

	public List<LtMastModules> findByModuleName(String moduleName, Long companyId) throws Exception;

	public List<LtMastModules> findByModuleUrl(String moduleUrl,Long companyId) throws Exception;

	public List<LtMastModules> findInModuleId(List<Long> ltP2pUserRolesList) throws Exception;

	public List<LtMastModules> findAllActive(Long companyId) throws Exception;

	public List<LtMastModules> findByActiveLikeModuleName(String moduleName, Long companyId) throws Exception;
	
	public List<LtMastModules> findByLikeModuleName(String moduleName) throws Exception;

	public Status save(LtMastModules ltMastModules) throws Exception;
	
	public Status update(LtMastModules ltMastModules) throws Exception;

/*	public Long getCount(LtMastModules input) throws Exception;

	public List<LtMastModules> getModuleData(LtMastModules input)  throws Exception;
	*/
	CustomeDataTable getDataTable(LtMastModules input, Long companyId) throws Exception;

	public LtMastModules getLtMastModulesByID(Long parseLong) throws Exception;

	public List<LtMastModules> getLikeModuleNameAndUser(Long userId, String moduleName) throws Exception;

	public List<LtMastModules> findAll(DataTablesInput companyId) throws Exception;
	
	
	

}
