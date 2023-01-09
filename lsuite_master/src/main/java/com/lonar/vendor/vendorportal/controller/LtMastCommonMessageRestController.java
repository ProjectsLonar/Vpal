package com.lonar.vendor.vendorportal.controller;
import java.util.List;

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
import com.lonar.vendor.vendorportal.model.LtMastCommonMessage;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastCommonMessageRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterValuesService;

@RestController
@RequestMapping("/API/message")
public class LtMastCommonMessageRestController implements CodeMaster
{
	final String restBaseUrl = "/API/message";
	static final Logger logger = Logger.getLogger(LtMastCommonMessageRestController.class);
	@Autowired
	LtMastCommonMessageRepository ltMastCommonMessageRepository;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;

	
	//@PreAuthorize("hasPermission(null, '#/messages/messages', 'View')")
	@RequestMapping(value = "/dataTable1/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getCommonMessageDataTable(LtMastCommonMessage input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastCommonMessageService.getCount(input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastCommonMessage> ltMastCommonMessageList= 
			    		ltMastCommonMessageService.getCommonMessageDataTable(input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} 
		catch (Exception e) 
		{	
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
		
	}
	
	//--------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/messages/messages', 'View')")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastCommonMessage>> listLtMastCommonMessage(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		List<LtMastCommonMessage> ltMastCommonMessageList =  ltMastCommonMessageService.listLtMastCommonMessage();
		 return new ResponseEntity<List<LtMastCommonMessage>>(ltMastCommonMessageList, HttpStatus.OK);
	}
	
	// -------------------Retrieve Single message Details-------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/messages/messages', 'View')")
		@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastCommonMessage> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
		{
			return ltMastCommonMessageService.getByID(id);	
		}

	//------------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/messages/messages', 'Add')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastCommonMessage(@RequestBody LtMastCommonMessage ltMastCommonMessage) throws ServiceException 
	{
		try {
			return ltMastCommonMessageService.save(ltMastCommonMessage);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
	}
	//------------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/messages/messages', 'Update')")
	@RequestMapping(value = "/updateCommonMessage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> updateLtMastCommonMessage(@RequestBody LtMastCommonMessage mastCommonMessage) throws ServiceException 
		{
		try {
			return ltMastCommonMessageService.updateMessage(mastCommonMessage);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			
		}
		
		//------------------------------------------------------------------------------------------------------
	//@PreAuthorize("hasPermission(null, '#/messages/messages', 'Delete')")
	@RequestMapping(value = "/deleteCommonMessage/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastCommonMessage(@PathVariable("id") String id,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		try {
			return ltMastCommonMessageService.delete(id);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
	}
}
