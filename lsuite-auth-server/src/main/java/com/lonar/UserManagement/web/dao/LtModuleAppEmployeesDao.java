package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastModuleAppEmployees;

public interface LtModuleAppEmployeesDao
{

	boolean save(LtMastModuleAppEmployees ltExpenseModuleAppEmployees) throws Exception;

	boolean update(LtMastModuleAppEmployees ltExpenseModuleAppEmployees) throws Exception;

	
	boolean deleteByModuleApprovalId(Long moduleApprovalId) throws Exception;

	public List<LtMastModuleAppEmployees> getByModuleApprovalId(Long moduleApprovalId) throws Exception;

	boolean checkForDuplicate(LtMastModuleAppEmployees ltExpenseModuleAppEmployees) throws Exception;

	boolean deleteEmployee(Long moduleAppEmployeesId, Long moduleId) throws Exception;

	LtMastModuleAppEmployees getEmployeesBymoduleEmpId(Long moduleEmpId) throws Exception;

	//List<LtExpenseModuleAppEmployees> getByModuleApprovalId(Long moduleApprovalId) throws Exception;
	
	//public List<LtExpenseModuleAppEmployees> getBymoduleApprovalIdId(Long moduleApprovalId) throws Exception;

}
