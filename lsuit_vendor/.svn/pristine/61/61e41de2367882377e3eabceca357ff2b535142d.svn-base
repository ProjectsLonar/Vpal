package com.lonar.vendor.vendorportal.dao;


import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastGlAccountsDao {
	
	public List<LtMastGlAccounts> findByAccountCode(String accountCode) throws ServiceException;
	public List<LtMastGlAccounts> findByAccountName(String accountName) throws ServiceException;
	public List<LtMastGlAccounts>	findAllActive() throws ServiceException;
	public List<LtMastGlAccounts> findActiveLikeAccountName(String accountName) throws ServiceException;
	public List<LtMastGlAccounts> findLikeAccountName(String accountName) throws ServiceException;
	public List<LtMastGlAccounts> findAll() throws ServiceException;
	public LtMastGlAccounts getLtMastGlAccountsByID(Long id) throws ServiceException;
	public Long getCount(LtMastGlAccounts input) throws ServiceException;
	public List<LtMastGlAccounts> getDatatableRecords(LtMastGlAccounts input) throws ServiceException;
	
}
