package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastProductDivisionsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastProductDivisionsRepository;

@Service
public class LtMastProductDivisionsServiceImpl implements LtMastProductDivisionsService,CodeMaster {
	@Autowired
	LtMastProductDivisionsDao ltP2pProductDivisionsDao;

	@Autowired
	LtMastProductDivisionsRepository ltP2pProductDivisionsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastProductDivisions> findAllActive() throws  ServiceException{
		// TODO Auto-generated method stub
		return ltP2pProductDivisionsDao.findAllActive();
	}

	@Override
	public List<LtMastProductDivisions> findByDivisionId(Long divisionId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pProductDivisionsDao.findByDivisionId(divisionId);
	}

	@Override
	public List<LtMastProductDivisions> findByProductId(Long productId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pProductDivisionsDao.findByProductId(productId);
	}

	@Override
	public List<LtMastProductDivisions> findByProductIdAndDivisionId(Long productId, Long divisionId) throws ServiceException{
		// TODO Auto-generated method stub
		return ltP2pProductDivisionsDao.findByProductIdAndDivisionId(productId, divisionId);
	}

	@Override
	public List<LtMastProductDivisions> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProductDivisionsDao.getAll();
	}

	@Override
	public LtMastProductDivisions getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProductDivisionsDao.getById(id);
	}

	@Transactional
	@Override
	public ResponseEntity<Status> save(LtMastProductDivisions ltP2pProductDivisions) throws ServiceException 
	{
		Status status = new Status();
		List<LtMastProductDivisions> ltP2pProductDivisionsList=ltP2pProductDivisionsDao.findByProductId(ltP2pProductDivisions.getProductId());
		
		/*if ( !ltP2pProductDivisionsList.isEmpty() && (ltP2pProductDivisions.getProductDivisionId()==null?true:
			!ltP2pProductDivisions.getProductDivisionId().equals(ltP2pProductDivisionsList.get(0).getProductDivisionId()))) {
			status.setCode(FAIL);
			status.setMessage("Product with sme division alredy exists. ");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}*/
		if ( !ltP2pProductDivisionsList.isEmpty() && 
			!ltP2pProductDivisionsList.get(0).getProductDivisionId().equals(ltP2pProductDivisions.getProductDivisionId())) {
			status.setCode(FAIL);
			status.setMessage("Product with same division alredy exists. ");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltP2pProductDivisions.setCreationDate(new Date());
		ltP2pProductDivisions.setLastUpdateDate(new Date());
		ltP2pProductDivisions.setCreatedBy(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions.setLastUpdatedBy(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions.setLastUpdateLogin(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions = ltP2pProductDivisionsRepository.save(ltP2pProductDivisions);
		if(ltP2pProductDivisions.getProductDivisionId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}else {
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
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
			ltP2pProductDivisionsRepository.delete(id);
			if(!ltP2pProductDivisionsRepository.exists(id)) {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastProductDivisions ltP2pProductDivisions) throws ServiceException {
		Status status = new Status();
		if(ltP2pProductDivisions.getProductDivisionId()!=null) {
		List<LtMastProductDivisions> ltP2pProductDivisionsList=ltP2pProductDivisionsDao.findByProductId(ltP2pProductDivisions.getProductId());
	
		if ( ltP2pProductDivisionsList.isEmpty() &&
			!ltP2pProductDivisionsList.get(0).getProductDivisionId().equals(ltP2pProductDivisions.getProductDivisionId())) {
			status.setCode(FAIL);
			status.setMessage("productidpresent");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltP2pProductDivisions.setLastUpdateDate(new Date());
		ltP2pProductDivisions.setLastUpdatedBy(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions.setLastUpdateLogin(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions = ltP2pProductDivisionsRepository.save(ltP2pProductDivisions);
		if(ltP2pProductDivisions.getProductDivisionId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}else {
		status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
		if( status.getMessage()==null)
		{
			status.setCode(FAIL);
			status.setMessage("Error in finding message! The action is completed unsuccessfully.");
		}
	}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	

}
