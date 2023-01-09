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

import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendCompanySistConcernService;

@RestController
@RequestMapping("/API/companysistconcern")
public class LtVendCompanySistConcernRestController 
{

	@Autowired
	LtVendCompanySistConcernService ltVendCompanySistConcernService;
	
	@RequestMapping(value = "/getBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanySistConcern>> getBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanySistConcern> list = ltVendCompanySistConcernService.getBycompanyId(companyId);
		return new ResponseEntity<List<LtVendCompanySistConcern>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanySistConcern> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanySistConcern list = ltVendCompanySistConcernService.getById(id);
		return new ResponseEntity<LtVendCompanySistConcern>(list, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanySistConcern>> getAll(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanySistConcern> list = ltVendCompanySistConcernService.getAll();
		return new ResponseEntity<List<LtVendCompanySistConcern>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanySistConcern>> getAllActive(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanySistConcern> list = ltVendCompanySistConcernService.getAllActive();
		return new ResponseEntity<List<LtVendCompanySistConcern>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> save(@RequestBody LtVendCompanySistConcern ltVendCompanySistConcern) throws ServiceException 
	{
		return ltVendCompanySistConcernService.save(ltVendCompanySistConcern);
	}

	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestBody LtVendCompanySistConcern ltVendCompanySistConcern) throws ServiceException
	{
		return  ltVendCompanySistConcernService.update(ltVendCompanySistConcern);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanySistConcernService.delete(Long.parseLong(id));
	}
}
