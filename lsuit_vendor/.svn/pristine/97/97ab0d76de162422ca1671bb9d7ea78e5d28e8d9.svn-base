package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyClientDetailsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyClientDetailsRepository;

@Service
public class LtVendCompanyClientDetailsServiceImpl implements LtVendCompanyClientDetailsService,CodeMaster{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendCompanyClientDetailsDao ltVendCompanyClientDetailsDao;
	
	@Autowired
	LtVendCompanyClientDetailsRepository ltVendCompanyClientDetailsRepository;
	
	@Override
	public List<LtVendCompanyClientDetails> getBycompanyId(Long companyId) throws ServiceException {
		return ltVendCompanyClientDetailsDao.getBycompanyId( companyId);
	}

	@Override
	public LtVendCompanyClientDetails getById(Long id) throws ServiceException {
		return ltVendCompanyClientDetailsDao.getById( id);
	}

	@Override
	public List<LtVendCompanyClientDetails> getAllActive() throws ServiceException {
		return ltVendCompanyClientDetailsDao.getAllActive();
	}

	@Override
	public List<LtVendCompanyClientDetails> getAll() throws ServiceException {
		return ltVendCompanyClientDetailsDao.getAll();
	}

	@Override
	public ResponseEntity<Status> save(LtVendCompanyClientDetails ltVendCompanyClientDetails) throws ServiceException {
		Status status = new Status();
		if( ltVendCompanyClientDetails.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		
		ltVendCompanyClientDetails.setCreationDate(new Date());
		ltVendCompanyClientDetails.setLastUpdateDate(new Date());
		ltVendCompanyClientDetails.setCreatedBy(ltVendCompanyClientDetails.getLastUpdateLogin());
		ltVendCompanyClientDetails.setLastUpdateLogin(ltVendCompanyClientDetails.getLastUpdateLogin());
		ltVendCompanyClientDetails.setLastUpdatedBy(ltVendCompanyClientDetails.getLastUpdateLogin()); 
		ltVendCompanyClientDetails = ltVendCompanyClientDetailsRepository.save(ltVendCompanyClientDetails);
			if(ltVendCompanyClientDetails.getCompClientId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltVendCompanyClientDetails.getCompClientId());
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtVendCompanyClientDetails ltVendCompanyClientDetails)
			throws ServiceException {
		Status status = new Status();
		if(ltVendCompanyClientDetails.getCompClientId()!=null) {
		
			ltVendCompanyClientDetails.setLastUpdateDate(new Date());
			ltVendCompanyClientDetails.setLastUpdateLogin(ltVendCompanyClientDetails.getLastUpdateLogin());
			ltVendCompanyClientDetails.setLastUpdatedBy(ltVendCompanyClientDetails.getLastUpdateLogin()); 
			ltVendCompanyClientDetails = ltVendCompanyClientDetailsRepository.save(ltVendCompanyClientDetails);
			if(ltVendCompanyClientDetails.getCompClientId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		}else {
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
		ltVendCompanyClientDetailsRepository.delete(id);
		if (!ltVendCompanyClientDetailsRepository.exists(id))
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
