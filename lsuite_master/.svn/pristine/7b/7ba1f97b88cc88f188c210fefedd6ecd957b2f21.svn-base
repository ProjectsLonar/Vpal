package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.lonar.vendor.vendorportal.model.CompanyMgmt;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtVendCompanyService;

@RestController
@RequestMapping("/API/vedcompany")
public class LtVendCompanyRestController implements CodeMaster
{
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendCompanyService ltVendCompanyService;
	
	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtVendCompanyDataTable1(@PathVariable("companyId") Long companyId,LtVendCompany input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltVendCompanyService.getCount(companyId,input);
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtVendCompany> ltMastCompanyList= ltVendCompanyService.getDatatableRecords(companyId,input);
				customeDataTable.setData(ltMastCompanyList);	
		} 
		catch (Exception e) 
		{	
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
		
	}

	@RequestMapping(value = "/getVedCompanyBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtVendCompany> getLtVendMastCompanyBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltVendCompanyService.getLtMastCompanyBycompanyId(companyId);
	}
	
	
	@RequestMapping(value = "/getVendorMasterMgmtBycompanyId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyMgmt>> getVendorMasterMgmtBycompanyId(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltVendCompanyService.getMasterMgmtBycompanyId(companyId);
	}
	
	@RequestMapping(value = "/getLikecompanyName/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompany>> getCompanyLikecompanyName(@PathVariable("name") String companyName,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltVendCompanyService.getLtVendMastCompanyLikecompanyName(companyName);
	}
	
	@RequestMapping(value = "/getAllLtVendCompany/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompany>> getAllLtVendMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltVendCompanyService.getAllLtVendMastCompany();
	}
	
	@RequestMapping(value = "/getAllActiveLtVendCompany/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtVendCompany>> getAllActiveLtVendMastCompany(@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltVendCompanyService.getAllActiveLtVendMastCompany();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Status> savewithlogo(@RequestParam("ltVendCompany") String strltMastCompany,
			@RequestParam("file") MultipartFile[] files) throws JsonParseException, JsonMappingException, ServiceException, IOException, Exception
	{
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		jsonInputObject =  (JSONObject) jsonparser.parse(strltMastCompany);
		LtVendCompany ltVendMastCompany = new ObjectMapper().readValue(strltMastCompany,
				LtVendCompany.class);
		return ltVendCompanyService.save(ltVendMastCompany,files);
		
	}

	
	@RequestMapping(value = "/update", method= RequestMethod.POST)
    public ResponseEntity<Status> update(@RequestParam("ltVendCompany") String company ,@RequestParam("file") MultipartFile[] files)
	{
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
			Status status=new Status();
			try
			{
				jsonInputObject = (JSONObject) jsonparser.parse(company);
				LtVendCompany ltMastCompany = new ObjectMapper().readValue(company,
						LtVendCompany.class);
				status =  ltVendCompanyService.update(ltMastCompany,files);
			}
			catch(Exception e)
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteAttachment/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> deleteAttachment(@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		Status status =  ltVendCompanyService.deleteAttachment(companyId);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}
	
	//@PreAuthorize("hasPermission(null, '#/companyMaster/companyMaster', 'Delete')")
	@RequestMapping(value = "/delete/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<Status> delete(@PathVariable("id") String companyId,@PathVariable("logTime") String logTime) throws NumberFormatException, ServiceException
	{
		return ltVendCompanyService.delete(Long.parseLong(companyId));
		
	}
}
