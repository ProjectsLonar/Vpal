package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendCompanyCocService;

@RestController
@RequestMapping("/API/companycoc")
public class LtVendCompanyCocRestController implements CodeMaster{

	@Autowired
	LtVendCompanyCocService ltVendCompanyCocService;
	
	

	@RequestMapping(value = "/getBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyCoc>> getBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyCoc> list = ltVendCompanyCocService.getBycompanyId(companyId);
		return new ResponseEntity<List<LtVendCompanyCoc>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getBycompanyvendorId/{comId}/{venId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyCoc>> getBycompanyAndVendorId(@PathVariable("comId") Long companyId,@PathVariable("venId") Long venId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyCoc> list = ltVendCompanyCocService.getBycompanyAndVendorId(companyId,venId);
		return new ResponseEntity<List<LtVendCompanyCoc>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanyCoc> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanyCoc list = ltVendCompanyCocService.getById(id);
		return new ResponseEntity<LtVendCompanyCoc>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyCoc>> getAllLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyCoc> list = ltVendCompanyCocService.getAll();
		return new ResponseEntity<List<LtVendCompanyCoc>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyCoc>> getAllActiveLtMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyCoc> list = ltVendCompanyCocService.getAllActive();
		return new ResponseEntity<List<LtVendCompanyCoc>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> savewithfile (@RequestParam("ltVendCompanyCoc") String strltVendCompanyCoc,
	@RequestParam("file") MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException 
	{
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		jsonInputObject =  (JSONObject) jsonparser.parse(strltVendCompanyCoc);
		LtVendCompanyCoc ltVendCompanyCoc = new ObjectMapper().readValue(strltVendCompanyCoc,
				LtVendCompanyCoc.class);
		return ltVendCompanyCocService.save(ltVendCompanyCoc,files);
	}

	
	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestParam("ltVendCompanyCoc") String strltVendCompanyCoc ,@RequestParam("file") MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException
	{
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		jsonInputObject =  (JSONObject) jsonparser.parse(strltVendCompanyCoc);
		LtVendCompanyCoc ltVendCompanyCoc = new ObjectMapper().readValue(strltVendCompanyCoc,
				LtVendCompanyCoc.class);
		return  ltVendCompanyCocService.update(ltVendCompanyCoc,files);
	}
	
	@RequestMapping(value = "/delete/{id}/{companyId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") Long id,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanyCocService.delete(id,companyId);
	}
	
}
