package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;

public interface LtMastEmployeeDelegationDao {
	public List<LtMastEmployeeDelegation> findByEmployeeId(Long employeeId) throws Exception;

	public List<LtMastEmployeeDelegation> findEmployeeBetween(Long employeeId, Date startDate, Date endDate)
			throws Exception;

	public List<LtMastEmployeeDelegation> findDelegationBetween(Long delegationId, Date startDate, Date endDate)
			throws Exception;

	public List<LtMastEmployeeDelegation> findByDelegationId(Long delegationId) throws Exception;
	public List<LtMastEmployeeDelegation> findForDelegation(Long employeeId) throws Exception;
	
	public List<LtMastEmployeeDelegation> findByEmployeeIdOrderByEmployeeDelegationId(Long employeeId) throws Exception;
	public List<LtMastEmployeeDelegation> findByDelegationIdOrderByEmployeeDelegationId(Long delegationId) throws Exception;
	
	public List<LtMastEmployeeDelegation> findForEmployee(Long delegationId) throws Exception;

	public void updateDelegation(Long employeeId, Long delegationId) throws Exception;

	public List<LtMastEmployeeDelegation> getByCreatedBy(Long userId)  throws Exception;

	public List<LtMastEmployeeDelegation> getThirdPartyEmployeeDelegationDataTable(LtMastEmployeeDelegation input) throws Exception;

	public Long getThirdPartyCount(LtMastEmployeeDelegation input) throws Exception;

	public Long getCount(LtMastEmployeeDelegation input) throws Exception;

	public List<LtMastEmployeeDelegation> getEmployeeDelegationDataTable(LtMastEmployeeDelegation input) throws Exception;

	public LtMastEmployeeDelegation checkDelegateeAvailability(LtMastEmployeeDelegation ltMastEmployeeDelegation) throws Exception;

	public LtMastEmployeeDelegation checkEmpDelegation(LtMastEmployeeDelegation ltMastEmployeeDelegation) throws Exception;
}
