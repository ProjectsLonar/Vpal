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

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtInvoiceLines;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtInvoiceLineService;

@RestController
@RequestMapping("/API/invoiceline")
public class LtInvoiceLinesRestController 
{
	@Autowired
	LtInvoiceLineService ltInvoiceLineService;
	
		@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtMastVendorsDataTable(LtInvoiceLines input,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
					Long count=ltInvoiceLineService.getLtInvoiceLinesCount(input);
					customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    List<LtInvoiceLines> ltMastCommonMessageList= 
				    		ltInvoiceLineService.getLtInvoiceLinesDataTable(input);
					customeDataTable.setData(ltMastCommonMessageList);	
			} 
			catch (Exception e) 
			{	
				 e.printStackTrace();
			}
			return customeDataTable;
		}
		
		@RequestMapping(value = "/dataTableByHeader/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getInvoiceLineDataTableByHeader(LtInvoiceLines input,@PathVariable("id") Long id,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
					Long count=ltInvoiceLineService.getLtInvoiceLinesCountByHeader(input,id);
					customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    List<LtInvoiceLines> ltMastCommonMessageList= 
				    		ltInvoiceLineService.getLtInvoiceLinesDataTableByHeader(input,id);
					customeDataTable.setData(ltMastCommonMessageList);	
			} 
			catch (Exception e) 
			{	
				 e.printStackTrace();
			}
			return customeDataTable;
			
		}
	
		@RequestMapping(value = "/getInvoiceLineById/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<LtInvoiceLines> getInvoiceLineById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
		{
			LtInvoiceLines ltInvoiceLines=  ltInvoiceLineService.getInvoiceLineById(id);
				return new ResponseEntity<LtInvoiceLines>(ltInvoiceLines, HttpStatus.OK);
		}
	
		
		@RequestMapping(value = "/getAllInvoiceLinesByHeaderId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<List<LtInvoiceLines>> getAllInvoiceLinesByHeaderId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
		{
				List<LtInvoiceLines> invoiceList=  ltInvoiceLineService.getAllInvoiceLinesByHeaderId(id);
				return new ResponseEntity<List<LtInvoiceLines>>(invoiceList, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<Status> save(@RequestBody LtInvoiceLines ltInvoiceLines) throws ServiceException
		{
				Status status=new Status();
				status =  ltInvoiceLineService.save(ltInvoiceLines);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<Status> update(@RequestBody LtInvoiceLines ltInvoiceLines) throws ServiceException
		{
				Status status=new Status();
				status =  ltInvoiceLineService.update(ltInvoiceLines);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/loadlines/{invoiceHeaderId}", method= RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<Status> loadLines(@PathVariable("invoiceHeaderId") Long invoiceHeaderId, @RequestBody List<Long> poLinelist) throws ServiceException
		{
				Status status=new Status();
				status =  ltInvoiceLineService.loadLines(poLinelist,invoiceHeaderId);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
		{
				Status status=new Status();
				status =  ltInvoiceLineService.delete(vendorId);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

}
