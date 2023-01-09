package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.lonar.vendor.vendorportal.model.LtMastBuildings;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastBuildingsRepository;
import com.lonar.vendor.vendorportal.service.LtMastBuildingsService;

@RestController
@RequestMapping("/API/buildings") //  
public class LtMastBuildingsController  implements CodeMaster
{

	final String restBaseUrl = "/API/buildings";
	static final Logger logger = Logger.getLogger(LtMastBuildingsController.class);
	
	@Autowired
	LtMastBuildingsRepository ltP2pBuildingsRepository;
	
	@Autowired
	LtMastBuildingsService ltP2pBuildingsService;
	
	
	//@PreAuthorize("hasPermission(null, '#/employee/employee', 'View')")
	@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastEmployeesDataTable(LtMastBuildings input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
			Long count=ltP2pBuildingsService.getCount(input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastBuildings> ltMastBuildingList= ltP2pBuildingsService.getDatatableRecords(input);
			customeDataTable.setData(ltMastBuildingList);	
		} 
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}
			
	// -------------------Retrieve Buildings details with respect to dataTable--------------------
	@RequestMapping(value = "/getLikeAddr/{buildingaddr}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBuildings>> getLtP2pLikeName(@PathVariable("buildingaddr") String buildingaddr,@PathVariable("logTime") String logTime) throws ServiceException
	{
		return  (ResponseEntity<List<LtMastBuildings>>) ltP2pBuildingsService.findActiveLikeBuildingAddr(buildingaddr.trim());			
	}
	//-------------------------------------------------------------------------------------------------		
	@RequestMapping(value = "/getLikeBuildingName/{buildingName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBuildings>> listLikeBuildingName(@PathVariable("buildingName") String buildingName,@PathVariable("logTime") String logTime) throws ServiceException {
					
		return (ResponseEntity<List<LtMastBuildings>>) ltP2pBuildingsService.findByLikeBuildingName(buildingName.trim());
	}
	//---------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getActiveLikeBuildingName/{buildingName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastBuildings>> listActiveLikeBuildingName(@PathVariable("buildingName") String buildingName,@PathVariable("logTime") String logTime) throws ServiceException {
					
			return (ResponseEntity<List<LtMastBuildings>>) ltP2pBuildingsService.findByActiveLikeBuildingName(buildingName.trim());
	}
	//-------------------------------saveBuildings-------------------------------------
		//@PreAuthorize("hasPermission(null, '#/Building/Building', 'Add')")
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveBuildings(@RequestBody LtMastBuildings ltP2pBuildings) throws ServiceException	{
			try {
				return ltP2pBuildingsService.saveBuildings(ltP2pBuildings);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			
		
		}
	//-------------------------------saveBuildings-------------------------------------
	//@PreAuthorize("hasPermission(null, '#/Building/Building', 'Add')")
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateBuildings(@RequestBody LtMastBuildings ltP2pBuildings) throws ServiceException	{
		try {
			return ltP2pBuildingsService.updateBuildings(ltP2pBuildings);
			}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			
	}	
		//---------------------------------findByBranchId------------------------------------
		@RequestMapping(value = "/getbybuildingid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastBuildings> findByBuildingId(@PathVariable("id") Long buildingId,@PathVariable("logTime") String logTime) throws ServiceException {
		
				return ltP2pBuildingsService.findByBuildingId(buildingId);
		}
		//------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/getbuildingsbybranchid/{branchId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastBuildings>> getBuildingByBranchId(@PathVariable("branchId") Long branchId,@PathVariable("logTime") String logTime) throws ServiceException{
			
			 return (ResponseEntity<List<LtMastBuildings>>) ltP2pBuildingsService.getBuildingsByBranchId(branchId);	   
		}
		//---------------------------------get Building Address------------------------------------
		@RequestMapping(value = "/getAllBuildingAddr/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastBuildings>> findAllBuildingAddr(@PathVariable("id") String addr,@PathVariable("logTime") String logTime) throws ServiceException {
				return (ResponseEntity<List<LtMastBuildings>>) ltP2pBuildingsService.findAllBuildingAddr(addr);
		}
				
		
		// -------------------Delete Single Branch details----------------------------
		//@PreAuthorize("hasPermission(null, '#/Building/Building', 'Delete')")
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> deleteLtP2pBuildingByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			try {
				return ltP2pBuildingsService.deleteBuildings(id);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
			
			
		}
		
		
						
	
}
