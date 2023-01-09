package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastBusinessNature;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastBusinessNatureService {

	Long getCount(LtMastBusinessNature input, Long companyId) throws ServiceException;

	List<LtMastBusinessNature> getDataTable(LtMastBusinessNature input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastBusinessNature ltMastBusinessNature) throws ServiceException;

	ResponseEntity<Status> update(LtMastBusinessNature ltMastBusinessNature) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastBusinessNature findById(Long id) throws ServiceException;

	List<LtMastBusinessNature> getAll() throws ServiceException;

	List<LtMastBusinessNature> getLikeName(String trim, Long companyId) throws ServiceException;

	List<LtMastBusinessNature> getAllActive(Long companyId) throws ServiceException;

}
