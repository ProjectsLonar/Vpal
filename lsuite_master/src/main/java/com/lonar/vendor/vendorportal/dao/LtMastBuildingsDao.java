package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastBuildings;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastBuildingsDao 
{
	public Integer getLtP2pBuildingsCount() throws Exception;
	public  List<LtMastBuildings>  listLtP2pBuildingsAll(Integer pageNo) throws ServiceException ;
	public List<LtMastBuildings> findByBuildingCode(String buildingCode) throws ServiceException;
	public List<LtMastBuildings> findByBranchId(String branchId) throws ServiceException;
	public List<LtMastBuildings>	findAllActive() throws ServiceException;
	
	
	/*public ResponseEntity<Status> saveBuildings(@RequestBody LtP2pBuildings ltP2pBuildings);*/
	
	public List<LtMastBuildings>	searchBuildings(LtMastBuildings ob) throws ServiceException;
	
	
	public List<LtMastBuildings>	findByBuildingId(Long id) throws ServiceException;
	
	
	public List<LtMastBuildings>	findAllBuildingAddr(String addr) throws ServiceException;
	
	
	public List<LtMastBuildings> findActiveLikeBuildingAddr(String buildingaddr) throws ServiceException;
	public List<LtMastBuildings> findByActiveLikeBuildingName(String buildingName) throws ServiceException;
	public List<LtMastBuildings> findByLikeBuildingName(String buildingName) throws ServiceException;
 
	
	List<LtMastBuildings> getBuildingsByBranchId(Long branchId) throws ServiceException;
	public Long getCount(LtMastBuildings input) throws ServiceException;
	public List<LtMastBuildings> getDatatableRecords(LtMastBuildings input) throws ServiceException;
	public LtMastBuildings getByBuildingCode(String buildingCode) throws ServiceException;
	public LtMastBuildings getByBuildingName(String buildingName) throws ServiceException;
}
