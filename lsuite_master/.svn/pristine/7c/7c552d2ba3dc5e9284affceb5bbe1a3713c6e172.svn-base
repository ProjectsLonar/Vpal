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

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastLogger;
import com.lonar.vendor.vendorportal.service.LtMastLoggerService;

@RestController
@RequestMapping("/API/logger")
public class LtMastLoggerRestController implements CodeMaster {

	@Autowired
	LtMastLoggerService ltMastLoggerService;
	
	
	@RequestMapping(value="/datatable/{logTime}",method = RequestMethod.GET ,produces = "application/json")
	public CustomeDataTable getLtMastLoggerDataTable(LtMastLogger input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastLoggerService.getCount(input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastLogger> loggerList= 
			    		ltMastLoggerService.getLoggerRecords(input);
				customeDataTable.setData(loggerList);	
		} 
		catch (Exception e) 
		{	
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastLogger> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws Exception {
		LtMastLogger ltMastLogger =  ltMastLoggerService.getByID(id);
		return new ResponseEntity<LtMastLogger>(ltMastLogger, HttpStatus.OK);
	}
	
}
