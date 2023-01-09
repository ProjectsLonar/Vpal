package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastSubDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastDivisionsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastSubDivisionsRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastSubDivisionsService;

@RestController
@RequestMapping("/API/subdivision")
public class LtMastSubDivisionsRestController implements CodeMaster 
{
	final String restBaseUrl = "/API/subdivision";
	static final Logger logger = Logger.getLogger(LtMastSubDivisionsRestController.class);
	@Autowired
	LtMastSubDivisionsRepository ltMastSubDivisionsRepository;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Autowired
	LtMastSubDivisionsService ltMastSubDivisionsService;
	
	@Autowired
	LtMastDivisionsRepository ltMastDivisionsRepository;
	
	@Autowired
	private MessageSource messageSource;

//======================================================================================================================	
	@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DataTablesOutput<LtMastSubDivisions> getLtMastSubDivisionsDataTable(@Valid DataTablesInput input,@PathVariable("logTime") String logTime) {
		
		DataTablesOutput<LtMastSubDivisions> ltMastSubDivisions = new DataTablesOutput<LtMastSubDivisions>();
		String startDate = "";
		String endDate = "";
		if (input.getColumn("startDate") != null)
			startDate = input.getColumn("startDate").getSearch().getValue();
		if (input.getColumn("endDate") != null)
			endDate = input.getColumn("endDate").getSearch().getValue();
		if (startDate.length() == 0 && endDate.length() == 0)
			ltMastSubDivisions = ltMastSubDivisionsRepository.findAll(input);
		
		return ltMastSubDivisions;
	}
//=================================================================================================================
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastSubDivisions>> listLtP2pSubDivisionsAll(@PathVariable("logTime") String logTime) throws ServiceException
	{
		List<LtMastSubDivisions> ltMastSubDivisions =ltMastSubDivisionsService.findAll();
		return new ResponseEntity<List<LtMastSubDivisions>>(ltMastSubDivisions, HttpStatus.OK);
	}

//=====================================================================================================	
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastSubDivisions> getByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException
	{
		LtMastSubDivisions ltMastSubDivisions = ltMastSubDivisionsService.getById(id);;
		
		return new ResponseEntity<LtMastSubDivisions>(ltMastSubDivisions, HttpStatus.OK);
	}


//=====================================================================================================	
	@RequestMapping(value = "/getActiveByDivisionID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastSubDivisions>> getActiveByDivisionID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 		{
			List<LtMastSubDivisions> subDivisionList=ltMastSubDivisionsService.findActiveByDivisionId(id);
			return new ResponseEntity<List<LtMastSubDivisions>>(subDivisionList, HttpStatus.OK);
		}

		
//=====================================================================================================	
	@RequestMapping(value = "/getByDivisionID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastSubDivisions>> getByDivisionID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
		{
			 List<LtMastSubDivisions> subDivisionList=ltMastSubDivisionsService.findByDivisionId(id);
			return new ResponseEntity<List<LtMastSubDivisions>>(subDivisionList, HttpStatus.OK);		
	}


//====================================================================================================================
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastSubDivisions(@RequestBody @Valid LtMastSubDivisions ltMastSubDivisions) throws ServiceException 
	{
		return ltMastSubDivisionsService.save(ltMastSubDivisions);
	}

	
//===================================================================================================================
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> updateLtMastSubDivisions(@RequestBody @Valid LtMastSubDivisions ltMastSubDivisions,
				BindingResult bindingResult) throws ServiceException 
		{
			return ltMastSubDivisionsService.update(ltMastSubDivisions);
			
		}

//======================================================================================================================
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastSubDivisionsByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException
	 {
		return ltMastSubDivisionsService.delete(id);
		
	}
	
//==================================================================================================================
		@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastSubDivisions>> listAllActiveLtMastSubDivisions(@PathVariable("logTime") String logTime) throws ServiceException
		{
			List<LtMastSubDivisions> ltMastSubDivisions = ltMastSubDivisionsService.findAllActive();
			return new ResponseEntity<List<LtMastSubDivisions>>(ltMastSubDivisions, HttpStatus.OK);
		}
	
//========================================================================================================================
}