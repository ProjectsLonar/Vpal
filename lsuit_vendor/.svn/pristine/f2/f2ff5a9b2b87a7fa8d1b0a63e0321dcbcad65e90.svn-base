package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastRoleModulesDao;
import com.lonar.vendor.vendorportal.model.LtMastRoleModules;

@Service
public class LtMastRoleModulesServiceImpl implements LtMastRoleModulesService{

	@Autowired
	LtMastRoleModulesDao ltMastRoleModulesDao;
	
	@Override
	public List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleId, Long moduleId) {
		// TODO Auto-generated method stub
		return ltMastRoleModulesDao.findByRoleIdANDModuleId(roleId,moduleId);
	}

}
