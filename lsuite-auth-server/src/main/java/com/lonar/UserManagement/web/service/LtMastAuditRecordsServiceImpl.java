package com.lonar.UserManagement.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.dao.LtMastAuditRecordsDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.LtModuleApprovals;
import com.lonar.UserManagement.web.model.Status;

@Service
public class LtMastAuditRecordsServiceImpl implements LtMastAuditRecordsService,CodeMaster{

	@Autowired
	LtMastAuditRecordsDao ltMastAuditRecordsDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	@Transactional
	public ResponseEntity<Status> update(List<LtMastAuditRecords> ltMastAuditRecordsList) throws ServiceException {
		Status status = new Status();
		for(LtMastAuditRecords ltMastAuditRecords : ltMastAuditRecordsList) {
			if(ltMastAuditRecordsDao.update(ltMastAuditRecords.getAuditRecordId(),ltMastAuditRecords.getReason())) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action was successful");
				}
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		}
		 return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public List<LtMastAuditRecords> getByAuditId(float auditId) throws ServiceException {
		return ltMastAuditRecordsDao.getByAuditId(auditId);
	}

	@Override
	public Long getCount(LtMastAuditRecords input,Long auditId) throws ServiceException {
		return ltMastAuditRecordsDao.getCount(input,auditId);
	}

	@Override
	public List<LtMastAuditRecords> getLtMastAuditRecordsData(LtMastAuditRecords input,Long auditId) throws ServiceException {
		return ltMastAuditRecordsDao.getLtMastAuditRecordsData(input,auditId);
	}

}
