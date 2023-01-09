package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.DivisionWithSubDivision;
import com.lonar.vendor.vendorportal.model.LtMastDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtMastDivisionsService 
{

	//public List<LtP2pDivisions> findByDivisionCode(String divisionCode) throws Exception;

	//public List<LtP2pDivisions> findByDivisionName(String divisionName) throws Exception;

	public List<LtMastDivisions> findAllActive(Long companyId) throws ServiceException;

	public List<LtMastDivisions> findActiveLikeName(Long companyId, String divisionName) throws ServiceException;
	
	public ResponseEntity findByDivisionId(Long divisionId) throws ServiceException;

	public String checkDetails(LtMastDivisions ltMastDivisions) throws ServiceException;

	public ResponseEntity getDivisionByDivisionId(Long divisionId)throws ServiceException;

	public Long getCount(Long companyId, LtMastDivisions input) throws Exception;

	public List<LtMastDivisions> getDataTableRecords(Long companyId, LtMastDivisions input) throws Exception;

	public List<LtMastDivisions> getAll(Long companyId) throws ServiceException;

	public ResponseEntity<Status> save(DivisionWithSubDivision divisionWithSubDivision) throws ServiceException;

	public ResponseEntity<Status> update(LtMastDivisions ltMastDivisions)  throws ServiceException;

	public ResponseEntity<Status> delete(String id)throws ServiceException;

	public ResponseEntity<Status> saveDivision(LtMastDivisions ltMastDivisions) throws ServiceException;

	

}
