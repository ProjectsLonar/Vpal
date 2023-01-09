package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtModuleApprovals;


public interface LtModuleApprovalsDao extends CodeMaster
{

	//boolean loadApprovers(LtExpExpenseHeaders ltExpExpenseHeaders) throws Exception;

	Long save(LtModuleApprovals ltExpModuleApprovals) throws Exception;

	boolean delete(Long moduleApprovalId) throws Exception;

	String getByApprovalLevelAndModuleId(String approvalLevel,Long moduleApprovalId)  throws Exception;

	List<LtModuleApprovals> getByExpenseHeaderId(Long divId) throws Exception;

	List<LtModuleApprovals> getByStatus(String status) throws Exception;

	LtModuleApprovals getBymoduleApprovalId(Long moduleApprovalId) throws Exception;

	boolean update(LtModuleApprovals ltExpModuleApprovals) throws Exception;

	List<LtModuleApprovals> getModuleApproval(Long companyId, LtModuleApprovals input) throws Exception;

	Long getCount(Long companyId, LtModuleApprovals input) throws Exception;

	boolean checkForDuplicate(LtModuleApprovals ltExpModuleApprovals) throws Exception;

	LtModuleApprovals getByLevelAndHeaderId(String level, Long moduleApprovalId) throws Exception;

//	boolean chkIsAprovedByAnyOne(LtExpenseApprovalHistory approvalHistory) throws Exception;

	List<LtModuleApprovals> getExpenseApprovalLevel(Long expenseHeaderId)  throws Exception;

	boolean checkForDuplicateForUpdate(LtModuleApprovals ltExpModuleApprovals) throws Exception;

	

}
