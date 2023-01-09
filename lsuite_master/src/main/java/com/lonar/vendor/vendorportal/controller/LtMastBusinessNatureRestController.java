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
import com.lonar.vendor.vendorportal.model.LtMastBusinessNature;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastBusinessNatureService;

@RestController
@RequestMapping("/API/businessnature")
public class LtMastBusinessNatureRestController implements CodeMaster{

	@Autowired
	LtMastBusinessNatureService ltMastBusinessNatureService;
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastBusinessNature input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastBusinessNatureService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastBusinessNature> ltMastBusinessNatureList= ltMastBusinessNatureService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastBusinessNatureList);
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	// -------------------Add and Update Product Category Details-------------------------------------------
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastBusinessNature(@RequestBody LtMastBusinessNature ltMastBusinessNature) throws ServiceException 
	{
		try {
			return ltMastBusinessNatureService.save(ltMastBusinessNature);	
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	//------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastBusinessNature(@RequestBody LtMastBusinessNature ltMastBusinessNature) throws ServiceException 
	{
		try {
			return ltMastBusinessNatureService.update(ltMastBusinessNature);	
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
			
	// -------------------Delete single Product Sub Category Details-------------------------------
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		try {
			return ltMastBusinessNatureService.delete(id);
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}	
			
	@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastBusinessNature> getLtMastBusinessNatureByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
				LtMastBusinessNature ltMastBusinessNature = null;
		try {
			ltMastBusinessNature = ltMastBusinessNatureService.findById(id);
			return new ResponseEntity<LtMastBusinessNature>(ltMastBusinessNature, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<LtMastBusinessNature>(ltMastBusinessNature, HttpStatus.OK);
		}
	}
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastBusinessNature>> getAll(@PathVariable("logTime") String logTime){
				List<LtMastBusinessNature> ltMastBusinessNatureList = null;
				try {
					ltMastBusinessNatureList = ltMastBusinessNatureService.getAll();
						return new ResponseEntity<List<LtMastBusinessNature>>(ltMastBusinessNatureList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastBusinessNature>>(ltMastBusinessNatureList, HttpStatus.OK);
				}
			}
			
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastBusinessNature>> getAllActive(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastBusinessNature> ltMastBusinessNatureList = null;
				try {
					ltMastBusinessNatureList = ltMastBusinessNatureService.getAllActive(companyId);
						return new ResponseEntity<List<LtMastBusinessNature>>(ltMastBusinessNatureList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastBusinessNature>>(ltMastBusinessNatureList, HttpStatus.OK);
				}
			}
			
			//---------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getLikeName/{name}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastBusinessNature>> getLikePositionName(@PathVariable("name") String name,
					@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastBusinessNature> ltMastBusinessNatureList = null;
				try {
					ltMastBusinessNatureList = ltMastBusinessNatureService.getLikeName(name.trim(),companyId);
					return new ResponseEntity<List<LtMastBusinessNature>>(ltMastBusinessNatureList, HttpStatus.OK);
				} catch(Exception e) {
				return new ResponseEntity<List<LtMastBusinessNature>>(ltMastBusinessNatureList, HttpStatus.OK);
				}
			}
}
