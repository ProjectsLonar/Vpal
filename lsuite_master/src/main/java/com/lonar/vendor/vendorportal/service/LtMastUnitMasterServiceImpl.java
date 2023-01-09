package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastUnitMasterDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.LtMastUnitMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastUnitMasterServiceImpl implements LtMastUnitMasterService,CodeMaster{

	@Autowired
	LtMastUnitMasterDao ltMastUnitMasterDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastUnitMaster input, Long companyId) throws ServiceException {
		return ltMastUnitMasterDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastUnitMaster> getDataTable(LtMastUnitMaster input, Long companyId) throws ServiceException {
		return ltMastUnitMasterDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastUnitMaster ltMastUnitMaster) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastUnitMaster);
		if(chkDuplicate==null) {
		ltMastUnitMaster.setCreationDate(new Date());
		ltMastUnitMaster.setLastUpdateDate(new Date());
		ltMastUnitMaster.setLastUpdatedBy(ltMastUnitMaster.getLastUpdateLogin());
		ltMastUnitMaster = ltMastUnitMasterDao.save(ltMastUnitMaster);
		if(ltMastUnitMaster.getUnitId()!=null) {
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
	public ResponseEntity<Status> update(LtMastUnitMaster ltMastUnitMaster) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastUnitMaster);
		if(chkDuplicate==null) {
		ltMastUnitMaster.setLastUpdateDate(new Date());
		ltMastUnitMaster.setLastUpdatedBy(ltMastUnitMaster.getLastUpdateLogin());
		ltMastUnitMaster = ltMastUnitMasterDao.update(ltMastUnitMaster);
		if(ltMastUnitMaster.getUnitId()!=null) {
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

	private String checkDuplicate(LtMastUnitMaster ltMastUnitMaster) throws ServiceException {
		List<LtMastUnitMaster> unitMaster = 
				ltMastUnitMasterDao.getByUnitName(ltMastUnitMaster.getUnitName(), ltMastUnitMaster.getCompanyId());
		if(!unitMaster.isEmpty()) {
			if(!unitMaster.get(0).getUnitId().equals(ltMastUnitMaster.getUnitId())) {
				return "Unit name already exists";
			}
		}
		
		unitMaster = ltMastUnitMasterDao.getByUnitCode(ltMastUnitMaster.getUnitCode(), ltMastUnitMaster.getCompanyId());
		if(!unitMaster.isEmpty()) {
			if(!unitMaster.get(0).getUnitId().equals(ltMastUnitMaster.getUnitId())) {
				return "Unit code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		LtMastPositionMaster ltMastPositionMaster = ltMastUnitMasterDao.delete(id);
		if(ltMastPositionMaster ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastUnitMaster findById(Long id) throws ServiceException {
		return ltMastUnitMasterDao.findById(id);
	}

	@Override
	public List<LtMastUnitMaster> getAll() throws ServiceException {
		return ltMastUnitMasterDao.getAll();
	}

	@Override
	public List<LtMastUnitMaster> getLikeUnitName(String unit, Long companyId) throws ServiceException {
		return ltMastUnitMasterDao.getLikeUnitName(unit,companyId);
	}

	@Override
	public List<LtMastUnitMaster> getAllActive(Long companyId) throws ServiceException {
		return ltMastUnitMasterDao.getAllActive(companyId);
	}

}
