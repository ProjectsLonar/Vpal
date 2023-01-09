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
import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastCostCentersRepository;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeesRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterValuesService;
import com.lonar.vendor.vendorportal.service.LtMastCostCentersService;
import com.lonar.vendor.vendorportal.service.LtMastEmployeesService;



@RestController
@RequestMapping("/API/costcenter")
public class LtMastCostCentersRestController implements CodeMaster {
	final String restBaseUrl = "/API/costcenter";
	// #/costCenter/costCenter
	static final Logger logger = Logger.getLogger(LtMastCostCentersRestController.class);
	@Autowired
	LtMastCostCentersRepository ltMastCostCentersRepository;
	
	@Autowired
	LtMastCostCentersService ltMastCostCentersService;
	@Autowired
	LtMastEmployeesRepository ltMastEmployeesRepository;
	@Autowired
	LtMastEmployeesService ltMastEmployeesService;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	//---------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(@PathVariable("companyId") Long companyId, LtMastCostCenters input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastCostCentersService.getCount(companyId, input);
				
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    
				List<LtMastCostCenters> ltMastCostCentersList= ltMastCostCentersService.getDataTable(companyId, input);
				
				customeDataTable.setData(ltMastCostCentersList);
			
		} 
		catch (Exception e) 
		{		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	
		return customeDataTable;
	}


//======================================================================================================================
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCostCenters>> listLtMastCostCentersAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltMastCostCentersService.getAll(companyId);
	}

//=======================================================================================================================
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCostCenters>> listAllActiveLtMastCostCenters(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		return   ltMastCostCentersService.findAllActive(companyId);
		
		
	}

//================================================================================================================================
	@RequestMapping(value = "/getLikeCostName/{costName}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCostCenters>> listLikeModuleName(@PathVariable("costName") String costName, @PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastCostCenters> list =    ltMastCostCentersService.findByLikeCostCentersName(costName, companyId);
		return new ResponseEntity<List<LtMastCostCenters>>(list, HttpStatus.OK);
	}

//======================================================================================================================================
	@RequestMapping(value = "/getActiveLikeCostName/{companyId}/{costName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCostCenters>> listActiveLikeCostName(@PathVariable("companyId") Long companyId, @PathVariable("costName") String costName,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastCostCenters> list = ltMastCostCentersService.findByActiveLikeCostCentersName(companyId, costName);
		return new ResponseEntity<List<LtMastCostCenters>>(list, HttpStatus.OK);
	}

//=====================================================================================================================
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastCostCenters> getLtMastCostCentersByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException {
		LtMastCostCenters ltMastCostCenters = ltMastCostCentersService.getLtMastCostCentersByID(id);
			
		return new ResponseEntity<LtMastCostCenters>(ltMastCostCenters, HttpStatus.OK);
	}

//=============================================================================================================
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastCostCenters(@RequestBody @Valid LtMastCostCenters ltMastCostCenters) throws ServiceException {
		try {
			return ltMastCostCentersService.save(ltMastCostCenters);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
//=======================================================================================================================
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastCostCenters(@RequestBody @Valid LtMastCostCenters ltMastCostCenters) throws ServiceException {
		try {
			return ltMastCostCentersService.update(ltMastCostCenters);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
//========================================================================================================================
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastCostCentersByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltMastCostCentersService.delete(id);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}
//=======================================================================================================================
}