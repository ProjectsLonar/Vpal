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
import com.lonar.vendor.vendorportal.model.LtMastPaymentTerms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastPaymentTermsService;

@RestController
@RequestMapping("/API/paymentTerms")
public class LtMastPaymentTermsRestController implements CodeMaster{

	
	@Autowired
	LtMastPaymentTermsService ltMastPaymentTermsService;
	
	@RequestMapping(value="/datatable/{companyId}/{logTime}",method = RequestMethod.GET ,produces = "application/json")
	public CustomeDataTable getLtMastUserLocationDataTable(@PathVariable("companyId") Long companyId,LtMastPaymentTerms input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastPaymentTermsService.getCount(companyId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastPaymentTerms> termList= 
			    		ltMastPaymentTermsService.getDatatableRecords(companyId,input);
				customeDataTable.setData(termList);	
		} 
		catch (Exception e) 
		{	
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastPaymentTerms>> getAllLtMastPaymentTerms(@PathVariable("logTime") String logTime) throws  ServiceException {
		List<LtMastPaymentTerms> list =  ltMastPaymentTermsService.getAllLtMastPaymentTerms();
		return new ResponseEntity<List<LtMastPaymentTerms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastPaymentTerms>> listAllActiveLtMastPaymentTerms(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastPaymentTerms> list =   ltMastPaymentTermsService.findAllActive(companyId);
		return new ResponseEntity<List<LtMastPaymentTerms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActiveByPaytermId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastPaymentTerms>> getAllActiveByPaytermId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastPaymentTerms> list =   ltMastPaymentTermsService.getAllActiveByPaytermId(id);
		return new ResponseEntity<List<LtMastPaymentTerms>>(list, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastPaymentTerms> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastPaymentTerms ltMastPaymentTerms =  ltMastPaymentTermsService.getByID(id);
		return new ResponseEntity<LtMastPaymentTerms>(ltMastPaymentTerms, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody  LtMastPaymentTerms ltMastPaymentTerms) throws ServiceException {
		try {
			return ltMastPaymentTermsService.save(ltMastPaymentTerms);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> update(@RequestBody  LtMastPaymentTerms ltMastPaymentTerms) throws ServiceException {
		try {
			return ltMastPaymentTermsService.update(ltMastPaymentTerms);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastPaymentTermsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltMastPaymentTermsService.delete(id);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
}
