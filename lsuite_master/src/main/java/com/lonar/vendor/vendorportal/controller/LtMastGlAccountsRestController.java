package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastGlAccountsRepository;
import com.lonar.vendor.vendorportal.service.LtMastGlAccountsService;

@RestController
@RequestMapping("/API/glaccount")
public class LtMastGlAccountsRestController implements CodeMaster {
	final String restBaseUrl = "/API/glaccount";
	static final Logger logger = Logger.getLogger(LtMastGlAccountsRestController.class);
	@Autowired
	LtMastGlAccountsRepository ltMastGlAccountsRepository;
	@Autowired
	LtMastGlAccountsService ltMastGlAccountsService;

	
		@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtMastEmployeesDataTable(@PathVariable("companyId") Long companyId,LtMastGlAccounts input,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
					Long count=ltMastGlAccountsService.getCount(companyId,input);
				    customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    List<LtMastGlAccounts> ltMastEmployeesList= ltMastGlAccountsService.getDatatableRecords(companyId,input);
				    customeDataTable.setData(ltMastEmployeesList);	
			} 
			catch (Exception e) 
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return customeDataTable;
			
		}
		
	// -------------------Retrieve All GlAccount Details-----------------------------
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGlAccounts>> listLtP2pGlAccountsAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastGlAccounts> ltP2pGlAccounts =ltMastGlAccountsService.findAll(companyId);
		return new ResponseEntity<List<LtMastGlAccounts>>(ltP2pGlAccounts, HttpStatus.OK);
	}

	// -------------------Retrieve All Active GlAccount Details-----------------------------
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGlAccounts>> listAllActiveLtP2pGlAccounts(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastGlAccounts> ltMastGlAccountsList =(List<LtMastGlAccounts>) ltMastGlAccountsService.findAllActive(companyId);
		return new ResponseEntity<List<LtMastGlAccounts>>(ltMastGlAccountsList, HttpStatus.OK);
	}
	// -------------------Retrieve Active Like GlAccount Name details----------------------------
		@RequestMapping(value = "/getActiveLikeName/{companyId}/{accountName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastGlAccounts>> getActiveLikeCategoryName(@PathVariable("accountName") String accountName,
				@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtMastGlAccounts> ltMastGlAccountsList = ltMastGlAccountsService.findActiveLikeAccountName(accountName.trim(),companyId);
			return new ResponseEntity<List<LtMastGlAccounts>>(ltMastGlAccountsList, HttpStatus.OK);
		}
	// -------------------Retrieve Like Category Namedetails----------------------------
		@RequestMapping(value = "/getLikeName/{accountName}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastGlAccounts>> getLikeCategoryName(@PathVariable("accountName") String accountName,
				@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtMastGlAccounts> ltMastGlAccountsList = ltMastGlAccountsService.findLikeAccountName(accountName.trim(),companyId);
			return new ResponseEntity<List<LtMastGlAccounts>>(ltMastGlAccountsList, HttpStatus.OK);
		}
	// -------------------Retrieve Single GlAccount Details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastGlAccounts> getLtMastGlAccountsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastGlAccounts ltMastGlAccounts =ltMastGlAccountsService.getLtMastGlAccountsByID(id);
			
		return new ResponseEntity<LtMastGlAccounts>(ltMastGlAccounts, HttpStatus.OK);
	}

	// -------------------Create and update GlAccount Details-----------------
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtP2pGlAccounts(@RequestBody @Valid LtMastGlAccounts ltMastGlAccounts) throws ServiceException {
		Status status = new Status();
		try {
			status=ltMastGlAccountsService.save(ltMastGlAccounts);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
		
	// -------------------Create and update GlAccount Details-----------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtP2pGlAccounts(@RequestBody @Valid LtMastGlAccounts ltMastGlAccounts) throws ServiceException {
		Status status = new Status();
		try {
			status=ltMastGlAccountsService.update(ltMastGlAccounts);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}		

	// -------------------Delete Single GlAccount Details----------------------------
	@RequestMapping(value = "/delete/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pGlAccountsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltMastGlAccountsService.delete(id);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

}