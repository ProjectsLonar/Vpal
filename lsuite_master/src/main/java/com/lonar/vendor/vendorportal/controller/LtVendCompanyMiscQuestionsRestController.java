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

import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendMiscQuestionsService;

@RestController
@RequestMapping("/API/miscquestions")
public class LtVendCompanyMiscQuestionsRestController {

	@Autowired
	LtVendMiscQuestionsService ltVendMiscQuestionsService;
	
	@RequestMapping(value = "/getBycompanyMiscId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getBycompanyMiscId(@PathVariable("id") Long companyMiscId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getBycompanyMiscId(companyMiscId);
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/getMiscQueBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getMiscQueBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getMiscQueBycompanyId(companyId);
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);	
	}
	
	
	@RequestMapping(value = "/getMiscQueBycompanyVendorId/{companyId}/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getMiscQueBycompanyVendorId(@PathVariable("companyId") Long companyId,@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getMiscQueBycompanyVendorId(companyId,vendorId);
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);	
	}
	
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendMiscQuestions> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getById(id);
		return new ResponseEntity<LtVendMiscQuestions>(list.get(0), HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getAllLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getAll();
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getAllActiveLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getAllActive();
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> save(@RequestBody LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException 
	{
		return ltVendMiscQuestionsService.save(ltVendMiscQuestions);
	}

	
	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestBody LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException
	{
		return  ltVendMiscQuestionsService.update(ltVendMiscQuestions);
	}
	
	@RequestMapping(value = "/delete/{id}/{comId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String id,@PathVariable("comId") Long comId,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendMiscQuestionsService.delete(Long.parseLong(id),comId);
		
	}
}
