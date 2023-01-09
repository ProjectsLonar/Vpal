package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastBranchesService;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;

@RestController
@RequestMapping("/API/branch")
public class LtMastBranchesRestController implements CodeMaster
{
	@Autowired
	LtMastBranchesService ltMastBranchesService;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
		
//---------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getBranchDataTable1(@PathVariable("companyId") Long companyId, LtMastBranches input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastBranchesService.getCount(companyId, input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastBranches> ltMastBranchesList= 
			    		ltMastBranchesService.getBranchDataTableRecords(companyId, input);
				customeDataTable.setData(ltMastBranchesList);	
			  
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
		
	}
//====================================================================================================================
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> listLtMastBranchesAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws  ServiceException {
		List<LtMastBranches> list =  ltMastBranchesService.findAll(companyId);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> listAllActiveLtMastBranches(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list =   ltMastBranchesService.findAllActive(companyId);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}
	
	
//====================================================================================================================
	@RequestMapping(value = "/getAllActiveBillingAddress/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getAllActiveBillingAddress(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list =   ltMastBranchesService.getAllActiveBillingAddress(companyId);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}	

//====================================================================================================================
	@RequestMapping(value = "/getAllActiveBillingAddrByBuyer/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getAllActiveBillingAddrByBuyer(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list =   ltMastBranchesService.getAllActiveBillingAddrByBuyer(id);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}
//====================================================================================================================
	@RequestMapping(value = "/getAllActiveShippingAddress/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getAllActiveShippingAddress(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list =   ltMastBranchesService.getAllActiveShippingAddress(companyId);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}	
//====================================================================================================================
	@RequestMapping(value = "/getAllActiveShippingAddressByBuyer/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getAllActiveShippingAddrByBuyer(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list =   ltMastBranchesService.getAllActiveShippingAddrByBuyer(id);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}	
//====================================================================================================================
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastBranches> getLtMastBranchesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastBranches ltMastBranches =  ltMastBranchesService.getLtMastBranchesByID(id);
		return new ResponseEntity<LtMastBranches>(ltMastBranches, HttpStatus.OK);
	}
//====================================================================================================================
	@RequestMapping(value = "/getByCompanyID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getLtMastBranchesByCompID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> ltMastBranches =  ltMastBranchesService.getLtMastBranchesByCompID(id);
		return new ResponseEntity<List<LtMastBranches>>(ltMastBranches, HttpStatus.OK);
	}

//====================================================================================================================
	@RequestMapping(value = "/getLikeName/{branchname}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getLtMastLikeName(@PathVariable("branchname") String branchname, @PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list = ltMastBranchesService.findActiveLikeBranchName(branchname.trim(), companyId);
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}
//====================================================================================================================
	@RequestMapping(value = "/getLikeNameByCompanyId/{id}/{branchname}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBranches>> getLtMastLikeNameByCompanyId(@PathVariable("id") Long id,@PathVariable("branchname") String branchname,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastBranches> list = ltMastBranchesService.getLtMastLikeNameByCompanyId(id,branchname.trim());
		return new ResponseEntity<List<LtMastBranches>>(list, HttpStatus.OK);
	}

//====================================================================================================================
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastBranches(@RequestBody @Valid LtMastBranches ltMastBranches,
			BindingResult bindingResult) throws ServiceException, IOException {
		try {
			return ltMastBranchesService.save(ltMastBranches,bindingResult);	
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}

//====================================================================================================================
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastBranch(@RequestBody @Valid LtMastBranches ltMastBranches,
			BindingResult bindingResult) throws ServiceException, IOException {
		try {
			return ltMastBranchesService.update(ltMastBranches);	
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}

//====================================================================================================================
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastBranchesByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltMastBranchesService.delete(id);	
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}

//====================================================================================================================

}