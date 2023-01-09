package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtInvoiceAccountingDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtInvoiceAccounting;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtInvoiceAccountingRepository;

@Service
public class LtInvoiceAccountingServiceImpl implements LtInvoiceAccountingService,CodeMaster{

	@Autowired
	LtInvoiceAccountingDao ltInvoiceAccountingDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtInvoiceAccountingRepository ltInvoiceAccountingRepository;
	
	
	@Override
	public LtInvoiceAccounting getInvoiceAccountingById(Long id) throws ServiceException {
		return ltInvoiceAccountingDao.getInvoiceAccountingById(id);
	}

	@Override
	public List<LtInvoiceAccounting> getInvoiceAccountingByHeaderId(Long id) throws ServiceException {
		return ltInvoiceAccountingDao.getInvoiceAccountingByHeaderId(id);
	}

	@Override
	public List<LtInvoiceAccounting> getInvoiceAccountingByLineId(Long id) throws ServiceException {
		return ltInvoiceAccountingDao.getInvoiceAccountingByLineId(id);
	}

	@Override
	public Status save(LtInvoiceAccounting ltInvoiceAccounting) throws ServiceException {
		Status status = new Status();
		
		ltInvoiceAccounting.setCreatedBy(ltInvoiceAccounting.getLastUpdateLogin());
		ltInvoiceAccounting.setLastUpdateLogin(ltInvoiceAccounting.getLastUpdateLogin());
		ltInvoiceAccounting.setLastUpdatedBy(ltInvoiceAccounting.getLastUpdateLogin()); 
		ltInvoiceAccounting.setCreationDate(new Date());
		ltInvoiceAccounting.setLastUpdateDate(new Date());
		ltInvoiceAccounting = ltInvoiceAccountingRepository.save(ltInvoiceAccounting);
		if(ltInvoiceAccounting.getInvoiceAccountingId()!=null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
	    return status;
	}

	@Override
	public Status update(LtInvoiceAccounting ltInvoiceAccounting) throws ServiceException {
		Status status = new Status();
		if(ltInvoiceAccounting.getInvoiceAccountingId()!=null) {
			ltInvoiceAccounting.setLastUpdateLogin(ltInvoiceAccounting.getLastUpdateLogin());
			ltInvoiceAccounting.setLastUpdatedBy(ltInvoiceAccounting.getLastUpdateLogin()); 
			ltInvoiceAccounting.setLastUpdateDate(new Date());
			ltInvoiceAccounting = ltInvoiceAccountingRepository.save(ltInvoiceAccounting);
		if(ltInvoiceAccounting.getInvoiceAccountingId()!=null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
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
	    return status;
	}

	@Override
	public Status delete(Long id) {
		Status status = new Status();
		ltInvoiceAccountingRepository.delete(id);
		if(ltInvoiceAccountingRepository.exists(id)) {
		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		if(status.getMessage()==null)
		{
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
		}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was successful");
			}
		}
		 return status;	
	}

}
