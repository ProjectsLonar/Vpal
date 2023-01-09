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
import com.lonar.vendor.vendorportal.model.LtMastComnMaster;
import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastComnMasterRepository;
import com.lonar.vendor.vendorportal.repository.LtMastComnMasterValuesRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterValuesService;


@RestController
@RequestMapping("/API/comnmastervalue")
public class LtMastComnMasterValuesRestController implements CodeMaster {
	final String restBaseUrl = "/API/comnmastervalue";
	static final Logger logger = Logger.getLogger(LtMastComnMasterValuesRestController.class);
	@Autowired
	LtMastComnMasterValuesRepository ltMastComnMasterValuesRepository;
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	@Autowired
	LtMastComnMasterRepository ltMastComnMasterRepository;
	@Autowired
	LtMastComnMasterService ltMastComnMasterService;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	

	// -------------------Retrieve All commonmasterValue details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> listLtMastComnMasterValuesAll(@PathVariable("logTime") String logTime) throws ServiceException {
		
		return ltMastComnMasterValuesService.getAll();
		
	}

	// -------------------Retrieve All Active commonmasterValue details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> listAllActiveLtMastComnMasterValues(@PathVariable("logTime") String logTime) throws ServiceException {
		return ltMastComnMasterValuesService.getAllActive();
		
	}

	// -------------------Retrieve Single commonmasterValuedetails----------------------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastComnMasterValues> getLtMastComnMasterValuesByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltMastComnMasterValuesService.getLtMastComnMasterValuesByID(id);
		
	}
	
	// -------------------Retrieve Single commonmasterValuedetails----------------------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getByCommonMasterID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> getByCommonMasterID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltMastComnMasterValuesService.getByCommonMasterID(id);
			
	}
//---------------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getLikeByValueNameWithMaster/{masterId}/{valueName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getLikeByValueNameWithMaster(
			@PathVariable("masterId") String masterId, @PathVariable("valueName") String valueName,@PathVariable("logTime") String logTime) throws ServiceException {
		
		//List<LtMastComnMasterValues> ltMastComnMasterValues = null;
		
			List<LtMastComnMaster> ltMastComnMaster = (List<LtMastComnMaster>) ltMastComnMasterService.findByMasterName(masterId);
			if (!ltMastComnMaster.isEmpty())
			{

				return ltMastComnMasterValuesService
						.findLikeValueNameWithMasterId(ltMastComnMaster.get(0).getMasterId(), valueName.trim());
			}
	return new 	ResponseEntity(null, HttpStatus.OK);
		
	}

	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getLikeNameWithMaster/{masterName}/{valueName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> getLikeNameWithMaster(@PathVariable("masterName") String masterName,
			@PathVariable("valueName") String valueName,@PathVariable("logTime") String logTime) throws ServiceException {
		
			List<LtMastComnMasterValues> ltMastComnMasterValues = ltMastComnMasterService.getLikeNameWithMaster(masterName,valueName);
			return new ResponseEntity<List<LtMastComnMasterValues>>(ltMastComnMasterValues, HttpStatus.OK);
	}
	
	
	// -------------------Create and update commonmasterValue details-----------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'Add')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastComnMasterValues(
			@RequestBody @Valid LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException {
		try {
			return ltMastComnMasterValuesService.save(ltMastComnMasterValues);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}
	
	// -------------------Create and update commonmasterValue details-----------------
		//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'Add')")
		@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> updateLtMastComnMasterValues(
		@RequestBody @Valid LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException {
			try {
				return ltMastComnMasterValuesService.update(ltMastComnMasterValues);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
		}
//---------------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/commonMaster/commonMaster', 'View')")
	@RequestMapping(value = "/getByValueCode/{valuecode}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> getByCode(@PathVariable("valuecode") String valueCode,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtMastComnMasterValues> ltMastComnMasterValues = null;
		ltMastComnMasterValues = ltMastComnMasterValuesService.getByValueCode(valueCode);
		return new ResponseEntity<List<LtMastComnMasterValues>>(ltMastComnMasterValues, HttpStatus.OK);
	}

	// -------------------Delete Single commonmasterValue details----------------------------
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastComnMasterValuesByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) {
	
		Status status=new Status();
		try
		{
			if (ltMastComnMasterValuesRepository.exists(Long.parseLong(id))) 
			{
				ltMastComnMasterValuesRepository.delete(Long.parseLong(id));
			} 
			else 
			{
				status=ltMastCommonMessageService.getCodeAndMessage(NO_RESULT);
				return new ResponseEntity<Status>(status,HttpStatus.OK);

			}
		
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			return new ResponseEntity<Status>(status,HttpStatus.OK);

		} 
		catch (org.springframework.dao.DataIntegrityViolationException e) 
		{
			throw new BusinessException(ENTITY_CANNOT_DELETE, null, e);
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}

		
	}

}