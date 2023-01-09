package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.ApproverModule;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastModuleAppEmployees;
import com.lonar.UserManagement.web.model.LtModuleApprovals;
import com.lonar.UserManagement.web.model.Status;


public interface LtModuleApprovalsService extends CodeMaster
{

	Status save(LtModuleApprovals ltModuleApprovals) throws Exception;

	Status delete(Long moduleApprovalId) throws Exception;

	public List<LtModuleApprovals> getByExpenseHeaderId(Long expId)throws Exception;
	
	public LtModuleApprovals getBymoduleApprovalId(Long moduleApprovalId) throws Exception ;
	
	Status update(LtModuleApprovals ltModuleApprovals) throws Exception;

	List<LtModuleApprovals> getModuleApproval(Long companyId, LtModuleApprovals input) throws Exception;

	Long getCount(Long companyId, LtModuleApprovals input) throws Exception;

	Status deleteEmployee(Long moduleAppEmployeesId, Long moduleId) throws Exception;

	LtModuleApprovals getByLevelAndHeaderId(String level, Long moduleApprovalId) throws Exception;

	List<LtModuleApprovals> getExpenseApprovalLevel(Long expenseHeaderId) throws Exception;

	Status saveModuleApprovalsEmployee(LtMastModuleAppEmployees ltMastModuleAppEmployees) throws Exception;

	Status updateModuleApprovalsEmployee(LtMastModuleAppEmployees ltMastModuleAppEmployees) throws Exception;

	List<LtMastModuleAppEmployees> getEmployeesBymoduleApprovalId(Long moduleApprovalId) throws Exception;

	LtMastModuleAppEmployees getEmployeesBymoduleEmpId(Long moduleEmpId) throws Exception;
	
	//public List<LtExpModuleApprovals> getByStatus(String status)throws Exception;
	

}
