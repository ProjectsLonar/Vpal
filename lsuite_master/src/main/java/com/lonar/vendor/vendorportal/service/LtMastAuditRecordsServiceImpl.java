package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.dao.LtMastAuditRecordsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

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
	public ResponseEntity<LtMastAuditRecords> getByMaster(String masterName) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastAuditRecordsDao.getByMaster(masterName);
	}

}
