package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendCompanySistConcernService
{

	List<LtVendCompanySistConcern> getBycompanyId(Long companyId) throws ServiceException;

	LtVendCompanySistConcern getById(Long id) throws ServiceException;

	List<LtVendCompanySistConcern> getAll() throws ServiceException;

	List<LtVendCompanySistConcern> getAllActive() throws ServiceException;

	ResponseEntity<Status> save(LtVendCompanySistConcern ltVendCompanySistConcern) throws ServiceException;

	ResponseEntity<Status> update(LtVendCompanySistConcern ltVendCompanySistConcern) throws ServiceException;

	ResponseEntity<Status> delete(long parseLong) throws ServiceException;

}
