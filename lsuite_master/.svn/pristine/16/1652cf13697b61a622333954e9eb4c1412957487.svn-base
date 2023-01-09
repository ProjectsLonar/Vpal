package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastGlAccountsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastGlAccountsRepository;

@Service
public  class LtMastGlAccountsServiceImpl implements LtMastGlAccountsService,CodeMaster {
	@Autowired
	LtMastGlAccountsDao ltMastGlAccountsDao;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastGlAccountsRepository ltMastGlAccountsRepository;
	
	@Override
	public List<LtMastGlAccounts> findByAccountCode(String accountCode,Long companyId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltMastGlAccountsDao.findByAccountCode(accountCode,companyId);
	}

	@Override
	public List<LtMastGlAccounts> findByAccountName(String accountName,Long companyId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltMastGlAccountsDao.findByAccountName(accountName,companyId);
	}

	@Override
	public List<LtMastGlAccounts> findAllActive(Long companyId) throws ServiceException{
		return ltMastGlAccountsDao.findAllActive(companyId);
	}

	@Override
	public List<LtMastGlAccounts> findActiveLikeAccountName(String accountName, Long companyId) throws ServiceException{
		return ltMastGlAccountsDao.findActiveLikeAccountName(accountName,companyId);
	}

	@Override
	public List<LtMastGlAccounts> findLikeAccountName(String accountName, Long companyId) throws ServiceException{
		return ltMastGlAccountsDao.findLikeAccountName(accountName,companyId);
	}

	@Override
	public List<LtMastGlAccounts> findAll(Long companyId) throws ServiceException {
		return ltMastGlAccountsDao.findAll(companyId);
	}

	@Override
	public LtMastGlAccounts getLtMastGlAccountsByID(Long id) throws ServiceException {
		return ltMastGlAccountsDao.getLtMastGlAccountsByID(id);
	}

	@Override
	public Status save(LtMastGlAccounts ltMastGlAccounts) throws ServiceException {
		Status status = new Status();
		List<LtMastGlAccounts> ltP2pGlAccountsList = ltMastGlAccountsDao.findByAccountCode(ltMastGlAccounts.getAccountCode(),ltMastGlAccounts.getCompanyId());
		if (!ltP2pGlAccountsList.isEmpty() && (
				 !ltP2pGlAccountsList.get(0).getGlAccountId().equals(ltMastGlAccounts.getGlAccountId()))) {
			status.setMessage("Account code already exists.");

			return status;

		}
		ltP2pGlAccountsList = ltMastGlAccountsDao.findByAccountName(ltMastGlAccounts.getAccountName(),ltMastGlAccounts.getCompanyId());

		if (!ltP2pGlAccountsList.isEmpty() && (
				 !ltP2pGlAccountsList.get(0).getGlAccountId().equals(ltMastGlAccounts.getGlAccountId()))) {
			status.setCode(ACC_CODE_PRESENT);
			status.setMessage("Account name already exists.");
			return status;

		}
		ltMastGlAccounts.setLastUpdateDate(new Date());
		ltMastGlAccounts.setCreationDate(new Date());
		ltMastGlAccounts.setCreatedBy(ltMastGlAccounts.getLastUpdateLogin());
		ltMastGlAccounts.setLastUpdatedBy(ltMastGlAccounts.getLastUpdateLogin());
		ltMastGlAccounts.setLastUpdateLogin(ltMastGlAccounts.getLastUpdateLogin());
		ltMastGlAccounts = ltMastGlAccountsRepository.save(ltMastGlAccounts);
		if(ltMastGlAccounts.getGlAccountId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
			}
			return status;
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
			return status;
		}

	}

	@Override
	public Status update(LtMastGlAccounts ltMastGlAccounts) throws ServiceException {
		
		Status status = new Status();
		if(ltMastGlAccounts.getGlAccountId()!=null) {
		List<LtMastGlAccounts> ltP2pGlAccountsList = ltMastGlAccountsDao.findByAccountCode(ltMastGlAccounts.getAccountCode(),ltMastGlAccounts.getCompanyId());

		if (!ltP2pGlAccountsList.isEmpty() && (ltMastGlAccounts.getGlAccountId() == null ? true
				: !ltMastGlAccounts.getGlAccountId().equals(ltP2pGlAccountsList.get(0).getGlAccountId()))) {
			//status.setCode(ACC_CODE_PRESENT);
			status.setMessage("Account code already exists.");

			return status;

		}
		ltP2pGlAccountsList = ltMastGlAccountsDao.findByAccountName(ltMastGlAccounts.getAccountName(),ltMastGlAccounts.getCompanyId());

		if (!ltP2pGlAccountsList.isEmpty() && (ltMastGlAccounts.getGlAccountId() == null ? true
				: !ltMastGlAccounts.getGlAccountId().equals(ltP2pGlAccountsList.get(0).getGlAccountId()))) {
			status.setCode(ACC_CODE_PRESENT);
			status.setMessage("Account name already exists.");
			return status;

		}
		ltMastGlAccounts.setLastUpdateDate(new Date());
		ltMastGlAccounts.setLastUpdatedBy(ltMastGlAccounts.getLastUpdateLogin());
		ltMastGlAccounts.setLastUpdateLogin(ltMastGlAccounts.getLastUpdateLogin());
		ltMastGlAccounts = ltMastGlAccountsRepository.save(ltMastGlAccounts);
		if(ltMastGlAccounts.getGlAccountId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
			}
			return status;
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
			return status;
		}
	}else {
		status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
		if(status.getMessage()==null)
		{
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
		}
		return status;
	}
	}

	@Override
	public Long getCount(Long companyId,LtMastGlAccounts input) throws ServiceException {
		return ltMastGlAccountsDao.getCount(companyId,input);
	}

	@Override
	public List<LtMastGlAccounts> getDatatableRecords(Long companyId,LtMastGlAccounts input) throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		
		if(input.getColumnNo()==7 && input.getSort().equals("asc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("asc"))
		{
			input.setColumnNo(19);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(7);
		}
		List<LtMastGlAccounts> list=  ltMastGlAccountsDao.getDatatableRecords(companyId,input);
		
		return list;
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		ltMastGlAccountsRepository.delete(id);
		if (!ltMastGlAccountsRepository.exists(id))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} 
		else 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		} 
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
}
