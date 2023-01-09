package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
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
import com.lonar.vendor.vendorportal.model.LtMastAttachmentType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastAttachmentTypeService;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;

@RestController
@RequestMapping("/API/attachment")
public class LtMastAttachmentTypeRestController implements CodeMaster{

	@Autowired
	LtMastAttachmentTypeService ltMastAttachmentTypeService;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
		
//---------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable1(@PathVariable("companyId") Long companyId, LtMastAttachmentType input) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastAttachmentTypeService.getCount(companyId, input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastAttachmentType> ltMastBranchesList= 
			    		ltMastAttachmentTypeService.getDataTableRecords(companyId, input);
				customeDataTable.setData(ltMastBranchesList);	
			  
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
		
	}
//====================================================================================================================
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastAttachmentType>> listLtMastAttachmentTypeAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws  ServiceException {
		List<LtMastAttachmentType> list =  ltMastAttachmentTypeService.findAll(companyId);
		return new ResponseEntity<List<LtMastAttachmentType>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastAttachmentType>> listAllActive(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastAttachmentType> list =   ltMastAttachmentTypeService.findAllActive(companyId);
		return new ResponseEntity<List<LtMastAttachmentType>>(list, HttpStatus.OK);
	}
//====================================================================================================================
	@RequestMapping(value = "/getAllActiveByModule/{module}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastAttachmentType>> listAllActiveByModule(@PathVariable("module") String module,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastAttachmentType> list =   ltMastAttachmentTypeService.listAllActiveByModule(module,companyId);
		return new ResponseEntity<List<LtMastAttachmentType>>(list, HttpStatus.OK);
	}	
//====================================================================================================================
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastAttachmentType> getLtMastBranchesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastAttachmentType ltMastAttachmentType =  ltMastAttachmentTypeService.getLtMastAttachmentTypeByID(id);
		return new ResponseEntity<LtMastAttachmentType>(ltMastAttachmentType, HttpStatus.OK);
	}
//====================================================================================================================
	@RequestMapping(value = "/getByCompanyID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastAttachmentType>> getLtMastBranchesByCompID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastAttachmentType> ltMastAttachmentType =  ltMastAttachmentTypeService.getLtMastAttachmentTypeByCompID(id);
		return new ResponseEntity<List<LtMastAttachmentType>>(ltMastAttachmentType, HttpStatus.OK);
	}

//====================================================================================================================
	@RequestMapping(value = "/getLikeName/{attachmentName}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastAttachmentType>> getLtMastLikeName(@PathVariable("attachmentName") String attachmentName, @PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastAttachmentType> list = ltMastAttachmentTypeService.findActiveLikeName(attachmentName.trim(), companyId);
		return new ResponseEntity<List<LtMastAttachmentType>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody @Valid LtMastAttachmentType ltMastAttachmentType,
			BindingResult bindingResult) throws ServiceException, IOException {
		try {
			return ltMastAttachmentTypeService.save(ltMastAttachmentType,bindingResult);	
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}

//====================================================================================================================
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateh(@RequestBody @Valid LtMastAttachmentType ltMastAttachmentType,
			BindingResult bindingResult) throws ServiceException, IOException {
		try {
			return ltMastAttachmentTypeService.update(ltMastAttachmentType);	
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}

//====================================================================================================================
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastBranchesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltMastAttachmentTypeService.delete(id);	
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}

}
