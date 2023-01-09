package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalDao;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;
import com.lonar.vendor.vendorportal.repository.LtMastModulesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastRoleModulesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastRolesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastUserRolesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastUsersRepository;
import com.lonar.vendor.vendorportal.repository.LtMastVendorsRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastComnMasterValuesService;
import com.lonar.vendor.vendorportal.service.LtMastDivisionsService;
import com.lonar.vendor.vendorportal.service.LtMastEmployeesService;
import com.lonar.vendor.vendorportal.service.LtMastModuleApprovalsService;
import com.lonar.vendor.vendorportal.service.LtMastModulesService;
import com.lonar.vendor.vendorportal.service.LtMastRoleModulesService;
import com.lonar.vendor.vendorportal.service.LtMastRolesService;
import com.lonar.vendor.vendorportal.service.LtMastVendorsService;

@RestController
@RequestMapping("/API/vendor")
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastVendorsController implements CodeMaster
{
	final String restBaseUrl = "/API/vendor";
	static final Logger logger = Logger.getLogger(LtMastVendorsController.class);
	
	private SecureRandom random = new SecureRandom();
	
	@Autowired
	LtMastVendorsService ltMastVendorsService;
	
	@Autowired
	LtMastModulesService ltMastModulesService;
	
	@Autowired
	LtMastRolesService ltMastRolesService;
	
	@Autowired
	LtMastRoleModulesService ltMastRoleModulesService;
	
	@Autowired
	LtMastDivisionsService ltMastDivisionsService;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorsRepository ltMastVendorsRepository;
	
	@Autowired
	LtMastEmployeesService ltMastEmployeesService;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
    LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	@Autowired
	LtMastUsersRepository ltMastUsersRepository;
	
	@Autowired
	LtMastUserRolesRepository ltMastUserRolesRepository;
	
	@Autowired
	LtMastModulesRepository ltMastModulesRepository;
	
	@Autowired
	LtMastRolesRepository ltMastRolesRepository;
	
	@Autowired
	LtMastRoleModulesRepository ltMastRoleModulesRepository;
	
	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;
	
	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtVendorApprovalDao ltVendorApprovalDao;
	
	@Autowired
	LtMastModuleApprovalsService ltMastModuleApprovalsService;
	
	@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorsDataTable(@PathVariable("companyId") Long companyId,LtMastVendors input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
				Long count=ltMastVendorsService.getLtMastVendorsCount(companyId,input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendors> ltMastCommonMessageList= 
			    		ltMastVendorsService.getLtMastVendorsDataTable(companyId,input);
				customeDataTable.setData(ltMastCommonMessageList);	
		} catch (Exception e) {	
			 e.printStackTrace();
		}
		return customeDataTable;
		
	}
	
	@RequestMapping(value = "/vendorDataTableByInitiator/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorsDataTableByInitiatorId(LtMastVendors input,@PathVariable("id") Long initiatorId,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
				Long count=ltMastVendorsService.getLtMastVendorsCountByInitiatorId(input,initiatorId);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastVendors> ltMastVendorsList= 
			    		ltMastVendorsService.getLtMastVendorsDataTableByInitiatorId(input,initiatorId);
				customeDataTable.setData(ltMastVendorsList);	
		} catch (Exception e) {	
			logger.error("ERROR "+ e );
			 e.printStackTrace();
		}
		return customeDataTable;
		
	}
	
	@RequestMapping(value = "/getAllVendors/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendors>> getAllVendors(@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList=  ltMastVendorsService.getAllVendors();
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllVendorsByInitiator/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendors>> getAllVendorsByInitiator(@PathVariable("id") Long initiatorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList=  ltMastVendorsService.getAllVendorsByInitiator(initiatorId);
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getactivevendors/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<LtMastVendors>> getAllActiveVendors(@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList =  ltMastVendorsService.getAllActiveVendors();
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorsbycompany/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<LtMastVendors>> getAllVendorsByCompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList =  ltMastVendorsService.getAllVendorsByCompanyId(companyId);
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorbyname/{companyId}/{name}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<LtMastVendors>> getActiveVendorByName(@PathVariable("companyId") Long companyId,@PathVariable("name") String vendorName,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList= ltMastVendorsService.getActiveVendorByName(companyId,vendorName);
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getvendor/{companyId}/{name}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<LtMastVendors>> getVendorByName(@PathVariable("companyId") Long companyId,@PathVariable("name") String vendorName,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList= ltMastVendorsService.getVendorByName(companyId,vendorName);
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getactivevendorbynameanddivision/{name}/{division}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<LtMastVendors>> getActiveVendorByNameAndDivId(@PathVariable("name") String vendorName,
			 @PathVariable("division") Long divId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendorList=  ltMastVendorsService.getActiveVendorByNameAndDivId(vendorName,divId);
			return new ResponseEntity<List<LtMastVendors>>(vendorList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendors> getVendorById(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtMastVendors vendor = ltMastVendorsService.getVendorById(vendorId);
			return new ResponseEntity<LtMastVendors>(vendor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendornamebyid/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status getVendorNameById(@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime) throws Exception 
	{
			return ltMastVendorsService.getVendorNameById(vendorId);
	}
	
	@RequestMapping(value = "/getPanByvendorbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LtMastVendors> getPanByvendorbyid(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			LtMastVendors vendor = ltMastVendorsService.getPanByvendorbyid(vendorId);
			return new ResponseEntity<LtMastVendors>(vendor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getstatusvendorbyid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	public ResponseEntity<LtMastVendors> getStatusVendorById(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		LtMastVendors vendor = ltMastVendorsService.getStatusVendorById(vendorId);
		return new ResponseEntity<LtMastVendors>(vendor, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/getvendorbydivisionid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendors>> getVendorByDivId(@PathVariable("id") Long divId,@PathVariable("logTime") String logTime) throws ServiceException
	{
			List<LtMastVendors> vendor=ltMastVendorsService.getVendorByDivId(divId);
			return new ResponseEntity<List<LtMastVendors>>(vendor, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtMastVendors vendors) throws ServiceException
	{
			Status status=new Status();
			status =  ltMastVendorsService.save(vendors);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/save", method= RequestMethod.POST)
    public ResponseEntity<Status> save(@RequestParam("ltMastVendors") String ltMastVendors,
			@RequestParam("file") MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException
	{
			Status status=new Status();
			JSONParser jsonparser = new JSONParser();
			JSONObject jsonInputObject = null;
			jsonInputObject =  (JSONObject) jsonparser.parse(ltMastVendors);
			LtMastVendors ltMastVendor = new ObjectMapper().readValue(ltMastVendors,
					LtMastVendors.class);
			status =  ltMastVendorsService.saveWithAttachment(ltMastVendor,files);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/update", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> update(@RequestBody LtMastVendors vendors) throws ServiceException
	{
			Status status=new Status();
			status =  ltMastVendorsService.update(vendors);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestParam("ltMastVendors") String ltMastVendors,
			@RequestParam("file") MultipartFile[] files) throws ServiceException, ParseException, JsonParseException, JsonMappingException, IOException
	{
		Status status=new Status();
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		jsonInputObject =  (JSONObject) jsonparser.parse(ltMastVendors);
		LtMastVendors ltMastVendor = new ObjectMapper().readValue(ltMastVendors,
				LtMastVendors.class);
			status =  ltMastVendorsService.updateWithAttachment(ltMastVendor,files);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateAttachment/{vendorId}", method= RequestMethod.POST)
    public ResponseEntity<Status> updateAttachment(@PathVariable("vendorId") Long vendorId,
			@RequestParam("file") MultipartFile[] files) throws ServiceException, ParseException, JsonParseException, JsonMappingException, IOException
	{
		Status status=new Status();
		status =  ltMastVendorsService.updateAttachment(vendorId,files);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
	{
			Status status=new Status();
			try
			{
			 status =  ltMastVendorsService.delete(vendorId);
			}
			catch (org.springframework.dao.DataIntegrityViolationException e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
			} 
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/vendorInvite", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> vendorInvite( @RequestBody LtMastVendors ltMastVendors) throws ServiceException
	{
		Status status = new Status();
		//LtMastVendors vendor = ltMastVendorsService.getByEMailId(ltMastVendors.getRegistrationEmail(),ltMastVendors.getCompanyId());
		LtMastVendors vendor = ltMastVendorsService.getByRegistrationMailId(ltMastVendors.getRegistrationEmail(),ltMastVendors.getCompanyId());
		if(vendor!=null) {
			status.setCode(INSERT_FAIL);
			status.setMessage("Vendor Registration email address already exists.");
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveVendorInvite", method = RequestMethod.POST)
	public ResponseEntity<Status> saveVendorInvite( @RequestParam("vendorsList") String vendorsList,
			@RequestParam("file") MultipartFile[] files)
	{
		Status status = new Status();
		try {
		return ltMastVendorsService.saveVendorInvite(vendorsList,files);
		}catch(Exception e) {
			e.printStackTrace();
			
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage("Vendor Email Id already exists!");
			e.printStackTrace();
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	}
	
	/*@RequestMapping(value = "/saveVendorInvite", method = RequestMethod.POST)
	public ResponseEntity<Status> saveVendorInvite( @RequestBody List<LtMastVendors> ltMastVendorsList,
			@RequestParam("file") MultipartFile[] files)
	{
		Status status = new Status();
		try {
		return ltMastVendorsService.saveVendorInvite(ltMastVendorsList,files);
		}catch(Exception e) {
			e.printStackTrace();
			
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage("Vendor Email Id already exists!");
			e.printStackTrace();
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	}*/

	public String passwordGenater(String input) 
	{
		String shaVesion = "SHA-256";
		
		MessageDigest digest = null;
		StringBuffer hexString = new StringBuffer();
		try {
			digest = MessageDigest.getInstance(shaVesion);

			byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
				for (int i = 0; i < encodedhash.length; i++) {
					String hex = Integer.toHexString(0xff & encodedhash[i]);
					if (hex.length() == 1)
						hexString.append('0');
						hexString.append(hex);
				}
		} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return hexString.toString();
	}
	
	public String getToken() {
		String token = new BigInteger(130, random).toString(32);
		
		return token;
	}
	
	@RequestMapping(value = "/submitforapproval/{vendorId}/{logTime}", method = RequestMethod.GET)
	public ResponseEntity<Status> submitForApproval( @PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime)
	{
		Status status=new Status();
		try
		{		
			String stat =checkforApprovals(vendorId);
			if(stat.equals("null"))
			{
				status.setCode(FAIL);
				status.setMessage("No approvers found for employee's division.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}else {
			
			status=ltMastVendorsService.submitForApproval(new Date(),vendorId,INPROCESS,null);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}


	private String checkforApprovals(Long vendorId) throws ServiceException 
	{
		//String stat = ltMastModuleApprovalsService.checkforApprovals(vendorId);
		String stat = ltMastVendorsService.checkforApprovals(vendorId);
		return stat;
	}
	
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		Status status = new Status();
			 status =  ltMastVendorsService.checkRecord(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCompanyByVendor/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> getCompanyByVendor(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		Status status = new Status();
			 status =  ltMastVendorsService.getCompanyByVendor(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
