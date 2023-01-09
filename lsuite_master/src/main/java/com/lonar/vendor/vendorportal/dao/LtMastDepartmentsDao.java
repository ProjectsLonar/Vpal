package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastDepartments;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastDepartmentsDao {

	Long getCount(LtMastDepartments input, Long companyId) throws ServiceException;

	List<LtMastDepartments> getDataTable(LtMastDepartments input, Long companyId) throws ServiceException;

	LtMastDepartments save(LtMastDepartments ltMastDepartments) throws ServiceException;

	LtMastDepartments update(LtMastDepartments ltMastDepartments) throws ServiceException;

	LtMastDepartments delete(Long id) throws ServiceException;

	LtMastDepartments findById(Long id) throws ServiceException;

	List<LtMastDepartments> getAll() throws ServiceException;

	List<LtMastDepartments> getLikeName(String name, Long companyId) throws ServiceException;

	List<LtMastDepartments> getByCode(String departmentCode, Long companyId) throws ServiceException;

	List<LtMastDepartments> getByName(String departmentName, Long companyId) throws ServiceException;


}
