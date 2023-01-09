package com.lonar.vendor.vendorportal.controller;

import java.util.ArrayList;
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
import com.lonar.vendor.vendorportal.model.LtMastVendorContacts;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorContactsService;

@RestController
@RequestMapping("/API/vendorcontact")
public class LtMastVendorContactsController implements CodeMaster
{
	final String restBaseUrl = "/API/vendorcontact";
	static final Logger logger = Logger.getLogger(LtMastVendorContactsController.class);
	Status status=new Status();
	@Autowired
	LtMastVendorContactsService ltMastVendorContactsService;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/dataTable/{vendorAddressId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorContactsDataTable(@PathVariable("vendorAddressId") Long vendorAddressId,LtMastVendorContacts input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
				Long count=ltMastVendorContactsService.getLtMastVendorContactsCount(vendorAddressId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorContacts> ltMastCommonMessageList= 
			    		ltMastVendorContactsService.getLtMastVendorContactsDataTable(vendorAddressId,input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			 e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorContacts>> getAllVendorsContact(@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorContacts> vendorContactList =new ArrayList<LtMastVendorContacts>();
			try
			{
			 vendorContactList =  ltMastVendorContactsService.getAllVendorsContact();
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}	
			return new ResponseEntity<List<LtMastVendorContacts>>(vendorContactList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorcontactbyaddridvenid/{addressId}/{venId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorContacts>> getVendorContactByAddressIdAndVendorId(@PathVariable("addressId") String vendorAddressId,@PathVariable("venId") String vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorContacts> ltMastVendorContacts=new ArrayList<LtMastVendorContacts>();
			try
			{
			 ltMastVendorContacts =  ltMastVendorContactsService.getVendorContactByAddressIdAndVendorId(vendorAddressId,vendorId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorContacts>>(ltMastVendorContacts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorcontactbycontactid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorContacts> getVendorContactByContactId(@PathVariable("id") Long vendorContactId,@PathVariable("logTime") String logTime)
	{
			LtMastVendorContacts ltMastVendorContacts=new LtMastVendorContacts();
			try
			{
			 ltMastVendorContacts =  ltMastVendorContactsService.getVendorContactByContactId(vendorContactId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<LtMastVendorContacts>(ltMastVendorContacts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorContacts vendorContact)
	{
			try
			{
			 status =  ltMastVendorContactsService.save(vendorContact);
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
	
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtMastVendorContacts vendorContact)
	{
			try
			{
			 status =  ltMastVendorContactsService.update(vendorContact);
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
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorContactId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorContactsService.delete(vendorContactId);
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
	
	

}
