package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;


public interface LtMastCostCentersDao {
	
	public List<LtMastCostCenters> findByCostCenterCode(String costCenterCode) throws ServiceException;
	public List<LtMastCostCenters> findByCostCenterName(String costCenterName) throws ServiceException;
	public List<LtMastCostCenters> findAllActive(Long companyId) throws ServiceException;
	public List<LtMastCostCenters> findByActiveLikeCostCentersName(Long companyId, String costCentersName) throws ServiceException;
	public List<LtMastCostCenters> findByLikeCostCentersName(String costCentersName, Long companyId) throws ServiceException;
	public List<LtMastCostCenters> checkDetails(LtMastCostCenters ltMastCostCenters)throws ServiceException;
	
	
	public LtMastCostCenters findByCostCenterId(Long costCenterCode) throws ServiceException;
	public List<LtMastCostCenters> getDataTable(Long companyId, LtMastCostCenters input) throws ServiceException;
	public Long getCount(Long companyId, LtMastCostCenters input) throws ServiceException;
	public LtMastCostCenters getLtMastCostCentersByID(Long costCentersID) throws ServiceException;
	public List<LtMastCostCenters> getDataForReport(ReportParameters reportParameters) throws ServiceException;
	
	public List<LtMastCostCenters> getAll(Long companyId) throws ServiceException;
}
