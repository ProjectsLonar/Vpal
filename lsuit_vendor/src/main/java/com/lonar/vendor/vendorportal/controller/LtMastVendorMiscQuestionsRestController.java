package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.LtMastVendorMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastVendorMiscQuestionsService;

@RestController
@RequestMapping("/API/vendormiscquestions")
public class LtMastVendorMiscQuestionsRestController
{
	Status status=new Status();
	
	@Autowired
	LtMastVendorMiscQuestionsService ltMastVendorMiscQuestionsService;
	
	@RequestMapping(value = "/getvendormiscquestionbyvenid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorMiscQuestions>> getVendorMiscByVenId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendorMiscQuestions> vendor = ltMastVendorMiscQuestionsService.getVendorMiscQuestionByVenId(vendorId);
			return new ResponseEntity<List<LtMastVendorMiscQuestions>>(vendor, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getvendormiscquestionbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendorMiscQuestions> getVendorMiscQuesById(@PathVariable("id") Long vendorMiscQuesId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		LtMastVendorMiscQuestions vendor =  ltMastVendorMiscQuestionsService.getVendorMiscQuesById(vendorMiscQuesId);
			return new ResponseEntity<LtMastVendorMiscQuestions>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody List<LtMastVendorMiscQuestions> ltMastVendorMiscQuestions) throws ServiceException
	{
			 status =  ltMastVendorMiscQuestionsService.save(ltMastVendorMiscQuestions);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody List<LtMastVendorMiscQuestions> ltMastVendorMiscQuestions) throws ServiceException
	{
			 status =  ltMastVendorMiscQuestionsService.update(ltMastVendorMiscQuestions);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			 status =  ltMastVendorMiscQuestionsService.checkRecord(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
