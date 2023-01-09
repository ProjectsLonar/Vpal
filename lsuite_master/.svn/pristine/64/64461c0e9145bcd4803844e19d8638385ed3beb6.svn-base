package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastVenorManagmentDesgDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVenorManagmentDesg;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVenorManagmentDesgServiceImpl implements LtMastVenorManagmentDesgService,CodeMaster{

	@Autowired
	LtMastVenorManagmentDesgDao ltMastVenorManagmentDesgDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastVenorManagmentDesg input, Long companyId) throws ServiceException {
		return ltMastVenorManagmentDesgDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastVenorManagmentDesg> getDataTable(LtMastVenorManagmentDesg input, Long companyId)
			throws ServiceException {
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
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{ input.setColumnNo(18); }
		if(input.getColumnNo()==0) {
			input.setColumnNo(8);
		}
		return ltMastVenorManagmentDesgDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastVenorManagmentDesg);
		if(chkDuplicate==null) {
		ltMastVenorManagmentDesg.setCreationDate(new Date());
		ltMastVenorManagmentDesg.setLastUpdateDate(new Date());
		ltMastVenorManagmentDesg.setLastUpdatedBy(ltMastVenorManagmentDesg.getLastUpdateLogin());
		ltMastVenorManagmentDesg = ltMastVenorManagmentDesgDao.save(ltMastVenorManagmentDesg);
		if(ltMastVenorManagmentDesg.getVenManDesgId()!=null) {
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

	private String checkDuplicate(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException {
		List<LtMastVenorManagmentDesg> venorManagmentDesg = 
				ltMastVenorManagmentDesgDao.getByDesignationName(ltMastVenorManagmentDesg.getVenManDesgName(), ltMastVenorManagmentDesg.getCompanyId());
		if(!venorManagmentDesg.isEmpty()) {
			if(!venorManagmentDesg.get(0).getVenManDesgId().equals(ltMastVenorManagmentDesg.getVenManDesgId())) {
				return "Designation name already exists";
			}
		}
		
		venorManagmentDesg = ltMastVenorManagmentDesgDao.getLikeDesgCode(ltMastVenorManagmentDesg.getVenManDesgCode(), ltMastVenorManagmentDesg.getCompanyId());
		if(!venorManagmentDesg.isEmpty()) {
			if(!venorManagmentDesg.get(0).getVenManDesgId().equals(ltMastVenorManagmentDesg.getVenManDesgId())) {
				return "Designation code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastVenorManagmentDesg);
		if(chkDuplicate==null) {
		ltMastVenorManagmentDesg.setLastUpdateDate(new Date());
		ltMastVenorManagmentDesg.setLastUpdatedBy(ltMastVenorManagmentDesg.getLastUpdateLogin());
		ltMastVenorManagmentDesg = ltMastVenorManagmentDesgDao.update(ltMastVenorManagmentDesg);
		if(ltMastVenorManagmentDesg.getVenManDesgId()!=null) {
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
		LtMastVenorManagmentDesg ltMastVenorManagmentDesg = ltMastVenorManagmentDesgDao.delete(id);
		if(ltMastVenorManagmentDesg ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastVenorManagmentDesg findById(Long id) throws ServiceException {
		return ltMastVenorManagmentDesgDao.findById(id);
	}

	@Override
	public List<LtMastVenorManagmentDesg> getAll() throws ServiceException {
		return ltMastVenorManagmentDesgDao.getAll();
	}

	@Override
	public List<LtMastVenorManagmentDesg> getLikeDesignation(String designation, Long companyId)
			throws ServiceException {
		return ltMastVenorManagmentDesgDao.getLikeDesignation(designation,companyId);
	}

	@Override
	public List<LtMastVenorManagmentDesg> getAllActive(Long companyId) throws ServiceException {
		return ltMastVenorManagmentDesgDao.getAllActive(companyId);
	}

}
