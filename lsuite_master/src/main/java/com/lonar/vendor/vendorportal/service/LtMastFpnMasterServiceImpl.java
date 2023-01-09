package com.lonar.vendor.vendorportal.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastFpnMasterDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.LtMastFpnMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastFpnMasterRepository;

@Service
public class LtMastFpnMasterServiceImpl implements LtMastFpnMasterService,CodeMaster {
	@Autowired
	LtMastFpnMasterDao ltP2pFpnMasterDao;

	@Autowired
	LtMastFpnMasterRepository ltP2pFpnMasterRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastFpnMaster> findByFpnNumber(String fpnNumber) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pFpnMasterDao.findByFpnNumber(fpnNumber);
	}

	@Override
	public List<LtMastFpnMaster> findByFpnValue(Long fpnValue) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pFpnMasterDao.findByFpnValue(fpnValue);
	}

	@Override
	public List<LtMastFpnMaster> getLikeFpnNumber(String fpnNumber) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pFpnMasterDao.getLikeFpnNumber(fpnNumber);
	}

	@Override
	public LtMastFpnMaster getFpnNumberById(String fpnId)
			throws ServiceException {
		return ltP2pFpnMasterDao.getFpnNumberById(fpnId);
	}

	@Override
	public BigDecimal getFpnUtilizedAmt(String poHeaderId, String fpnNumber) throws ServiceException{
		return ltP2pFpnMasterDao.getFpnUtilizedAmt(poHeaderId, fpnNumber);
	}

	public boolean revertFpnUtilizedAmt(Long fpnId, Double amount) throws ServiceException{
		return ltP2pFpnMasterDao.revertFpnUtilizedAmt(fpnId, amount);
	}

	@Override
	public ResponseEntity<List<LtMastFpnMaster>> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LtMastFpnMaster> getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Status> save(LtMastFpnMaster ltP2pFpnMaster) throws ServiceException {
		Status status = new Status();
		String notnull=status.getMessage()==null?"":status.getMessage();
	
			List<LtMastFpnMaster> p2pFpnMasters = ltP2pFpnMasterDao.findByFpnNumber(ltP2pFpnMaster.getFpnNumber());
			
			if(p2pFpnMasters.size() > 0 && ltP2pFpnMaster.getFpnId() == null ) {
				status.setMessage("FPN Number alraedy exist.");
				status.setCode(FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltP2pFpnMaster = ltP2pFpnMasterRepository.save(ltP2pFpnMaster);
			if(ltP2pFpnMaster.getFpnId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
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
	public ResponseEntity<Status> update(LtMastFpnMaster ltP2pFpnMaster) throws ServiceException {
		Status status = new Status();
		String notnull=status.getMessage()==null?"":status.getMessage();
		if( ltP2pFpnMaster.getFpnId()!=null) {
			List<LtMastFpnMaster> p2pFpnMasters = ltP2pFpnMasterDao.findByFpnNumber(ltP2pFpnMaster.getFpnNumber());
			
			if(p2pFpnMasters.size() > 0 && ltP2pFpnMaster.getFpnId() == null ) {
				status.setMessage("FPN Number alraedy exist.");
				status.setCode(FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltP2pFpnMaster = ltP2pFpnMasterRepository.save(ltP2pFpnMaster);
			if(ltP2pFpnMaster.getFpnId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
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

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException 
	{
		Status status = new Status();
		ltP2pFpnMasterRepository.delete(id);
		if (!ltP2pFpnMasterRepository.exists(id))
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
	public Long getCount(LtMastFpnMaster input) throws ServiceException 
	{
		// TODO Auto-generated method stub
		return ltP2pFpnMasterDao.getCount(input);
	}

	@Override
	public List<LtMastFpnMaster> getDatatableRecords(LtMastFpnMaster input) throws ServiceException {
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
		List<LtMastFpnMaster> list=  ltP2pFpnMasterDao.getDatatableRecords(input);
		
		return list;
	}
	
	

}
