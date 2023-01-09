package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtP2pProductPaytermsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtP2pProductPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtP2pProductPaytermsRepository;

@Service
public class LtP2pProductPaytermsServiceImpl implements LtP2pProductPaytermsService,CodeMaster {
	@Autowired
	LtP2pProductPaytermsDao ltP2pProductPaytermsDao;

	@Autowired
	LtP2pProductPaytermsRepository ltP2pProductPaytermsRepository ;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtP2pProductPayterms> findByProductId(Long productId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pProductPaytermsDao.findByProductId(productId);
	}

	@Override
	public List<LtP2pProductPayterms> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProductPaytermsDao.getAll();
	}

	@Override
	public List<LtP2pProductPayterms> findAllActive() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProductPaytermsDao.findAllActive();
	}

	@Override
	public LtP2pProductPayterms getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProductPaytermsDao.getById(id);
	}

	@Override
	public ResponseEntity<Status> save(LtP2pProductPayterms ltP2pProductPayterms) throws ServiceException {
		Status status = new Status();
		
		List<LtP2pProductPayterms> ltP2pProductPaytermsList=ltP2pProductPaytermsDao.findByPaytermAndProduct(ltP2pProductPayterms.getProductId(),ltP2pProductPayterms.getTermName());
		
		
		if ( !ltP2pProductPaytermsList.isEmpty()  
				&& ( !ltP2pProductPaytermsList.get(0).getPayTermId().equals(ltP2pProductPayterms.getPayTermId())) )
		{
			status.setCode(FAIL);
			status.setMessage("Payterm already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltP2pProductPayterms.setCreatedBy(ltP2pProductPayterms.getLastUpdateLogin());
		ltP2pProductPayterms.setLastUpdatedBy(ltP2pProductPayterms.getLastUpdateLogin());
		ltP2pProductPayterms.setLastUpdateLogin(ltP2pProductPayterms.getLastUpdateLogin());
		ltP2pProductPayterms.setCreationDate(new Date());
		ltP2pProductPayterms.setLastUpdateDate(new Date());
		ltP2pProductPayterms = ltP2pProductPaytermsRepository.save(ltP2pProductPayterms);
		if(ltP2pProductPayterms.getPayTermId()!=null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
	
	return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtP2pProductPayterms ltP2pProductPayterms) throws ServiceException {
		Status status = new Status();
		if(ltP2pProductPayterms.getPayTermId()!=null) {

			List<LtP2pProductPayterms> ltP2pProductPaytermsList=ltP2pProductPaytermsDao.findByPaytermAndProduct(ltP2pProductPayterms.getProductId(),ltP2pProductPayterms.getTermName());
			
		if ( !ltP2pProductPaytermsList.isEmpty()  
				&& (ltP2pProductPaytermsList.get(0).getPayTermId().equals(ltP2pProductPayterms.getPayTermId())) )
		{
			status.setCode(FAIL);
			status.setMessage("Payterm already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltP2pProductPayterms.setLastUpdatedBy(ltP2pProductPayterms.getLastUpdateLogin());
		ltP2pProductPayterms.setLastUpdateLogin(ltP2pProductPayterms.getLastUpdateLogin());
		ltP2pProductPayterms.setLastUpdateDate(new Date());
		ltP2pProductPayterms = ltP2pProductPaytermsRepository.save(ltP2pProductPayterms);
		if(ltP2pProductPayterms.getPayTermId()!=null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
	
	return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		ltP2pProductPaytermsRepository.delete(id);
		if (!ltP2pProductPaytermsRepository.exists(id))
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
