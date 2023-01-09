package com.lonar.vendor.vendorportal.dao;


import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtMastGlAccountsDao {
	
	public List<LtMastGlAccounts> findByAccountCode(String accountCode, Long companyId) throws ServiceException;
	public List<LtMastGlAccounts> findByAccountName(String accountName, Long companyId) throws ServiceException;
	public List<LtMastGlAccounts>	findAllActive(Long companyId) throws ServiceException;
	public List<LtMastGlAccounts> findActiveLikeAccountName(String accountName, Long companyId) throws ServiceException;
	public List<LtMastGlAccounts> findLikeAccountName(String accountName, Long companyId) throws ServiceException;
	public List<LtMastGlAccounts> findAll(Long companyId) throws ServiceException;
	public LtMastGlAccounts getLtMastGlAccountsByID(Long id) throws ServiceException;
	public Long getCount(Long companyId, LtMastGlAccounts input) throws ServiceException;
	public List<LtMastGlAccounts> getDatatableRecords(Long companyId, LtMastGlAccounts input) throws ServiceException;
	public List<LtMastGlAccounts> getDataForReport(ReportParameters reportParameters) throws ServiceException;
	
}
