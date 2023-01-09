package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastBusinessNature;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastBusinessNatureDao {

	Long getCount(LtMastBusinessNature input, Long companyId) throws ServiceException;

	List<LtMastBusinessNature> getDataTable(LtMastBusinessNature input, Long companyId) throws ServiceException;

	LtMastBusinessNature save(LtMastBusinessNature ltMastBusinessNature) throws ServiceException;
	
	LtMastBusinessNature update(LtMastBusinessNature ltMastBusinessNature) throws ServiceException;

	LtMastBusinessNature delete(Long id) throws ServiceException;

	LtMastBusinessNature findById(Long id) throws ServiceException;

	List<LtMastBusinessNature> getAll() throws ServiceException;

	List<LtMastBusinessNature> getLikeName(String name, Long companyId) throws ServiceException;

	List<LtMastBusinessNature> getByCode(String businessNatureCode, Long companyId) throws ServiceException;

	List<LtMastBusinessNature> getByName(String businessNatureName, Long companyId) throws ServiceException;

	List<LtMastBusinessNature> getAllActive(Long companyId) throws ServiceException;

	

}
