package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastDocumentList;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastDocumentListService;

@RestController
@RequestMapping("/API/document")
public class LtMastDocumentListRestController implements CodeMaster {
	
	@Autowired
	LtMastDocumentListService ltMastDocumentListService;
	
	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable1(@PathVariable("companyId") Long companyId,LtMastDocumentList input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastDocumentListService.getCount(companyId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastDocumentList> ltMastDivisionsList=ltMastDocumentListService.getDataTableRecords(companyId,input);
				customeDataTable.setData(ltMastDivisionsList);	
		} 
		catch (Exception e) 
		{	
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<Status> saveWithfile(@RequestParam("lastUpdateLogin") Long lastUpdateLogin,
	@RequestParam("file") MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException 
	{
		return ltMastDocumentListService.saveWithfile(lastUpdateLogin,files);
	}
	
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Status> deleteById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException  {
		return ltMastDocumentListService.deleteById(id);
	}

}
