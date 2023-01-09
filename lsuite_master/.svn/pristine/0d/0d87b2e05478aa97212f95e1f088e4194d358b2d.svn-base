package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import com.lonar.vendor.vendorportal.model.CommonMasterWithValue;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
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
@RequestMapping("/API/commmaster")
public class LtMastComnMasterRestController implements CodeMaster 
{
	final String restBaseUrl = "/API/commmaster";
	static final Logger logger = Logger.getLogger(LtMastComnMasterRestController.class);
	@Autowired
	LtMastComnMasterRepository ltMastComnMasterRepository;
	@Autowired
	LtMastComnMasterService ltMastComnMasterService;
	@Autowired
	LtMastComnMasterValuesRepository ltMastComnMasterValuesRepository;
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	
	
	//==========================================================================================================
	@RequestMapping(value = "/dataTable1/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(@Valid LtMastComnMaster input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltMastComnMasterService.getCount(input);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
				List<LtMastComnMaster> ltMastComnMasterList= ltMastComnMasterService.getDataTable(input);
				customeDataTable.setData(ltMastComnMasterList);
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	//============================================================================================================
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getLtMastComnMasterByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException
	{
				return ltMastComnMasterService.getLtMastComnMasterByID(Long.parseLong(id));
	}
	
	//==========================================================================================================
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity listLtMastComnMasterAll(@PathVariable("logTime") String logTime) 
	{
			return  (ResponseEntity) ltMastComnMasterRepository.findAll();	
	}
	
	//============================================================================================================
	@RequestMapping(value = "/getActiveLikeName/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> listLtMastComnMastergetAllActiveMastersWithValue(@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException 
	{
			return ltMastComnMasterValuesService.findByCommanMasterName(name.trim());
	}
	
	
	@RequestMapping(value = "/getMasterList/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastComnMasterValues>> getMasterList(@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException 
	{
			return ltMastComnMasterValuesService.getMasterList(name.trim());
	}
	//---------------------save commonmasterwithvalues-------------------------------------------------------------------
	@RequestMapping(value = "/saveMasterWithValue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveMasterWithValue(@Valid @RequestBody CommonMasterWithValue commonMasterWithValue,
			BindingResult bindingResult) 
	{
		try {
			return ltMastComnMasterService.saveMasterWithValue(commonMasterWithValue,bindingResult);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
	}
	
	//---------------------save commonmaster-------------------------------------------------------------------
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveMasterWithValue(@Valid @RequestBody LtMastComnMaster LtMastComnMaster,
				BindingResult bindingResult) throws ServiceException 
		{
			try {
				return ltMastComnMasterService.save(LtMastComnMaster);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			
		}
	// -------------------Delete Single CommonMaster details----------------------------
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastComnMasterByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException 
	{
		try {
			return ltMastComnMasterService.deleteLtMastComnMasterByID(id);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
		
	}
	//--------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/deleteComnMasterValuesByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastComnMasterValuesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		try {
			return ltMastComnMasterService.delete(id);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}
		
	//==========================================================================================================
	@RequestMapping(value = "/getByMasterId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonMasterWithValue> listLtMastComnMasterAll(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		CommonMasterWithValue commonMasterWithValue = new CommonMasterWithValue();
		commonMasterWithValue=ltMastComnMasterService.getById(id);
		return new ResponseEntity<CommonMasterWithValue>(commonMasterWithValue, HttpStatus.OK);
	}
			
			
	//---------------------update commonmaster
	@RequestMapping(value = "/updateMasterWithValue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateMasterWithValue(@Valid @RequestBody CommonMasterWithValue commonMasterWithValue,
					BindingResult bindingResult) throws ServiceException 
	{
		try {
			return ltMastComnMasterService.updateMasterWithValue(commonMasterWithValue);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> update(@Valid @RequestBody LtMastComnMaster ltMastComnMaster) throws ServiceException 
	{
		try {
			return ltMastComnMasterService.update(ltMastComnMaster);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
	}
		
}