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

import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendCompanyAttachmentsService;

@RestController
@RequestMapping("/API/companyattachment")
public class LtVendCompanyAttachmentsRestController 
{

	@Autowired
	LtVendCompanyAttachmentsService ltVendCompanyAttachmentsService;
	
	@RequestMapping(value = "/getBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyAttachments>> getBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyAttachments> list = ltVendCompanyAttachmentsService.getBycompanyId(companyId);
		return new ResponseEntity<List<LtVendCompanyAttachments>>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompanyAttachments> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		LtVendCompanyAttachments list = ltVendCompanyAttachmentsService.getById(id);
		return new ResponseEntity<LtVendCompanyAttachments>(list, HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyAttachments>> getAll(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyAttachments> list = ltVendCompanyAttachmentsService.getAll();
		return new ResponseEntity<List<LtVendCompanyAttachments>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompanyAttachments>> getAllActive(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtVendCompanyAttachments> list = ltVendCompanyAttachmentsService.getAllActive();
		return new ResponseEntity<List<LtVendCompanyAttachments>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> save(@RequestBody LtVendCompanyAttachments ltVendCompanyAttachments) throws ServiceException 
	{
		return ltVendCompanyAttachmentsService.save(ltVendCompanyAttachments);
	}

	
	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestBody LtVendCompanyAttachments ltVendCompanyAttachments) throws ServiceException
	{
		return  ltVendCompanyAttachmentsService.update(ltVendCompanyAttachments);
	}
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanyAttachmentsService.delete(Long.parseLong(id));
	}
}
