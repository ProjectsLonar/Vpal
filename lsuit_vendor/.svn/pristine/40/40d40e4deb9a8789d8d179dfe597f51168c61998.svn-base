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

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorsAddressService;

@RestController
@RequestMapping("/API/vendoraddress")
public class LtMastVendorAddressController implements CodeMaster
{
	final String restBaseUrl = "/API/vendoraddress";
	static final Logger logger = Logger.getLogger(LtMastVendorAddressController.class);
	Status status=new Status();
	//ExceptionMessage expMsg=new ExceptionMessage();
	
	@Autowired
	LtMastVendorsAddressService ltMastVendorsAddressService;
	
	@RequestMapping(value = "/dataTable/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorAddressDataTable(@PathVariable("vendorId") Long vendorId,LtMastVendorAddress input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastVendorsAddressService.getLtMastVendorAddressCount(vendorId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorAddress> ltMastCommonMessageList= 
			    		ltMastVendorsAddressService.getLtMastVendorAddressDataTable(vendorId,input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			 e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorAddress>> getAllVendorsAddress(@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
			try
			{
			 vendorAddList = ltMastVendorsAddressService.getAllVendorsAddress();
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			
			return new ResponseEntity<List<LtMastVendorAddress>>(vendorAddList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vendoraddrbyvenid/{venid}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorAddress>> getAllVendorsAddressByVendorId(@PathVariable("venid") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
			try
			{
			 vendorAddList =  ltMastVendorsAddressService.getAllVendorsAddressByVendorId(vendorId);
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<List<LtMastVendorAddress>>(vendorAddList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getactivevendoraddrbyvenid/{venid}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorAddress>> getAllActiveVendorsAddressByVendorId(@PathVariable("venid") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
			try
			{
			 vendorAddList =  ltMastVendorsAddressService.getAllActiveVendorsAddressByVendorId(vendorId);
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<List<LtMastVendorAddress>>(vendorAddList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getactivevendorshippingaddrbyvenid/{venid}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorAddress>> getAllActiveShippingAddressByVendId(@PathVariable("venid") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
			try
			{
			 vendorAddList =  ltMastVendorsAddressService.getAllActiveShippingAddressByVendId(vendorId);
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<List<LtMastVendorAddress>>(vendorAddList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendoraddbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorAddress> getVendorById(@PathVariable("id") Long vendorAddId,@PathVariable("logTime") String logTime)
	{
			LtMastVendorAddress vendorAdd=new LtMastVendorAddress();
			try
			{                              
			 vendorAdd =  ltMastVendorsAddressService.getVendorAddById(vendorAddId);
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
			return new ResponseEntity<LtMastVendorAddress>(vendorAdd, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorAddress vendorsAdd)
	{
			try
			{
			 status =  ltMastVendorsAddressService.save(vendorsAdd);
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtMastVendorAddress vendorsAdd)
	{
			try
			{
			 status =  ltMastVendorsAddressService.update(vendorsAdd);
			}
			catch(Exception e)
			{
				/*e.printStackTrace();
				logger.error("ERROR "+ e );*/
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}

			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorAddId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorsAddressService.delete(vendorAddId);
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
				/*e.printStackTrace();
				logger.error("ERROR "+ e );*/
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		Status status = new Status();
			 status =  ltMastVendorsAddressService.checkRecord(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
