package com.lonar.vendor.vendorportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.config.ExceptionMessage;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastVendorAgreements;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorAgreementsService;

@RestController
@RequestMapping("/API/vendoragreement")
public class LtMastVendorAgreementsController implements CodeMaster
{

	final String restBaseUrl = "/API/vendoragreement";
	static final Logger logger = Logger.getLogger(LtMastVendorAgreementsController.class);
	Status status=new Status();
	ExceptionMessage expMsg=new ExceptionMessage();
	@Autowired
	LtMastVendorAgreementsService ltMastVendorAgreementsService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorAgreementsDataTable(@PathVariable("companyId") Long companyId,LtMastVendorAgreements input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastVendorAgreementsService.getLtMastVendorAgreementsCount(input,companyId);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorAgreements> ltMastCommonMessageList= 
			    		ltMastVendorAgreementsService.getLtMastVendorAgreementsDataTable(input,companyId);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			logger.error("ERROR "+ e );
			 e.printStackTrace();
		}
		return customeDataTable;
		
	}
	
	@RequestMapping(value = "/dataTableByVenId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getVendorAgreementsDataTableByVenId(LtMastVendorAgreements input,@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastVendorAgreementsService.getLtMastVendorAgreementsCountByVenId(input,vendorId);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorAgreements> ltMastCommonMessageList= 
			    		ltMastVendorAgreementsService.getLtMastVendorAgreementsDataTableByVenId(input,vendorId);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			logger.error("ERROR "+ e );
			 e.printStackTrace();
		}
		return customeDataTable;
		
	}
	@RequestMapping(value = "/list/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorAgreements>> getAllVendorAgrrement(@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorAgreements> vendorAgreementList=new ArrayList<LtMastVendorAgreements>();
			try
			{
			 vendorAgreementList =  ltMastVendorAgreementsService.getAllVendorAgrrement();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorAgreements>>(vendorAgreementList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getallagreementbyvendor/{venid}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorAgreements>> getAllVendorAgrrementByVendorId(@PathVariable("venid") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorAgreements> vendorAgreementList=new ArrayList<LtMastVendorAgreements>();
			try
			{
			 vendorAgreementList =  ltMastVendorAgreementsService.getAllVendorAgrrementByVendorId(vendorId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorAgreements>>(vendorAgreementList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendoragreementbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorAgreements> getVendorAgreementById(@PathVariable("id") Long vendorAggId,@PathVariable("logTime") String logTime)
	{
			LtMastVendorAgreements vendorAgreement=new LtMastVendorAgreements();
			try
			{
			 vendorAgreement =  ltMastVendorAgreementsService.getVendorAgreementById(vendorAggId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return new ResponseEntity<LtMastVendorAgreements>(vendorAgreement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorAgreements vendorAggreement)
	{
			try
			{
			 status =  ltMastVendorAgreementsService.save(vendorAggreement);
			}
			catch(Exception e)
			{
				status=expMsg.getExceptionMessage();
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/savewithattachment", method= RequestMethod.POST)
    public ResponseEntity<Status> saveWithAttachment(@RequestParam("vendorAggreement") String data,@RequestParam("file") MultipartFile[] files)
	{
			JSONParser jsonparser = new JSONParser();
			JSONObject jsonInputObject = null;
			try
			{
				jsonInputObject = (JSONObject) jsonparser.parse(data);
				LtMastVendorAgreements vendorAggreement = new ObjectMapper().readValue(data,
						LtMastVendorAgreements.class);
				status =  ltMastVendorAgreementsService.saveWithAttachment(vendorAggreement,files);
			}
			catch(Exception e)
			{
				status=expMsg.getExceptionMessage();
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestParam("vendorAggreement") String data,@RequestParam("file") MultipartFile[] files)
	{
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
			try
			{
				jsonInputObject = (JSONObject) jsonparser.parse(data);
				LtMastVendorAgreements vendorAggreement = new ObjectMapper().readValue(data,
						LtMastVendorAgreements.class);
			 status =  ltMastVendorAgreementsService.update(vendorAggreement,files);
			}
			catch(Exception e)
			{
				status=expMsg.getExceptionMessage();
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorAgreementId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorAgreementsService.delete(vendorAgreementId);
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
	
	@RequestMapping(value = "/deleteAttachment/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> deleteAttachment(@PathVariable("id") Long vendorAgreementId,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorAgreementsService.deleteAttachment(vendorAgreementId);
			}
			catch (org.springframework.dao.DataIntegrityViolationException e)
			{
				e.printStackTrace();
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
			} 
			catch(Exception e)
			{
				status=expMsg.getExceptionMessage();
				e.printStackTrace();
			}
		
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
}
