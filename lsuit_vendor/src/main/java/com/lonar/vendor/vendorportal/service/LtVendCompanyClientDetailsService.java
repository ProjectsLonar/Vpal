package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendCompanyClientDetailsService 
{

	List<LtVendCompanyClientDetails> getBycompanyId(Long companyId) throws ServiceException;

	LtVendCompanyClientDetails getById(Long id) throws ServiceException;

	List<LtVendCompanyClientDetails> getAllActive() throws ServiceException;

	List<LtVendCompanyClientDetails> getAll() throws ServiceException;

	ResponseEntity<Status> save(LtVendCompanyClientDetails ltVendCompanyClientDetails) throws ServiceException;

	ResponseEntity<Status> update(LtVendCompanyClientDetails ltVendCompanyClientDetails) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong) throws ServiceException;

}
