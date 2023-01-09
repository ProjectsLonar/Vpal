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
import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorBanksService;

@RestController
@RequestMapping("/API/vendorbank")
public class LtMastVendorBanksController implements CodeMaster
{
	final String restBaseUrl = "/API/vendorbank";
	static final Logger logger = Logger.getLogger(LtMastVendorBanksController.class);
	Status status=new Status();
	ExceptionMessage expMsg=new ExceptionMessage();
	@Autowired
	LtMastVendorBanksService ltMastVendorBanksService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/dataTable/{vendorAddressId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorBanksDataTable(@PathVariable("vendorAddressId") Long vendorAddressId,LtMastVendorBanks input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
				Long count=ltMastVendorBanksService.getLtMastVendorBanksCount(vendorAddressId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorBanks> ltMastCommonMessageList= 
			    		ltMastVendorBanksService.getLtMastVendorBanksDataTable(vendorAddressId,input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			 e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorBanks>> getAllVendorBanks(@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendorBanks> vendorBankList=  ltMastVendorBanksService.getAllVendorBanks();
			return new ResponseEntity<List<LtMastVendorBanks>>(vendorBankList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbyvendoridaddressid/{vendorId}/{vendorAddressId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorBanks>> getByVendorIdWithAddress(@PathVariable("vendorId") Long vendorId, @PathVariable("vendorAddressId") Long vendorAddId,@PathVariable("logTime") String logTime) throws ServiceException
    {
            List<LtMastVendorBanks> vendorBank= ltMastVendorBanksService.findByVendorIdWithAddressId(vendorId,vendorAddId);
            return new ResponseEntity<List<LtMastVendorBanks>>(vendorBank, HttpStatus.OK);
    }
  
	@RequestMapping(value = "/getvendorbankbybankid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorBanks> getVendorBankByBankId(@PathVariable("id") Long vendorBankId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtMastVendorBanks vendorBank= ltMastVendorBanksService.getVendorBankByBankId(vendorBankId);
			return new ResponseEntity<LtMastVendorBanks>(vendorBank, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorbankbyvendorid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorBanks> getVendorBankByVendorId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtMastVendorBanks vendorBank=  ltMastVendorBanksService.getVendorBankByVendorId(vendorId);
			return new ResponseEntity<LtMastVendorBanks>(vendorBank, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorbankbyvenaddressid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorBanks> getVendorBankByVendorAddId(@PathVariable("id") Long vendorAddId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtMastVendorBanks vendorBank= ltMastVendorBanksService.getVendorBankByVendorId(vendorAddId);
			return new ResponseEntity<LtMastVendorBanks>(vendorBank, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorBanks ltMastVendorBanks) throws ServiceException
	{
			 status =  ltMastVendorBanksService.save(ltMastVendorBanks);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtMastVendorBanks ltMastVendorBanks) throws ServiceException
	{
		 status =  ltMastVendorBanksService.update(ltMastVendorBanks);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorBankId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorBanksService.delete(vendorBankId);
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
				status=expMsg.getExceptionMessage();
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	

}
