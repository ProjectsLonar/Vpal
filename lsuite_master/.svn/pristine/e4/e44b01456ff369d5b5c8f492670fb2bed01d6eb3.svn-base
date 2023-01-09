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
import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastTaxesRepository;
import com.lonar.vendor.vendorportal.service.LtMastTaxesService;

@RestController
@RequestMapping("/API/taxes")
public class LtMastTaxesRestController implements CodeMaster{
	final String restBaseUrl = "/API/taxes";
	static final Logger logger = Logger.getLogger(LtMastTaxesRestController.class);
	@Autowired
	LtMastTaxesRepository ltP2pTaxesRepository;
	@Autowired
	LtMastTaxesService ltP2pTaxesService;

	
	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastEmployeesDataTable(@PathVariable("companyId") Long companyId,LtMastTaxes input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
			Long count=ltP2pTaxesService.getCount(companyId,input);
			
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastTaxes> ltMastTaxList= ltP2pTaxesService.getDatatableRecords(companyId,input);
			
			customeDataTable.setData(ltMastTaxList);	
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	// -------------------Retrieve All Tax details-----------------------------
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastTaxes>> listLtMastTaxesAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastTaxes>>) ltP2pTaxesService.getAll(companyId);
		
	}

	@RequestMapping(value = "/getActiveLikeTaxName/{taxName}/{companyId}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastTaxes>> getActiveLikeTaxName(@PathVariable("taxName") String taxName,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		
		List<LtMastTaxes> list = ltP2pTaxesService.findActiveLikeTaxName(taxName,companyId);
		return new ResponseEntity<List<LtMastTaxes>>(list, HttpStatus.OK);
	}

	// -------------------Retrieve All Active Tax details-----------------------------
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastTaxes>> listAllActiveLtMastTaxes(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
				
		List<LtMastTaxes> list = ltP2pTaxesService.findAllActive(companyId);
		return new ResponseEntity<List<LtMastTaxes>>(list, HttpStatus.OK);
		}
				
	// -------------------Retrieve Single Tax details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastTaxes> getLtP2pTaxesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltP2pTaxesService.getById(id);
			
	}

	
	// -------------------Create and update Tax details-----------------
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveLtMastTaxes(@RequestBody @Valid LtMastTaxes ltP2pTaxes) throws ServiceException {
		return ltP2pTaxesService.save(ltP2pTaxes);
		}
	// -------------------Create and update Tax details-----------------
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastTaxes(@RequestBody @Valid LtMastTaxes ltP2pTaxes) throws ServiceException {
		return ltP2pTaxesService.update(ltP2pTaxes);
	}
	
	// -------------------Create and update Tax details-----------------
	@RequestMapping(value = "/delete/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> delete(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			return ltP2pTaxesService.delete(id);
		}
	

}