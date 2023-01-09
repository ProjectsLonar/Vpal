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

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastBillingAddresses;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastBillingAddressesService;

@RestController
@RequestMapping("/API/billingaddresses")
public class LtMastBillingAddressesRestController implements CodeMaster {

	
	@Autowired
	LtMastBillingAddressesService ltP2pBillingAddressesService;
	
	//@PreAuthorize("hasPermission(null, '#/employee/employee', 'View')")
	@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastBillingDataTable(LtMastBillingAddresses input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
			Long count=ltP2pBillingAddressesService.getCount(input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastBillingAddresses> ltMastEmployeesList= ltP2pBillingAddressesService.getDatatableRecords(input);
			customeDataTable.setData(ltMastEmployeesList);	
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
				
	}

	
	
	@RequestMapping(value = "/getLikeBillingAddressCode/{addrCode}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBillingAddresses>> getLikeBillingAddressCode(@PathVariable("addrCode") String addrCode,@PathVariable("logTime") String logTime) throws ServiceException
	{
		List<LtMastBillingAddresses> ltP2pBillingAddresses = null;
		ltP2pBillingAddresses = ltP2pBillingAddressesService.getLikeBillingAddressCode(addrCode.trim());
		return new ResponseEntity<List<LtMastBillingAddresses>>(ltP2pBillingAddresses, HttpStatus.OK);
	}
	
	
		@RequestMapping(value = "/getByBillingId/{billingId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastBillingAddresses> getByBillingId(@PathVariable("billingId") Long billingId,@PathVariable("logTime") String logTime) throws ServiceException {
			LtMastBillingAddresses ltP2pBillingAddresses =  ltP2pBillingAddressesService.getByBillingId(billingId);
			return new ResponseEntity<LtMastBillingAddresses>(ltP2pBillingAddresses, HttpStatus.OK);
		}
	
		@RequestMapping(value = "/getBillingAddressesByVendorId/{vendorId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastBillingAddresses>> getByBillingAddressesByVendorId(@PathVariable("vendorId") Long vendorId,@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtMastBillingAddresses> ltP2pBillingAddresses = null;
			ltP2pBillingAddresses = ltP2pBillingAddressesService.getByBillingAddresses(name);
			return new ResponseEntity<List<LtMastBillingAddresses>>(ltP2pBillingAddresses, HttpStatus.OK);
		}
	
				
		@RequestMapping(value = "/getLikeBillingAddressByVendorState/{venId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastBillingAddresses>> getLikeBillingAddressByVendorState(@PathVariable("venId") Long venId,@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException
		{
			List<LtMastBillingAddresses> ltP2pBillingAddresses = null;
			ltP2pBillingAddresses = ltP2pBillingAddressesService.getLikeBillingAddressByState(venId, name);
			return new ResponseEntity<List<LtMastBillingAddresses>>(ltP2pBillingAddresses, HttpStatus.OK);
		}
			
				
				
	//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/savebillingaddresses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveBillingAddresses(@RequestBody LtMastBillingAddresses ltP2pBillingAddresses) throws ServiceException	{
		try {
			return ltP2pBillingAddressesService.save(ltP2pBillingAddresses);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}
	//----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/updatebillingaddresses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateBillingaddresses(@RequestBody LtMastBillingAddresses ltP2pBillingAddresses) throws ServiceException	{
		try {
			return ltP2pBillingAddressesService.update(ltP2pBillingAddresses);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
		
	}
	//-----------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/BillingAddresses/BillingAddresses', 'Delete')")
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> deleteLtP2pBillingAddressesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			try {
				return ltP2pBillingAddressesService.delete(id);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			
		}
				
}
