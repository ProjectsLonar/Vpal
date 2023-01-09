package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
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
import com.lonar.vendor.vendorportal.model.LtMastProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastProductsService;

@RestController
@RequestMapping("/API/product")
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastProductsRestController implements CodeMaster {
	final String restBaseUrl = "/API/product";
	static final Logger logger = Logger.getLogger(LtMastProductsRestController.class);
	
	@Autowired
	LtMastProductsService ltP2pProductsService;
	
	//-------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastProducts input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
			Long count=ltP2pProductsService.getCount(input,companyId);
						
		    customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
					    
			List<LtMastProducts> ltP2pProdList= ltP2pProductsService.getDataTable(input,companyId);
			customeDataTable.setData(ltP2pProdList);
					
		} catch (Exception e) 
		{		
				e.printStackTrace();
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
			
	// -------------------Retrieve All Products-----------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProducts>> listLtP2pProductsAll(@PathVariable("logTime") String logTime) throws ServiceException {
		return ltP2pProductsService.getAll();
	}

	// -------------------Retrieve All Active Products-----------------------------
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProducts>> listAllActiveLtP2pProducts(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProducts> list = ltP2pProductsService.findAllActive();	
		return new ResponseEntity<List<LtMastProducts>>(list, HttpStatus.OK);	
	}
	//-----------------------------------------------------------------------------
	@RequestMapping(value = "/getActiveLikeName/{id}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProducts>> listActiveLikeName(@PathVariable("name") String name,@PathVariable("id") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
			
		List<LtMastProducts> list = ltP2pProductsService.findActiveLikeName(name.trim(),companyId);
		return new ResponseEntity<List<LtMastProducts>>(list, HttpStatus.OK);
	}

	//-----------------------------------------------------------------------------
	@RequestMapping(value = "/getActiveLikeName/{catId}/{subcatId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProducts>> listActiveLikeNameByCategory(@PathVariable("name") String name,
			@PathVariable("catId") Long catId ,@PathVariable("subcatId") Long subcatId,@PathVariable("logTime") String logTime) throws ServiceException {
				
		if(subcatId==0) {
			subcatId = null;
		}
		List<LtMastProducts> list = ltP2pProductsService.listActiveLikeNameByCategory(name.trim(),catId,subcatId);
		return new ResponseEntity<List<LtMastProducts>>(list, HttpStatus.OK);
	}
	
	// -------------------Retrieve Single Products----------------------------
		@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastProducts> getLtMastProductsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
				return ltP2pProductsService.findOne(id);	
		}
		
	//------------------------------------------------------------------------	
		@RequestMapping(value = "/saveproductwithfile", method = RequestMethod.POST)
		public ResponseEntity<Status> saveWithLtP2pProducts(@RequestParam("uploadfile") MultipartFile[] uploadfile,
					@RequestParam("ltMastProducts") String data) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException 
		{
			try {
			JSONParser jsonparser = new JSONParser();
			JSONObject jsonInputObject = null;
			jsonInputObject = (JSONObject) jsonparser.parse(data);
			LtMastProducts ltMastProducts = new ObjectMapper().readValue(data, LtMastProducts.class);
			if(uploadfile.length>0) {
			return ltP2pProductsService.save(ltMastProducts,uploadfile[0]);
			}else {
				return ltP2pProductsService.save(ltMastProducts,null);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}return ltP2pProductsService.save(null,null);
		}
	
	//------------------------------------------------------------------------	
		@RequestMapping(value = "/updateproductwithfile", method = RequestMethod.POST)
		public ResponseEntity<Status> updateWithLtP2pProducts(@RequestParam("uploadfile") MultipartFile[] uploadfile,
						@RequestParam("ltMastProducts") String data) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException 
		{
			JSONParser jsonparser = new JSONParser();
			JSONObject jsonInputObject = null;
			jsonInputObject = (JSONObject) jsonparser.parse(data);
			LtMastProducts ltMastProducts = new ObjectMapper().readValue(data, LtMastProducts.class);
			if(uploadfile.length>0) {
				return ltP2pProductsService.update(ltMastProducts,uploadfile[0]);
			}else {
				return ltP2pProductsService.update(ltMastProducts,null);
			}

		}

		

		// -------------------Delete Single Products----------------------------
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> deleteLtP2pProductsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			return ltP2pProductsService.delete(id);
			
		}
	

}