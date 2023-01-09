package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastAuditRecordsService {

	ResponseEntity<Status> update(List<LtMastAuditRecords> ltMastAuditRecordsList) throws ServiceException;

	List<LtMastAuditRecords> getByAuditId(float auditId) throws ServiceException;

	ResponseEntity<LtMastAuditRecords> getByMaster(String masterName) throws ServiceException;

}
