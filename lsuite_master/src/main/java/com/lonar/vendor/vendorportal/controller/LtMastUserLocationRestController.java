package com.lonar.vendor.vendorportal.controller;

import java.util.List;

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
import com.lonar.vendor.vendorportal.model.LtMastUserLocation;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastUserLocationService;

@RestController
@RequestMapping("/API/userlocation")
public class LtMastUserLocationRestController implements CodeMaster
{

	@Autowired
	LtMastUserLocationService ltMastUserLocationService;
	
	@RequestMapping(value="/datatable/{logTime}",method = RequestMethod.GET ,produces = "application/json")
	public CustomeDataTable getLtMastUserLocationDataTable(LtMastUserLocation input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastUserLocationService.getCount(input);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastUserLocation> loggerList= 
			    		ltMastUserLocationService.getDatatableRecords(input);
				customeDataTable.setData(loggerList);	
		} 
		catch (Exception e) 
		{	
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastUserLocation>> getAllLtMastUserLocation(@PathVariable("logTime") String logTime) throws  ServiceException {
		List<LtMastUserLocation> list =  ltMastUserLocationService.getAllLtMastUserLocation();
		return new ResponseEntity<List<LtMastUserLocation>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastUserLocation>> listAllActiveLtMastUserLocation(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastUserLocation> list =   ltMastUserLocationService.findAllActive();
		return new ResponseEntity<List<LtMastUserLocation>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActiveByLocationId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastUserLocation>> listAllActiveUserLocationByLocId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastUserLocation> list =   ltMastUserLocationService.listAllActiveUserLocationByLocId(id);
		return new ResponseEntity<List<LtMastUserLocation>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActiveByUserId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastUserLocation>> listAllActiveUserLocationByUserId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastUserLocation> list =   ltMastUserLocationService.listAllActiveUserLocationByUserId(id);
		return new ResponseEntity<List<LtMastUserLocation>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastUserLocation> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastUserLocation ltMastUserLocation =  ltMastUserLocationService.getByID(id);
		if(ltMastUserLocation!=null){
		}
		return new ResponseEntity<LtMastUserLocation>(ltMastUserLocation, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> save(@RequestBody  LtMastUserLocation ltMastUserLocation) throws ServiceException {
		return ltMastUserLocationService.save(ltMastUserLocation);	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> update(@RequestBody  LtMastUserLocation ltMastUserLocation) throws ServiceException {
		return ltMastUserLocationService.update(ltMastUserLocation);	

	}
	
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastBranchesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltMastUserLocationService.delete(id);	
		
	}

}
