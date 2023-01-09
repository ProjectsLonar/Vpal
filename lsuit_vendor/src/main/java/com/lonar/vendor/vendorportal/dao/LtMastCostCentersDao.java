package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastCostCentersDao {
	
	public List<LtMastCostCenters> findByCostCenterCode(String costCenterCode) throws ServiceException;
	public List<LtMastCostCenters> findByCostCenterName(String costCenterName) throws ServiceException;
	public List<LtMastCostCenters> findAllActive() throws ServiceException;
	public List<LtMastCostCenters> findByActiveLikeCostCentersName(String costCentersName) throws ServiceException;
	public List<LtMastCostCenters> findByLikeCostCentersName(String costCentersName) throws ServiceException;
	public List<LtMastCostCenters> checkDetails(LtMastCostCenters ltMastCostCenters)throws ServiceException;
	
	
	public LtMastCostCenters findByCostCenterId(Long costCenterCode) throws ServiceException;
	public List<LtMastCostCenters> getDataTable(LtMastCostCenters input) throws ServiceException;
	public Long getCount(LtMastCostCenters input) throws ServiceException;
	public LtMastCostCenters getLtMastCostCentersByID(Long costCentersID) throws ServiceException;
}
