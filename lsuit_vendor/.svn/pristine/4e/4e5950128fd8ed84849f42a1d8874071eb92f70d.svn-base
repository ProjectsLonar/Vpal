package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lonar.vendor.vendorportal.model.LtMastBuildings;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtMastBuildingsService 
{
	public Integer getLtP2pBuildingsCount() throws Exception;
//	public ResponseEntity<Response> listLtP2pBuildingsAll(Integer pageNo )throws Exception;
	public List<LtMastBuildings> findByBuildingCode(String buildingCode) throws ServiceException;
	//public ResponseEntity<LtP2pBuildings> findByBranchId(String branchId);
	public List<LtMastBuildings>	findAllActive() throws ServiceException;
	
	
	public ResponseEntity<Status> saveBuildings(LtMastBuildings ltP2pBuildings) throws ServiceException;
	
	public List<LtMastBuildings>	searchBuildings(LtMastBuildings ob) throws ServiceException;
	

	public ResponseEntity<LtMastBuildings> findByBuildingId(Long id)throws ServiceException;
	

	//---------------------------------get Building Address------------------------------------
	public List<LtMastBuildings>	findAllBuildingAddr(String addr)throws ServiceException;
	
	//-----------------------------------------------------------------------
	public List<LtMastBuildings> findActiveLikeBuildingAddr(String buildingaddr) throws ServiceException;
	
	public List<LtMastBuildings> findByActiveLikeBuildingName(String buildingName) throws ServiceException;
	public List<LtMastBuildings> findByLikeBuildingName(String buildingName) throws ServiceException;

	
	List<LtMastBuildings> getBuildingsByBranchId(Long branchId) throws ServiceException;
	public ResponseEntity<Status> updateBuildings(LtMastBuildings ltP2pBuildings) throws ServiceException;
	public ResponseEntity<Status> deleteBuildings(Long id) throws ServiceException;
	public Long getCount(LtMastBuildings input) throws ServiceException;
	public List<LtMastBuildings> getDatatableRecords(LtMastBuildings input) throws ServiceException;
	
}
