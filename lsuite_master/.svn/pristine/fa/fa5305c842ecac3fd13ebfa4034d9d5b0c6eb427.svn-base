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
import com.lonar.vendor.vendorportal.model.LtMastProductType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastProductTypeService;

@RestController
@RequestMapping("/API/producttype")
public class LtMastProductTypeRestController implements CodeMaster {

	@Autowired
	LtMastProductTypeService ltMastProductTypeService;
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastProductType input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastProductTypeService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastProductType> ltMastPositionMasterList= ltMastProductTypeService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastPositionMasterList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	// -------------------Add and Update Product Category Details-------------------------------------------
	
			@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> saveLtMastProductType(@RequestBody LtMastProductType ltMastProductType) throws ServiceException 
			{
				try {
					return ltMastProductTypeService.save(ltMastProductType);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			//------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> updateLtMastProductType(@RequestBody LtMastProductType ltMastProductType) throws ServiceException 
			{
				try {
					return ltMastProductTypeService.update(ltMastProductType);	
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}
			
			// -------------------Delete single Product Sub Category Details-------------------------------
			@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
			{
				try {
					return ltMastProductTypeService.delete(id);
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}	
			
			@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<LtMastProductType> getLtMastProductTypeByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
				LtMastProductType ltMastProductType = null;
				try {
					ltMastProductType = ltMastProductTypeService.findById(id);
						return new ResponseEntity<LtMastProductType>(ltMastProductType, HttpStatus.OK);
					}catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<LtMastProductType>(ltMastProductType, HttpStatus.OK);
				}
			}
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastProductType>> getAll(@PathVariable("logTime") String logTime){
				List<LtMastProductType> ltMastProductTypeList = null;
				try {
					ltMastProductTypeList = ltMastProductTypeService.getAll();
						return new ResponseEntity<List<LtMastProductType>>(ltMastProductTypeList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastProductType>>(ltMastProductTypeList, HttpStatus.OK);
				}
			}
			
			
			@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastProductType>> getAllActive(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastProductType> ltMastProductTypeList = null;
				try {
					ltMastProductTypeList = ltMastProductTypeService.getAllActive(companyId);
						return new ResponseEntity<List<LtMastProductType>>(ltMastProductTypeList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastProductType>>(ltMastProductTypeList, HttpStatus.OK);
				}
			}
			//---------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getLikeName/{producttype}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastProductType>> getLikeProductType(@PathVariable("producttype") String productType,
					@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastProductType> ltMastTaxTypeList = null;
				try {
					ltMastTaxTypeList = ltMastProductTypeService.getLikeProductType(productType.trim(),companyId);
					return new ResponseEntity<List<LtMastProductType>>(ltMastTaxTypeList, HttpStatus.OK);
				} catch(Exception e) {
				return new ResponseEntity<List<LtMastProductType>>(ltMastTaxTypeList, HttpStatus.OK);
				}
			}
}
