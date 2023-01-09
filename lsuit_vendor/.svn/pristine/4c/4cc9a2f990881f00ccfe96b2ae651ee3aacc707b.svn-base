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
import com.lonar.vendor.vendorportal.model.LtMastVendorSisterConcerns;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorSisterConcernsService;

@RestController
@RequestMapping("/API/VendorSisterConcerns")
public class LtMastVendorSisterConcernsRestController  implements CodeMaster
{
	
	final String restBaseUrl = "/API/VendorSisterConcerns";
	static final Logger logger = Logger.getLogger(LtMastVendorSisterConcernsRestController.class);
	Status status=new Status();
	ExceptionMessage expMsg=new ExceptionMessage();
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Autowired
	LtMastVendorSisterConcernsService ltMastVendorSisterConcernsService;
	
	@RequestMapping(value = "/dataTable/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorSisterConcernsDataTable(@PathVariable("vendorId") Long vendorId,LtMastVendorSisterConcerns input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastVendorSisterConcernsService.getLtMastVendorSisterConcernsCount(vendorId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendorSisterConcerns> ltMastVendorSisterConcernsList= 
			    		ltMastVendorSisterConcernsService.getLtMastVendorSisterConcernsDataTable(vendorId,input);
				customeDataTable.setData(ltMastVendorSisterConcernsList);	
		} catch (Exception e) {	
			 e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorSisterConcerns>> getAllVendorSisterConcerns(@PathVariable("logTime") String logTime) throws Exception
	{
		List<LtMastVendorSisterConcerns> ltMastVendorSisterConcerns = new ArrayList<LtMastVendorSisterConcerns>();
		;
		try 
		{
			ltMastVendorSisterConcerns = ltMastVendorSisterConcernsService.getAllVendorSisterConcerns();
		}
		catch (Exception e) 
		{
			logger.error("ERROR "+ e );
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastVendorSisterConcerns>>(ltMastVendorSisterConcerns, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getvendorsisconcbyvenid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorSisterConcerns>> getVendorSisConcByVenId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorSisterConcerns> ltMastVendorSisterConcerns=new ArrayList<LtMastVendorSisterConcerns>();
			try
			{
				ltMastVendorSisterConcerns =  ltMastVendorSisterConcernsService.getVendorSisConcByVenId(vendorId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorSisterConcerns>>(ltMastVendorSisterConcerns, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getvendorSisConcid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorSisterConcerns> getVendorSisConcId(@PathVariable("id") Long vendorSisterConcernsId,@PathVariable("logTime") String logTime)
	{
			LtMastVendorSisterConcerns ltMastVendorSisterConcerns=new LtMastVendorSisterConcerns();
			try
			{
				ltMastVendorSisterConcerns =  ltMastVendorSisterConcernsService.getVendorSisterConcernsById(vendorSisterConcernsId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<LtMastVendorSisterConcerns>(ltMastVendorSisterConcerns, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendorSisterConcerns ltMastVendorSisterConcerns)
	{
			try
			{
			 status =  ltMastVendorSisterConcernsService.save(ltMastVendorSisterConcerns);
			}
			catch(Exception e)
			{
				status=expMsg.getExceptionMessage();
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtMastVendorSisterConcerns ltMastVendorSisterConcerns)
	{
			try
			{
			 status =  ltMastVendorSisterConcernsService.update(ltMastVendorSisterConcerns);
			}
			catch(Exception e)
			{
				status=expMsg.getExceptionMessage();
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long ltMastVendorSisterConcerns,@PathVariable("logTime") String logTime)
	{
			try
			{
			 status =  ltMastVendorSisterConcernsService.delete(ltMastVendorSisterConcerns);
			}
			catch (org.springframework.dao.DataIntegrityViolationException e)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
				logger.error("ERROR "+ e );
				e.printStackTrace();
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
	
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			 status =  ltMastVendorSisterConcernsService.checkRecord(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}


}
