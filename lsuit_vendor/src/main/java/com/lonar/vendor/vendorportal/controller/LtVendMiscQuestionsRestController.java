package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtVendMiscQuestionsService;

@RestController
@RequestMapping("/API/miscquestions")
public class LtVendMiscQuestionsRestController {

	@Autowired
	LtVendMiscQuestionsService ltVendMiscQuestionsService;
	
	/*@Autowired
	LtMastCompanyService ltMastCompanyService;*/
	

	//@PreAuthorize("hasPermission(null, '#/companyMaster/companyMaster', 'View')")
	@RequestMapping(value = "/getBycompanyMiscId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getBycompanyMiscId(@PathVariable("id") Long companyMiscId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getBycompanyMiscId(companyMiscId);
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendMiscQuestions> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendMiscQuestions list = ltVendMiscQuestionsService.getById(id);
		return new ResponseEntity<LtVendMiscQuestions>(list, HttpStatus.OK);	
		
	}
	
	//@PreAuthorize("hasPermission(null, '#/companyMaster/companyMaster', 'View')")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getAllLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getAll();
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/companyMaster/companyMaster', 'View')")
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendMiscQuestions>> getAllActiveLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendMiscQuestions> list = ltVendMiscQuestionsService.getAllActive();
		return new ResponseEntity<List<LtVendMiscQuestions>>(list, HttpStatus.OK);
	}
	
	
}
