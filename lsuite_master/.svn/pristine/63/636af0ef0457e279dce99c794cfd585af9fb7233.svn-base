package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.DivisionWithSubDivision;
import com.lonar.vendor.vendorportal.model.LtMastDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastDivisionsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastSubDivisionsRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterValuesService;
import com.lonar.vendor.vendorportal.service.LtMastDivisionsService;
import com.lonar.vendor.vendorportal.service.LtMastSubDivisionsService;

@RestController
@RequestMapping("/API/division")
public class LtMastDivisionsRestController implements CodeMaster 
{
	final String restBaseUrl = "/API/division";
	//	#/division/division
	static final Logger logger = Logger.getLogger(LtMastDivisionsRestController.class);
	@Autowired
	LtMastDivisionsRepository ltMastDivisionsRepository;
	
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	@Autowired
	LtMastDivisionsService ltMastDivisionsService;
	
	@Autowired
	LtMastSubDivisionsRepository ltMastSubDivisionsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSubDivisionsService ltMastSubDivisionsService;
	
	//---------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public CustomeDataTable getDataTable1(@PathVariable("companyId") Long companyId, LtMastDivisions input,@PathVariable("logTime") String logTime) 
			{
				CustomeDataTable customeDataTable = new CustomeDataTable();
				try 
				{
						Long count=ltMastDivisionsService.getCount(companyId, input);
						customeDataTable.setRecordsTotal(count);
					    customeDataTable.setRecordsFiltered(count);
					    List<LtMastDivisions> ltMastDivisionsList= 
					    		ltMastDivisionsService.getDataTableRecords(companyId, input);
					 
						customeDataTable.setData(ltMastDivisionsList);	
					  
				} 
				catch (Exception e) 
				{	
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
				return customeDataTable;
				
			}
	// -------------------Retrieve All Division Details-----------------------------
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDivisions>> getAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws Exception 
	{
		List<LtMastDivisions> list =  ltMastDivisionsService.getAll(companyId);
		 return new ResponseEntity<List<LtMastDivisions>>(list, HttpStatus.OK);
	}

	// -------------------Retrieve All Active Division Details-----------------------------
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDivisions>> listAllActiveLtMastDivisions(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		 List<LtMastDivisions> list =  ltMastDivisionsService.findAllActive(companyId);
		 return new ResponseEntity<List<LtMastDivisions>>(list, HttpStatus.OK);
	}
	
	
	// -------------------Retrieve All Active Division Details-----------------------------
	@RequestMapping(value = "/getActiveDivLikeNme/{companyId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDivisions>> findActiveLikeName(@PathVariable("companyId") Long companyId, @PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException
	{
		 List<LtMastDivisions> list =   ltMastDivisionsService.findActiveLikeName(companyId, name);
		 return new ResponseEntity<List<LtMastDivisions>>(list, HttpStatus.OK);
	}
	
	// -------------------Retrieve Single Division Details-------------------------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastDivisions> getByDivisionID(@PathVariable("id") Long divisionId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltMastDivisionsService.getDivisionByDivisionId(divisionId);
	}

	//-----------------------------------------save----------------------------------------------------
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody @Valid DivisionWithSubDivision divisionWithSubDivision) throws ServiceException
	{
		try {
			return ltMastDivisionsService.save(divisionWithSubDivision);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	
	//-----------------------------------------save----------------------------------------------------
		@RequestMapping(value = "/savedivision", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveDivision(@RequestBody  LtMastDivisions ltMastDivisions) throws ServiceException
		{
			try {
				return ltMastDivisionsService.saveDivision(ltMastDivisions);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}
	//-----------------------------------------update----------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateDivision(@RequestBody @Valid LtMastDivisions ltMastDivisions) throws ServiceException
	{
		try {
			return ltMastDivisionsService.update(ltMastDivisions);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
		
//===========================================================================================================================
	@RequestMapping(value = "/deleteDivisionWithSubDiv/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteDivision(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException
	{
		try {
			return ltMastDivisionsService.delete(id);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	

	
}