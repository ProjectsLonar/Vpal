package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.lonar.vendor.vendorportal.model.LtMastFpnMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastFpnMasterService;

@RestController
@RequestMapping("/API/fpnmaster")
public class LtMastFpnMasterRestController implements CodeMaster {
	final String restBaseUrl = "/API/fpnmaster";
	static final Logger logger = Logger.getLogger(LtMastFpnMasterRestController.class);
	
	
	
	@Autowired
	LtMastFpnMasterService ltP2pFpnMasterService;
	
	
	
		@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtMastEmployeesDataTable(LtMastFpnMaster input,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
				Long count=ltP2pFpnMasterService.getCount(input);
				customeDataTable.setRecordsTotal(count);
				customeDataTable.setRecordsFiltered(count);
				List<LtMastFpnMaster> fpnMasterList= ltP2pFpnMasterService.getDatatableRecords(input);
				customeDataTable.setData(fpnMasterList);	
			} 
			catch (Exception e) 
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return customeDataTable;
		}
	
	
	
	// -------------------Retrieve All Bank details-----------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastFpnMaster>> listLtP2pFpnMasterAll(@PathVariable("logTime") String logTime) throws ServiceException {
		return ltP2pFpnMasterService.getAll();
		
	}

	
	// -------------------Retrieve Single Bank details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastFpnMaster> getLtP2pFpnMasterByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltP2pFpnMasterService.getById(id);
		
	}
	
	//---------------------------------getLikeFPNNumber-----------------------------------------------------------------
	@RequestMapping(value = "/getLikefpnNumber/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastFpnMaster>> getLikeFPNNumber(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return (ResponseEntity<List<LtMastFpnMaster>>) ltP2pFpnMasterService.getLikeFpnNumber(id);
		
	}
	
	// -------------------Create and Update Bank details-----------------
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtP2pFpnMaster(@RequestBody  @Valid LtMastFpnMaster ltP2pFpnMaster) throws ServiceException
	{
		try {
			return ltP2pFpnMasterService.save(ltP2pFpnMaster);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}
	// -------------------Create and Update Bank details-----------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtP2pFpnMaster(@RequestBody  @Valid LtMastFpnMaster ltP2pFpnMaster) throws ServiceException
	{
		try {
			return ltP2pFpnMasterService.update(ltP2pFpnMaster);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
			
	}
	
	// -------------------Create and Update Bank details-----------------
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pFpnMaster( @PathVariable("id") Long id) throws ServiceException
	{
		try {
			return ltP2pFpnMasterService.delete(id);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}
	
}