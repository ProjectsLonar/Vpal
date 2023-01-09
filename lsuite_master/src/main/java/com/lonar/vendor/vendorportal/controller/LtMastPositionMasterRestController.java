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
import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastPositionMasterService;

@RestController
@RequestMapping("/API/position")
public class LtMastPositionMasterRestController implements CodeMaster{

	@Autowired
	LtMastPositionMasterService ltMastPositionMasterService;
	
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastPositionMaster input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastPositionMasterService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastPositionMaster> ltMastPositionMasterList= ltMastPositionMasterService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastPositionMasterList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	// -------------------Add and Update Product Category Details-------------------------------------------
	
			@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> saveLtP2pProductSubCategories(@RequestBody LtMastPositionMaster ltMastPositionMaster) throws ServiceException 
			{
				try {
					return ltMastPositionMasterService.save(ltMastPositionMaster);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			//------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> updateLtP2pProductSubCategories(@RequestBody LtMastPositionMaster ltMastPositionMaster) throws ServiceException 
			{
				try {
					return ltMastPositionMasterService.update(ltMastPositionMaster);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			
			// -------------------Delete single Product Sub Category Details-------------------------------
			@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
			{
				try {
					return ltMastPositionMasterService.delete(id);
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}	
			
			@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<LtMastPositionMaster> getLtMastPositionMasterByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
				LtMastPositionMaster ltMastPositionMaster = null;
				try {
					ltMastPositionMaster = ltMastPositionMasterService.findById(id);
						return new ResponseEntity<LtMastPositionMaster>(ltMastPositionMaster, HttpStatus.OK);
					}catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<LtMastPositionMaster>(ltMastPositionMaster, HttpStatus.OK);
				}
			}
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastPositionMaster>> getAll(@PathVariable("logTime") String logTime){
				List<LtMastPositionMaster> ltMastPositionMasterList = null;
				try {
					ltMastPositionMasterList = ltMastPositionMasterService.getAll();
						return new ResponseEntity<List<LtMastPositionMaster>>(ltMastPositionMasterList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastPositionMaster>>(ltMastPositionMasterList, HttpStatus.OK);
				}
			}
			
			//---------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getLikeName/{companyId}/{position}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastPositionMaster>> getLikePositionName(@PathVariable("position") String position,
					@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastPositionMaster> ltMastPositionMasterList = null;
				try {
					ltMastPositionMasterList = ltMastPositionMasterService.getLikePositionName(position.trim(),companyId);
					return new ResponseEntity<List<LtMastPositionMaster>>(ltMastPositionMasterList, HttpStatus.OK);
				} catch(Exception e) {
				return new ResponseEntity<List<LtMastPositionMaster>>(ltMastPositionMasterList, HttpStatus.OK);
				}
			}
}
