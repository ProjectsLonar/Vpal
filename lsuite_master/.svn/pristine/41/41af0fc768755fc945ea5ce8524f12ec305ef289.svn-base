package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastPersonTypeDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastPersonType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastPersonTypeServiceImpl implements LtMastPersonTypeService,CodeMaster{

	@Autowired
	LtMastPersonTypeDao ltMastPersonTypeDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastPersonType input, Long companyId) throws ServiceException {
		return ltMastPersonTypeDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastPersonType> getDataTable(LtMastPersonType input, Long companyId) throws ServiceException {
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
		
		return ltMastPersonTypeDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastPersonType ltMastPersonType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastPersonType);
		if(chkDuplicate==null) {
		ltMastPersonType.setCreationDate(new Date());
		ltMastPersonType.setLastUpdateDate(new Date());
		ltMastPersonType.setLastUpdatedBy(ltMastPersonType.getLastUpdateLogin());
		ltMastPersonType = ltMastPersonTypeDao.save(ltMastPersonType);
		if(ltMastPersonType.getPersonTypeId()!=null) {
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

	private String checkDuplicate(LtMastPersonType ltMastPersonType) throws ServiceException {
		List<LtMastPersonType> personType = 
				ltMastPersonTypeDao.getByPersonTypeName(ltMastPersonType.getPersonTypeName(), ltMastPersonType.getCompanyId());
		if(!personType.isEmpty()) {
			if(!personType.get(0).getPersonTypeId().equals(ltMastPersonType.getPersonTypeId())) {
				return "Person type name already exists";
			}
		}
		
		personType = ltMastPersonTypeDao.getByPersonTypeCode(ltMastPersonType.getPersonTypeCode(), ltMastPersonType.getCompanyId());
		if(!personType.isEmpty()) {
			if(!personType.get(0).getPersonTypeId().equals(ltMastPersonType.getPersonTypeId())) {
				return "Person type code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastPersonType ltMastPersonType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastPersonType);
		if(chkDuplicate==null) {
		ltMastPersonType.setLastUpdateDate(new Date());
		ltMastPersonType.setLastUpdatedBy(ltMastPersonType.getLastUpdateLogin());
		ltMastPersonType = ltMastPersonTypeDao.update(ltMastPersonType);
		if(ltMastPersonType.getPersonTypeId()!=null) {
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
		LtMastPersonType ltMastPersonType = ltMastPersonTypeDao.delete(id);
		if(ltMastPersonType ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastPersonType findById(Long id) throws ServiceException {
		return ltMastPersonTypeDao.findById(id);
	}

	@Override
	public List<LtMastPersonType> getAll() throws ServiceException {
		return ltMastPersonTypeDao.getAll();
	}

	@Override
	public List<LtMastPersonType> getLikePersonTypeName(String personType, Long companyId) throws ServiceException {
		return ltMastPersonTypeDao.getLikePersonTypeName(personType,companyId);
	}

	@Override
	public List<LtMastPersonType> getAllActive(Long companyId) throws ServiceException {
		return ltMastPersonTypeDao.getAllActive(companyId);
	}

}
