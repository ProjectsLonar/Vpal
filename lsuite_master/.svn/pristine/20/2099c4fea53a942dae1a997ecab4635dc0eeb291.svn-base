package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastPaymentTerms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastPaymentTermsService 
{

	Long getCount(Long companyId, LtMastPaymentTerms input) throws ServiceException;

	List<LtMastPaymentTerms> getDatatableRecords(Long companyId, LtMastPaymentTerms input) throws ServiceException;

	List<LtMastPaymentTerms> getAllLtMastPaymentTerms() throws ServiceException;

	List<LtMastPaymentTerms> findAllActive(Long companyId) throws ServiceException;

	List<LtMastPaymentTerms> getAllActiveByPaytermId(Long id) throws ServiceException;

	LtMastPaymentTerms getByID(Long id) throws ServiceException;

	ResponseEntity<Status> save(LtMastPaymentTerms ltMastPaymentTerms) throws ServiceException;

	ResponseEntity<Status> update(LtMastPaymentTerms ltMastPaymentTerms) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

}
