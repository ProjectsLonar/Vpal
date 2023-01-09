package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastEmployeesService;

@RestController
@RequestMapping("/API/employer")
public class LtMastEmployeesRestController implements CodeMaster {

	final String restBaseUrl = "/API/employer";

	static final Logger logger = Logger.getLogger(LtMastEmployeesRestController.class);

	@Autowired
	LtMastEmployeesService ltMastEmployeesService;
//---------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastEmployeesDataTable(@PathVariable("companyId") Long companyId, LtMastEmployees input) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastEmployeesService.getCount(companyId, input);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastEmployees> ltMastEmployeesList= ltMastEmployeesService.getDatatableRecords(companyId, input);
			    customeDataTable.setData(ltMastEmployeesList);	
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
//=========================================================================================================
	@RequestMapping(value = "/getByUserID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmployeeDetailsByUserID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			 return ltMastEmployeesService.getEmployeeDetailsByUserID(id);
	}
	
	
	//======================================================================================================================
		@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity getLtMastEmployeesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException {
				return ltMastEmployeesService.getLtMastEmployeesByID(id);			
		}
	//=====================================================================================================================	
		@RequestMapping(value = "/getEmployeeImgByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity getEmployeeImgByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException {
			
				return ltMastEmployeesService.getEmployeeImgByID(id);			
		}

	//======================================================================================================================
		@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity listLtMastEmployeesAll(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
			return  ltMastEmployeesService.findAll(companyId);
		}	
	//======================================================================================================================
		
		@RequestMapping(value = "/getEmpByCompId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity listLtMastCompanyWiseEmployees(@PathVariable("id") Long compId,@PathVariable("logTime") String logTime) throws ServiceException {
			return  ltMastEmployeesService.companyWiseEmp(compId);
		}
	//=======================================================================================================================
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ResponseEntity<Status> saveLtMastEmployees(@RequestParam("ltMastEmployee") String ltMastEmployee,
				@RequestParam("file") MultipartFile[] files) throws ServiceException, ParseException, JsonParseException, JsonMappingException, IOException
		{
			
			Status status = new Status();
			JSONParser jsonparser = new JSONParser();
			JSONObject jsonInputObject = null;
			jsonInputObject =  (JSONObject) jsonparser.parse(ltMastEmployee);
			LtMastEmployees ltMastEmployees = new ObjectMapper().readValue(ltMastEmployee,
					LtMastEmployees.class);
			try {
				status=ltMastEmployeesService.save(ltMastEmployees,files);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

	//=====================================================================================================================
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public ResponseEntity<Status> updateLtMastEmployees(@RequestParam("ltMastEmployee") String ltMastEmployee,
				@RequestParam("file") MultipartFile[] files) throws ServiceException, ParseException, JsonParseException, JsonMappingException, IOException {
			
			Status status = new Status();
			JSONParser jsonparser = new JSONParser();
			JSONObject jsonInputObject = null;
			String stat = null;
			
				jsonInputObject = (JSONObject) jsonparser.parse(ltMastEmployee);
				LtMastEmployees ltMastEmployees = new ObjectMapper().readValue(ltMastEmployee,
						LtMastEmployees.class);
						ltMastEmployees.setLastUpdateDate(new Date());
						ltMastEmployees.setLastUpdatedBy(ltMastEmployees.getLastUpdateLogin());
						status= ltMastEmployeesService.update(ltMastEmployees,files);
					return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

	//=================================================================================================================
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = {
				MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public ResponseEntity<Status> deleteByIDLtMastEmployees(@PathVariable("id") Long id,@PathVariable("logTime") String logTimed) throws ServiceException  {
		return ltMastEmployeesService.delete(id);
		}

	//=================================================================================================================
		@RequestMapping(value = "/getLikeByName/{companyId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployees>>  getLtMastLikeByName(@PathVariable("companyId") Long companyId, @PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException {
		
			List<LtMastEmployees> ltMastEmployees =  ltMastEmployeesService.findByActiveLikeName(companyId, name.trim());
		return new ResponseEntity<List<LtMastEmployees>>(ltMastEmployees, HttpStatus.OK);
		}
		
		
	//===============================================================================================================
		@RequestMapping(value = "/getLikeNameByDivId/{name}/{divisionId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployees>> getLikeNameByDivId(@PathVariable("name") String name,@PathVariable("divisionId") String divisionId,@PathVariable("logTime") String logTime) throws ServiceException {
		
		return ltMastEmployeesService.getLikeNameByDivisionId(name, divisionId);

		}
		
	//===============================================================================================================
		@RequestMapping(value = "/getBuyerByDivId/{name}/{divisionId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployees>> getBuyerByDivId(@PathVariable("name") String name,@PathVariable("divisionId") String divisionId,@PathVariable("logTime") String logTime) throws ServiceException {
				
			return ltMastEmployeesService.getBuyerByDivId(name, divisionId);
		}
	//------------------------------------------------------------------------------------------------------------------	
		@RequestMapping(value = "/getLikeNameByComId/{companyId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployees>> getLikeNameByComId(@PathVariable("name") String name,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
			return ltMastEmployeesService.getLikeNameByComId(name, companyId);
		}
		
	//===============================================================================================================
		@RequestMapping(value = "/getBuyerByDivId/{divisionId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployees>> getAllBuyerByDivId(@PathVariable("divisionId") String divisionId,@PathVariable("logTime") String logTime) throws ServiceException {	
				return ltMastEmployeesService.getAllBuyerByDivId( divisionId);
		}	
	//================================================================================================================================	
		@RequestMapping(value = "/getLtMastEmployeesBySuperWiserId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastEmployees>> getLtMastEmployeesBySuperWiserId(@PathVariable("id") Long employeeId,@PathVariable("logTime") String logTime) throws ServiceException {
		
				return ltMastEmployeesService.getLtMastEmployeesBySuperWID(employeeId);			
			
		}

		
		//----------------------------------------------kb-----------------------------------------------------
		@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
		public ResponseEntity<Status> updateProfile(@RequestParam("file") MultipartFile[] files,
				@RequestParam("employeeId") Long employeeId) 
		{
		Status status = new Status();
			try {
				LtMastEmployees emp= new LtMastEmployees();
				emp.setEmployeeId(employeeId);
				if (files != null && files.length > 0) 
				{
					status = ltMastEmployeesService.updateProfile(files, emp);
				}
			}
			catch (Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		
		@RequestMapping(value = "/getCompanyByBuyer/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<Status> getCompanyByBuyer(@PathVariable("id") Long buyerId,@PathVariable("logTime") String logTime) throws ServiceException
		{
			Status status = new Status();
				 status =  ltMastEmployeesService.getCompanyByBuyer(buyerId);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
}