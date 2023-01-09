package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastProductType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastProductTypeService {

	Long getCount(LtMastProductType input, Long companyId) throws ServiceException;

	List<LtMastProductType> getDataTable(LtMastProductType input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastProductType ltMastProductType) throws ServiceException;

	ResponseEntity<Status> update(LtMastProductType ltMastProductType) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastProductType findById(Long id) throws ServiceException;

	List<LtMastProductType> getAll() throws ServiceException;

	List<LtMastProductType> getLikeProductType(String trim, Long companyId) throws ServiceException;

	List<LtMastProductType> getAllActive(Long companyId) throws ServiceException;

}
