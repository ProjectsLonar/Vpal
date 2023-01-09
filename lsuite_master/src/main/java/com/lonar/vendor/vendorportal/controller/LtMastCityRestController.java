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
import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.LtMastCity;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCityService;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;

@RestController
@RequestMapping("/API/city")
public class LtMastCityRestController implements CodeMaster {

	@Autowired
	LtMastCityService ltMastCityService;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	// ---------------------------------------------------------------------------------------------------
	// @PreAuthorize("hasPermission(null, '#/city/city', 'View')")
	@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getCityDataTable1(LtMastCity input,@PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltMastCityService.getCount(input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastCity> ltMastCityList = ltMastCityService.getCityDataTableRecords(input);
			customeDataTable.setData(ltMastCityList);

		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;

	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'getAll')")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCity>> listLtMastCityAll(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastCity> list = ltMastCityService.findAll();
		return new ResponseEntity<List<LtMastCity>>(list, HttpStatus.OK);
	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'getAllActive')")
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCity>> listAllActiveLtMastCity(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastCity> list = ltMastCityService.findAllActive();
		return new ResponseEntity<List<LtMastCity>>(list, HttpStatus.OK);
	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'View')")
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastCity> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastCity ltMastCity = ltMastCityService.getByID(id);
		return new ResponseEntity<LtMastCity>(ltMastCity, HttpStatus.OK);
	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'View')")
	@RequestMapping(value = "/getLikeName/{cityname}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCity>> getLtMastCityLikeName(@PathVariable("cityname") String cityname)
			throws ServiceException {
		List<LtMastCity> list = ltMastCityService.findActiveLikeCityName(cityname.trim());
		return new ResponseEntity<List<LtMastCity>>(list, HttpStatus.OK);
	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'Add')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastCity(@RequestBody LtMastCity ltMastCity) throws ServiceException, IOException {
		try {
			return ltMastCityService.save(ltMastCity);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'Update')")
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastCity(@RequestBody @Valid LtMastCity ltMastCity,
			BindingResult bindingResult) throws ServiceException, IOException {
		try {
			return ltMastCityService.update(ltMastCity);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		

	}

	// ====================================================================================================================
	// @PreAuthorize("hasPermission(null, '#/city/city', 'Delete')")
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastCityByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltMastCityService.delete(id);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		

	}
	
	//=============================================================================================================
	@RequestMapping(value = "/getaAuditRecords/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastAuditRecords>> getLtMastCityAudit(@PathVariable("id") Long cityId,@PathVariable("logTime") String logTime)
			throws ServiceException {
		List<LtMastAuditRecords> list = ltMastCityService.getLtMastCityAudit(cityId);
		return new ResponseEntity<List<LtMastAuditRecords>>(list, HttpStatus.OK);
	}
	
	//=============================================================================================================
		@RequestMapping(value = "/getDifference", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastAuditRecords>> getDifference(@RequestBody  LtMastCity ltMastCity)
				throws ServiceException, IOException {
			List<LtMastAuditRecords> list = ltMastCityService.getDifference(ltMastCity);
			return new ResponseEntity<List<LtMastAuditRecords>>(list, HttpStatus.OK);
		}
	
	
}
