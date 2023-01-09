package com.lonar.vendor.vendorportal.controller;

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

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastSysVariableValues;
import com.lonar.vendor.vendorportal.model.LtMastSysVariables;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastSysVariableValuesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastSysVariablesRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariableValuesService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;


@RestController
@RequestMapping("/API/sysvariable")
public class LtMastSysVariablesRestController implements CodeMaster
{

	final String restBaseUrl = "/API/sysvariable";
	static final Logger logger = Logger.getLogger(LtMastSysVariablesRestController.class);
	
	@Autowired
	LtMastSysVariablesRepository ltMastSysVariablesRepository;
	
	@Autowired
	LtMastSysVariableValuesRepository ltMastSysVariableValuesRepository;
	
	@Autowired
	LtMastSysVariableValuesService ltMastSysVariableValuesService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	
	@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastSysVariablesDataTable(@PathVariable("companyId") Long companyId,LtMastSysVariables input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastSysVariablesService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastSysVariables> ltMastCompanyList= ltMastSysVariablesService.getDatatableRecords(input,companyId);
			    customeDataTable.setData(ltMastCompanyList);	
			  
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	
		
		
		// -------------------Retrieve All system variable values details-----------------------------
		@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastSysVariables>> listLtP2pSysVariableValuesAll(@PathVariable("logTime") String logTime) throws ServiceException
		{
			return ltMastSysVariablesService.getAll();
		}
		
		// -------------------Retrieve All system variable values details-----------------------------
		@RequestMapping(value = "/getAllValuesBySysVariableId/{id}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastSysVariableValues>> getAllValuesBySysVariable(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
		{
				return ltMastSysVariableValuesService.getAllValuesBySysVariableId(id);
		}
		
		// -------------------Retrieve All system variable values details-----------------------------
		@RequestMapping(value = "/getBySysVariableValuesId/{id}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastSysVariableValues> getBySysVariableValuesId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
		{
			return ltMastSysVariableValuesService.getBySysVariableValuesId(id);
		}
				
		// -------------------Retrieve All system variable values details-----------------------------
		@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SysVariableWithValues> getById(@PathVariable("id") String id,@PathVariable("logTime") String logTime)
		{
			SysVariableWithValues sysVariableWithValues=new SysVariableWithValues() ;
			try
			{
				if( ltMastSysVariablesRepository.exists(Long.parseLong(id)) );
				{
					LtMastSysVariables ltMastSysVariables=ltMastSysVariablesRepository.findOne(Long.parseLong(id));
					sysVariableWithValues.setLtMastSysVariables(ltMastSysVariables);
					sysVariableWithValues.setLtMastSysVariableValues
							(ltMastSysVariableValuesService.getByVariableId(Long.parseLong(id)));
				}
			} 
			catch (Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<SysVariableWithValues>(sysVariableWithValues, HttpStatus.OK);
		}
		
	//-------------------------------------------------------------------------------------------------	
		@RequestMapping(value = "/getbysysvariablename/{name}/{companyId}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SysVariableWithValues> getBySysVariableName(@PathVariable("name") String name,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime)
		{
			SysVariableWithValues sysVariableWithValues=null ;
			try
			{
				 sysVariableWithValues=ltMastSysVariablesService.getBySysVariableName(name,companyId);		
			} 
			catch (Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<SysVariableWithValues>(sysVariableWithValues, HttpStatus.OK);
		}
							
	// -------------------Create system variable values details-----------------
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody @Valid SysVariableWithValues sysVariableWithValues,BindingResult bindingResult) throws ServiceException 
	{
		return  ltMastSysVariablesService.save(sysVariableWithValues);
	}
	
	// -------------------Create system variable values details-----------------
		@RequestMapping(value = "/savesysvariable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveSysVariable(@RequestBody @Valid LtMastSysVariables ltMastSysVariables) throws ServiceException 
		{
			return  ltMastSysVariablesService.saveSysVariable(ltMastSysVariables);
		}
		
	// -------------------Create system variable values details-----------------
	@RequestMapping(value = "/savesysvariablevalues", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveSysVariableValues(@RequestBody @Valid LtMastSysVariableValues ltMastSysVariableValues) throws ServiceException 
	{
			return  ltMastSysVariableValuesService.saveSysVariableValues(ltMastSysVariableValues);
	}	
	
	@RequestMapping(value = "/updatesysvariablevalues", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateSysVariableValues(@RequestBody @Valid LtMastSysVariableValues ltMastSysVariableValues) throws ServiceException 
	{
			return  ltMastSysVariableValuesService.updateSysVariableValues(ltMastSysVariableValues);
	}	
		
	// -------------------Create system variable values details-----------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> update(@RequestBody @Valid SysVariableWithValues sysVariableWithValues,BindingResult bindingResult) throws ServiceException 
	{
			return  ltMastSysVariablesService.update(sysVariableWithValues);				
	}
	
	@RequestMapping(value = "/updatesysvariable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateSysVariable(@RequestBody @Valid LtMastSysVariables ltMastSysVariables) throws ServiceException 
	{
			return  ltMastSysVariablesService.updateSysVariable(ltMastSysVariables);				
	}
	
	// -------------------Delete Single system variable  details----------------------------
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = 		MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastSysVariableByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltMastSysVariablesService.delete(id);
	}
	
	// -------------------Delete Single system variable  details----------------------------
	@RequestMapping(value = "/deleteSysVariableValuesByID/{id}/{logTime}", method = RequestMethod.GET, produces = 		MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastSysVariableValuesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltMastSysVariablesService.deleteLtMastSysVariableValuesByID(id);
	}
}
