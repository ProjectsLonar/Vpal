package com.lonar.UserManagement.web.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.Status;

public interface LtMastAuditRecordsService {

	ResponseEntity<Status> update(List<LtMastAuditRecords> ltMastAuditRecordsList) throws ServiceException;

	List<LtMastAuditRecords> getByAuditId(float auditId) throws ServiceException;

	Long getCount(LtMastAuditRecords input, Long auditId) throws ServiceException;

	List<LtMastAuditRecords> getLtMastAuditRecordsData(LtMastAuditRecords input, Long auditId) throws ServiceException;

}
