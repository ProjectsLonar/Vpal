package com.lonar.vendor.vendorportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.config.ExceptionMessage;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorMiscInfo;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorMiscInfoService;

@RestController
@RequestMapping("/API/vendormiscinfo")
public class LtMastVendorMiscInfoController implements CodeMaster
{
	final String restBaseUrl = "/API/vendormiscinfo";
	static final Logger logger = Logger.getLogger(LtMastVendorMiscInfoController.class);
	Status status=new Status();
	@Autowired
	LtMastVendorMiscInfoService ltMastVendorMiscInfoService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorMiscInfo>> getAllVendorMiscInfo(@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorMiscInfo> vendorMiscInfoList=new ArrayList<LtMastVendorMiscInfo>();
			try
			{
			 vendorMiscInfoList =  ltMastVendorMiscInfoService.getAllVendorMiscInfo();
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			
			return new ResponseEntity<List<LtMastVendorMiscInfo>>(vendorMiscInfoList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendormiscinfobyvenid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorMiscInfo>> getVendorMiscByVenId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorMiscInfo> vendor = new ArrayList<LtMastVendorMiscInfo>();
			try
			{
			 vendor =  ltMastVendorMiscInfoService.getVendorMiscByVenId(vendorId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			
			return new ResponseEntity<List<LtMastVendorMiscInfo>>(vendor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendormiscinfobyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorMiscInfo> getVendorMiscInfoById(@PathVariable("id") Long vendorMiscInfoId,@PathVariable("logTime") String logTime)
	{
			LtMastVendorMiscInfo vendor = new LtMastVendorMiscInfo();
			try
			{
			 vendor =  ltMastVendorMiscInfoService.getVendorMiscInfoById(vendorMiscInfoId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
		
			return new ResponseEntity<LtMastVendorMiscInfo>(vendor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorMiscInfo ltMastVendorMiscInfo)
	{
			try
			{
			 status =  ltMastVendorMiscInfoService.save(ltMastVendorMiscInfo);
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
    public ResponseEntity<Status> update(@RequestBody LtMastVendorMiscInfo ltMastVendorMiscInfo)
	{
			try
			{
			 status =  ltMastVendorMiscInfoService.update(ltMastVendorMiscInfo);
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
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorMiscInfoId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorMiscInfoService.delete(vendorMiscInfoId);
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
