package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtMastCostCentersService {

	public List<LtMastCostCenters> findByCostCenterCode(String costCenterCode) throws ServiceException;

	public List<LtMastCostCenters> findByCostCenterName(String costCenterName)throws ServiceException;

	public ResponseEntity<List<LtMastCostCenters>> findAllActive(Long companyId)throws ServiceException;

	public List<LtMastCostCenters> findByActiveLikeCostCentersName(Long companyId, String costCentersName)throws ServiceException;

	public List<LtMastCostCenters> findByLikeCostCentersName(String costCentersName, Long companyId)throws ServiceException;

	public String checkDetails(LtMastCostCenters ltMastCostCenters, String flag) throws ServiceException;

	public List<LtMastCostCenters> getDataTable(Long companyId, LtMastCostCenters input) throws ServiceException;

	public Long getCount(Long companyId, LtMastCostCenters input) throws ServiceException;

	public LtMastCostCenters getLtMastCostCentersByID(Long parseLong) throws ServiceException;

	public ResponseEntity<List<LtMastCostCenters>> getAll(Long companyId) throws ServiceException;

	public ResponseEntity<Status> save(LtMastCostCenters ltMastCostCenters) throws ServiceException;

	public ResponseEntity<Status> update(LtMastCostCenters ltMastCostCenters) throws ServiceException;

	public ResponseEntity<Status> delete(String id) throws ServiceException;
}
