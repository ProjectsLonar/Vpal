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
import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.LtMastVendorHsnSacCodes;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorHsnSacCodesService;

@RestController
@RequestMapping("/API/vendorhsnsaccodes")
public class LtMastVendorHsnSacCodesController implements CodeMaster
{
	final String restBaseUrl = "/API/vendoraddress";
	static final Logger logger = Logger.getLogger(LtMastVendorHsnSacCodesController.class);
	Status status=new Status();
	@Autowired
	LtMastVendorHsnSacCodesService ltMastVendorHsnSacCodesService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/dataTable/{vendorAddressId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorHsnSacCodesDataTable(@PathVariable("vendorAddressId") Long vendorAddressId,LtMastVendorHsnSacCodes input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
				Long count=ltMastVendorHsnSacCodesService.getLtMastVendorHsnSacCodesCount(vendorAddressId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorHsnSacCodes> ltMastCommonMessageList= 
			    		ltMastVendorHsnSacCodesService.getLtMastVendorHsnSacCodesDataTable(vendorAddressId,input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			 e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorHsnSacCodes>> getAllVendorHsnSacCodes(@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorHsnSacCodes> vendorHsnSacCodesList=new ArrayList<LtMastVendorHsnSacCodes>();
			try
			{
			vendorHsnSacCodesList =  ltMastVendorHsnSacCodesService.getAllVendorHsnSacCodes();
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorHsnSacCodes>>(vendorHsnSacCodesList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbyhsnid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorHsnSacCodes> getByHsnId(@PathVariable("id") Long vendorHsnId,@PathVariable("logTime") String logTime)
	{
			LtMastVendorHsnSacCodes vendorAdd=new LtMastVendorHsnSacCodes();
			try
			{
			 vendorAdd =  ltMastVendorHsnSacCodesService.getByHsnId(vendorHsnId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<LtMastVendorHsnSacCodes>(vendorAdd, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbyvenidaddrid/{venid}/{addrid}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorHsnSacCodes>> getByVendorIdAndAddrId(@PathVariable("venid") Long vendorId,@PathVariable("addrid") Long addrId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorHsnSacCodes> vendorHsnSacCodeList = null;
			try
			{
				vendorHsnSacCodeList =  ltMastVendorHsnSacCodesService.getByVendorIdAndAddrId(vendorId,addrId);
				return new ResponseEntity<List<LtMastVendorHsnSacCodes>>(vendorHsnSacCodeList, HttpStatus.OK);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorHsnSacCodes>>(vendorHsnSacCodeList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorHsnSacCodes vendorhsnSacCode)
	{
			try
			{
			 status =  ltMastVendorHsnSacCodesService.save(vendorhsnSacCode);
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
    public ResponseEntity<Status> update(@RequestBody LtMastVendorHsnSacCodes vendorhsnSacCode)
	{
			try
			{
				status =  ltMastVendorHsnSacCodesService.update(vendorhsnSacCode);
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
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorHsnId,@PathVariable("logTime") String logTime)
	{
			try
			{
				 status =  ltMastVendorHsnSacCodesService.delete(vendorHsnId);
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
				e.printStackTrace();
			}
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	

}
