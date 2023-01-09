package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.config.ExceptionMessage;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastValidation;
import com.lonar.vendor.vendorportal.model.LtMastVendorManagements;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorManagementsService;

@RestController
@RequestMapping("/API/vendormanagement")
public class LtMastVendorManagementsController implements CodeMaster
{
	final String restBaseUrl = "/API/vendormanagement";
	static final Logger logger = Logger.getLogger(LtMastVendorManagementsController.class);
	Status status=new Status();
	ExceptionMessage expMsg=new ExceptionMessage();
	@Autowired
	LtMastVendorManagementsService ltMastVendorManagementsService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/dataTable/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorAddressDataTable(@PathVariable("vendorId") Long vendorId,LtMastVendorManagements input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastVendorManagementsService.getLtMastVendorManagementsCount(vendorId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorManagements> ltMastCommonMessageList= 
			    		ltMastVendorManagementsService.getLtMastVendorManagementsDataTable(vendorId,input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} catch (Exception e) {	
			 e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorManagements>> getAllVendorManagements(@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendorManagements> vendorManagementsList=  ltMastVendorManagementsService.getAllVendorManagements();
			return new ResponseEntity<List<LtMastVendorManagements>>(vendorManagementsList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendormanagementbyvenid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorManagements>> getVendorManagementByVenId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendorManagements> vendor =  ltMastVendorManagementsService.getVendorManagementByVenId(vendorId);
			return new ResponseEntity<List<LtMastVendorManagements>>(vendor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendormanagementbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorManagements> getVendorManagementById(@PathVariable("id") Long vendorManagementId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtMastVendorManagements vendorManagement = ltMastVendorManagementsService.getVendorManagementById(vendorManagementId);
			return new ResponseEntity<LtMastVendorManagements>(vendorManagement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorManagements ltMastVendorManagements) throws ServiceException
	{
			status =  ltMastVendorManagementsService.save(ltMastVendorManagements);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtMastVendorManagements ltMastVendorManagements) throws ServiceException
	{
			 status =  ltMastVendorManagementsService.update(ltMastVendorManagements);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorManagementId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorManagementsService.delete(vendorManagementId);
			}
			catch (org.springframework.dao.DataIntegrityViolationException e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
			} 
			catch(Exception e)
			{
				ExceptionMessage expMsg=new ExceptionMessage();
				status=expMsg.getExceptionMessage();
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvalidationbytablename/{name}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastValidation>> getValidationByTableName(@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException
	{
		List<LtMastValidation> vendorManagement = ltMastVendorManagementsService.getValidationByTableName(name);
			return new ResponseEntity<List<LtMastValidation>>(vendorManagement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			 status =  ltMastVendorManagementsService.checkRecord(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

}
