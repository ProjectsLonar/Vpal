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
import com.lonar.vendor.vendorportal.model.LtMastUnitMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastUnitMasterService;

@RestController
@RequestMapping("/API/unit")
public class LtMastUnitMasterRestController implements CodeMaster{

	@Autowired
	LtMastUnitMasterService ltMastUnitMasterService;
	
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastUnitMaster input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastUnitMasterService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastUnitMaster> ltMastPositionMasterList= ltMastUnitMasterService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastPositionMasterList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	// -------------------Add and Update Product Category Details-------------------------------------------
	
			@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> saveLtMastUnitMaster(@RequestBody LtMastUnitMaster ltMastUnitMaster) throws ServiceException 
			{
				try {
					return ltMastUnitMasterService.save(ltMastUnitMaster);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			//------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> updateLtMastUnitMaster(@RequestBody LtMastUnitMaster ltMastUnitMaster) throws ServiceException 
			{
				try {
					return ltMastUnitMasterService.update(ltMastUnitMaster);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			
			// -------------------Delete single Product Sub Category Details-------------------------------
			@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
			{
				try {
					return ltMastUnitMasterService.delete(id);
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}	
			
			@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<LtMastUnitMaster> getLtMastUnitMasterByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
				LtMastUnitMaster ltMastUnitMaster = null;
				try {
					ltMastUnitMaster = ltMastUnitMasterService.findById(id);
						return new ResponseEntity<LtMastUnitMaster>(ltMastUnitMaster, HttpStatus.OK);
					}catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<LtMastUnitMaster>(ltMastUnitMaster, HttpStatus.OK);
				}
			}
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastUnitMaster>> getAll(@PathVariable("logTime") String logTime){
				List<LtMastUnitMaster> ltMastUnitMasterList = null;
				try {
					ltMastUnitMasterList = ltMastUnitMasterService.getAll();
						return new ResponseEntity<List<LtMastUnitMaster>>(ltMastUnitMasterList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastUnitMaster>>(ltMastUnitMasterList, HttpStatus.OK);
				}
			}
			
			
			@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastUnitMaster>> getAllActive(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastUnitMaster> ltMastUnitMasterList = null;
				try {
					ltMastUnitMasterList = ltMastUnitMasterService.getAllActive(companyId);
						return new ResponseEntity<List<LtMastUnitMaster>>(ltMastUnitMasterList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastUnitMaster>>(ltMastUnitMasterList, HttpStatus.OK);
				}
			}
			//---------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getLikeName/{unit}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastUnitMaster>> getLikeUnitName(@PathVariable("unit") String unit,
					@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastUnitMaster> ltMastUnitMasterList = null;
				try {
					ltMastUnitMasterList = ltMastUnitMasterService.getLikeUnitName(unit.trim(),companyId);
					return new ResponseEntity<List<LtMastUnitMaster>>(ltMastUnitMasterList, HttpStatus.OK);
				} catch(Exception e) {
				return new ResponseEntity<List<LtMastUnitMaster>>(ltMastUnitMasterList, HttpStatus.OK);
				}
			}
}
