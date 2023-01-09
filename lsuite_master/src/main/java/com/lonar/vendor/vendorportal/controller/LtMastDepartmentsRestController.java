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
import com.lonar.vendor.vendorportal.model.LtMastDepartments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastDepartmentsService;

@RestController
@RequestMapping("/API/departments")
public class LtMastDepartmentsRestController implements CodeMaster{

	@Autowired
	LtMastDepartmentsService ltMastDepartmentsService;
	
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastDepartments input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastDepartmentsService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastDepartments> ltMastBusinessNatureList= ltMastDepartmentsService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastBusinessNatureList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	// -------------------Add and Update Product Category Details-------------------------------------------
	
			@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> saveLtMastDepartments(@RequestBody LtMastDepartments ltMastDepartments) throws ServiceException 
			{
				try {
					return ltMastDepartmentsService.save(ltMastDepartments);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			//------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> updateLtMastDepartments(@RequestBody LtMastDepartments ltMastDepartments) throws ServiceException 
			{
				try {
					return ltMastDepartmentsService.update(ltMastDepartments);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			
			// -------------------Delete single Product Sub Category Details-------------------------------
			@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
			{
				try {
					return ltMastDepartmentsService.delete(id);
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}	
			
			@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<LtMastDepartments> getLtMastDepartmentsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
				LtMastDepartments ltMastDepartments = null;
				try {
					ltMastDepartments = ltMastDepartmentsService.findById(id);
						return new ResponseEntity<LtMastDepartments>(ltMastDepartments, HttpStatus.OK);
					}catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<LtMastDepartments>(ltMastDepartments, HttpStatus.OK);
				}
			}
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastDepartments>> getAll(@PathVariable("logTime") String logTime){
				List<LtMastDepartments> ltMastDepartmentsList = null;
				try {
					ltMastDepartmentsList = ltMastDepartmentsService.getAll();
						return new ResponseEntity<List<LtMastDepartments>>(ltMastDepartmentsList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastDepartments>>(ltMastDepartmentsList, HttpStatus.OK);
				}
			}
			
			//---------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getLikeName/{companyId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastDepartments>> getLikeName(@PathVariable("name") String name,
					@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastDepartments> ltMastDepartmentsList = null;
				try {
					ltMastDepartmentsList = ltMastDepartmentsService.getLikeName(name.trim(),companyId);
					return new ResponseEntity<List<LtMastDepartments>>(ltMastDepartmentsList, HttpStatus.OK);
				} catch(Exception e) {
				return new ResponseEntity<List<LtMastDepartments>>(ltMastDepartmentsList, HttpStatus.OK);
				}
			}
}
