package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastModules;

public interface LtMastModulesDao {

	List<LtMastModules> findByModuleName(String string);

}
