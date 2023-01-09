package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastDepartments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastDepartmentsService {

	Long getCount(LtMastDepartments input, Long companyId) throws ServiceException;

	List<LtMastDepartments> getDataTable(LtMastDepartments input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastDepartments ltMastDepartments) throws ServiceException;

	ResponseEntity<Status> update(LtMastDepartments ltMastDepartments) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastDepartments findById(Long id) throws ServiceException;

	List<LtMastDepartments> getAll() throws ServiceException;

	List<LtMastDepartments> getLikeName(String trim, Long companyId) throws ServiceException;

}
