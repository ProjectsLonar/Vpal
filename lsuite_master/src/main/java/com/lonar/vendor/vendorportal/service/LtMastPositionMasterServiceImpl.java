package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastPositionMasterServiceImpl implements LtMastPositionMasterService,CodeMaster{

	@Autowired
	LtMastPositionMasterDao ltMastPositionMasterDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastPositionMaster input, Long companyId) throws ServiceException {
		return ltMastPositionMasterDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastPositionMaster> getDataTable(LtMastPositionMaster input, Long companyId) throws ServiceException {
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
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
		return ltMastPositionMasterDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastPositionMaster ltMastPositionMaster) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastPositionMaster);
		if(chkDuplicate==null) {
		ltMastPositionMaster.setCreationDate(new Date());
		ltMastPositionMaster.setLastUpdateDate(new Date());
		ltMastPositionMaster.setLastUpdatedBy(ltMastPositionMaster.getLastUpdateLogin());
		ltMastPositionMaster = ltMastPositionMasterDao.save(ltMastPositionMaster);
		if(ltMastPositionMaster.getPositionId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
		}
		}else {
			status.setCode(FAIL);
			status.setMessage(chkDuplicate);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	private String checkDuplicate(LtMastPositionMaster ltMastPositionMaster) throws ServiceException {
		List<LtMastPositionMaster> positionMaster = 
				ltMastPositionMasterDao.getByPositionName(ltMastPositionMaster.getPositionName(), ltMastPositionMaster.getCompanyId());
		if(!positionMaster.isEmpty()) {
			if(!positionMaster.get(0).getPositionId().equals(ltMastPositionMaster.getPositionId())) {
				return "Position name already exists";
			}
		}
		
		positionMaster = ltMastPositionMasterDao.getByPositionCode(ltMastPositionMaster.getPositionCode(), ltMastPositionMaster.getCompanyId());
		if(!positionMaster.isEmpty()) {
			if(!positionMaster.get(0).getPositionId().equals(ltMastPositionMaster.getPositionId())) {
				return "Position code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastPositionMaster ltMastPositionMaster) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastPositionMaster);
		if(chkDuplicate==null) {
		ltMastPositionMaster.setLastUpdateDate(new Date());
		ltMastPositionMaster.setLastUpdatedBy(ltMastPositionMaster.getLastUpdateLogin());
		ltMastPositionMaster = ltMastPositionMasterDao.update(ltMastPositionMaster);
		if(ltMastPositionMaster.getPositionId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
		}
		}else {
			status.setCode(FAIL);
			status.setMessage(chkDuplicate);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		LtMastPositionMaster ltMastPositionMaster = ltMastPositionMasterDao.delete(id);
		if(ltMastPositionMaster ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastPositionMaster findById(Long id) throws ServiceException {
		return ltMastPositionMasterDao.findById(id);
	}

	@Override
	public List<LtMastPositionMaster> getAll() throws ServiceException {
		return ltMastPositionMasterDao.getAll();
	}

	@Override
	public List<LtMastPositionMaster> getLikePositionName(String position, Long companyId) throws ServiceException {
		return ltMastPositionMasterDao.getLikePositionName(position,companyId);
	}

}
