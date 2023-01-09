package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastVenorManagmentDesg;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVenorManagmentDesgService {

	Long getCount(LtMastVenorManagmentDesg input, Long companyId) throws ServiceException;

	List<LtMastVenorManagmentDesg> getDataTable(LtMastVenorManagmentDesg input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException;

	ResponseEntity<Status> update(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastVenorManagmentDesg findById(Long id) throws ServiceException;

	List<LtMastVenorManagmentDesg> getAll() throws ServiceException;

	List<LtMastVenorManagmentDesg> getLikeDesignation(String designation, Long companyId) throws ServiceException;

	List<LtMastVenorManagmentDesg> getAllActive(Long companyId) throws ServiceException;

}
