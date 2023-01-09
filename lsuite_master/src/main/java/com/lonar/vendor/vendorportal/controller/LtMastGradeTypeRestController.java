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
import com.lonar.vendor.vendorportal.model.LtMastGradeType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastGradeTypeService;

@RestController
@RequestMapping("/API/gradetype")
public class LtMastGradeTypeRestController implements CodeMaster {

	@Autowired
	LtMastGradeTypeService ltMastGradeTypeService;
	
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastGradeType input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastGradeTypeService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastGradeType> ltMastPositionMasterList= ltMastGradeTypeService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastPositionMasterList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody LtMastGradeType ltMastGradeType) throws ServiceException 
	{
		try {
			return ltMastGradeTypeService.save(ltMastGradeType);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	//------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> update(@RequestBody LtMastGradeType ltMastGradeType) throws ServiceException 
	{
		try {
			return ltMastGradeTypeService.update(ltMastGradeType);	
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
			
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		try {
			return ltMastGradeTypeService.delete(id);
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}	
			
	@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastGradeType> getLtMastGradeTypeByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
		LtMastGradeType ltMastGradeType = null;
		try {
			ltMastGradeType = ltMastGradeTypeService.findById(id);
			return new ResponseEntity<LtMastGradeType>(ltMastGradeType, HttpStatus.OK);
		}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<LtMastGradeType>(ltMastGradeType, HttpStatus.OK);
		}
		}
			
	//------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGradeType>> getAll(@PathVariable("logTime") String logTime){
		List<LtMastGradeType> ltMastGradeTypeList = null;
		try {
			ltMastGradeTypeList = ltMastGradeTypeService.getAll();
			return new ResponseEntity<List<LtMastGradeType>>(ltMastGradeTypeList, HttpStatus.OK);
		}catch (Exception e)  {
			return new ResponseEntity<List<LtMastGradeType>>(ltMastGradeTypeList, HttpStatus.OK);
		}
	}
	
	//------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGradeType>> getAllActive(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
		List<LtMastGradeType> ltMastGradeTypeList = null;
		try {
			ltMastGradeTypeList = ltMastGradeTypeService.getAllActive(companyId);
			return new ResponseEntity<List<LtMastGradeType>>(ltMastGradeTypeList, HttpStatus.OK);
		}catch (Exception e)  {
			return new ResponseEntity<List<LtMastGradeType>>(ltMastGradeTypeList, HttpStatus.OK);
		}
	}
	//---------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getLikeName/{companyId}/{grade}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGradeType>> getLikeGradeName(@PathVariable("grade") String grade,
			@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
		List<LtMastGradeType> ltMastGradeTypeList = null;
		try {
			ltMastGradeTypeList = ltMastGradeTypeService.getLikeGradeName(grade.trim(),companyId);
			return new ResponseEntity<List<LtMastGradeType>>(ltMastGradeTypeList, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<List<LtMastGradeType>>(ltMastGradeTypeList, HttpStatus.OK);
		}
	}
}
