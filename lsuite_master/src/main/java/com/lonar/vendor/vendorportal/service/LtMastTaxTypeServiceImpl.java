package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastTaxTypeDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastTaxType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastTaxTypeServiceImpl implements LtMastTaxTypeService,CodeMaster{

	@Autowired
	LtMastTaxTypeDao ltMastTaxTypeDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(LtMastTaxType input, Long companyId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastTaxTypeDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastTaxType> getDataTable(LtMastTaxType input, Long companyId) throws ServiceException {
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
		return ltMastTaxTypeDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastTaxType ltMastTaxType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastTaxType);
		if(chkDuplicate==null) {
		ltMastTaxType.setCreationDate(new Date());
		ltMastTaxType.setLastUpdateDate(new Date());
		ltMastTaxType.setLastUpdatedBy(ltMastTaxType.getLastUpdateLogin());
		ltMastTaxType = ltMastTaxTypeDao.save(ltMastTaxType);
		if(ltMastTaxType.getTaxTypeId()!=null) {
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

	private String checkDuplicate(LtMastTaxType ltMastTaxType) throws ServiceException {
		List<LtMastTaxType> taxType = 
				ltMastTaxTypeDao.getByTaxTypeName(ltMastTaxType.getTaxTypeName(), ltMastTaxType.getCompanyId());
		if(!taxType.isEmpty()) {
			if(!taxType.get(0).getTaxTypeId().equals(ltMastTaxType.getTaxTypeId())) {
				return "Taxtype name already exists";
			}
		}
		
		taxType = ltMastTaxTypeDao.getByTaxTypeCode(ltMastTaxType.getTaxTypeCode(), ltMastTaxType.getCompanyId());
		if(!taxType.isEmpty()) {
			if(!taxType.get(0).getTaxTypeId().equals(ltMastTaxType.getTaxTypeId())) {
				return "Taxtype code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastTaxType ltMastTaxType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastTaxType);
		if(chkDuplicate==null) {
		ltMastTaxType.setLastUpdateDate(new Date());
		ltMastTaxType.setLastUpdatedBy(ltMastTaxType.getLastUpdateLogin());
		ltMastTaxType = ltMastTaxTypeDao.update(ltMastTaxType);
		if(ltMastTaxType.getTaxTypeId()!=null) {
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
		LtMastTaxType ltMastTaxType = ltMastTaxTypeDao.delete(id);
		if(ltMastTaxType ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastTaxType findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastTaxTypeDao.findById(id);
	}

	@Override
	public List<LtMastTaxType> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastTaxTypeDao.getAll();
	}

	@Override
	public List<LtMastTaxType> getLikeTaxName(String name, Long companyId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastTaxTypeDao.getLikeTaxName(name,companyId);
	}

}
