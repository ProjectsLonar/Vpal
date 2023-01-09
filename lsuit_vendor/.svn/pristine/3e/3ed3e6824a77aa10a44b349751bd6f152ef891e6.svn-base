package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastGlAccountsService {

	public List<LtMastGlAccounts> findByAccountCode(String accountCode) throws ServiceException;

	public List<LtMastGlAccounts> findByAccountName(String accountName) throws ServiceException;

	public List<LtMastGlAccounts> findAllActive() throws ServiceException;

	public List<LtMastGlAccounts> findActiveLikeAccountName(String accountName) throws ServiceException;

	public List<LtMastGlAccounts> findLikeAccountName(String accountName) throws ServiceException;

	public List<LtMastGlAccounts> findAll() throws ServiceException;

	public LtMastGlAccounts getLtMastGlAccountsByID(Long id) throws ServiceException;

	public Status save(LtMastGlAccounts ltMastGlAccounts) throws ServiceException;

	public Status update(LtMastGlAccounts ltMastGlAccounts) throws ServiceException;

	public Long getCount(LtMastGlAccounts input) throws ServiceException;

	public List<LtMastGlAccounts> getDatatableRecords(LtMastGlAccounts input) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;

}
