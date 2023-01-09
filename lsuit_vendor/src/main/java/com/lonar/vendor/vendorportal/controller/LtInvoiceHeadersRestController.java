package com.lonar.vendor.vendorportal.controller;

import java.util.Date;
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

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtInvoiceHeadersService;

@RestController
@RequestMapping("/API/invoiceheader")
public class LtInvoiceHeadersRestController implements CodeMaster
{

	@Autowired
	LtInvoiceHeadersService ltInvoiceHeadersService;
	
		@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtMastVendorsDataTable(LtInvoiceHeaders input,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
					Long count=ltInvoiceHeadersService.getLtInvoiceHeadersCount(input);
					customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    List<LtInvoiceHeaders> ltMastCommonMessageList= 
				    		ltInvoiceHeadersService.getLtInvoiceHeadersDataTable(input);
					customeDataTable.setData(ltMastCommonMessageList);	
			} 
			catch (Exception e) 
			{	
				 e.printStackTrace();
			}
			return customeDataTable;
			
		}
		
		
		@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtMastVendorsDataTableById(LtInvoiceHeaders input,@PathVariable("id") Long id,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
					Long count=ltInvoiceHeadersService.getLtInvoiceHeadersCountById(input,id);
					customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    List<LtInvoiceHeaders> ltMastCommonMessageList= 
				    		ltInvoiceHeadersService.getLtInvoiceHeadersDataTableById(input,id);
					customeDataTable.setData(ltMastCommonMessageList);	
			} 
			catch (Exception e) 
			{	
				 e.printStackTrace();
			}
			return customeDataTable;
			
		}
		
		@RequestMapping(value = "/invoiceDataTableByVendorId/{venId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtInvoiceHeadersDataTableByVendorId(LtInvoiceHeaders input,@PathVariable("venId") Long venId,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
					Long count=ltInvoiceHeadersService.getLtInvoiceHeadersCountByVendorId(input,venId);
					customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    List<LtInvoiceHeaders> ltMastCommonMessageList= 
				    		ltInvoiceHeadersService.getLtInvoiceHeadersDataTableByVendorId(input,venId);
					customeDataTable.setData(ltMastCommonMessageList);	
			} 
			catch (Exception e) 
			{	
				 e.printStackTrace();
			}
			return customeDataTable;
		}
		
		@RequestMapping(value = "/getInvoiceById/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<LtInvoiceHeaders> getInvoiceById(@PathVariable("id") Long id) throws ServiceException
		{
				LtInvoiceHeaders invoiceList=  ltInvoiceHeadersService.getInvoiceById(id);
				return new ResponseEntity<LtInvoiceHeaders>(invoiceList, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/getAllInvoice/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<List<LtInvoiceHeaders>> getAllInvoice(@PathVariable("logTime") String logTime) throws ServiceException
		{
				List<LtInvoiceHeaders> invoiceList=  ltInvoiceHeadersService.getAllInvoice();
				return new ResponseEntity<List<LtInvoiceHeaders>>(invoiceList, HttpStatus.OK);
		}
		
		
		@RequestMapping(value = "/getAllInvoiceByInitiator/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<List<LtInvoiceHeaders>> getAllInvoiceByInitiator(@PathVariable("id") Long initiatorId,@PathVariable("logTime") String logTime) throws ServiceException
		{
				List<LtInvoiceHeaders> invoiceList=  ltInvoiceHeadersService.getAllInvoiceByInitiator(initiatorId);
				return new ResponseEntity<List<LtInvoiceHeaders>>(invoiceList, HttpStatus.OK);
		}
		
		
		@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<Status> save(@RequestBody LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException
		{
				Status status=new Status();
				status =  ltInvoiceHeadersService.save(ltInvoiceHeaders);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<Status> update(@RequestBody LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException
		{
				Status status=new Status();
				status =  ltInvoiceHeadersService.update(ltInvoiceHeaders);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<Status> delete(@PathVariable("id") Long invoiceHeaderId,@PathVariable("logTime") String logTime) throws ServiceException
		{
				Status status=new Status();
				status =  ltInvoiceHeadersService.delete(invoiceHeaderId);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		
		@RequestMapping(value = "/getinvoicestatuscountbyvendorId/{vendorId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<List<DashboardDetails>> getCountAndStatusByVendorId(@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
		{
			List<DashboardDetails> vendor = ltInvoiceHeadersService.getCountAndStatusByVendorId(vendorId);
			return new ResponseEntity<List<DashboardDetails>>(vendor, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/getinvoiceamountbyuser/{userId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<List<DashboardDetails>> getInvoiceAmtByUserId(@PathVariable("userId") Long userId,@PathVariable("logTime") String logTime) throws ServiceException
		{
			List<DashboardDetails> vendor = ltInvoiceHeadersService.getInvoiceAmtByUserId(userId);
			return new ResponseEntity<List<DashboardDetails>>(vendor, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/submitforapproval/{invoiceheaderid}/{logTime}", method = RequestMethod.GET)
		public ResponseEntity<Status> submitForApproval( @PathVariable("invoiceheaderid") Long invoiceheaderid,@PathVariable("logTime") String logTime)
		{
			Status status=new Status();
			try
			{		
				String stat =checkforApprovals(invoiceheaderid);
				if(stat.equals("null"))
				{
					status.setCode(FAIL);
					status.setMessage("No approvers found for employee's division.");
					return new ResponseEntity<Status>(status, HttpStatus.OK);
				}else {
					
					LtInvoiceHeaders ltInvoiceHeaders =ltInvoiceHeadersService.getInvoiceById(invoiceheaderid);
					if(  ltInvoiceHeaders.getInvoiceAmount()!=null &&  ltInvoiceHeaders.getInvoiceAmount()>0) {
						status=ltInvoiceHeadersService.submitForApproval(new Date(),invoiceheaderid,INVOICE_INPROCESS,null);
					}else {
						status.setCode(FAIL);
						status.setMessage("Invoice with zero amount can not be sent for approval.");
						return new ResponseEntity<Status>(status, HttpStatus.OK);
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

		private String checkforApprovals(Long invoiceheaderid) throws ServiceException 
		{
			String stat = ltInvoiceHeadersService.checkforApprovals(invoiceheaderid);
			return stat;
		}
		
		@RequestMapping(value = "/getInvoiceStatusById/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<LtInvoiceHeaders> getInvoiceStatusById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
		{
			LtInvoiceHeaders invoiceHeaders=  ltInvoiceHeadersService.getInvoiceStatusById(id);
				return new ResponseEntity<LtInvoiceHeaders>(invoiceHeaders, HttpStatus.OK);
		}
		
		//boolean loadApprovers(Long vendorId) throws ServiceException;
		
		@RequestMapping(value = "/checkStatusIsPending/{invid}/{appid}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public boolean checkStatusIsPending(@PathVariable("invid") Long invid, @PathVariable("appid") Long appid,@PathVariable("logTime") String logTime) throws ServiceException
		{
			return  ltInvoiceHeadersService.checkStatusIsPending(invid, appid);
		}
}
