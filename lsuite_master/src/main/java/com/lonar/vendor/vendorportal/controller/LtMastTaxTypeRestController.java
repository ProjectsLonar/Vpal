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
import com.lonar.vendor.vendorportal.model.LtMastTaxType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastTaxTypeService;

@RestController
@RequestMapping("/API/taxtype")
public class LtMastTaxTypeRestController implements CodeMaster{

	@Autowired
	LtMastTaxTypeService ltMastTaxTypeService;
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastTaxType input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastTaxTypeService.getCount(input,companyId);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastTaxType> ltMastPositionMasterList= ltMastTaxTypeService.getDataTable(input,companyId);
				customeDataTable.setData(ltMastPositionMasterList);
			
		} 
		catch (Exception e) {		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	// -------------------Add and Update Product Category Details-------------------------------------------
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastTaxType(@RequestBody LtMastTaxType ltMastTaxType) throws ServiceException 
	{
		try {
			return ltMastTaxTypeService.save(ltMastTaxType);	
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	//------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastTaxType(@RequestBody LtMastTaxType ltMastTaxType) throws ServiceException 
	{
		try {
			return ltMastTaxTypeService.update(ltMastTaxType);	
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
			
			// -------------------Delete single Product Sub Category Details-------------------------------
			@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> deleteByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
			{
				try {
					return ltMastTaxTypeService.delete(id);
				}catch(Exception e) {
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			}	
			
			@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<LtMastTaxType> getLtMastTaxTypeByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
				LtMastTaxType ltMastTaxType = null;
				try {
					ltMastTaxType = ltMastTaxTypeService.findById(id);
						return new ResponseEntity<LtMastTaxType>(ltMastTaxType, HttpStatus.OK);
					}catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<LtMastTaxType>(ltMastTaxType, HttpStatus.OK);
				}
			}
			
			//------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastTaxType>> getAll(@PathVariable("logTime") String logTime){
				List<LtMastTaxType> ltMastTaxTypeList = null;
				try {
					ltMastTaxTypeList = ltMastTaxTypeService.getAll();
						return new ResponseEntity<List<LtMastTaxType>>(ltMastTaxTypeList, HttpStatus.OK);
				}  catch (Exception e)  {
					return new ResponseEntity<List<LtMastTaxType>>(ltMastTaxTypeList, HttpStatus.OK);
				}
			}
			
			//---------------------------------------------------------------------------------------------------------
			@RequestMapping(value = "/getLikeName/{taxname}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<LtMastTaxType>> getLikeTaxName(@PathVariable("taxname") String taxname,
					@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
				List<LtMastTaxType> ltMastTaxTypeList = null;
				try {
					ltMastTaxTypeList = ltMastTaxTypeService.getLikeTaxName(taxname.trim(),companyId);
					return new ResponseEntity<List<LtMastTaxType>>(ltMastTaxTypeList, HttpStatus.OK);
				} catch(Exception e) {
				return new ResponseEntity<List<LtMastTaxType>>(ltMastTaxTypeList, HttpStatus.OK);
				}
			}
}
