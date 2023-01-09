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

import com.lonar.vendor.vendorportal.model.LtInvoiceLineTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtInvoiceLineTaxesService;

@RestController
@RequestMapping("/API/invoicelinetax")
public class LtInvoiceLineTaxesRestController 
{
	@Autowired
	LtInvoiceLineTaxesService ltInvoiceLineTaxesService;
	
	@RequestMapping(value = "/getInvoiceLineTaxById/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtInvoiceLineTaxes> getInvoiceLineTaxesById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
	{
		LtInvoiceLineTaxes ltInvoiceLineTaxes=  ltInvoiceLineTaxesService.getInvoiceLineTaxesById(id);
			return new ResponseEntity<LtInvoiceLineTaxes>(ltInvoiceLineTaxes, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/getInvoiceLineTaxesByHeaderId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtInvoiceLineTaxes>> getAllInvoiceLinesByHeaderId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtInvoiceLineTaxes> invoiceTaxList=  ltInvoiceLineTaxesService.getAllInvoiceLinesByHeaderId(id);
			return new ResponseEntity<List<LtInvoiceLineTaxes>>(invoiceTaxList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getInvoiceLineTaxesByLineId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtInvoiceLineTaxes>> getAllInvoiceLinesByLineId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtInvoiceLineTaxes> invoiceTaxList=  ltInvoiceLineTaxesService.getAllInvoiceLinesByLineId(id);
			return new ResponseEntity<List<LtInvoiceLineTaxes>>(invoiceTaxList, HttpStatus.OK);
	}
	
	
	//@PreAuthorize("hasPermission(null, '#/vendor/vendor', 'Add')")
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody List<LtInvoiceLineTaxes> ltInvoiceLineTaxesList) throws ServiceException
	{
			Status status=new Status();
			status =  ltInvoiceLineTaxesService.save(ltInvoiceLineTaxesList);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/vendor/vendor', 'Update')")
	@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtInvoiceLineTaxes ltInvoiceLineTaxes) throws ServiceException
	{
			Status status=new Status();
			status =  ltInvoiceLineTaxesService.update(ltInvoiceLineTaxes);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasPermission(null, '#/vendor/vendor', 'Delete')")
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
	{
			Status status=new Status();
			status =  ltInvoiceLineTaxesService.delete(vendorId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}


}
