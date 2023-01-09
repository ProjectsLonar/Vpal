package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastBusinessNatureDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBusinessNature;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastBusinessNatureServiceImpl implements LtMastBusinessNatureService,CodeMaster{

	@Autowired
	LtMastBusinessNatureDao ltMastBusinessNatureDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastBusinessNature input, Long companyId) throws ServiceException {
		return ltMastBusinessNatureDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastBusinessNature> getDataTable(LtMastBusinessNature input, Long companyId) throws ServiceException {
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		
		return ltMastBusinessNatureDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastBusinessNature ltMastBusinessNature) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastBusinessNature);
		if(chkDuplicate==null) {
		ltMastBusinessNature.setCreationDate(new Date());
		ltMastBusinessNature.setLastUpdateDate(new Date());
		ltMastBusinessNature.setLastUpdatedBy(ltMastBusinessNature.getLastUpdateLogin());
		ltMastBusinessNature = ltMastBusinessNatureDao.save(ltMastBusinessNature);
		if(ltMastBusinessNature.getBusinessNatureId()!=null) {
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

	@Override
	public ResponseEntity<Status> update(LtMastBusinessNature ltMastBusinessNature) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastBusinessNature);
		if(chkDuplicate==null) {
		ltMastBusinessNature.setLastUpdateDate(new Date());
		ltMastBusinessNature.setLastUpdatedBy(ltMastBusinessNature.getLastUpdateLogin());
		ltMastBusinessNature = ltMastBusinessNatureDao.update(ltMastBusinessNature);
		if(ltMastBusinessNature.getBusinessNatureId()!=null) {
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

	private String checkDuplicate(LtMastBusinessNature ltMastBusinessNature) throws ServiceException {
		List<LtMastBusinessNature> businessNature = 
				ltMastBusinessNatureDao.getByName(ltMastBusinessNature.getBusinessNatureName(), ltMastBusinessNature.getCompanyId());
		if(!businessNature.isEmpty()) {
			if(!businessNature.get(0).getBusinessNatureId().equals(ltMastBusinessNature.getBusinessNatureId())) {
				return "Business name already exists";
			}
		}
		
		businessNature = ltMastBusinessNatureDao.getByCode(ltMastBusinessNature.getBusinessNatureCode(), ltMastBusinessNature.getCompanyId());
		if(!businessNature.isEmpty()) {
			if(!businessNature.get(0).getBusinessNatureId().equals(ltMastBusinessNature.getBusinessNatureId())) {
				return "Business code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		LtMastBusinessNature ltMastBusinessNature = ltMastBusinessNatureDao.delete(id);
		if(ltMastBusinessNature ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastBusinessNature findById(Long id) throws ServiceException {
		return ltMastBusinessNatureDao.findById(id);
	}

	@Override
	public List<LtMastBusinessNature> getAll() throws ServiceException {
		return ltMastBusinessNatureDao.getAll();
	}

	@Override
	public List<LtMastBusinessNature> getLikeName(String name, Long companyId) throws ServiceException {
		return ltMastBusinessNatureDao.getLikeName(name,companyId);
	}

	@Override
	public List<LtMastBusinessNature> getAllActive(Long companyId) throws ServiceException {
		return ltMastBusinessNatureDao.getAllActive(companyId);
	}

}
