package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastEmployeeDelegationDao {
	public List<LtMastEmployeeDelegation> findByEmployeeId(Long employeeId) throws Exception;

	public List<LtMastEmployeeDelegation> findEmployeeBetween(Long employeeId, Date startDate, Date endDate)
			throws Exception;

	public List<LtMastEmployeeDelegation> findDelegationBetween(Long delegationId, Date startDate, Date endDate)
			throws Exception;

	public List<LtMastEmployeeDelegation> findByDelegationId(Long delegationId) throws Exception;
	public List<LtMastEmployeeDelegation> findForDelegation(Long employeeId) throws ServiceException;
	
	public List<LtMastEmployeeDelegation> findByEmployeeIdOrderByEmployeeDelegationId(Long employeeId) throws Exception;
	public List<LtMastEmployeeDelegation> findByDelegationIdOrderByEmployeeDelegationId(Long delegationId) throws Exception;
	
	public List<LtMastEmployeeDelegation> findForEmployee(Long delegationId) throws Exception;

	public void updateDelegation(Long employeeId, Long delegationId) throws Exception;

	public List<LtMastEmployeeDelegation> getByCreatedBy(Long userId)  throws Exception;

	public List<LtMastEmployeeDelegation> getEmployeeDelegationDataTable(LtMastEmployeeDelegation input) throws Exception;

	public Long getCount(LtMastEmployeeDelegation input) throws Exception;
}
