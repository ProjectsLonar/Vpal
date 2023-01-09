package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastPaymentTermsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastPaymentTerms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastPaymentTermsRepository;

@Service
public class LtMastPaymentTermsServiceImpl implements LtMastPaymentTermsService, CodeMaster{

	@Autowired
	LtMastPaymentTermsDao ltMastPaymentTermsDao;
	
	@Autowired
	LtMastPaymentTermsRepository ltMastPaymentTermsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(Long companyId,LtMastPaymentTerms input) throws ServiceException {
		return ltMastPaymentTermsDao.getCount(companyId,input);
	}

	@Override
	public List<LtMastPaymentTerms> getDatatableRecords(Long companyId,LtMastPaymentTerms input) throws ServiceException {
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
		if(input.getColumnNo()==6 && input.getSort().equals("asc"))
		{
			input.setColumnNo(16);
		}
		
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(6);
		}
		List<LtMastPaymentTerms> list=  ltMastPaymentTermsDao.getDatatableRecords(companyId,input);
		
		return list;
	}

	@Override
	public List<LtMastPaymentTerms> getAllLtMastPaymentTerms() throws ServiceException {
		return ltMastPaymentTermsDao.getAllLtMastPaymentTerms();
	}

	@Override
	public List<LtMastPaymentTerms> findAllActive(Long companyId) throws ServiceException {
		return ltMastPaymentTermsDao.findAllActive(companyId);
	}

	@Override
	public List<LtMastPaymentTerms> getAllActiveByPaytermId(Long id) throws ServiceException {
		return ltMastPaymentTermsDao.getAllActiveByPaytermId(id);
	}

	@Override
	public LtMastPaymentTerms getByID(Long id) throws ServiceException {
		return ltMastPaymentTermsDao.getByID(id);
	}

	@Override
	public ResponseEntity<Status> save(LtMastPaymentTerms ltMastPaymentTerms) throws ServiceException {
		Status status = new Status();
		/*List<LtMastPaymentTerms> userLocationList = ltMastUserLocationDao.listAllActiveUserLocationByUserId(ltMastUserLocation.getUserId());
		if(!userLocationList.isEmpty())
		{
			status.setCode(FAIL);
			status.setMessage("Location for user already associated.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}*/
	
		ltMastPaymentTerms.setCreatedBy(ltMastPaymentTerms.getLastUpdateLogin());
		ltMastPaymentTerms.setLastUpdateLogin(ltMastPaymentTerms.getLastUpdateLogin());
		ltMastPaymentTerms.setLastUpdatedBy(ltMastPaymentTerms.getLastUpdateLogin()); 
		ltMastPaymentTerms.setCreationDate(new Date());
		ltMastPaymentTerms.setLastUpdateDate(new Date());
		ltMastPaymentTerms = ltMastPaymentTermsRepository.save(ltMastPaymentTerms);
		if(ltMastPaymentTerms.getPaytermId()!=null)
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
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastPaymentTerms ltMastPaymentTerms) throws ServiceException {
		Status status = new Status();
		ltMastPaymentTerms.setLastUpdateLogin(ltMastPaymentTerms.getLastUpdateLogin());
		ltMastPaymentTerms.setLastUpdatedBy(ltMastPaymentTerms.getLastUpdateLogin()); 
		ltMastPaymentTerms.setLastUpdateDate(new Date());
		ltMastPaymentTerms = ltMastPaymentTermsRepository.save(ltMastPaymentTerms);
		if(ltMastPaymentTerms.getPaytermId()!=null)
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
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		ltMastPaymentTermsRepository.delete(id);
		if(ltMastPaymentTermsRepository.exists(id)) {
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
		 return new ResponseEntity<Status>(status, HttpStatus.OK);	
	}

}
