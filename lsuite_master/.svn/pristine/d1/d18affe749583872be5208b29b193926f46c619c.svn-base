package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastGlAccountsService {

	public List<LtMastGlAccounts> findByAccountCode(String accountCode,Long companyId) throws ServiceException;

	public List<LtMastGlAccounts> findByAccountName(String accountName,Long companyId) throws ServiceException;

	public List<LtMastGlAccounts> findAllActive(Long companyId) throws ServiceException;

	public List<LtMastGlAccounts> findActiveLikeAccountName(String accountName, Long companyId) throws ServiceException;

	public List<LtMastGlAccounts> findLikeAccountName(String accountName, Long companyId) throws ServiceException;

	public List<LtMastGlAccounts> findAll(Long companyId) throws ServiceException;

	public LtMastGlAccounts getLtMastGlAccountsByID(Long id) throws ServiceException;

	public Status save(LtMastGlAccounts ltMastGlAccounts) throws ServiceException;

	public Status update(LtMastGlAccounts ltMastGlAccounts) throws ServiceException;

	public Long getCount(Long companyId, LtMastGlAccounts input) throws ServiceException;

	public List<LtMastGlAccounts> getDatatableRecords(Long companyId, LtMastGlAccounts input) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;

}
