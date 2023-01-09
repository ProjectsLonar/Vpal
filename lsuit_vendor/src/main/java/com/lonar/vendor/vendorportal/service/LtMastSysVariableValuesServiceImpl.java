package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastSysVariableValuesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastSysVariableValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastSysVariableValuesRepository;



@Service
public class LtMastSysVariableValuesServiceImpl implements LtMastSysVariableValuesService,CodeMaster
{

	@Autowired
	LtMastSysVariableValuesDao ltMastSysVariableValuesDao;
	
	@Autowired
	LtMastSysVariableValuesRepository ltMastSysVariableValuesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	
	@Transactional
	@Override
	public List<LtMastSysVariableValues> getByVariableId(Long parseLong) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastSysVariableValuesDao.getByVariableId(parseLong);
	}

	@Override
	public ResponseEntity<Status> saveSysVariableValues(LtMastSysVariableValues ltMastSysVariableValues)
			throws ServiceException {
		Status status = new  Status();
		ltMastSysVariableValues.setCreatedBy(ltMastSysVariableValues.getLastUpdateLogin());
		ltMastSysVariableValues.setLastUpdatedBy(ltMastSysVariableValues.getLastUpdateLogin());
		ltMastSysVariableValues.setLastUpdateLogin(ltMastSysVariableValues.getLastUpdateLogin());
		ltMastSysVariableValues.setLastUpdateDate(new Date());
		ltMastSysVariableValues = ltMastSysVariableValuesRepository.save(ltMastSysVariableValues);
		if(ltMastSysVariableValues.getVariableValuesId()!=null) {
		status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		if (status.getMessage() == null) {
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
		}
		}else {
			status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
		}
		return new ResponseEntity(status, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Status> updateSysVariableValues(LtMastSysVariableValues ltMastSysVariableValues)
			throws ServiceException {
		Status status = new  Status();
		
		ltMastSysVariableValues.setLastUpdatedBy(ltMastSysVariableValues.getLastUpdateLogin());
		ltMastSysVariableValues.setLastUpdateLogin(ltMastSysVariableValues.getLastUpdateLogin());
		ltMastSysVariableValues.setLastUpdateDate(new Date());
		ltMastSysVariableValues = ltMastSysVariableValuesRepository.save(ltMastSysVariableValues);
		if(ltMastSysVariableValues.getVariableValuesId()!=null) {
		status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		if (status.getMessage() == null) {
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
		}
		}else {
			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
		}
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<LtMastSysVariableValues>> getAllValuesBySysVariableId(Long id) throws ServiceException
	{
		List<LtMastSysVariableValues> list = ltMastSysVariableValuesDao.getByVariableId(id);
		return new ResponseEntity<List<LtMastSysVariableValues>>(list, HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<LtMastSysVariableValues> getBySysVariableValuesId(Long id) throws ServiceException {
		LtMastSysVariableValues list = ltMastSysVariableValuesDao.getBySysVariableValuesId(id);
		return new ResponseEntity<LtMastSysVariableValues>(list, HttpStatus.OK) ;
	}

}
