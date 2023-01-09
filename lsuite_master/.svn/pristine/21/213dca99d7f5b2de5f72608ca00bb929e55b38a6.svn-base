package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.lonar.vendor.vendorportal.model.LtMastStates;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastStatesService;

@RestController
@RequestMapping("/API/states")
public class LtMastStatesRestController implements CodeMaster{

	@Autowired
	LtMastStatesService ltMastStatesService;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
		
//---------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'View')")
	@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getBranchDataTable1(LtMastStates input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastStatesService.getCount(input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastStates> ltMastStatesList= 
			    		ltMastStatesService.getStateDataTableRecords(input);
				customeDataTable.setData(ltMastStatesList);	
			  
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
		
	}
//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'View')")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastStates>> listLtMastStatesAll(@PathVariable("logTime") String logTime) throws  ServiceException {
		List<LtMastStates> list =  ltMastStatesService.findAll();
		return new ResponseEntity<List<LtMastStates>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'View')")
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastStates>> listAllActiveLtMastStates(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastStates> list =   ltMastStatesService.findAllActive();
		return new ResponseEntity<List<LtMastStates>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'View')")
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastStates> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastStates ltMastStates =  ltMastStatesService.getByID(id);
		return new ResponseEntity<LtMastStates>(ltMastStates, HttpStatus.OK);
	}

//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'View')")
	@RequestMapping(value = "/getLikeName/{statename}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastStates>> getLtMastStatesLikeName(@PathVariable("statename") String statename,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastStates> list = ltMastStatesService.findActiveLikeStateName(statename.trim());
		return new ResponseEntity<List<LtMastStates>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'Add')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastStates(@RequestBody  LtMastStates ltMastStates) throws ServiceException {
		return ltMastStatesService.save(ltMastStates);	
	}

//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'Update')")
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastBranch(@RequestBody @Valid LtMastStates ltMastStates,
			BindingResult bindingResult) throws ServiceException {
		return ltMastStatesService.update(ltMastStates);	
		

	}

//====================================================================================================================
	//@PreAuthorize("hasPermission(null, '#/branch/branch', 'Delete')")
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastBranchesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltMastStatesService.delete(id);	
		
	}

}
