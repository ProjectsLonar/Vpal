package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lonar.vendor.vendorportal.dao.LtMastAttachmentTypeDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastAttachmentType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastAttachmentTypeServiceImpl implements LtMastAttachmentTypeService,CodeMaster{

	@Autowired
	LtMastAttachmentTypeDao ltMastAttachmentTypeDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public Long getCount(Long companyId, LtMastAttachmentType input) throws ServiceException {
		return ltMastAttachmentTypeDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastAttachmentType> getDataTableRecords(Long companyId, LtMastAttachmentType input)
			throws ServiceException {
		return ltMastAttachmentTypeDao.getDataTable(input,companyId);
	}

	@Override
	public List<LtMastAttachmentType> findAll(Long companyId) throws ServiceException {
		return ltMastAttachmentTypeDao.findAll(companyId);
	}

	@Override
	public List<LtMastAttachmentType> findAllActive(Long companyId) throws ServiceException {
		return ltMastAttachmentTypeDao.findAllActive(companyId);
	}

	@Override
	public LtMastAttachmentType getLtMastAttachmentTypeByID(Long id) throws ServiceException {
		return ltMastAttachmentTypeDao.getLtMastAttachmentTypeByID(id);
	}

	@Override
	public List<LtMastAttachmentType> getLtMastAttachmentTypeByCompID(Long id) throws ServiceException {
		return ltMastAttachmentTypeDao.getLtMastAttachmentTypeByCompID(id);
	}

	@Override
	public List<LtMastAttachmentType> findActiveLikeName(String name, Long companyId) throws ServiceException {
		return ltMastAttachmentTypeDao.findActiveLikeName(name,companyId);
	}

	@Override
	public List<LtMastAttachmentType> listAllActiveByModule(String module, Long companyId) throws ServiceException {
		return ltMastAttachmentTypeDao.listAllActiveByModule(module,companyId);
	}

	
	@Override
	public ResponseEntity<Status> save(LtMastAttachmentType ltMastAttachmentType, BindingResult bindingResult)
			throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastAttachmentType);
		if(chkDuplicate==null) {
		
			ltMastAttachmentType.setCreationDate(new Date());
			ltMastAttachmentType.setLastUpdateDate(new Date());
			ltMastAttachmentType.setLastUpdatedBy(ltMastAttachmentType.getLastUpdateLogin());
			ltMastAttachmentType = ltMastAttachmentTypeDao.save(ltMastAttachmentType);
			if(ltMastAttachmentType.getAttachmentTypeId()!=null) {
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

	private String checkDuplicate(LtMastAttachmentType ltMastAttachmentType) throws ServiceException {
		List<LtMastAttachmentType> attachmentType = 
				ltMastAttachmentTypeDao.getByName(ltMastAttachmentType.getAttachmentName(),ltMastAttachmentType.getModuleCode(),
						ltMastAttachmentType.getCompanyId());
		if(!attachmentType.isEmpty()) {
			if(!attachmentType.get(0).getAttachmentTypeId().equals(ltMastAttachmentType.getAttachmentTypeId())) {
				return "Attachment already exists for the module";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastAttachmentType ltMastAttachmentType) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastAttachmentType);
		if(chkDuplicate==null) {
		
			ltMastAttachmentType.setLastUpdateDate(new Date());
			ltMastAttachmentType.setLastUpdatedBy(ltMastAttachmentType.getLastUpdateLogin());
			ltMastAttachmentType = ltMastAttachmentTypeDao.update(ltMastAttachmentType);
			if(ltMastAttachmentType.getAttachmentTypeId()!=null) {
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
		LtMastAttachmentType ltMastAttachmentType = ltMastAttachmentTypeDao.delete(id);
		if(ltMastAttachmentType ==null) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	
}
