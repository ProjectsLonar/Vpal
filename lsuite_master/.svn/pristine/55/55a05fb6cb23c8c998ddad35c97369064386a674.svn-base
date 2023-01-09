package com.lonar.vendor.vendorportal.controller;

import java.util.List;

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
import com.lonar.vendor.vendorportal.model.LtMastVenorManagmentDesg;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastVenorManagmentDesgService;

@RestController
@RequestMapping("/API/vendordesg")
public class LtMastVenorManagmentDesgRestController implements CodeMaster{

	@Autowired
	LtMastVenorManagmentDesgService ltMastVenorManagmentDesgService;
	
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastVenorManagmentDesg input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastVenorManagmentDesgService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastVenorManagmentDesg> ltMastVenorManagmentDesgList= ltMastVenorManagmentDesgService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastVenorManagmentDesgList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException 
	{
		try {
			return ltMastVenorManagmentDesgService.save(ltMastVenorManagmentDesg);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	//------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> update(@RequestBody LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException 
	{
		try {
			return ltMastVenorManagmentDesgService.update(ltMastVenorManagmentDesg);	
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
			
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		try {
			return ltMastVenorManagmentDesgService.delete(id);
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}	
			
	@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastVenorManagmentDesg> getLtMastVenorManagmentDesgByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
		LtMastVenorManagmentDesg ltMastVenorManagmentDesg = null;
		try {
			ltMastVenorManagmentDesg = ltMastVenorManagmentDesgService.findById(id);
			return new ResponseEntity<LtMastVenorManagmentDesg>(ltMastVenorManagmentDesg, HttpStatus.OK);
		}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<LtMastVenorManagmentDesg>(ltMastVenorManagmentDesg, HttpStatus.OK);
		}
		}
			
	//------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastVenorManagmentDesg>> getAll(@PathVariable("logTime") String logTime){
		List<LtMastVenorManagmentDesg> ltMastVenorManagmentDesgList = null;
		try {
			ltMastVenorManagmentDesgList = ltMastVenorManagmentDesgService.getAll();
			return new ResponseEntity<List<LtMastVenorManagmentDesg>>(ltMastVenorManagmentDesgList, HttpStatus.OK);
		}catch (Exception e)  {
			return new ResponseEntity<List<LtMastVenorManagmentDesg>>(ltMastVenorManagmentDesgList, HttpStatus.OK);
		}
	}
		
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastVenorManagmentDesg>> getAllActive(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
		List<LtMastVenorManagmentDesg> ltMastVenorManagmentDesgList = null;
		try {
			ltMastVenorManagmentDesgList = ltMastVenorManagmentDesgService.getAllActive(companyId);
			return new ResponseEntity<List<LtMastVenorManagmentDesg>>(ltMastVenorManagmentDesgList, HttpStatus.OK);
		}catch (Exception e)  {
			return new ResponseEntity<List<LtMastVenorManagmentDesg>>(ltMastVenorManagmentDesgList, HttpStatus.OK);
		}
	}
	//---------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getLikeName/{designation}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastVenorManagmentDesg>> getLikeDesignation(@PathVariable("designation") String designation,
			@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
		List<LtMastVenorManagmentDesg> ltMastGradeTypeList = null;
		try {
			ltMastGradeTypeList = ltMastVenorManagmentDesgService.getLikeDesignation(designation.trim(),companyId);
			return new ResponseEntity<List<LtMastVenorManagmentDesg>>(ltMastGradeTypeList, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<List<LtMastVenorManagmentDesg>>(ltMastGradeTypeList, HttpStatus.OK);
		}
	}
}
