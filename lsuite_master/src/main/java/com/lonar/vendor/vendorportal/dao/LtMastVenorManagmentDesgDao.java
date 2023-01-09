package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVenorManagmentDesg;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVenorManagmentDesgDao {

	Long getCount(LtMastVenorManagmentDesg input, Long companyId) throws ServiceException;

	List<LtMastVenorManagmentDesg> getDataTable(LtMastVenorManagmentDesg input, Long companyId) throws ServiceException;

	LtMastVenorManagmentDesg save(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException;

	LtMastVenorManagmentDesg update(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException;

	LtMastVenorManagmentDesg delete(Long id) throws ServiceException;

	LtMastVenorManagmentDesg findById(Long id) throws ServiceException;

	List<LtMastVenorManagmentDesg> getAll() throws ServiceException;

	List<LtMastVenorManagmentDesg> getLikeDesignation(String designation, Long companyId) throws ServiceException;

	List<LtMastVenorManagmentDesg> getLikeDesgCode(String venManDesgCode, Long companyId) throws ServiceException;

	List<LtMastVenorManagmentDesg> getByDesignationName(String venManDesgName, Long companyId)  throws ServiceException;

	List<LtMastVenorManagmentDesg> getAllActive(Long companyId) throws ServiceException;

}
