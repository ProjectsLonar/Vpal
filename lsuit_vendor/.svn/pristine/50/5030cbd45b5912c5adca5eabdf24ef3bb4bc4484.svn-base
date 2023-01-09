package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastComnMasterValuesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastComnMaster;
import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastComnMasterRepository;
import com.lonar.vendor.vendorportal.repository.LtMastComnMasterValuesRepository;



@Service
public class LtMastComnMasterValuesServiceImpl implements LtMastComnMasterValuesService,CodeMaster {
	@Autowired
	LtMastComnMasterValuesDao ltMastComnMasterValuesDao;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	LtMastComnMasterRepository ltMastComnMasterRepository;
	
	@Autowired
	LtMastComnMasterValuesRepository ltMastComnMasterValuesRepository;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Transactional
	@Override
	public ResponseEntity findByValueCode(String valueCode) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByValueCode(valueCode);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByValueName(String valueName) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByValueName(valueName);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findAllActive() throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findAllActive();
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByMasteridWithValuecode(Long masterId, String valueCode) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByMasteridWithValuecode(masterId, valueCode);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByMasterId(Long masterId) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByMasterId(masterId);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findLikeValueNameWithMasterId(Long masterId, String valueName)
			throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findLikeValueNameWithMasterId(masterId, valueName);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByMasteridWithValueTag(Long masterId, String valueTag) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByMasteridWithValueTag(masterId, valueTag);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByMasterNameWithValueCode(String masterName, String valueCode)
			throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByMasterNameWithValueCode(masterName, valueCode);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.getByValueCode(valueCode);
		return list;
	}

	@Transactional
	@Override
	public String checkCommonMasterValuesDetails(LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException {
		String status = null;

		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao
				.checkCommonMasterValuesDetails(ltMastComnMasterValues);
		for (LtMastComnMasterValues comnMasterValues : list) {

			if (comnMasterValues.getValueCode().equals(ltMastComnMasterValues.getValueCode())) {

				status = messageSource.getMessage("Common Master Value Code is already Exists", null,
						"Common Master Value Code is already Exists", Locale.getDefault());
			}

		}
		return status;
	}

	@Override
	public ResponseEntity findByCommanMasterName(String masterName) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.findByCommanMasterName(masterName);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<List<LtMastComnMasterValues>> getAll() throws ServiceException 
	{
		List<LtMastComnMasterValues> ltMastComnMasterValues = new ArrayList<LtMastComnMasterValues>();
		
			ltMastComnMasterValues = (List<LtMastComnMasterValues>) ltMastComnMasterValuesRepository.findAll();
			for (LtMastComnMasterValues ltMastComnMasterValues2 : ltMastComnMasterValues) {

				LtMastComnMaster ltMastComnMaster = new LtMastComnMaster();
				if (ltMastComnMasterValues2.getMasterId() != null)
					if (ltMastComnMasterRepository.exists(ltMastComnMasterValues2.getMasterId()))
						ltMastComnMaster = ltMastComnMasterRepository.findOne(ltMastComnMasterValues2.getMasterId());
				if (ltMastComnMaster != null) {
					ltMastComnMasterValues2.setMasterName(ltMastComnMaster.getMasterName());
					ltMastComnMasterValues2.setMasterDesc(ltMastComnMaster.getMasterDesc());
				}
			}
			if (ltMastComnMasterValues.isEmpty()) {
			
				return new ResponseEntity<List<LtMastComnMasterValues>>(ltMastComnMasterValues, HttpStatus.NO_CONTENT);
			}
		
		return new ResponseEntity<List<LtMastComnMasterValues>>(ltMastComnMasterValues, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<LtMastComnMasterValues>> getAllActive() throws ServiceException {
		List<LtMastComnMasterValues> ltMastComnMasterValues = new ArrayList<LtMastComnMasterValues>();
		
			ltMastComnMasterValues = (List<LtMastComnMasterValues>) ltMastComnMasterValuesDao.findAllActive();
			for (LtMastComnMasterValues ltMastComnMasterValues2 : ltMastComnMasterValues) {
				LtMastComnMaster ltMastComnMaster = new LtMastComnMaster();
				if (ltMastComnMasterValues2.getMasterId() != null)
					if (ltMastComnMasterRepository.exists(ltMastComnMasterValues2.getMasterId()))
						ltMastComnMaster = ltMastComnMasterRepository.findOne(ltMastComnMasterValues2.getMasterId());
				if (ltMastComnMaster != null) {
					ltMastComnMasterValues2.setMasterName(ltMastComnMaster.getMasterName());
					ltMastComnMasterValues2.setMasterDesc(ltMastComnMaster.getMasterDesc());
				}
			}
		 
		return new ResponseEntity<List<LtMastComnMasterValues>>(ltMastComnMasterValues, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<LtMastComnMasterValues> getLtMastComnMasterValuesByID(String id) throws ServiceException {
		LtMastComnMasterValues ltMastComnMasterValues = null;
			if (ltMastComnMasterValuesRepository.exists(Long.parseLong(id))) {
				ltMastComnMasterValues = ltMastComnMasterValuesRepository.findOne(Long.parseLong(id));
				LtMastComnMaster ltMastComnMaster = new LtMastComnMaster();
				if (ltMastComnMasterValues.getMasterId() != null)
					if (ltMastComnMasterRepository.exists(ltMastComnMasterValues.getMasterId()))
						ltMastComnMaster = ltMastComnMasterRepository.findOne(ltMastComnMasterValues.getMasterId());
				if (ltMastComnMaster != null) {
					ltMastComnMasterValues.setMasterName(ltMastComnMaster.getMasterName());
					ltMastComnMasterValues.setMasterDesc(ltMastComnMaster.getMasterDesc());
				}

			}
		
		return new ResponseEntity<LtMastComnMasterValues>(ltMastComnMasterValues, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> save(LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException
	{

		Status status = new Status();
	
			List<LtMastComnMasterValues> ltMastComnMasterValuesList =  ltMastComnMasterValuesDao
					.findByValueCode(ltMastComnMasterValues.getValueCode());

			if (!ltMastComnMasterValuesList.isEmpty() && !ltMastComnMasterValuesList
					.get(0).getComnMasterValuesId().equals(ltMastComnMasterValues.getComnMasterValuesId())) {
				status.setCode(VALUE_CODE_PRESENT);
				status.setMessage(" Value code already exists.");

				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			ltMastComnMasterValuesList =  ltMastComnMasterValuesDao
					.findByValueName(ltMastComnMasterValues.getValueName());

			if (!ltMastComnMasterValuesList.isEmpty() && !ltMastComnMasterValuesList
					.get(0).getComnMasterValuesId().equals(ltMastComnMasterValues.getComnMasterValuesId() )) {
				status.setCode(VALUE_CODE_PRESENT);
				status.setMessage("Value name already exists.");

				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			ltMastComnMasterValues.setCreationDate(new Date());
			ltMastComnMasterValues.setLastUpdateDate(new Date());
			ltMastComnMasterValues.setCreatedBy(ltMastComnMasterValues.getLastUpdateLogin());
			ltMastComnMasterValues.setLastUpdatedBy(ltMastComnMasterValues.getLastUpdateLogin());
			ltMastComnMasterValues.setLastUpdateLogin(ltMastComnMasterValues.getLastUpdateLogin());
			ltMastComnMasterValues = ltMastComnMasterValuesRepository.save(ltMastComnMasterValues);
			
			if(ltMastComnMasterValues.getComnMasterValuesId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastComnMasterValues.getComnMasterValuesId());
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	

		
	}

	@Override
	public ResponseEntity<List<LtMastComnMasterValues>> getByCommonMasterID(String id) throws ServiceException {
		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao.getByCommonMasterID(id);
		return new ResponseEntity<List<LtMastComnMasterValues>>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException {
		Status status = new Status();
		
		List<LtMastComnMasterValues> ltMastComnMasterValuesList =  ltMastComnMasterValuesDao
				.findByValueCode(ltMastComnMasterValues.getValueCode());

		
		if (!ltMastComnMasterValuesList.isEmpty() && !ltMastComnMasterValuesList
				.get(0).getComnMasterValuesId().equals(ltMastComnMasterValues.getComnMasterValuesId())) {
			status.setCode(VALUE_CODE_PRESENT);
			status.setMessage(messageSource.getMessage("valuecodepresent", null, "valuecodepresent", Locale.getDefault()));

			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltMastComnMasterValuesList =  ltMastComnMasterValuesDao
				.findByValueName(ltMastComnMasterValues.getValueName());

	
		if (!ltMastComnMasterValuesList.isEmpty() && !ltMastComnMasterValuesList
				.get(0).getComnMasterValuesId().equals(ltMastComnMasterValues.getComnMasterValuesId())) {
			status.setCode(VALUE_CODE_PRESENT);
			status.setMessage(messageSource.getMessage("valuenamepresent", null, "valuenamepresent", Locale.getDefault()));

			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		
		ltMastComnMasterValues.setLastUpdateDate(new Date());
		ltMastComnMasterValues.setLastUpdatedBy(ltMastComnMasterValues.getLastUpdateLogin());
		ltMastComnMasterValues.setLastUpdateLogin(ltMastComnMasterValues.getLastUpdateLogin());
		ltMastComnMasterValues = ltMastComnMasterValuesRepository.save(ltMastComnMasterValues);
		
		if(ltMastComnMasterValues.getComnMasterValuesId()!=null) {
		status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		if( status.getMessage()==null)
		{
			status.setCode(SUCCESS);
			status.setMessage("Error in finding message! The action is completed successfully.");
		}
		status.setData(ltMastComnMasterValues.getComnMasterValuesId());
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);


	}

}
