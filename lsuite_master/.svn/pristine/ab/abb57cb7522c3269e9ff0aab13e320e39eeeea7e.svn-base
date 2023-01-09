package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastProductTypeDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastProductType;
import com.lonar.vendor.vendorportal.model.LtMastUnitMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastProductTypeServiceImpl implements LtMastProductTypeService,CodeMaster{

	@Autowired
	LtMastProductTypeDao ltMastProductTypeDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	
	@Override
	public Long getCount(LtMastProductType input, Long companyId) throws ServiceException {
		return ltMastProductTypeDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastProductType> getDataTable(LtMastProductType input, Long companyId) throws ServiceException {
		return ltMastProductTypeDao.getDataTable(input,companyId);
	}

	@Override
	public ResponseEntity<Status> save(LtMastProductType ltMastProductType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastProductType);
		if(chkDuplicate==null) {
		ltMastProductType.setCreationDate(new Date());
		ltMastProductType.setLastUpdateDate(new Date());
		ltMastProductType.setLastUpdatedBy(ltMastProductType.getLastUpdateLogin());
		ltMastProductType = ltMastProductTypeDao.save(ltMastProductType);
		if(ltMastProductType.getProductTypeId()!=null) {
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
	public ResponseEntity<Status> update(LtMastProductType ltMastProductType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastProductType);
		if(chkDuplicate==null) {
		ltMastProductType.setLastUpdateDate(new Date());
		ltMastProductType.setLastUpdatedBy(ltMastProductType.getLastUpdateLogin());
		ltMastProductType = ltMastProductTypeDao.update(ltMastProductType);
		if(ltMastProductType.getProductTypeId()!=null) {
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

	private String checkDuplicate(LtMastProductType ltMastProductType) throws ServiceException {
		List<LtMastProductType> productTypeMaster = 
				ltMastProductTypeDao.getByProductTypeName(ltMastProductType.getProductTypeName(), ltMastProductType.getCompanyId());
		if(!productTypeMaster.isEmpty()) {
			if(!productTypeMaster.get(0).getProductTypeId().equals(ltMastProductType.getProductTypeId())) {
				return "Product type name already exists";
			}
		}
		
		productTypeMaster = ltMastProductTypeDao.getByProductTypeCode(ltMastProductType.getProductTypeCode(), ltMastProductType.getCompanyId());
		if(!productTypeMaster.isEmpty()) {
			if(!productTypeMaster.get(0).getProductTypeId().equals(ltMastProductType.getProductTypeId())) {
				return "Product type code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		LtMastProductType ltMastProductType = ltMastProductTypeDao.delete(id);
		if(ltMastProductType ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastProductType findById(Long id) throws ServiceException {
		return ltMastProductTypeDao.findById(id);
	}

	@Override
	public List<LtMastProductType> getAll() throws ServiceException {
		return ltMastProductTypeDao.getAll();
	}

	@Override
	public List<LtMastProductType> getLikeProductType(String name, Long companyId) throws ServiceException {
		return ltMastProductTypeDao.getLikeProductType(name,companyId);
	}

	@Override
	public List<LtMastProductType> getAllActive(Long companyId) throws ServiceException {
		return ltMastProductTypeDao.getAllActive(companyId);
	}

}
