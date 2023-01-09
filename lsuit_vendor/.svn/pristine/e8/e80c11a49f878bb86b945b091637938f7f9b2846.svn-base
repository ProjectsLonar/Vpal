package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastProdSubcatPaytermsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastProdSubcatPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastProdSubcatPaytermsRepository;

@Service
public class LtMastProdSubcatPaytermsServiceImpl implements LtMastProdSubcatPaytermsService,CodeMaster{

	@Autowired
	LtMastProdSubcatPaytermsDao ltP2pProdSubcatPaytermsDao;
	
	@Autowired
	LtMastProdSubcatPaytermsRepository ltP2pProdSubcatPaytermsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public ResponseEntity<Status> save(LtMastProdSubcatPayterms prodSubcatPayterms) throws ServiceException {
		
		Status status = new Status();
		if(prodSubcatPayterms.getSubCategoryId()==null || prodSubcatPayterms.getStartDate()==null 
				|| prodSubcatPayterms.getLastUpdateLogin() == null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			return new ResponseEntity<Status>(status,HttpStatus.OK);
		}
			/*if (bindingResult.hasErrors()) {
				for(ObjectError objectError : bindingResult.getAllErrors()){
					status.setCode(VALIDATION);
					if(objectError.getCode().toString().equals("notnull")) {
						status.setMessage(messageSource.getMessage(objectError.getDefaultMessage().toString(), null, "Default", Locale.getDefault()));
						return new ResponseEntity<Status>(status, HttpStatus.OK);
					}
				}
			}*/
			
			prodSubcatPayterms.setCreatedBy(prodSubcatPayterms.getLastUpdateLogin());
			prodSubcatPayterms.setLastUpdatedBy(prodSubcatPayterms.getLastUpdateLogin());
			prodSubcatPayterms.setLastUpdateLogin(prodSubcatPayterms.getLastUpdateLogin());
			prodSubcatPayterms.setLastUpdateDate(new Date());
			prodSubcatPayterms.setCreationDate(new Date());
			prodSubcatPayterms = ltP2pProdSubcatPaytermsRepository.save(prodSubcatPayterms);
			if(prodSubcatPayterms.getPayTermId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
			}else {
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					return new ResponseEntity<Status>(status,HttpStatus.OK);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastProdSubcatPayterms prodSubcatPayterms) throws ServiceException {
		Status status = new Status();
		if(prodSubcatPayterms.getSubCategoryId()==null || prodSubcatPayterms.getStartDate()==null 
				|| prodSubcatPayterms.getLastUpdateLogin() == null || prodSubcatPayterms.getPayTermId() == null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			return new ResponseEntity<Status>(status,HttpStatus.OK);
		}
			/*if (bindingResult.hasErrors()) {
				for(ObjectError objectError : bindingResult.getAllErrors()){
					status.setCode(VALIDATION);
					if(objectError.getCode().toString().equals("notnull")) {
						status.setMessage(messageSource.getMessage(objectError.getDefaultMessage().toString(), null, "Default", Locale.getDefault()));
						return new ResponseEntity<Status>(status, HttpStatus.OK);
					}
				}
			}*/
			
			prodSubcatPayterms.setLastUpdatedBy(prodSubcatPayterms.getLastUpdateLogin());
			prodSubcatPayterms.setLastUpdateDate(new Date());
			
			prodSubcatPayterms = ltP2pProdSubcatPaytermsRepository.save(prodSubcatPayterms);
			if(prodSubcatPayterms.getPayTermId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
			}else {
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					return new ResponseEntity<Status>(status,HttpStatus.OK);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public List<LtMastProdSubcatPayterms> getAll() throws ServiceException {
		return ltP2pProdSubcatPaytermsDao.getAll();
	}

	@Override
	public List<LtMastProdSubcatPayterms> getAllActive() throws ServiceException {
		return ltP2pProdSubcatPaytermsDao.getAllActive();
	}

	@Override
	public LtMastProdSubcatPayterms getById(Long id) throws ServiceException {
		return ltP2pProdSubcatPaytermsDao.getById(id);
	}

	@Override
	public List<LtMastProdSubcatPayterms> getAllBySubCatId(Long id) throws ServiceException {
		return ltP2pProdSubcatPaytermsDao.getAllBySubCatId(id);
	}

	@Override
	public List<LtMastProdSubcatPayterms> getLikeTermCat(String category) throws ServiceException {
		return ltP2pProdSubcatPaytermsDao.getLikeTermCat(category);
	}

	@Override
	public List<LtMastProdSubcatPayterms> getLikeTermName(String name) throws ServiceException {
		return ltP2pProdSubcatPaytermsDao.getLikeTermName(name);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		 ltP2pProdSubcatPaytermsRepository.delete(id);
		if(!ltP2pProdSubcatPaytermsRepository.exists(id)) {
		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
		}else {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

}
