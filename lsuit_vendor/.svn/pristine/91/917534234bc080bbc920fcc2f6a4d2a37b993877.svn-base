package com.lonar.vendor.vendorportal.csvupload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.CustomeDataTable;


@RestController
@RequestMapping("/API/sysreq")
public class LtMastSysRequestsRestController 
{
	@Autowired
	LtMastSysRequestsService ltMastSysRequestsService;
	
	@RequestMapping(value = "/dataTable", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastSysRequestsDataTable1(LtMastSysRequests input) 
	{
		String apiUrl = "/dataTable/" ;
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastSysRequestsService.getCount(input);
				
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    
			    List<LtMastSysRequests> ltMastSysRequestsList= 
			    		ltMastSysRequestsService.getLtMastSysRequestsDataTableRecords(input);
				
			    customeDataTable.setData(ltMastSysRequestsList);	
			  
		} 
		catch (Exception e) 
		{		
			 e.printStackTrace();
		}
		return customeDataTable;
		
	}
	
	
	@RequestMapping(value = "/reportDataTable/{reqId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastSysRequestsReportDataTable(LtMastSysRequestReport input,
			@PathVariable("reqId") Long reqId) 
	{
	
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastSysRequestsService.getLtMastSysRequestReportCount(input,reqId);
				
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    
			    List<LtMastSysRequestReport> ltMastSysRequestsList= 
			    		ltMastSysRequestsService.getLtMastSysRequestReportDataTableRecords(input,reqId);
				
			    customeDataTable.setData(ltMastSysRequestsList);	
			  
		} 
		catch (Exception e) 
		{		
			 e.printStackTrace();
		}
		return customeDataTable;
		
	}
}
