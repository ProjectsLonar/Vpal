package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastModulesDao;
import com.lonar.vendor.vendorportal.model.LtMastModules;

@Service
public class LtMastModulesServiceImpl implements LtMastModulesService {

	@Autowired
	LtMastModulesDao ltMastModulesDao;
	
	@Override
	public List<LtMastModules> findByModuleName(String string) {
		// TODO Auto-generated method stub
		return ltMastModulesDao.findByModuleName(string);
	}

}
