package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastGradeTypeDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastGradeType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastGradeTypeServiceImpl implements LtMastGradeTypeService,CodeMaster{

	@Autowired
	LtMastGradeTypeDao ltMastGradeTypeDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastGradeType input, Long companyId) throws ServiceException {
		return ltMastGradeTypeDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastGradeType> getDataTable(LtMastGradeType input, Long companyId) throws ServiceException {
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
		return ltMastGradeTypeDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastGradeType ltMastGradeType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastGradeType);
		if(chkDuplicate==null) {
		ltMastGradeType.setCreationDate(new Date());
		ltMastGradeType.setLastUpdateDate(new Date());
		ltMastGradeType.setLastUpdatedBy(ltMastGradeType.getLastUpdateLogin());
		ltMastGradeType = ltMastGradeTypeDao.save(ltMastGradeType);
		if(ltMastGradeType.getGradeTypeId()!=null) {
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

	private String checkDuplicate(LtMastGradeType ltMastGradeType) throws ServiceException {
		List<LtMastGradeType> gradeType = 
				ltMastGradeTypeDao.getByGradeName(ltMastGradeType.getGradeTypeName(), ltMastGradeType.getCompanyId());
		if(!gradeType.isEmpty()) {
			if(!gradeType.get(0).getGradeTypeId().equals(ltMastGradeType.getGradeTypeId())) {
				return "Grade name already exists";
			}
		}
		
		gradeType = ltMastGradeTypeDao.getByGradeCode(ltMastGradeType.getGradeTypeCode(), ltMastGradeType.getCompanyId());
		if(!gradeType.isEmpty()) {
			if(!gradeType.get(0).getGradeTypeId().equals(ltMastGradeType.getGradeTypeId())) {
				return "Grade code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastGradeType ltMastGradeType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastGradeType);
		if(chkDuplicate==null) {
		ltMastGradeType.setLastUpdateDate(new Date());
		ltMastGradeType.setLastUpdatedBy(ltMastGradeType.getLastUpdateLogin());
		ltMastGradeType = ltMastGradeTypeDao.update(ltMastGradeType);
		if(ltMastGradeType.getGradeTypeId()!=null) {
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
		LtMastGradeType ltMastGradeType = ltMastGradeTypeDao.delete(id);
		if(ltMastGradeType ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastGradeType findById(Long id) throws ServiceException {
		return ltMastGradeTypeDao.findById(id);
	}

	@Override
	public List<LtMastGradeType> getAll() throws ServiceException {
		return ltMastGradeTypeDao.getAll();
	}

	@Override
	public List<LtMastGradeType> getLikeGradeName(String grade, Long companyId) throws ServiceException {
		return ltMastGradeTypeDao.getLikeGradeName(grade,companyId);
	}

	@Override
	public List<LtMastGradeType> getAllActive(Long companyId) throws ServiceException {
		return ltMastGradeTypeDao.getAllActive(companyId);
	}

}
