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

import com.lonar.vendor.vendorportal.model.LtInvoiceAccounting;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtInvoiceAccountingService;

@RestController
@RequestMapping("/API/invoiceaccounting")
public class LtInvoiceAccountingRestController {

	@Autowired
	LtInvoiceAccountingService ltInvoiceAccountingService;
	
	@RequestMapping(value = "/getInvoiceAccountingById/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtInvoiceAccounting> getInvoiceAccountingById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
	{
		LtInvoiceAccounting LtInvoiceAccounting=  ltInvoiceAccountingService.getInvoiceAccountingById(id);
			return new ResponseEntity<LtInvoiceAccounting>(LtInvoiceAccounting, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/getInvoiceAccountingByHeaderId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtInvoiceAccounting>> getInvoiceAccountingByHeaderId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtInvoiceAccounting> ltInvoiceAccountingList=  ltInvoiceAccountingService.getInvoiceAccountingByHeaderId(id);
			return new ResponseEntity<List<LtInvoiceAccounting>>(ltInvoiceAccountingList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getInvoiceAccountingByLineId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtInvoiceAccounting>> getInvoiceAccountingByLineId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtInvoiceAccounting> ltInvoiceAccountingList=  ltInvoiceAccountingService.getInvoiceAccountingByLineId(id);
			return new ResponseEntity<List<LtInvoiceAccounting>>(ltInvoiceAccountingList, HttpStatus.OK);
	}
	
	
	//@PreAuthorize("hasPermission(null, '#/vendor/vendor', 'Add')")
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtInvoiceAccounting ltInvoiceAccounting) throws ServiceException
	{
			Status status=new Status();
			status =  ltInvoiceAccountingService.save(ltInvoiceAccounting);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/vendor/vendor', 'Update')")
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtInvoiceAccounting ltInvoiceAccounting) throws ServiceException
	{
			Status status=new Status();
			status =  ltInvoiceAccountingService.update(ltInvoiceAccounting);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/vendor/vendor', 'Delete')")
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long id,@PathVariable("logTime") String logTime)
	{
			Status status=new Status();
			status =  ltInvoiceAccountingService.delete(id);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
