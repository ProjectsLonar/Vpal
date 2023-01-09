package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastModules;

public interface LtMastModulesService {

	List<LtMastModules> findByModuleName(String string);

}
