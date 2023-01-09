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

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendCompanyMiscellaneousService;

@RestController
@RequestMapping("/API/companymisc")
public class LtVendCompanyMiscellaneousRestController implements CodeMaster {

	@Autowired
	LtVendCompanyMiscellaneousService ltVendCompanyMiscellaneousService;
	
	@RequestMapping(value = "/getBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanyMiscellaneous> getBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanyMiscellaneous list = ltVendCompanyMiscellaneousService.getBycompanyId(companyId);
		return new ResponseEntity<LtVendCompanyMiscellaneous>(list, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanyMiscellaneous> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanyMiscellaneous list = ltVendCompanyMiscellaneousService.getById(id);
		return new ResponseEntity<LtVendCompanyMiscellaneous>(list, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyMiscellaneous>> getAllLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyMiscellaneous> list = ltVendCompanyMiscellaneousService.getAll();
		return new ResponseEntity<List<LtVendCompanyMiscellaneous>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyMiscellaneous>> getAllActiveLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyMiscellaneous> list = ltVendCompanyMiscellaneousService.getAllActive();
		return new ResponseEntity<List<LtVendCompanyMiscellaneous>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> savewithlogo(@RequestBody LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous) throws ServiceException 
	{
		return ltVendCompanyMiscellaneousService.save(ltVendCompanyMiscellaneous);
	}

	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestBody LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous) throws ServiceException
	{
		return  ltVendCompanyMiscellaneousService.update(ltVendCompanyMiscellaneous);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanyMiscellaneousService.delete(Long.parseLong(id));
	}
}
