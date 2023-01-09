package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastBillingAddressesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBillingAddresses;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastBillingAddressesRepository;

@Service
public class LtMastBillingAddressesServiceImpl implements LtMastBillingAddressesService,CodeMaster
{
	@Autowired
	LtMastBillingAddressesRepository ltP2pBillingAddressesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastBillingAddressesDao ltP2pBillingAddressesDao;

	@Override
	public List<LtMastBillingAddresses> getLikeBillingAddressCode(String name) throws ServiceException 
	{
		
		return ltP2pBillingAddressesDao.getLikeBillingAddressCode(name);
	}

	@Override
	public LtMastBillingAddresses getByBillingId(Long id) throws ServiceException
	{
		
		return ltP2pBillingAddressesDao.getByBillingId(id);
	}

	@Override
	public List<LtMastBillingAddresses> getByBillingAddresses(String name) throws ServiceException
	{
		return ltP2pBillingAddressesDao.getByBillingAddresses(name);
	}

	@Override
	public List<LtMastBillingAddresses> getLikeBillingAddressByState(Long venId, String name) throws ServiceException 
	{
		
		return ltP2pBillingAddressesDao.getLikeBillingAddressByState(venId, name);
	}

	@Override
	public ResponseEntity<Status> save(LtMastBillingAddresses ltP2pBillingAddresses) throws ServiceException {
		Status status = new Status();
	
		LtMastBillingAddresses billingAddr = ltP2pBillingAddressesDao.getByBillingAddressCode(ltP2pBillingAddresses.getBillingAddressCode());
			
		if(billingAddr!=null && !(billingAddr.getBillingAddressId().equals(ltP2pBillingAddresses.getBillingAddressId())))
		{
			status.setCode(FAIL);
			status.setMessage("Billing address code already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		ltP2pBillingAddresses.setCreatedBy(ltP2pBillingAddresses.getLastUpdateLogin());
			ltP2pBillingAddresses.setLastUpdateLogin(ltP2pBillingAddresses.getLastUpdateLogin());
			ltP2pBillingAddresses.setLastUpdatedBy(ltP2pBillingAddresses.getLastUpdateLogin()); 
			ltP2pBillingAddresses.setCreationDate(new Date());
			ltP2pBillingAddresses.setLastUpdateDate(new Date());
			ltP2pBillingAddresses = ltP2pBillingAddressesRepository.save(ltP2pBillingAddresses);
			if(ltP2pBillingAddresses.getBillingAddressId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(INSERT_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action was successful");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(INSERT_FAIL);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Status> update(LtMastBillingAddresses ltP2pBillingAddresses) throws ServiceException 
	{
		Status status = new Status();
		if(ltP2pBillingAddresses.getBillingAddressId()!=null) {
			
			LtMastBillingAddresses billingAddr = ltP2pBillingAddressesDao.getByBillingAddressCode(ltP2pBillingAddresses.getBillingAddressCode());
			
			if(billingAddr!=null && !(billingAddr.getBillingAddressId().equals(ltP2pBillingAddresses.getBillingAddressId())))
			{
				status.setCode(FAIL);
				status.setMessage("Billing address code already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
		ltP2pBillingAddresses.setLastUpdateLogin(ltP2pBillingAddresses.getLastUpdateLogin());
		ltP2pBillingAddresses.setLastUpdatedBy(ltP2pBillingAddresses.getLastUpdateLogin()); 
		ltP2pBillingAddresses.setLastUpdateDate(new Date());
		ltP2pBillingAddresses = ltP2pBillingAddressesRepository.save(ltP2pBillingAddresses);
		if(ltP2pBillingAddresses.getBillingAddressId()!=null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(UPDATE_SUCCESSFULLY);
				status.setMessage("Error in finding message! The action was successful");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(UPDATE_FAIL);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
	    return new ResponseEntity<Status>(status, HttpStatus.OK);
	
	}

	@Transactional
	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
			ltP2pBillingAddressesRepository.delete(id);
			if(ltP2pBillingAddressesRepository.exists(id)) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(DELETE_FAIL);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(DELETE_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action was successful");
				}
			}
			 return new ResponseEntity<Status>(status, HttpStatus.OK);		
	}

	@Override
	public Long getCount(LtMastBillingAddresses input) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pBillingAddressesDao.getCount(input);
	}

	@Override
	public List<LtMastBillingAddresses> getDatatableRecords(LtMastBillingAddresses input) throws ServiceException {
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
		
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(7);
		}
		List<LtMastBillingAddresses> list=  ltP2pBillingAddressesDao.getDatatableRecords(input);
		
		return list;
	}

}
