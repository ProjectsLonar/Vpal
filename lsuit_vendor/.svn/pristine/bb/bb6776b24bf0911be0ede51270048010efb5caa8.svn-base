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

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtPoLinesService;

@RestController
@RequestMapping("/API/polines")
public class LtMastPoLinesRestController {

	@Autowired
	LtPoLinesService ltPoLinesService;
	
	@RequestMapping(value = "/datatable/{headerId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorsDataTable(@PathVariable("headerId") Long headerId,LtPoLines input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltPoLinesService.getLtPoLinesCount(headerId,input);
				customeDataTable.setRecordsTotal(count);
				customeDataTable.setRecordsFiltered(count);
				List<LtPoLines> ltPoLinesList= ltPoLinesService.getLtPoLinesDataTable(headerId,input);
				customeDataTable.setData(ltPoLinesList);	
		} 
		catch (Exception e) 
		{	
				e.printStackTrace();
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/getallpolinesbyheaderid/{headerId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtPoLines>> getAllPoLinesByHeaderId(@PathVariable("headerId") Long headerId ,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtPoLines> ltPoLinesList=  ltPoLinesService.getAllPoLinesByHeaderId(headerId);
			return new ResponseEntity<List<LtPoLines>>(ltPoLinesList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getpolinesbyid/{poLineId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtPoLines> getPoLinesByPolineId(@PathVariable("poLineId") Long poLineId ,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtPoLines ltPoLine =  ltPoLinesService.getPoLinesByPolineId(poLineId);
			return new ResponseEntity<LtPoLines>(ltPoLine, HttpStatus.OK);
	}
}
