package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastPaymentTerms;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastPaymentTermsDao 
{

	List<LtMastPaymentTerms> getAllLtMastPaymentTerms()  throws ServiceException;

	List<LtMastPaymentTerms> findAllActive(Long companyId) throws ServiceException;

	List<LtMastPaymentTerms> getAllActiveByPaytermId(Long id) throws ServiceException;

	LtMastPaymentTerms getByID(Long id) throws ServiceException;

	Long getCount(Long companyId, LtMastPaymentTerms input) throws ServiceException;

	List<LtMastPaymentTerms> getDatatableRecords(Long companyId, LtMastPaymentTerms input) throws ServiceException;

}
