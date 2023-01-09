package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastRoleModules;

public interface LtMastRoleModulesDao {

	List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleId, Long moduleId);

}
