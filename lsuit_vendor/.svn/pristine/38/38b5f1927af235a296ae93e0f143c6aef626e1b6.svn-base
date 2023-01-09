package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendCompanyMiscellaneousService {

	LtVendCompanyMiscellaneous getBycompanyId(Long companyId) throws ServiceException;

	List<LtVendCompanyMiscellaneous> getAll() throws ServiceException;

	List<LtVendCompanyMiscellaneous> getAllActive() throws ServiceException;

	ResponseEntity<Status> save(LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous) throws ServiceException;

	ResponseEntity<Status> update(LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong) throws ServiceException;

	LtVendCompanyMiscellaneous getById(Long id) throws ServiceException;

}
