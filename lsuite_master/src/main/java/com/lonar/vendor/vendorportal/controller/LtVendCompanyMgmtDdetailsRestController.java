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

import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendCompanyMgmtDdetailsService;

@RestController
@RequestMapping("/API/companymgmt")
public class LtVendCompanyMgmtDdetailsRestController {

	@Autowired
	LtVendCompanyMgmtDdetailsService ltVendCompanyMgmtDdetailsService;
	
	@RequestMapping(value = "/getBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyMgmtDdetails>> getBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyMgmtDdetails> list = ltVendCompanyMgmtDdetailsService.getBycompanyId(companyId);
		return new ResponseEntity<List<LtVendCompanyMgmtDdetails>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanyMgmtDdetails> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanyMgmtDdetails list = ltVendCompanyMgmtDdetailsService.getById(id);
		return new ResponseEntity<LtVendCompanyMgmtDdetails>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyMgmtDdetails>> getAll(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyMgmtDdetails> list = ltVendCompanyMgmtDdetailsService.getAll();
		return new ResponseEntity<List<LtVendCompanyMgmtDdetails>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyMgmtDdetails>> getAllActive(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyMgmtDdetails> list = ltVendCompanyMgmtDdetailsService.getAllActive();
		return new ResponseEntity<List<LtVendCompanyMgmtDdetails>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> save(@RequestBody LtVendCompanyMgmtDdetails ltVendCompanyMgmtDdetails) throws ServiceException 
	{
		return ltVendCompanyMgmtDdetailsService.save(ltVendCompanyMgmtDdetails);
	}

	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestBody LtVendCompanyMgmtDdetails ltVendCompanyMgmtDdetails) throws ServiceException
	{
		return  ltVendCompanyMgmtDdetailsService.update(ltVendCompanyMgmtDdetails);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanyMgmtDdetailsService.delete(Long.parseLong(id));
	}
}
