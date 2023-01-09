package com.lonar.UserManagement.web.service;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastComnMasterValuesDao;
import com.lonar.UserManagement.web.dao.LtMastEmployeesDao;
import com.lonar.UserManagement.web.dao.LtModuleAppEmployeesDao;
import com.lonar.UserManagement.web.dao.LtModuleApprovalsDao;
import com.lonar.UserManagement.web.model.LtMastEmployees;
import com.lonar.UserManagement.web.model.LtMastModuleAppEmployees;
import com.lonar.UserManagement.web.model.LtModuleApprovals;
import com.lonar.UserManagement.web.model.Status;


@Service
public class LtModuleApprovalsServiceImpl implements LtModuleApprovalsService 
{

	@Autowired
	LtModuleApprovalsDao ltExpModuleApprovalsDao;
	
	@Autowired
	LtModuleAppEmployeesDao ltExpenseModuleAppEmployeesDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastComnMasterValuesDao ltMastComnMasterValuesDao;
	

	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Transactional
	@Override
	public Status save(LtModuleApprovals ltModuleApprovals) throws Exception
	{
		Status status=new Status();
		
		
			if(ltModuleApprovals.getLastUpdateLogin()==null || ltModuleApprovals.getStartDate()==null  
					|| ltModuleApprovals.getStatus()==null )
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
						
			}
			
			ltModuleApprovals.setCreatedBy(ltModuleApprovals.getLastUpdateLogin());
			ltModuleApprovals.setLastUpdateDate(new Date());
			ltModuleApprovals.setLastUpdatedBy(ltModuleApprovals.getLastUpdateLogin());
			ltModuleApprovals.setCreationDate(new Date());
			
		
			if( ltExpModuleApprovalsDao.checkForDuplicate(ltModuleApprovals))
			{
			Long moduleApprovalId=ltExpModuleApprovalsDao.save(ltModuleApprovals);
			if(moduleApprovalId!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(moduleApprovalId);
				
			}	else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				return status;
			}
		}
		else
		{
			status.setCode(FAIL);
			status.setMessage("Record for same division and level already exists.");
		}
		return status;
			
		
	}

	@Transactional
	@Override
	public Status delete(Long moduleApprovalId) throws Exception 
	{
		Status status=new Status();
	
		List<LtMastModuleAppEmployees> moduleAppEmployees=
					ltExpenseModuleAppEmployeesDao.getByModuleApprovalId(moduleApprovalId);
		if(moduleAppEmployees!=null && !moduleAppEmployees.isEmpty())
		{
		
			if(ltExpenseModuleAppEmployeesDao.deleteByModuleApprovalId(moduleApprovalId))
			{
				
				if( ltExpModuleApprovalsDao.delete(moduleApprovalId))
				{
					
					status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
				}
				else
				{
					
					status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed unsuccessfully.");
					}
					return status;
				}
						
			}
			else
			{
				
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("The Approval Employee has some pending expenses for approval.");
				}
				return status;
			}
				
		}
		else
		{
			
			if( ltExpModuleApprovalsDao.delete(moduleApprovalId))
			{
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
				return status;
			}
		}
		return status;
	}

	@Transactional
	@Override
	public List<LtModuleApprovals> getByExpenseHeaderId(Long expId) throws Exception 
	{
		
		/*
		List<LtExpModuleApprovals> ltExpModuleApprovalsList = new ArrayList<LtExpModuleApprovals>();
		
		LtExpExpenseHeaders ltExpExpenseHeaders=ltExpExpenseHeadersDao.findOne(expId);
		ltExpModuleApprovalsList = ltExpModuleApprovalsDao.getByExpenseHeaderId(ltExpExpenseHeaders.getDivisionId());
	
		return ltExpModuleApprovalsList;*/
		return null;
		
		
	}

	@Transactional
	@Override
	public LtModuleApprovals getBymoduleApprovalId(Long moduleApprovalId) throws Exception 
	{
		
		LtModuleApprovals ltExpModuleApprovals = new LtModuleApprovals();
		
		ltExpModuleApprovals = ltExpModuleApprovalsDao.getBymoduleApprovalId(moduleApprovalId);
		if(ltExpModuleApprovals!=null)
		{
			List<LtMastModuleAppEmployees> employeeList=
					ltExpenseModuleAppEmployeesDao.getByModuleApprovalId(ltExpModuleApprovals.getModuleApprovalId());
			
			if(!employeeList.isEmpty() && employeeList.size()>0)
			{
				for(LtMastModuleAppEmployees ltExpenseModuleAppEmployees:employeeList)
				{
					List<LtMastEmployees> emp=ltMastEmployeesDao.getEmployeeDetailsByUserID(ltExpenseModuleAppEmployees.getEmployeesId());
					if(! emp.isEmpty())
					ltExpenseModuleAppEmployees.setEmployeeName(emp.get(0).getEmpName());
				}
					ltExpModuleApprovals.setEmpList(employeeList);
			}
		}
		return ltExpModuleApprovals;
	}

	@Transactional
	@Override
	public Status update(LtModuleApprovals ltModuleApprovals) throws Exception {
		Status status=new Status();
		
	
			if(ltModuleApprovals.getLastUpdateLogin()==null || ltModuleApprovals.getStartDate()==null  
					|| ltModuleApprovals.getStatus()==null || ltModuleApprovals.getModuleApprovalId()==null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
						
			}
			
			
			ltModuleApprovals.setLastUpdateDate(new Date());
			ltModuleApprovals.setLastUpdatedBy(ltModuleApprovals.getLastUpdateLogin());
			
			if( ltExpModuleApprovalsDao.checkForDuplicateForUpdate(ltModuleApprovals))
			{
			if(ltExpModuleApprovalsDao.update(ltModuleApprovals))
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				
				
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
				return status;
			}
		}
		else
		{
			status.setCode(FAIL);
			status.setMessage("Record for same division and level is already exists.");
		}
		
		return status;
	}

	@Transactional
	@Override
	public List<LtModuleApprovals> getModuleApproval(Long companyId,LtModuleApprovals input) throws Exception 
	{
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("desc"))
		{
			input.setColumnNo(19);
		}
	
		if(input.getColumnNo()==1 && input.getSort().equals("asc"))
		{
			input.setColumnNo(20);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(1);
		}
		List<LtModuleApprovals> list= ltExpModuleApprovalsDao.getModuleApproval(companyId,input);
		
		return list;
	}

	@Transactional
	@Override
	public Long getCount(Long companyId,LtModuleApprovals input) throws Exception 
	{
		return ltExpModuleApprovalsDao.getCount(companyId,input);
	}

	@Override
	public Status deleteEmployee(Long moduleAppEmployeesId,Long moduleId) throws Exception
	{
		Status status=new Status();
		if( ltExpenseModuleAppEmployeesDao.deleteEmployee(moduleAppEmployeesId,moduleId))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return status;
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		return status;
	}

	@Transactional
	@Override
	public LtModuleApprovals getByLevelAndHeaderId(String level, Long moduleApprovalId) throws Exception 
	{
		return ltExpModuleApprovalsDao.getByLevelAndHeaderId(level,moduleApprovalId);
	}

	@Transactional
	@Override
	public List<LtModuleApprovals> getExpenseApprovalLevel(Long expenseHeaderId) throws Exception
	{
		return ltExpModuleApprovalsDao.getExpenseApprovalLevel(expenseHeaderId);
	}

	@Override
	public Status saveModuleApprovalsEmployee(LtMastModuleAppEmployees ltMastModuleAppEmployees) throws Exception {
		Status status = new Status();
		if(ltMastModuleAppEmployees.getLastUpdateLogin()==null || ltMastModuleAppEmployees.getStartDate()==null  
							||  ltMastModuleAppEmployees.getCreationDate()==null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
						if(status.getMessage()==null)
						{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
		}
			
		if(ltExpenseModuleAppEmployeesDao.checkForDuplicate(ltMastModuleAppEmployees)) {
		ltMastModuleAppEmployees.setCreationDate(new Date());
		ltMastModuleAppEmployees.setLastUpdateDate(new Date());
				
		if(ltExpenseModuleAppEmployeesDao.save(ltMastModuleAppEmployees))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return status;
		}
		}else {
			status.setCode(FAIL);
			status.setMessage("Employee already exists for level.");
		}
		return status;
		
	}

	@Override
	public Status updateModuleApprovalsEmployee(LtMastModuleAppEmployees ltMastModuleAppEmployees) throws Exception {
		Status status = new Status();
		ltMastModuleAppEmployees.setLastUpdateDate(new Date());
		if(ltMastModuleAppEmployees.getLastUpdateLogin()==null && ltMastModuleAppEmployees.getStartDate()==null  
						&&  ltMastModuleAppEmployees.getLastUpdateDate()==null &&  ltMastModuleAppEmployees.getModuleApprovalId()==null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		
		if(ltExpenseModuleAppEmployeesDao.update(ltMastModuleAppEmployees))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return status;
		}
		return status;
	}

	@Override
	public List<LtMastModuleAppEmployees> getEmployeesBymoduleApprovalId(Long moduleApprovalId) throws Exception {
		return ltExpenseModuleAppEmployeesDao.getByModuleApprovalId(moduleApprovalId);
	}

	@Override
	public LtMastModuleAppEmployees getEmployeesBymoduleEmpId(Long moduleEmpId) throws Exception {
		return ltExpenseModuleAppEmployeesDao.getEmployeesBymoduleEmpId(moduleEmpId);
	}

	

}
