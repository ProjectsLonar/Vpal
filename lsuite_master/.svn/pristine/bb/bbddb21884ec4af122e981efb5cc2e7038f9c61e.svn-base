
package com.lonar.vendor.vendorportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeeDelegationRepository;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeesRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterValuesService;
import com.lonar.vendor.vendorportal.service.LtMastEmployeeDelegationService;

@RestController
@RequestMapping("/API/employeedelegation")
public class LtMastEmployeeDelegationRestController implements CodeMaster{
	
	final String restBaseUrl = "/API/employeedelegation";
	
	static final Logger logger = Logger.getLogger(LtMastEmployeeDelegation.class);
	
	@Autowired
	private LtMastEmployeeDelegationRepository ltMastEmployeeDelegationRepository;
	
	@Autowired
	LtMastEmployeesRepository ltMastEmployeesRepository;
	
	@Autowired 
	private LtMastEmployeeDelegationService ltMastEmployeeDelegationService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	

	//@PreAuthorize("hasPermission(null, '#/employee/employee', 'View')")
	@RequestMapping(value = "/dataTable/{empId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastEmployeesDelegationDataTable(LtMastEmployeeDelegation input,@PathVariable("empId") Long empId,@PathVariable("logTime") String logTime) 
	{
		input.setEmployeeId(empId);
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
			Long count=ltMastEmployeeDelegationService.getCount(input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastEmployeeDelegation> list= ltMastEmployeeDelegationService.getEmployeeDelegationDataTable(input);
			customeDataTable.setData(list);	
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
			
		// -------------------Retrieve All Bank details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'View')")
		@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployeeDelegation>> listLtMastEmployeeDelegationAll(@PathVariable("logTime") String logTime) 
		{
			List<LtMastEmployeeDelegation> ltMastEmployeeDelegation = new ArrayList<LtMastEmployeeDelegation>();
			try
			{
				ltMastEmployeeDelegation = (List<LtMastEmployeeDelegation>) ltMastEmployeeDelegationRepository.findAll();
				for (LtMastEmployeeDelegation ltMastEmployeeDelegation2 : ltMastEmployeeDelegation) 
				{
					if (ltMastEmployeeDelegation2.getDelegationId() != null)
					{
						if (ltMastEmployeesRepository.exists(ltMastEmployeeDelegation2.getDelegationId())) 
						{
							LtMastEmployees ltMastEmployees = ltMastEmployeesRepository
									.findOne(ltMastEmployeeDelegation2.getDelegationId());
							ltMastEmployeeDelegation2.setDelegationName(
									ltMastEmployees.getFirstName() + "(" + ltMastEmployees.getEmployeeNumber() + ")");
						}
					}
				}
				if (ltMastEmployeeDelegation.isEmpty()) 
				{
					return new ResponseEntity<List<LtMastEmployeeDelegation>>(ltMastEmployeeDelegation,
							HttpStatus.NO_CONTENT);
				}
			}
			catch (Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<List<LtMastEmployeeDelegation>>(ltMastEmployeeDelegation, HttpStatus.OK);
		}

		// -------------------Retrieve All Bank details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'View')")
		@RequestMapping(value = "/getByEmployeeId/{employeeId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployeeDelegation>> listEmployeeId(@PathVariable("employeeId") Long employeeId,@PathVariable("logTime") String logTime) 
		{
			List<LtMastEmployeeDelegation> ltMastEmployeeDelegation = new ArrayList<LtMastEmployeeDelegation>();
			try 
			{
				ltMastEmployeeDelegation = ltMastEmployeeDelegationService
						.findByEmployeeIdOrderByEmployeeDelegationId(employeeId);
				if (ltMastEmployeeDelegation.isEmpty()) 
				{
					return new ResponseEntity<List<LtMastEmployeeDelegation>>(new ArrayList<LtMastEmployeeDelegation>(),
							HttpStatus.OK);
				}
			} 
			catch (Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
			return new ResponseEntity<List<LtMastEmployeeDelegation>>(ltMastEmployeeDelegation, HttpStatus.OK);
		}
//============================================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'View')")
		@RequestMapping(value = "/getByDelegationId/{delegationId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployeeDelegation>> listDelegationId(@PathVariable("delegationId") Long delegationId,@PathVariable("logTime") String logTime) 
		{
			List<LtMastEmployeeDelegation> ltMastEmployeeDelegation = new ArrayList<LtMastEmployeeDelegation>();
			try 
			{
				ltMastEmployeeDelegation = ltMastEmployeeDelegationService
						.findByDelegationIdOrderByEmployeeDelegationId(delegationId);
				if (ltMastEmployeeDelegation.isEmpty()) 
				{
					return new ResponseEntity<List<LtMastEmployeeDelegation>>(ltMastEmployeeDelegation,
							HttpStatus.OK);
				}
			} 
			catch (Exception e) 
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<List<LtMastEmployeeDelegation>>(ltMastEmployeeDelegation, HttpStatus.OK);
		}
//============================================================================================================================
		// -------------------Retrieve Single Bank details----------------------------
	//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'View')")
		@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastEmployeeDelegation> getLtMastEmployeeDelegationByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) 
		{
			LtMastEmployeeDelegation ltMastEmployeeDelegation = null;
			try 
			{
				if (ltMastEmployeeDelegationRepository.exists(id))
				{
					ltMastEmployeeDelegation = ltMastEmployeeDelegationRepository.findOne(id);

					if (ltMastEmployeeDelegation.getDelegationId() != null)
					{
						if (ltMastEmployeesRepository.exists(ltMastEmployeeDelegation.getDelegationId())) 
						{
							LtMastEmployees ltMastEmployees = ltMastEmployeesRepository
									.findOne(ltMastEmployeeDelegation.getDelegationId());
							ltMastEmployeeDelegation.setDelegationName(
									ltMastEmployees.getFirstName() + "(" + ltMastEmployees.getEmployeeNumber() + ")");
						}
					}

				}
				else 
				{
					return new ResponseEntity<LtMastEmployeeDelegation>(ltMastEmployeeDelegation, HttpStatus.OK);
				}
			} 
			catch (NumberFormatException e) 
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			} 
			catch (Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<LtMastEmployeeDelegation>(ltMastEmployeeDelegation, HttpStatus.OK);
		}

		// -------------------Create and Update Bank details-----------------
	//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'Add')")
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveLtP2pEmployeeDelegation(@RequestBody @Valid LtMastEmployeeDelegation ltMastEmployeeDelegation) throws Exception
		{
			Status status = new Status();
			try {
				status = ltMastEmployeeDelegationService.save(ltMastEmployeeDelegation);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
		}

		// -------------------Retrieve Single Bank details----------------------------
		//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'Delete')  or hasPermission(null, '#/thirdPartyDelegation/thirdpartydelegation', 'Delete') ")
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> deleteLtMastEmployeeDelegationByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
		
			Status status=null;
			try {
				if (ltMastEmployeeDelegationRepository.exists(id)) {
					ltMastEmployeeDelegationRepository.delete(id);
				} else {
					
					status=ltMastCommonMessageService.getCodeAndMessage(NO_RESULT);
					return new ResponseEntity<Status>(status, HttpStatus.OK);
					
				}
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
				

			} 
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				e.printStackTrace();
				logger.error("ERROR "+ e );
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
			}
			catch (Exception e) 
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}
	//-------------------------------------------------------------------------------------------------	
		//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'View')")
		@RequestMapping(value = "/getByCreatedBy/{userId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployeeDelegation>> getByCreatedBy(@PathVariable("userId") Long userId,@PathVariable("logTime") String logTime) 
		{
			List<LtMastEmployeeDelegation> ltMastEmployeeDelegation = null;
			try 
			{
				ltMastEmployeeDelegation = ltMastEmployeeDelegationService
						.getByCreatedBy(userId);
			} 
			catch (Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
			return new ResponseEntity<List<LtMastEmployeeDelegation>>(ltMastEmployeeDelegation, HttpStatus.OK);
		}	
		
		
	//----------------------------------------------------------------------------------------------------
		//@PreAuthorize("hasPermission(null, '#/delegationMatrix/delegationMatrix', 'View')")
		@RequestMapping(value = "/thirdpartydataTable1/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getEmployeeDelegationDataTable(LtMastEmployeeDelegation input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
			Long count=ltMastEmployeeDelegationService.getThirdPartyCount(input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastEmployeeDelegation> projectList= 
					ltMastEmployeeDelegationService.getThirdPartyEmployeeDelegationDataTable(input);
					customeDataTable.setData(projectList);	
			} 
			catch (Exception e) 
			{	
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return customeDataTable;
			
		}
	
}
