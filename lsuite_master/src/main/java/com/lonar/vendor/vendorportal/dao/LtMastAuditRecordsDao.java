package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastAuditRecordsDao {

	boolean update(Long auditRecordId, String reason) throws ServiceException;

	List<LtMastAuditRecords> getByAuditId(float auditId)  throws ServiceException;

	ResponseEntity<LtMastAuditRecords> getByMaster(String masterName) throws ServiceException;

}
