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
		return ltP2pTaxesDao.findByTaxName(taxName);
	}

	@Override
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException{
		return ltP2pTaxesDao.findByTaxCategoryId(taxCategoryId);
	}

	@Override
	public List<LtMastTaxes> findAllActive(Long companyId) throws ServiceException{
		return ltP2pTaxesDao.findAllActive(companyId);
	}

	@Override
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName,Long companyId) throws ServiceException{
		return ltP2pTaxesDao.findActiveLikeTaxName(taxName,companyId);
	}

	@Override
	public List<LtMastTaxes> getAll(Long companyId) throws ServiceException {
		return ltP2pTaxesDao.getAll(companyId);
	}

	@Override
	public ResponseEntity<LtMastTaxes> getById(Long id) throws ServiceException {
		LtMastTaxes ltP2pTaxes =  ltP2pTaxesDao.getById(id);
		return new ResponseEntity<LtMastTaxes>(ltP2pTaxes, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> save(LtMastTaxes ltMastTaxes) throws ServiceException {
		Status status = new Status();
		
			List<LtMastTaxes> ltP2pTaxesList=ltP2pTaxesDao.findByTaxNameAndRate(ltMastTaxes.getTaxName(),ltMastTaxes.getTaxRate(),ltMastTaxes.getCompanyId());
			
			if ( !ltP2pTaxesList.isEmpty()  && (! ltP2pTaxesList.get(0).getTaxId().equals(ltMastTaxes.getTaxId()))) 
			{
				status.setCode(FAIL);
				status.setMessage("Tax with same rate already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			ltMastTaxes.setCreatedBy(ltMastTaxes.getLastUpdateLogin());
			ltMastTaxes.setLastUpdatedBy(ltMastTaxes.getLastUpdateLogin());
			ltMastTaxes.setLastUpdateLogin(ltMastTaxes.getLastUpdateLogin());
			ltMastTaxes.setCreationDate(new Date());
			ltMastTaxes.setLastUpdateDate(new Date());
			ltMastTaxes = ltP2pTaxesRepository.save(ltMastTaxes);
			if(ltMastTaxes.getTaxId()!=null)
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
	public ResponseEntity<Status> update(LtMastTaxes ltMastTaxes) throws ServiceException {
		Status status = new Status();
		if(ltMastTaxes.getTaxId()!=null) {
			List<LtMastTaxes> ltP2pTaxesList=ltP2pTaxesDao.findByTaxNameAndRate(ltMastTaxes.getTaxName(),ltMastTaxes.getTaxRate(),ltMastTaxes.getCompanyId());
			
			if ( !ltP2pTaxesList.isEmpty()  && (! ltP2pTaxesList.get(0).getTaxId().equals(ltMastTaxes.getTaxId()))) 
			{
				status.setCode(FAIL);
				status.setMessage("Tax with same rate exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			ltMastTaxes.setLastUpdatedBy(ltMastTaxes.getLastUpdateLogin());
			ltMastTaxes.setLastUpdateLogin(ltMastTaxes.getLastUpdateLogin());
			ltMastTaxes.setLastUpdateDate(new Date());
			ltMastTaxes = ltP2pTaxesRepository.save(ltMastTaxes);
			if(ltMastTaxes.getTaxId()!=null)
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
	public Long getCount(Long companyId,LtMastTaxes input) throws ServiceException {
				return ltP2pTaxesDao.getCount(companyId,input);
	}

	@Override
	public List<LtMastTaxes> getDatatableRecords(Long companyId,LtMastTaxes input) throws ServiceException {
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
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(8);
		}
		List<LtMastTaxes> list=  ltP2pTaxesDao.getDatatableRecords(companyId,input);
		
		return list;
	}

	
	
	
}
