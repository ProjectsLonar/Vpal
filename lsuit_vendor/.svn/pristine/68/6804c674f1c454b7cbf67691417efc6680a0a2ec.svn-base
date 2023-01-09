package com.lonar.vendor.vendorportal.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastTaxesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastTaxesRepository;

@Service
public  class LtMastTaxesServiceImpl implements LtMastTaxesService,CodeMaster {
	@Autowired
	LtMastTaxesDao ltP2pTaxesDao;

	@Autowired
	LtMastTaxesRepository ltP2pTaxesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastTaxes> findByTaxName(String taxName) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pTaxesDao.findByTaxName(taxName);
	}

	@Override
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pTaxesDao.findByTaxCategoryId(taxCategoryId);
	}

	@Override
	public List<LtMastTaxes> findAllActive() throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pTaxesDao.findAllActive();
	}

	@Override
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pTaxesDao.findActiveLikeTaxName(taxName);
	}

	@Override
	public List<LtMastTaxes> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pTaxesDao.getAll();
	}

	@Override
	public ResponseEntity<LtMastTaxes> getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		LtMastTaxes ltP2pTaxes =  ltP2pTaxesDao.getById(id);
		return new ResponseEntity<LtMastTaxes>(ltP2pTaxes, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> save(LtMastTaxes ltP2pTaxes) throws ServiceException {
		Status status = new Status();
		
			List<LtMastTaxes> ltP2pTaxesList=ltP2pTaxesDao.findByTaxName(ltP2pTaxes.getTaxName().toLowerCase());
			
			if ( !ltP2pTaxesList.isEmpty()  && (ltP2pTaxes.getTaxId()==null?true:! ltP2pTaxes.getTaxId().equals(ltP2pTaxesList.get(0).getTaxId()))) 
			{
				status.setCode(FAIL);
				status.setMessage("Tax name already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			ltP2pTaxes.setCreatedBy(ltP2pTaxes.getLastUpdateLogin());
			ltP2pTaxes.setLastUpdatedBy(ltP2pTaxes.getLastUpdateLogin());
			ltP2pTaxes.setLastUpdateLogin(ltP2pTaxes.getLastUpdateLogin());
			ltP2pTaxes.setCreationDate(new Date());
			ltP2pTaxes.setLastUpdateDate(new Date());
			ltP2pTaxes = ltP2pTaxesRepository.save(ltP2pTaxes);
			if(ltP2pTaxes.getTaxId()!=null)
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
	public ResponseEntity<Status> update(LtMastTaxes ltP2pTaxes) throws ServiceException {
		Status status = new Status();
		if(ltP2pTaxes.getTaxId()!=null) {
		List<LtMastTaxes> ltP2pTaxesList=ltP2pTaxesDao.findByTaxName(ltP2pTaxes.getTaxName().toLowerCase());
		
		if ( !ltP2pTaxesList.isEmpty()  && (ltP2pTaxes.getTaxId()==null?true:! ltP2pTaxes.getTaxId().equals(ltP2pTaxesList.get(0).getTaxId()))) 
		{
			status.setCode(FAIL);
			status.setMessage("Tax name already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltP2pTaxes.setLastUpdatedBy(ltP2pTaxes.getLastUpdateLogin());
		ltP2pTaxes.setLastUpdateLogin(ltP2pTaxes.getLastUpdateLogin());
		ltP2pTaxes.setLastUpdateDate(new Date());
		ltP2pTaxes = ltP2pTaxesRepository.save(ltP2pTaxes);
		if(ltP2pTaxes.getTaxId()!=null)
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
		ltP2pTaxesRepository.delete(id);
		if (!ltP2pTaxesRepository.exists(id))
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

	@Override
	public Long getCount(LtMastTaxes input) throws ServiceException {
		// TODO Auto-generated method stub
				return ltP2pTaxesDao.getCount(input);
	}

	@Override
	public List<LtMastTaxes> getDatatableRecords(LtMastTaxes input) throws ServiceException {
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
			input.setColumnNo(1);
		}
		List<LtMastTaxes> list=  ltP2pTaxesDao.getDatatableRecords(input);
		
		return list;
	}

	
	
	
}
