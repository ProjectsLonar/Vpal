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

import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendCompanyClientDetailsService;

@RestController
@RequestMapping("/API/companyclient")
public class LtVendCompanyClientDetailsRestController {

	@Autowired
	LtVendCompanyClientDetailsService ltVendCompanyClientDetailsService;
	
	

	@RequestMapping(value = "/getBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyClientDetails>> getBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyClientDetails> list = ltVendCompanyClientDetailsService.getBycompanyId(companyId);
		return new ResponseEntity<List<LtVendCompanyClientDetails>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanyClientDetails> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanyClientDetails list = ltVendCompanyClientDetailsService.getById(id);
		return new ResponseEntity<LtVendCompanyClientDetails>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyClientDetails>> getAll(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyClientDetails> list = ltVendCompanyClientDetailsService.getAll();
		return new ResponseEntity<List<LtVendCompanyClientDetails>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyClientDetails>> getAllActive(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyClientDetails> list = ltVendCompanyClientDetailsService.getAllActive();
		return new ResponseEntity<List<LtVendCompanyClientDetails>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> save(@RequestBody LtVendCompanyClientDetails ltVendCompanyClientDetails) throws ServiceException 
	{
		return ltVendCompanyClientDetailsService.save(ltVendCompanyClientDetails);
	}

	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestBody LtVendCompanyClientDetails ltVendCompanyClientDetails) throws ServiceException
	{
		return  ltVendCompanyClientDetailsService.update(ltVendCompanyClientDetails);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanyClientDetailsService.delete(Long.parseLong(id));
	}
}
