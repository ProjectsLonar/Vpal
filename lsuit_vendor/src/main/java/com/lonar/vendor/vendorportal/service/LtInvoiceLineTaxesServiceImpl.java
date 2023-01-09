package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtInvoiceLineTaxesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtInvoiceLineTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtInvoiceLineTaxesRepository;

@Service
public class LtInvoiceLineTaxesServiceImpl implements LtInvoiceLineTaxesService,CodeMaster{

	@Autowired
	LtInvoiceLineTaxesDao  ltInvoiceLineTaxesDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtInvoiceLineTaxesRepository ltInvoiceLineTaxesRepository;
	
	@Override
	public LtInvoiceLineTaxes getInvoiceLineTaxesById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltInvoiceLineTaxesDao.getInvoiceLineTaxesById(id);
	}

	@Override
	public List<LtInvoiceLineTaxes> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltInvoiceLineTaxesDao.getAllInvoiceLinesByHeaderId(id);
	}

	@Override
	public List<LtInvoiceLineTaxes> getAllInvoiceLinesByLineId(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltInvoiceLineTaxesDao.getAllInvoiceLinesByLineId(id);
	}

	@Override
	public Status save(List<LtInvoiceLineTaxes> ltInvoiceLineTaxesList) throws ServiceException {
		Status status = new Status();
		
		for(LtInvoiceLineTaxes ltInvoiceLineTaxes :ltInvoiceLineTaxesList) 
		{
		ltInvoiceLineTaxes.setCreatedBy(ltInvoiceLineTaxes.getLastUpdateLogin());
		ltInvoiceLineTaxes.setLastUpdateLogin(ltInvoiceLineTaxes.getLastUpdateLogin());
		ltInvoiceLineTaxes.setLastUpdatedBy(ltInvoiceLineTaxes.getLastUpdateLogin()); 
		ltInvoiceLineTaxes.setCreationDate(new Date());
		ltInvoiceLineTaxes.setLastUpdateDate(new Date());
		ltInvoiceLineTaxes = ltInvoiceLineTaxesRepository.save(ltInvoiceLineTaxes);
		if(ltInvoiceLineTaxes.getInvoiceLineTaxId()!=null)
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
			ltInvoiceLineTaxesDao.deleteTax(ltInvoiceLineTaxes.getInvoiceLineId());
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
			return status;
		}
		}
	    return status;
	}

	@Override
	public Status update(LtInvoiceLineTaxes ltInvoiceLineTaxes) throws ServiceException {
		Status status = new Status();
		if(ltInvoiceLineTaxes.getInvoiceLineTaxId()!=null) {
			ltInvoiceLineTaxes.setLastUpdateLogin(ltInvoiceLineTaxes.getLastUpdateLogin());
			ltInvoiceLineTaxes.setLastUpdatedBy(ltInvoiceLineTaxes.getLastUpdateLogin()); 
			ltInvoiceLineTaxes.setLastUpdateDate(new Date());
			ltInvoiceLineTaxes = ltInvoiceLineTaxesRepository.save(ltInvoiceLineTaxes);
		if(ltInvoiceLineTaxes.getInvoiceLineTaxId()!=null)
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
		ltInvoiceLineTaxesRepository.delete(id);
		if(ltInvoiceLineTaxesRepository.exists(id)) {
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
