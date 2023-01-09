package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastRoleModules;

public interface LtMastRoleModulesService {

	List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleId, Long moduleId);

}
