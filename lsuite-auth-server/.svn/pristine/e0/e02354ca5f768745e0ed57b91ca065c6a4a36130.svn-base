package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;

public interface LtMastAuditRecordsDao {

	boolean update(Long auditRecordId, String reason) throws ServiceException;

	List<LtMastAuditRecords> getByAuditId(float auditId)  throws ServiceException;

	void save(LtMastAuditRecords ltMastAuditRecords) throws ServiceException;

	Long getCount(LtMastAuditRecords input, Long auditId) throws ServiceException;

	List<LtMastAuditRecords> getLtMastAuditRecordsData(LtMastAuditRecords input, Long auditId) throws ServiceException;

}
