package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastPersonType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastPersonTypeService {

	Long getCount(LtMastPersonType input, Long companyId) throws ServiceException;

	List<LtMastPersonType> getDataTable(LtMastPersonType input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastPersonType ltMastPersonType) throws ServiceException;

	ResponseEntity<Status> update(LtMastPersonType ltMastPersonType) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastPersonType findById(Long id) throws ServiceException;

	List<LtMastPersonType> getAll() throws ServiceException;

	List<LtMastPersonType> getLikePersonTypeName(String personType, Long companyId) throws ServiceException;

	List<LtMastPersonType> getAllActive(Long companyId) throws ServiceException;



}
