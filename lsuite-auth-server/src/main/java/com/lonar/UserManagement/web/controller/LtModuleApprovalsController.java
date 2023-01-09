package com.lonar.UserManagement.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastModuleAppEmployees;
import com.lonar.UserManagement.web.model.LtModuleApprovals;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtExpModuleApprovalsRepository;
import com.lonar.UserManagement.web.service.LtMastCommonMessageService;
import com.lonar.UserManagement.web.service.LtMastComnMasterService;
import com.lonar.UserManagement.web.service.LtMastComnMasterValuesService;
import com.lonar.UserManagement.web.service.LtModuleApprovalsService;

@RestController
@RequestMapping("/api/moduleApprovals")
public class LtModuleApprovalsController implements CodeMaster
{

	final String restBaseUrl = "/API/expModuleApprovals";
	static final Logger logger = Logger.getLogger(LtModuleApprovalsController.class);
	
	@Autowired
	LtModuleApprovalsService ltExpModuleApprovalsService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastComnMasterService ltMastComnMasterService;
	
	@Autowired
	LtExpModuleApprovalsRepository ltExpModuleApprovalsRepository;
	
	
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	
	
	// ================================================================================================================

	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(@PathVariable("companyId") Long companyId,LtModuleApprovals input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltExpModuleApprovalsService.getCount(companyId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtModuleApprovals> moduleApprovalList= ltExpModuleApprovalsService.getModuleApproval(companyId,input);
				
			    customeDataTable.setData(moduleApprovalList);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}

	
	@RequestMapping(value = "/savemodule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveModuleApprovals( @RequestBody LtModuleApprovals ltModuleApprovals )  // @Valid
	{
		Status status = new Status();
		try 
		{
				status=ltExpModuleApprovalsService.save(ltModuleApprovals);
		} 
		catch (NullPointerException e) 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
		} 
		catch (Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updatemodule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateModuleApprovals( @RequestBody LtModuleApprovals ltModuleApprovals )  // @Valid
	{
		Status status = new Status();
		try 
		{
				status=ltExpModuleApprovalsService.update(ltModuleApprovals);
		} 
		catch (Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/savemoduleemployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveModuleApprovalsEmployee( @RequestBody LtMastModuleAppEmployees ltMastModuleAppEmployees )  // @Valid
	{
		Status status = new Status();
		try 
		{
				status=ltExpModuleApprovalsService.saveModuleApprovalsEmployee(ltMastModuleAppEmployees);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updatemoduleemployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateModuleApprovalsEmployee( @RequestBody LtMastModuleAppEmployees ltMastModuleAppEmployees )  // @Valid
	{
		Status status = new Status();
		try 
		{
			status=ltExpModuleApprovalsService.updateModuleApprovalsEmployee(ltMastModuleAppEmployees);
		} 
		catch (Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/approverModule/approverModule', 'Delete') ")
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") Long moduleApprovalId,@PathVariable("logTime") String logTime)
	{
		Status status=new Status();
		try
		{
			status =  ltExpModuleApprovalsService.delete(moduleApprovalId);
		}
		catch (org.springframework.dao.DataIntegrityViolationException e) 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			//throw new BusinessException(ENTITY_CANNOT_DELETE, null, e);
			return new ResponseEntity<Status>(status,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new BusinessException(ENTITY_CANNOT_DELETE, null, e);
		}
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
			
	
	//@PreAuthorize("hasPermission(null, '#/approverModule/approverModule', 'Delete') ")
	@RequestMapping(value = "/deleteemployee/{id}/{moduleId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> deleteEmployee(@PathVariable("id") Long moduleAppEmployeesId,
			 @PathVariable("moduleId") Long moduleId,@PathVariable("logTime") String logTime)
	{
		Status status=new Status();
		
		try
		{
			status =  ltExpModuleApprovalsService.deleteEmployee(moduleAppEmployeesId,moduleId);
		}
		catch (org.springframework.dao.DataIntegrityViolationException e) 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			logger.error("ERROR "+ e );
			return new ResponseEntity<Status>(status,HttpStatus.OK);
			//throw new BusinessException(ENTITY_CANNOT_DELETE, null, e);
		}
		catch(Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/approverModule/approverModule', 'View') ")
	@RequestMapping(value = "/getBymoduleApprovalId/{moduleApprovalId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtModuleApprovals> getBymoduleApprovalId(@PathVariable("moduleApprovalId") Long moduleApprovalId,@PathVariable("logTime") String logTime)
    { 
		LtModuleApprovals ltExpModuleApprovals=new LtModuleApprovals();
            try
            {
            	if(moduleApprovalId!=null)
            	{
            		ltExpModuleApprovals =  ltExpModuleApprovalsService.getBymoduleApprovalId(moduleApprovalId);
            	}
            }
            catch(Exception e)
            {
            	throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
            }
           
            return new ResponseEntity<LtModuleApprovals>(ltExpModuleApprovals, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/getEmployeesBymoduleApprovalId/{moduleApprovalId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastModuleAppEmployees>> getEmployeesBymoduleApprovalId(@PathVariable("moduleApprovalId") Long moduleApprovalId,@PathVariable("logTime") String logTime) throws Exception
    { 
		List<LtMastModuleAppEmployees> ltExpModuleApprovals= ltExpModuleApprovalsService.getEmployeesBymoduleApprovalId(moduleApprovalId);
        return new ResponseEntity<List<LtMastModuleAppEmployees>>(ltExpModuleApprovals, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/getEmployeesBymoduleEmpId/{moduleEmpId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastModuleAppEmployees> getEmployeesBymoduleEmpId(@PathVariable("moduleEmpId") Long moduleEmpId,@PathVariable("logTime") String logTime) throws Exception
    { 
		LtMastModuleAppEmployees ltExpModuleApprovals= ltExpModuleApprovalsService.getEmployeesBymoduleEmpId(moduleEmpId);
        return new ResponseEntity<LtMastModuleAppEmployees>(ltExpModuleApprovals, HttpStatus.OK);
    }
	
	//@PreAuthorize("hasPermission(null, '#/approverModule/approverModule', 'View') ")
	@RequestMapping(value = "/getModuleApprovalsByVendorId/{vendorId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtModuleApprovals>> getByExpenseHeaderId(@PathVariable("vendorId") Long expId,@PathVariable("logTime") String logTime)
    {
            List<LtModuleApprovals> ltExpModuleApprovals=null;
            try
            {
            	if(expId!=null)
            	{
            		ltExpModuleApprovals =  ltExpModuleApprovalsService.getByExpenseHeaderId(expId);
            	}
            }
            catch(Exception e)
            {
            	throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
            }
           
            return new ResponseEntity<List<LtModuleApprovals>>(ltExpModuleApprovals, HttpStatus.OK);
    }
	//---------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/approverModule/approverModule', 'View') ")
	@RequestMapping(value = "/getModuleApprovalsByLevelAndModuleApprovalId/{level}/{moduleApprovalId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtModuleApprovals> getByLevelAndHeaderId(@PathVariable("level") String level,@PathVariable("moduleApprovalId") Long moduleApprovalId,@PathVariable("logTime") String logTime)
    {
            LtModuleApprovals ltExpModuleApproval=null;
            try
            {
            	if(moduleApprovalId!=null && !level.equals("") )
            	{
            		ltExpModuleApproval =  ltExpModuleApprovalsService.getByLevelAndHeaderId(level,moduleApprovalId);
            	}
            }
            catch(Exception e)
            {
            	throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
            }
            return new ResponseEntity<LtModuleApprovals>(ltExpModuleApproval, HttpStatus.OK);
    }
	//-------------------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/approverModule/approverModule', 'View') ")
	@RequestMapping(value = "/getVendorApprovalLevel/{vendorId}/{logTime}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<LtModuleApprovals>> getExpenseApprovalLevel(@PathVariable("vendorId") Long expenseHeaderId,@PathVariable("logTime") String logTime)
	{
		List<LtModuleApprovals> expModuleApprovals=null;
		try
		{
			expModuleApprovals=ltExpModuleApprovalsService.getExpenseApprovalLevel(expenseHeaderId);
		}
		catch(Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<List<LtModuleApprovals>>(expModuleApprovals, HttpStatus.OK);
	}
	
}
